package io.oigres.ecomm.bff.admin.api.model.profiles.admins;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetAllAdminUsersApiResponse implements Serializable {
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
    private String phone;
    private Boolean isActive;
}
