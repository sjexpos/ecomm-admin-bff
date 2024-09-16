package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BrandWithAmountResponse extends BrandResponse {
    private String type;
    private Integer amountProducts;
    private String logo;
}
