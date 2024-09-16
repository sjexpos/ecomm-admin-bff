package io.oigres.ecomm.bff.admin.api.model.profiles.growers;

import io.oigres.ecomm.bff.admin.api.model.UserResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GrowerUserResponse extends UserResponse {
    private String name;
    private String state;
    private String licenseStatus;
    private String growerType;
}
