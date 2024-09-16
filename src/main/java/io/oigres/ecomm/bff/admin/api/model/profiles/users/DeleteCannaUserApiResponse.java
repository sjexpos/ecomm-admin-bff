package io.oigres.ecomm.bff.admin.api.model.profiles.users;

import lombok.Data;

@Data
public class DeleteCannaUserApiResponse {
    private String firstName;
    private String lastName;
    private String avatar;
    private String gender;
    private String phone;
    private String mmjCard;
    private String state;
    private String zipCode;
    private String userType;
    private Boolean isActive;
    private Boolean verified;
}
