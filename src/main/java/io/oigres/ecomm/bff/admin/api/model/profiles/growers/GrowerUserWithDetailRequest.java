package io.oigres.ecomm.bff.admin.api.model.profiles.growers;

import io.oigres.ecomm.bff.admin.api.model.ResourceRequest;
import io.oigres.ecomm.bff.admin.api.model.SocialMediaRequest;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class GrowerUserWithDetailRequest implements Serializable {
    private Integer id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String ucpc;
    @NotNull
    private Integer brandTypeId;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String address;
    @NotNull
    @NotEmpty
    private String logo;
    @NotNull
    @NotEmpty
    private String license;
    @NotNull
    private Boolean licenseStatus;
    @NotNull
    private SocialMediaRequest socialMedia;
    @NotNull
    @NotEmpty
    private String phone;
    private List<ResourceRequest> images;
    private List<ResourceRequest> videos;
    private Boolean isActive;
}
