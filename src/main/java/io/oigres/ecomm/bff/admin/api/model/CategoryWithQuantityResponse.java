package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryWithQuantityResponse extends CategoryResponse {
    private Integer quantity;
}
