package io.oigres.ecomm.bff.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties"
)
@AutoConfigureWireMock(port = 0)
@AutoConfigureMockMvc
@Slf4j
public class CategoriesControllerTest {

    static private final String BFF_ROUTE_GET_CATEGORIES = "/bff/v1/categories";

    static private final String PRODUCTS_SERVICE_ROUTE_GET_CATEGORIES = "/api/v1/categories";

    @Autowired
    MockMvc mvc;
    @Autowired
    private TestRestTemplate restTemplate;

    private void stubCategoryServiceCall(int page, int size, String body) {
        stubFor(get(urlEqualTo(PRODUCTS_SERVICE_ROUTE_GET_CATEGORIES +"?page="+page+"&size="+size))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(body)
                )
        );
    }

    private String readSubData(String filename) throws Exception {
        File file = ResourceUtils.getFile("classpath:io/oigres/ecomm/bff/admin/controller/categories/"+filename);
        InputStream in = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }

    @Test
    void testGetAllCategories_empty() throws Exception {
        String stubBody = readSubData("testGetAllCategories_empty.json");
        stubCategoryServiceCall(0, 20, stubBody);

        ResponseEntity response = restTemplate.getForEntity(BFF_ROUTE_GET_CATEGORIES+"?page=0&size=20", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

//        mvc.perform(MockMvcRequestBuilders.get(BFF_ROUTE_GET_CATEGORIES)
//                        .param("page", "0")
//                        .param("size", "20")
//                        .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("totalPages", is(0)))
//                .andExpect(jsonPath("page", is(0)))
//                .andExpect(jsonPath("size", is(20)))
//                .andExpect(jsonPath("totalItems", is(0)))
//                .andExpect(jsonPath("rows", is(empty())))
//        ;
    }

    @Test
    void testGetAllCategories_circuit_braker() throws Exception {
        stubFor(get(urlEqualTo(PRODUCTS_SERVICE_ROUTE_GET_CATEGORIES +"?page=0&size=20"))
                .willReturn(
                        serverError()
                )
        );
        IntStream.rangeClosed(1, 5)
                .forEach(i -> {
                    ResponseEntity response = restTemplate.getForEntity(BFF_ROUTE_GET_CATEGORIES, String.class);
                    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
                });
        IntStream.rangeClosed(1, 4)
                .forEach(i -> {
                    log.info(String.format("************************** request {} **************************", i));
                    ResponseEntity response = restTemplate.getForEntity(BFF_ROUTE_GET_CATEGORIES, String.class);
                    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE);

//                    try {
//                        mvc.perform(MockMvcRequestBuilders.get(BFF_ROUTE_GET_CATEGORIES)
//                                        .param("page", "0")
//                                        .param("size", "20")
//                                        .contentType(MediaType.APPLICATION_JSON)
//                                )
//                                .andExpect(status().isServiceUnavailable())
//                        ;
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }

                });

        verify(5, getRequestedFor(urlEqualTo(PRODUCTS_SERVICE_ROUTE_GET_CATEGORIES +"?page=0&size=20")));
    }

}
