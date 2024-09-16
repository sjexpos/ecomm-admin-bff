package io.oigres.ecomm.bff.admin.api.model.profiles.dispensaries;

import io.oigres.ecomm.bff.admin.api.model.ResourceRequest;
import io.oigres.ecomm.bff.admin.api.model.SocialMediaRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDispensaryUserApiResponse {
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
