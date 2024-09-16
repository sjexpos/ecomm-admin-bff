package io.oigres.ecomm.bff.admin.api.model.products.brands;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class GetAllBasicDataBrandResponse implements Serializable {
    private Long id;
    private String name;
}
