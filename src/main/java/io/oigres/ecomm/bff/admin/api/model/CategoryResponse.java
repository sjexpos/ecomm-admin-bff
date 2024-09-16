package io.oigres.ecomm.bff.admin.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse implements Serializable {
    private Long id;
    private String name;
}
