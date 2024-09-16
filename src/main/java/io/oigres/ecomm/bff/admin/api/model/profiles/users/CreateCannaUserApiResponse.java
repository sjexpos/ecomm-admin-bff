package io.oigres.ecomm.bff.admin.api.model.profiles.users;

import io.oigres.ecomm.bff.admin.api.model.enums.UserTypeApi;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCannaUserApiResponse implements Serializable {
    private Long id;
    private Boolean isActive;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
    private Long genderId;
    private Long stateId;
    private Long zipCodeId;
    private String phone;
    private String card;
    private UserTypeApi userType;
    private Boolean verified;
}
