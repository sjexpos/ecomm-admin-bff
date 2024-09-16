package io.oigres.ecomm.bff.admin.api.model.profiles.dispensaries;

import io.oigres.ecomm.bff.admin.api.model.ResourceRequest;
import io.oigres.ecomm.bff.admin.api.model.SocialMediaRequest;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class CreateDispensaryUserApiResponse implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String email;
    private String address;
    private String logo;
    private String license;
    private String licenseStatus;
    private SocialMediaRequest socialMedia;
    private String phone;
    private List<ResourceRequest> images;
    private List<ResourceRequest> videos;
    private Boolean isActive;
    private Long userId;
}
