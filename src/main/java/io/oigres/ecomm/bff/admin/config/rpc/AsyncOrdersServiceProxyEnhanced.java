package io.oigres.ecomm.bff.admin.config.rpc;

import io.oigres.ecomm.service.orders.OrderStatusEnumApi;
import io.oigres.ecomm.service.orders.api.AsyncOrdersService;
import io.oigres.ecomm.service.orders.model.order.*;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class AsyncOrdersServiceProxyEnhanced implements AsyncOrdersService {
    private final AsyncOrdersService asyncOrdersService;

    @Override
    public CompletableFuture<OrdersCountResponse> getOrdersCountAsync(Long dispensaryId, Long userId, OrderStatusEnumApi status) {
        return this.asyncOrdersService.getOrdersCountAsync(dispensaryId, userId, status);
    }

}
