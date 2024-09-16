package io.oigres.ecomm.bff.admin.api.model.profiles.dispensaries;

import io.oigres.ecomm.bff.admin.api.model.ResourceRequest;
import io.oigres.ecomm.bff.admin.api.model.SocialMediaRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class CreateDispensaryUserApiRequest implements Serializable {
    @Schema(name = "name", example = "", required = true)
    @NotEmpty
    private String name;
    @Schema(name = "description", example = "", required = true)
    @NotEmpty
    private String description;
    @Schema(name = "email", example = "dispensary@email.com", required = true)
    @NotEmpty
    @Email
    private String email;
    @Schema(name = "password", example = "", required = true)
    @NotEmpty
    private String password;
    @Schema(name = "address", example = "", required = true)
    @NotEmpty
    private String address;
    @Schema(name = "logo", example = "", required = true)
    @NotEmpty
    private String logo;
    @Schema(name = "license", example = "", required = true)
    @NotEmpty
    private String license;
    @Schema(name = "licenseStatus", allowableValues = "PENDING, APPROVED, REJECTED", example = "PENDING", required = true)
    @NotEmpty(message = "licenseStatus must not be empty")
    private String licenseStatus;
    @Schema(name = "socialMedia", example = "", required = true)
    @NotNull
    private SocialMediaRequest socialMedia;
    @Schema(name = "phone", example = "", required = true)
    @NotEmpty
    private String phone;
    @Schema(name = "images", example = "", required = false)
    private List<ResourceRequest> images;
    @Schema(name = "videos", example = "", required = false)
    private List<ResourceRequest> videos;
    @Schema(name = "isActive", example = "", required = false, type = "boolean")
    private Boolean isActive;
}
