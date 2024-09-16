package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DashboardContentResponse implements Serializable {
    private String content;
    private String title;
    private String img;
}
