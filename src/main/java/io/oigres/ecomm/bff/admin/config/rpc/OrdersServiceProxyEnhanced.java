package io.oigres.ecomm.bff.admin.config.rpc;

import io.oigres.ecomm.service.orders.OrderStatusEnumApi;
import io.oigres.ecomm.service.orders.OrdersService;
import io.oigres.ecomm.service.orders.model.NotFoundException;
import io.oigres.ecomm.service.orders.model.PageResponse;
import io.oigres.ecomm.service.orders.model.PageableRequest;
import io.oigres.ecomm.service.orders.model.order.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrdersServiceProxyEnhanced implements OrdersService {

    private final OrdersService ordersService;

    //**************************************** OrdersService ****************************************//

    @Override
    public GetOrderByIdResponse getOrderById(long orderId) throws NotFoundException {
        return ordersService.getOrderById(orderId);
    }

    @Override
    public PageResponse<GetAllOrdersResponse> getAllOrders(Long dispensaryId, Long userId, OrderStatusEnumApi status, PageableRequest pageable) {
        return ordersService.getAllOrders(dispensaryId, userId, status, pageable);
    }

    @Override
    public OrdersCountResponse getOrdersCount(Long dispensaryId, Long userId, OrderStatusEnumApi status) {
        return ordersService.getOrdersCount(dispensaryId, userId, status);
    }

    @Override
    public ChangeCurrentOrderStatusResponse changeOrderStatus(long orderId, ChangeCurrentOrderStatusRequest request) throws NotFoundException {
        return ordersService.changeOrderStatus(orderId, request);
    }

    @Override
    public OrderStatusAmountsResponse getOrdersStatusAmount(Long dispensaryId) throws NotFoundException {
        return ordersService.getOrdersStatusAmount(dispensaryId);
    }

}
