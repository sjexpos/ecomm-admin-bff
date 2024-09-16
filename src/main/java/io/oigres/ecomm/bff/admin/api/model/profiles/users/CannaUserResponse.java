package io.oigres.ecomm.bff.admin.api.model.profiles.users;

import io.oigres.ecomm.bff.admin.api.model.UserResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CannaUserResponse extends UserResponse {
    private String firstName;
    private String lastName;
    private String state;
    private String userType;
}
