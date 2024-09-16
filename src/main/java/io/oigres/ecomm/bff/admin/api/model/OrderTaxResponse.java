package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderTaxResponse implements Serializable {
    private String name;
    private Float price;
}
