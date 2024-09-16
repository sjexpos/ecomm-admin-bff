package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponse implements Serializable {
    private Integer id;
    private String avatar;
    private String email;
    private Boolean isActive;
}
