package io.oigres.ecomm.bff.admin.config;

import io.oigres.ecomm.bff.admin.config.rpc.*;
import io.oigres.ecomm.service.orders.OrdersService;
import io.oigres.ecomm.service.orders.api.AsyncOrdersService;
import io.oigres.ecomm.service.orders.api.OrdersServiceProxy;
import io.oigres.ecomm.service.products.IDispensaryService;
import io.oigres.ecomm.service.products.api.AsyncDispensariesService;
import io.oigres.ecomm.service.products.api.CategoryServiceProxy;
import io.oigres.ecomm.service.products.api.DispensariesServiceProxy;
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
    public UsersService asyncConsumerUsersService(
            WebClient.Builder builder,
            @Value("${ecomm.bff.users.baseUri}") String usersBaseUri
    ) {
        return new UsersServiceProxy(builder.baseUrl(usersBaseUri).build());
    }

    @Bean
    public StockTransactionsService stockTransactionService(
            WebClient.Builder builder,
            @Value("${ecomm.bff.products.baseUri}") String productsBaseUri
    ) {
        return new StockTransactionServiceProxy(builder.baseUrl(productsBaseUri).build());
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

    @Bean
    public IDispensaryService dispensariesService(
            WebClient.Builder builder,
            @Value("${ecomm.bff.products.baseUri}") String productsBaseUri
    ) {
        return new DispensariesServiceProxyEnhanced(
                new DispensariesServiceProxy(
                        builder.baseUrl(productsBaseUri).build()
                )
        );
    }

    @Bean
    public AsyncDispensariesService asyncDispensariesService(
            WebClient.Builder builder,
            @Value("${ecomm.bff.products.baseUri}") String productsBaseUri
    ) {
        return new AsyncDispensariesServiceProxyEnhanced(
                new DispensariesServiceProxy(
                        builder.baseUrl(productsBaseUri).build()
                )
        );
    }

    @Bean
    public OrdersService ordersService(
            WebClient.Builder builder,
            @Value("${ecomm.bff.orders.baseUri}") String ordersBaseUri
    ) {
        return new OrdersServiceProxyEnhanced(
                new OrdersServiceProxy(
                        builder.baseUrl(ordersBaseUri).build()
                )
        );
    }

    @Bean
    public AsyncOrdersService asyncOrdersService(
            WebClient.Builder builder,
            @Value("${ecomm.bff.orders.baseUri}") String ordersBaseUri
    ) {
        return new AsyncOrdersServiceProxyEnhanced(
                new OrdersServiceProxy(
                        builder.baseUrl(ordersBaseUri).build()
                )
        );
    }

}
