package io.oigres.ecomm.bff.admin.api.model.profiles.admins;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class AdminUserWithDetailResponse implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String img;
    private String email;
    private String phone;
    private Boolean isActive;
}
