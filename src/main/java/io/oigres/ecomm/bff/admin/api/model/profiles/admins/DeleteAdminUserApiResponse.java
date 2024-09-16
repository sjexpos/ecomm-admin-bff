package io.oigres.ecomm.bff.admin.api.model.profiles.admins;

import lombok.Data;

@Data
public class DeleteAdminUserApiResponse {
    private String firstName;
    private String lastName;
    private String avatar;
    private String phone;
}
