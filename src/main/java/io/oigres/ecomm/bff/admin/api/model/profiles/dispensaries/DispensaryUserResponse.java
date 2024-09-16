package io.oigres.ecomm.bff.admin.api.model.profiles.dispensaries;

import io.oigres.ecomm.bff.admin.api.model.UserResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DispensaryUserResponse extends UserResponse {
    private String name;
    private String state;
    private String licenseStatus;
}
