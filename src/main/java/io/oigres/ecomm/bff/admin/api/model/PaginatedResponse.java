package io.oigres.ecomm.bff.admin.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
public class PaginatedResponse<T extends Serializable> implements Serializable {
    private Collection<T> rows;
    private int totalPages;
    private int page;
    private int size;
    private long totalItems;
}
