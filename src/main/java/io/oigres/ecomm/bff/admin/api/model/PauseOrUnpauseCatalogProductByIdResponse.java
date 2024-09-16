package io.oigres.ecomm.bff.admin.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PauseOrUnpauseCatalogProductByIdResponse implements Serializable {
    private Long id;
    private Boolean enabled;
}