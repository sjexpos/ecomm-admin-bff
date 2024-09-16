package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

@Data
public class ChangeStrainStateByIdApiResponse {
    private Long id;
    private Boolean isActive;
}
