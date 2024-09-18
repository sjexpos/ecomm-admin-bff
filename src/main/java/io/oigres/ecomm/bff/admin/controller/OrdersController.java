package io.oigres.ecomm.bff.admin.controller;

import io.oigres.ecomm.bff.admin.api.Routes;
import io.oigres.ecomm.bff.admin.api.model.GetOrdersListWithTotalResponse;
import io.oigres.ecomm.bff.admin.api.model.OrderStatusEnum;
import io.oigres.ecomm.bff.admin.usecases.orders.list.GetOrdersUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.ORDERS_PATH)
@Tag(name = "Orders", description = " ")
@RequiredArgsConstructor
@Slf4j
public class OrdersController extends AbstractController {
    private final GetOrdersUseCase getOrdersUseCase;

    @Operation(summary = "Retrieve orders")
    @PageableAsQueryParam
    @GetMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public GetOrdersListWithTotalResponse getOrders(
            @RequestParam("status") OrderStatusEnum status,
            Pageable pageable
    ) {
        log.info("======= GetOrders | page={} size={} status={} =====", pageable.getPageNumber(), pageable.getPageSize(), status);
        return getOrdersUseCase.listOrders(status, pageable.getPageNumber(), pageable.getPageSize());
    }

}
