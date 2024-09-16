package io.oigres.ecomm.bff.admin.api.model.profiles.admins;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BulkDeleteAdminUserErrorResponse {
    private Long id;
}
