package io.oigres.ecomm.bff.admin.api.model.profiles.admins;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BulkDeleteAdminUsersResponse implements Serializable {
    @Builder.Default
    private List<Long> deleted = new ArrayList<>();
    @Builder.Default
    private List<BulkDeleteAdminUserErrorResponse> errors = new ArrayList<>();
}
