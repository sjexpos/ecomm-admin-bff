package io.oigres.ecomm.bff.admin.usecases.orders.list;

import io.oigres.ecomm.bff.admin.api.model.GetOrdersListWithTotalResponse;
import io.oigres.ecomm.bff.admin.api.model.OrderResponse;
import io.oigres.ecomm.bff.admin.api.model.OrderStatusEnum;
import io.oigres.ecomm.bff.admin.api.model.PaginatedResponse;
import io.oigres.ecomm.bff.admin.usecases.utils.TimeConverter;
import io.oigres.ecomm.service.orders.OrderStatusEnumApi;
import io.oigres.ecomm.service.orders.OrdersService;
import io.oigres.ecomm.service.orders.api.AsyncOrdersService;
import io.oigres.ecomm.service.orders.model.PageResponse;
import io.oigres.ecomm.service.orders.model.PageableRequestImpl;
import io.oigres.ecomm.service.orders.model.order.GetAllOrdersResponse;
import io.oigres.ecomm.service.orders.model.order.OrdersCountResponse;
import io.oigres.ecomm.service.products.api.AsyncDispensariesService;
import io.oigres.ecomm.service.products.model.dispensary.GetDispensaryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
@Slf4j
@RequiredArgsConstructor
public class GetOrdersUseCase {
    private final OrdersService ordersService;
    private final AsyncOrdersService asyncOrdersService;
    private final AsyncDispensariesService asyncDispensariesService;

    public GetOrdersListWithTotalResponse listOrders(OrderStatusEnum status, int pageNumber, int pageSize) {
        OrderStatusEnumApi orderStatusEnum = status != null ? OrderStatusEnumApi.valueOf(status.name()) : null;
        PageResponse<GetAllOrdersResponse> pages = ordersService.getAllOrders(null, null, orderStatusEnum, PageableRequestImpl.of(pageNumber, pageSize));

        Map<Long, CompletableFuture<GetDispensaryResponse>> dispensariesById = new HashMap<>();
        CompletableFuture<OrdersCountResponse> ordersCount = asyncOrdersService.getOrdersCountAsync(null, null, orderStatusEnum);
        pages.getContent().forEach(el ->
                dispensariesById.put(el.getDispensaryId(), asyncDispensariesService.getDispensaryByIdAsync(el.getDispensaryId()))
        );

        List<OrderResponse> ordersList = pages.getContent().stream().map(el -> {
            String dispensaryName = getDispensaryName(dispensariesById, el.getDispensaryId());
            long orderDateEpochFormat = TimeConverter.localDateTimeIntoEpoch(el.getOrderDate());
            return OrderResponse.builder().id(el.getId()).orderDate(orderDateEpochFormat).orderNumber(el.getId()).dispensary(dispensaryName)
                    .status(OrderStatusEnum.valueOf(el.getOrderStatus())).total(el.getTotal()).build();
        })
        .toList();
        BigDecimal total = null;
        try {
            total = ordersCount.get().getTotal();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        PaginatedResponse<OrderResponse> orders = new PaginatedResponse<>(ordersList, pages.getTotalPages(), pageNumber, pageSize, pages.getTotalElements());
        return GetOrdersListWithTotalResponse.builder().orders(orders).total(total).build();
    }

    private String getDispensaryName(Map<Long, CompletableFuture<GetDispensaryResponse>> dispensariesById, Long dispensaryId) {
        try {
            return dispensariesById.get(dispensaryId).get().getName();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}