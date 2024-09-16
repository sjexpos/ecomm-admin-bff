package io.oigres.ecomm.bff.admin.api.model.profiles.users;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetAllCannaUsersApiResponse implements Serializable {
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
    private String gender;
    private String phone;
    private String state;
    private String zipCode;
    private String userType;
    private Boolean isActive;
    private Boolean verified;
}
