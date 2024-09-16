package io.oigres.ecomm.bff.admin.api.model.profiles.dispensaries;

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
public class BulkDeleteDispensaryUsersRequest {
    @Schema(name = "ids", example = "[1,2,3,4,5]", allowableValues = "list of dispensary ids who are going to be deleted")
    @NotEmpty(message = "at least 1 dispensary profile must be sent")
    private List<Long> ids;
}