package io.oigres.ecomm.bff.admin.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@NoArgsConstructor
@Data
public class IdListGenericRequest {
    @Schema(name = "ids", example = "[1,2,3,4,5]")
    @NotEmpty(message = "at least one id id must be sent")
    private List<Long> ids;
}
