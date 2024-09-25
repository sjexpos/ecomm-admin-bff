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
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RemoteServicesConfiguration {

    @Bean
    public UsersService asyncConsumerUsersService(
            WebClient.Builder builder,
            BackendServicesProperties backendProperties
    ) {
        return new UsersServiceProxy(builder.baseUrl(backendProperties.getUsers().getBaseUri()).build());
    }

    @Bean
    public StockTransactionsService stockTransactionService(
            WebClient.Builder builder,
            BackendServicesProperties backendProperties
    ) {
        return new StockTransactionServiceProxy(builder.baseUrl(backendProperties.getProducts().getBaseUri()).build());
    }

    @Bean
    public CategoryService categoryService(
            WebClient.Builder builder,
            RestTemplateBuilder templateBuilder,
            BackendServicesProperties backendProperties
    ) {
        return new CategoryServiceProxyEnhanced(
                new CategoryServiceProxy(
                        builder.baseUrl(backendProperties.getProducts().getBaseUri()).build()
                ),
                templateBuilder.rootUri(backendProperties.getProducts().getBaseUri()).build()
        );
    }

    @Bean
    public IDispensaryService dispensariesService(
            WebClient.Builder builder,
            BackendServicesProperties backendProperties
    ) {
        return new DispensariesServiceProxyEnhanced(
                new DispensariesServiceProxy(
                        builder.baseUrl(backendProperties.getProducts().getBaseUri()).build()
                )
        );
    }

    @Bean
    public AsyncDispensariesService asyncDispensariesService(
            WebClient.Builder builder,
            BackendServicesProperties backendProperties
    ) {
        return new AsyncDispensariesServiceProxyEnhanced(
                new DispensariesServiceProxy(
                        builder.baseUrl(backendProperties.getProducts().getBaseUri()).build()
                )
        );
    }

    @Bean
    public OrdersService ordersService(
            WebClient.Builder builder,
            BackendServicesProperties backendProperties
    ) {
        return new OrdersServiceProxyEnhanced(
                new OrdersServiceProxy(
                        builder.baseUrl(backendProperties.getOrders().getBaseUri()).build()
                )
        );
    }

    @Bean
    public AsyncOrdersService asyncOrdersService(
            WebClient.Builder builder,
            BackendServicesProperties backendProperties
    ) {
        return new AsyncOrdersServiceProxyEnhanced(
                new OrdersServiceProxy(
                        builder.baseUrl(backendProperties.getOrders().getBaseUri()).build()
                )
        );
    }

}
