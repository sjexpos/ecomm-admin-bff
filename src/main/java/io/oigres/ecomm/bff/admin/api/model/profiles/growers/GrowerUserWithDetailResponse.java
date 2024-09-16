package io.oigres.ecomm.bff.admin.api.model.profiles.growers;

import io.oigres.ecomm.bff.admin.api.model.ResourceRequest;
import io.oigres.ecomm.bff.admin.api.model.SocialMediaRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GrowerUserWithDetailResponse implements Serializable {
    private Integer id;
    private String name;
    private String ucpc;
    private String description;
    private String email;
    private String address;
    private String logo;
    private String license;
    private Boolean licenseStatus;
    private SocialMediaRequest socialMedia;
    private String phone;
    private List<ResourceRequest> images;
    private List<ResourceRequest> videos;
    private Boolean isActive;
}
