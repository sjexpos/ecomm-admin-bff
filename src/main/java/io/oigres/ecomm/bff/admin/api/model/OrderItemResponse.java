package io.oigres.ecomm.bff.admin.api.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class OrderItemResponse implements Serializable {
    private Long publicationId;
    private Integer units;
    private String img;
    private String name;
    private BigDecimal price;
    private Boolean isPaused;
    private Boolean isDeleted;
}
