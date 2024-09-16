package io.oigres.ecomm.bff.admin.api.model.products;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BulkCPErrorResponse {
    private Long id;
    private String data;
}
