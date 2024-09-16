package io.oigres.ecomm.bff.admin.api.model.products.strains;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class GetAllBasicDataStrainResponse implements Serializable {
    private Long id;
    private String name;
}
