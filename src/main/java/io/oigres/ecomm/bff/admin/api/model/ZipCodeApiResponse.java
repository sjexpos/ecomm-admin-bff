package io.oigres.ecomm.bff.admin.api.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ZipCodeApiResponse implements Serializable {
    private Long id;
    private String name;
}

