package io.oigres.ecomm.bff.admin.api.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GenderApiResponse implements Serializable {
    private Long id;
    private String name;
}
