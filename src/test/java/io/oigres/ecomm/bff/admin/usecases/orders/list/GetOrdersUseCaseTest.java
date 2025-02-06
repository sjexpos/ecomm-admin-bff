/**********
 This project is free software; you can redistribute it and/or modify it under
 the terms of the GNU General Public License as published by the
 Free Software Foundation; either version 3.0 of the License, or (at your
 option) any later version. (See <https://www.gnu.org/licenses/gpl-3.0.html>.)

 This project is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 more details.

 You should have received a copy of the GNU General Public License
 along with this project; if not, write to the Free Software Foundation, Inc.,
 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 **********/
// Copyright (c) 2024-2025 Sergio Exposito.  All rights reserved.              

package io.oigres.ecomm.bff.admin.usecases.orders.list;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import io.oigres.ecomm.bff.admin.api.model.GetOrdersListWithTotalResponse;
import io.oigres.ecomm.bff.admin.api.model.OrderStatusEnum;
import io.oigres.ecomm.service.products.api.AsyncDispensariesService;
import io.oigres.ecomm.service.products.model.PageResponse;
import io.oigres.ecomm.service.products.model.PageableRequestImpl;
import io.oigres.ecomm.service.products.model.dispensary.GetAllDispensaryResponse;
import java.io.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.ResourceUtils;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(
    locations = "classpath:application-integrationtest.properties",
    properties =
        """
ecomm.bff.users.baseUri=http://localhost:20001
ecomm.bff.products.baseUri=http://localhost:20002
ecomm.bff.orders.baseUri=http://localhost:20003
                """)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Slf4j
public class GetOrdersUseCaseTest {
  private static final String ORDERS_SERVICE_ROUTE_GET_ORDERS =
      "/api/v1/orders?status=%s&page=%d&size=%d";
  private static final String ORDERS_SERVICE_ROUTE_GET_ORDERS_TOTAL =
      "/api/v1/orders/total?status=%s";
  private static final String PRODUCTS_SERVICE_ROUTE_GET_DISPENSARY = "/api/v1/dispensaries/%d";
  private static final String PRODUCTS_SERVICE_ROUTE_GET_ALL_DISPENSARIES =
      "/api/v1/dispensaries?page=%d&size=%d";

  @RegisterExtension
  static WireMockExtension PRODUCTS_SERVICE =
      WireMockExtension.newInstance()
          .options(WireMockConfiguration.wireMockConfig().port(20002))
          .build();

  @RegisterExtension
  static WireMockExtension ORDERS_SERVICE =
      WireMockExtension.newInstance()
          .options(WireMockConfiguration.wireMockConfig().port(20003))
          .build();

  @Autowired private GetOrdersUseCase useCase;

  private String readSubData(String filename) throws Exception {
    File file =
        ResourceUtils.getFile(
            "classpath:io/oigres/ecomm/bff/admin/usecases/orders/list/" + filename);
    InputStream in = new FileInputStream(file);
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    return reader.lines().collect(Collectors.joining(System.lineSeparator()));
  }

  @Test
  void test_correct_orders_search() throws Exception {
    long dispensaryId = 34;
    String orderStatus = "ORDERED";
    String bodyGetAllOrders = readSubData("testGetAllOrders.json");
    ORDERS_SERVICE.stubFor(
        get(urlEqualTo(String.format(ORDERS_SERVICE_ROUTE_GET_ORDERS, orderStatus, 0, 20)))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(bodyGetAllOrders)));
    String bodyGetAllOrdersTotal = readSubData("testGetAllOrders_total.json");
    ORDERS_SERVICE.stubFor(
        get(urlEqualTo(String.format(ORDERS_SERVICE_ROUTE_GET_ORDERS_TOTAL, orderStatus)))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(bodyGetAllOrdersTotal)));
    String bodyDispensary = readSubData("testGetAllOrders_dispensary.json");
    PRODUCTS_SERVICE.stubFor(
        get(urlEqualTo(String.format(PRODUCTS_SERVICE_ROUTE_GET_DISPENSARY, dispensaryId)))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(bodyDispensary)));

    // when
    GetOrdersListWithTotalResponse response =
        this.useCase.listOrders(OrderStatusEnum.ORDERED, 0, 20);

    // then
    Assertions.assertNotNull(response);
    Assertions.assertEquals(new BigDecimal("63.25"), response.getTotal());
    Assertions.assertEquals(1, response.getOrders().getRows().size());
    Assertions.assertEquals(
        1234, response.getOrders().getRows().stream().findFirst().get().getId());
    Assertions.assertEquals(
        1234, response.getOrders().getRows().stream().findFirst().get().getOrderNumber());
    Assertions.assertEquals(
        "My dispensary", response.getOrders().getRows().stream().findFirst().get().getDispensary());
    Assertions.assertEquals(
        OrderStatusEnum.ORDERED,
        response.getOrders().getRows().stream().findFirst().get().getStatus());
    Assertions.assertEquals(
        new BigDecimal("63.25"),
        response.getOrders().getRows().stream().findFirst().get().getTotal());
  }

  @Test
  void test_orders_search_with_errors_on_products_service() throws Exception {
    long dispensaryId = 34;
    String orderStatus = "ORDERED";
    String bodyGetAllOrders = readSubData("testGetAllOrders.json");
    ORDERS_SERVICE.stubFor(
        get(urlEqualTo(String.format(ORDERS_SERVICE_ROUTE_GET_ORDERS, orderStatus, 0, 20)))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(bodyGetAllOrders)));
    String bodyGetAllOrdersTotal = readSubData("testGetAllOrders_total.json");
    ORDERS_SERVICE.stubFor(
        get(urlEqualTo(String.format(ORDERS_SERVICE_ROUTE_GET_ORDERS_TOTAL, orderStatus)))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(bodyGetAllOrdersTotal)));
    PRODUCTS_SERVICE.stubFor(
        get(urlEqualTo(String.format(PRODUCTS_SERVICE_ROUTE_GET_DISPENSARY, dispensaryId)))
            .willReturn(serverError()));

    // when
    GetOrdersListWithTotalResponse response =
        this.useCase.listOrders(OrderStatusEnum.ORDERED, 0, 20);

    // then
    Assertions.assertNotNull(response);
    Assertions.assertEquals(new BigDecimal("63.25"), response.getTotal());
    Assertions.assertEquals(1, response.getOrders().getRows().size());
    Assertions.assertEquals(
        1234, response.getOrders().getRows().stream().findFirst().get().getId());
    Assertions.assertEquals(
        1234, response.getOrders().getRows().stream().findFirst().get().getOrderNumber());
    Assertions.assertEquals(
        "Not available", response.getOrders().getRows().stream().findFirst().get().getDispensary());
    Assertions.assertEquals(
        OrderStatusEnum.ORDERED,
        response.getOrders().getRows().stream().findFirst().get().getStatus());
    Assertions.assertEquals(
        new BigDecimal("63.25"),
        response.getOrders().getRows().stream().findFirst().get().getTotal());

    PRODUCTS_SERVICE.verify(
        1,
        getRequestedFor(
            urlEqualTo(String.format(PRODUCTS_SERVICE_ROUTE_GET_DISPENSARY, dispensaryId))));
  }

  @Test
  void test_orders_search_with_timeout_plus_retries() throws Exception {
    long dispensaryId = 34;
    String orderStatus = "ORDERED";
    String bodyGetAllOrders = readSubData("testGetAllOrders.json");
    ORDERS_SERVICE.stubFor(
        get(urlEqualTo(String.format(ORDERS_SERVICE_ROUTE_GET_ORDERS, orderStatus, 0, 20)))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(bodyGetAllOrders)));
    String bodyGetAllOrdersTotal = readSubData("testGetAllOrders_total.json");
    ORDERS_SERVICE.stubFor(
        get(urlEqualTo(String.format(ORDERS_SERVICE_ROUTE_GET_ORDERS_TOTAL, orderStatus)))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(bodyGetAllOrdersTotal)));
    String bodyDispensary = readSubData("testGetAllOrders_dispensary.json");
    PRODUCTS_SERVICE.stubFor(
        get(urlEqualTo(String.format(PRODUCTS_SERVICE_ROUTE_GET_DISPENSARY, dispensaryId)))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(bodyDispensary)
                    .withFixedDelay(Math.toIntExact(Duration.ofSeconds(1).toMillis()))));

    // when
    GetOrdersListWithTotalResponse response =
        this.useCase.listOrders(OrderStatusEnum.ORDERED, 0, 20);

    // then
    Assertions.assertNotNull(response);
    Assertions.assertEquals(new BigDecimal("63.25"), response.getTotal());
    Assertions.assertEquals(1, response.getOrders().getRows().size());
    Assertions.assertEquals(
        1234, response.getOrders().getRows().stream().findFirst().get().getId());
    Assertions.assertEquals(
        1234, response.getOrders().getRows().stream().findFirst().get().getOrderNumber());
    Assertions.assertEquals(
        "Not available", response.getOrders().getRows().stream().findFirst().get().getDispensary());
    Assertions.assertEquals(
        OrderStatusEnum.ORDERED,
        response.getOrders().getRows().stream().findFirst().get().getStatus());
    Assertions.assertEquals(
        new BigDecimal("63.25"),
        response.getOrders().getRows().stream().findFirst().get().getTotal());

    PRODUCTS_SERVICE.verify(
        1,
        getRequestedFor(
            urlEqualTo(String.format(PRODUCTS_SERVICE_ROUTE_GET_DISPENSARY, dispensaryId))));
  }

  @Autowired private AsyncDispensariesService asyncDispensariesService;

  @Test
  void test() throws Exception {
    String body = readSubData("test.json");
    PRODUCTS_SERVICE.stubFor(
        get(urlEqualTo(String.format(PRODUCTS_SERVICE_ROUTE_GET_ALL_DISPENSARIES, 0, 20)))
            .willReturn(
                //                        serverError()
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(body)
                    .withFixedDelay(Math.toIntExact(Duration.ofSeconds(2).toMillis()))));

    try {
      CompletableFuture<? extends PageResponse<GetAllDispensaryResponse>> response =
          asyncDispensariesService.getAllDispensariesAsync(PageableRequestImpl.of(0, 20));
      PageResponse<GetAllDispensaryResponse> page = response.get();
    } catch (Exception e) {
      log.error("ERROR", e.getMessage());
    }

    PRODUCTS_SERVICE.verify(
        2,
        getRequestedFor(
            urlEqualTo(String.format(PRODUCTS_SERVICE_ROUTE_GET_ALL_DISPENSARIES, 0, 20))));
  }
}
