package io.oigres.ecomm.bff.admin.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetCatalogProductsByBrandIdApiResponse implements Serializable {
    private long id;
    private String title;
}