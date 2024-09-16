package io.oigres.ecomm.bff.admin.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class BrandWithNameAndProductsAmountApiResponse implements Serializable {
    private Long id;
    private String name;
    private String brandType;
    private Integer quantity;
    private Boolean isActive;
    private String logo;

}
