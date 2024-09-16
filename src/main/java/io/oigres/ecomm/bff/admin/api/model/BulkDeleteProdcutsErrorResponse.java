package io.oigres.ecomm.bff.admin.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BulkDeleteProdcutsErrorResponse {
    private Long id;
}
