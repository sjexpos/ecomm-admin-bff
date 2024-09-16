package io.oigres.ecomm.bff.admin.api.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OrderWithDetailResponse implements Serializable {
    private Long id;
    private Long orderNumber;
    private long orderDate;
    private List<OrderItemResponse> items;
    private List<OrderStatusResponse> statuses;
    private String paymentMethod;
    private String deliveryMethod;
    private BigDecimal totalPriceProducts;
    private BigDecimal exciseTax;
    private BigDecimal salesTax;
    private BigDecimal totalPriceOrder;
    private OrderUserResponse user;
    private OrderDispensaryResponse dispensary;
}
