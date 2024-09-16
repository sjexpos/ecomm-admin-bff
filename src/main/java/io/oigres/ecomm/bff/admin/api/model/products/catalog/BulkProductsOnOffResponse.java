package io.oigres.ecomm.bff.admin.api.model.products.catalog;

import io.oigres.ecomm.bff.admin.api.model.products.BulkCPErrorResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(Include.NON_EMPTY)
public class BulkProductsOnOffResponse {
    @Builder.Default
    private List<ProductIdWithPublicationIdListDto> activated = new ArrayList<>();
    @Builder.Default
    private List<ProductIdWithPublicationIdListDto> deactivated = new ArrayList<>();
    @Builder.Default
    private List<BulkCPErrorResponse> errors = new ArrayList<>();
}
