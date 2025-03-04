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

package io.oigres.ecomm.bff.admin.usecases.categories.list;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.oigres.ecomm.bff.admin.api.model.CategoryResponse;
import io.oigres.ecomm.bff.admin.api.model.PaginatedResponse;
import io.oigres.ecomm.service.products.api.RemoteServiceUnavailableException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
public class ListCategoriesUseCaseTest {
  private static final String PRODUCTS_SERVICE_ROUTE_GET_CATEGORIES =
      "/api/v1/categories?page=%d&size=%d";

  @RegisterExtension
  static WireMockExtension PRODUCTS_SERVICE =
      WireMockExtension.newInstance()
          .options(WireMockConfiguration.wireMockConfig().port(20002))
          .build();

  @Autowired private ListCategoriesUseCase useCase;

  private String readSubData(String filename) throws Exception {
    File file =
        ResourceUtils.getFile(
            "classpath:io/oigres/ecomm/bff/admin/usecases/categories/list/" + filename);
    InputStream in = Files.newInputStream(Path.of(file.getPath()));
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    return reader.lines().collect(Collectors.joining(System.lineSeparator()));
  }

  @Test
  void test_get_all_categories_empty_response() throws Exception {
    // given
    String bodyDispensary = readSubData("testGetAllCategories_empty.json");
    PRODUCTS_SERVICE.stubFor(
        get(urlEqualTo(String.format(PRODUCTS_SERVICE_ROUTE_GET_CATEGORIES, 0, 20)))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(bodyDispensary)));

    // when
    PaginatedResponse<CategoryResponse> response = useCase.listCategories(0, 20);

    // then
    Assertions.assertNotNull(response);
  }

  @Test
  void testGetAllCategories_circuit_braker() throws Exception {
    // given
    PRODUCTS_SERVICE.stubFor(
        get(urlEqualTo(String.format(PRODUCTS_SERVICE_ROUTE_GET_CATEGORIES, 0, 20)))
            .willReturn(serverError()));

    // when
    IntStream.rangeClosed(1, 5)
        .forEach(
            i -> {
              try {
                PaginatedResponse<CategoryResponse> response = useCase.listCategories(0, 20);
                Assertions.assertTrue(false);
              } catch (RemoteServiceUnavailableException e) {
                Assertions.assertTrue(true);
              }
            });

    IntStream.rangeClosed(1, 4)
        .forEach(
            i -> {
              try {
                PaginatedResponse<CategoryResponse> response = useCase.listCategories(0, 20);
                Assertions.assertTrue(false);
              } catch (CallNotPermittedException e) {
                Assertions.assertTrue(true);
              }
            });

    // then
    PRODUCTS_SERVICE.verify(
        5,
        getRequestedFor(urlEqualTo(String.format(PRODUCTS_SERVICE_ROUTE_GET_CATEGORIES, 0, 20))));
  }
}
