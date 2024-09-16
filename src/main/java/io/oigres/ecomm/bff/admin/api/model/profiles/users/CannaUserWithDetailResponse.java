package io.oigres.ecomm.bff.admin.api.model.profiles.users;

import lombok.Data;

import java.io.Serializable;

@Data
public class CannaUserWithDetailResponse implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer genderId;
    private Integer stateId;
    private Integer zipCodeId;
    private String phone;
    private String userType;
    private String card;
    private Boolean isActive;
}
