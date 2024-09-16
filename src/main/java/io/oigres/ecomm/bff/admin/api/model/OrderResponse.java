package io.oigres.ecomm.bff.admin.api.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class OrderResponse implements Serializable {
    private Long id;
    private long orderDate;
    private Long orderNumber;
    private String dispensary;
    private OrderStatusEnum status;
    private BigDecimal total;
}
