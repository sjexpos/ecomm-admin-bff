package io.oigres.ecomm.bff.admin.config;

import io.oigres.ecomm.bff.admin.config.rpc.CategoryServiceProxyEnhanced;
import io.oigres.ecomm.service.products.api.CategoryServiceProxy;
import io.oigres.ecomm.service.products.api.StockTransactionServiceProxy;
import io.oigres.ecomm.service.products.model.CategoryService;
import io.oigres.ecomm.service.products.model.StockTransactionsService;
import io.oigres.ecomm.service.users.api.UsersService;
import io.oigres.ecomm.service.users.api.UsersServiceProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RemoteServicesConfiguration {

    @Bean
    public StockTransactionsService stockTransactionService(
            WebClient.Builder builder,
            @Value("${ecomm.bff.products.baseUri}") String productsBaseUri
    ) {
        return new StockTransactionServiceProxy(builder.baseUrl(productsBaseUri).build());
    }

    @Bean
    public UsersService asyncConsumerUsersService(
            WebClient.Builder builder,
            @Value("${ecomm.bff.users.baseUri}") String usersBaseUri
    ) {
        return new UsersServiceProxy(builder.baseUrl(usersBaseUri).build());
    }

    @Bean
    public CategoryService categoryService(
            WebClient.Builder builder,
            RestTemplateBuilder templateBuilder,
            @Value("${ecomm.bff.products.baseUri}") String productsBaseUri
    ) {
        return new CategoryServiceProxyEnhanced(
                new CategoryServiceProxy(
                        builder.baseUrl(productsBaseUri).build()
                ),
                templateBuilder.rootUri(productsBaseUri).build()
        );
    }

}
