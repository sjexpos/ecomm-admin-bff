package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandResponse implements Serializable {
    private Integer id;
    private String name;
}
