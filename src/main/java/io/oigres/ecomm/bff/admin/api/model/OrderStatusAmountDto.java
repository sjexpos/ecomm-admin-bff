package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderStatusAmountDto implements Serializable {
    private OrderStatusEnum name;
    private Integer amount;

}
