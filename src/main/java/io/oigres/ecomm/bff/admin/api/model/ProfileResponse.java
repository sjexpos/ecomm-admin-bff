package io.oigres.ecomm.bff.admin.api.model;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class ProfileResponse implements Serializable {
    private Long profileId;
    private String profileType;

    public ProfileResponse(Long profileId, String profileType) {
        this.profileId = profileId;
        this.profileType = profileType;
    }
}
