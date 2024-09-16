package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SocialMediaResponse implements Serializable {
    private String instagram;
    private String twitter;
    private String facebook;
    private String website;
}
