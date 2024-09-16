package io.oigres.ecomm.bff.admin.api.model.products.brands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BulkDeleteBrandApiResponse {
    @Builder.Default
    private List<Long> deleted = new ArrayList<>();
    @Builder.Default
    private List<BulkDeleteBrandErrorApiResponse> errors = new ArrayList<>();
}
