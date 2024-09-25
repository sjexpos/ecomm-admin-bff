package io.oigres.ecomm.bff.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "ecomm.bff")
public class BackendServicesProperties {

    @Data
    public static class UsersServiceProperties {
        private String baseUri;
    }

    @Data
    public static class ProductsServiceProperties {
        private String baseUri;
    }

    @Data
    public static class OrdersServiceProperties {
        private String baseUri;
    }

    private UsersServiceProperties users;
    private ProductsServiceProperties products;
    private OrdersServiceProperties orders;

}
