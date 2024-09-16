package io.oigres.ecomm.bff.admin.api.model.profiles.users;

import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CannaUserWithDetailRequest implements Serializable {
    private Integer id;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    private String avatar;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    private Integer genderId;
    @NotNull
    private Integer stateId;
    @NotNull
    private Integer zipCodeId;
    @NotNull
    @NotEmpty
    private String phone;
    @NotNull
    @NotEmpty
    private String userType;
    @NotNull
    @NotEmpty
    private String card;
    private Boolean isActive;
}
