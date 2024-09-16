package io.oigres.ecomm.bff.admin.api.model.profiles.admins;

import io.oigres.ecomm.bff.admin.api.model.UserResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AdminUserResponse extends UserResponse {
    private String firstName;
    private String lastName;
}
