package io.oigres.ecomm.bff.admin.api.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class GetOrdersListWithTotalResponse implements Serializable {
    PaginatedResponse<OrderResponse> orders;
    BigDecimal total;
}
