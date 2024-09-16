package io.oigres.ecomm.bff.admin.api.model.profiles;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BulkDeleteProfilesErrorResponse {
    private Long id;
}
