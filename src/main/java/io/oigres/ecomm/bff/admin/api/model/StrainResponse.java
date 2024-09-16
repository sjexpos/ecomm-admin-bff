package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class StrainResponse implements Serializable {
    private Integer id;
    private String name;
    private ResourceResponse img;
    private String type;
    private Float thc;
    private Float thcv;
    private Float cbg;
    private Float cbd;
    private String terpene;
    private String top;
    private Boolean isPaused;
}
