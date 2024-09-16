package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetAllTerpenesApiResponse implements Serializable {
    private Long id;
    private String name;
}
