package io.oigres.ecomm.bff.admin.api.model.products.brands;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BulkDeleteBrandErrorApiResponse {
    private Long id;
}
