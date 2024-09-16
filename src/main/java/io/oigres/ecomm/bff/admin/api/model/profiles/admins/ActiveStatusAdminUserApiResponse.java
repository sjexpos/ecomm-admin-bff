package io.oigres.ecomm.bff.admin.api.model.profiles.admins;

import lombok.Data;

@Data
public class ActiveStatusAdminUserApiResponse {
    private Long id;
    private Boolean isActive;
}