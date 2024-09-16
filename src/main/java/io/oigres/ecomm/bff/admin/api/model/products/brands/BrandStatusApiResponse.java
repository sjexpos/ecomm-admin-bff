package io.oigres.ecomm.bff.admin.api.model.products.brands;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandStatusApiResponse implements Serializable {
    private Long id;
    private Boolean enabled;
}
