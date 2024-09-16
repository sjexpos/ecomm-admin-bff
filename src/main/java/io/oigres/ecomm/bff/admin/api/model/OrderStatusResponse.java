package io.oigres.ecomm.bff.admin.api.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class OrderStatusResponse implements Serializable {
    private Long statusDate;
    private OrderStatusEnum status;
}
