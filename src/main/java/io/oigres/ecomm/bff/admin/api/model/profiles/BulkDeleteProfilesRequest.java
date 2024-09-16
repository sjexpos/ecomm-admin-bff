package io.oigres.ecomm.bff.admin.api.model.profiles;

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
public class BulkDeleteProfilesRequest {
    @Schema(name = "userIds", example = "[1,2,3,4,5]")
    @NotEmpty(message = "at least 1 userId must be sent")
    private List<Long> userIds;
}