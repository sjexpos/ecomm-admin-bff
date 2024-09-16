package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderStatusAmountApiResponse implements Serializable {
    private List<OrderStatusAmountDto> status;
}
