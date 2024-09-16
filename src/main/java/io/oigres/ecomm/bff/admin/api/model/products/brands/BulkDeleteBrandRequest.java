package io.oigres.ecomm.bff.admin.api.model.products.brands;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BulkDeleteBrandRequest {
    @Schema(name = "ids", example = "[1,2,3,4,5]")
    @NotEmpty(message = "at least 1 brand must be sent")
    private List<Long> ids;
}