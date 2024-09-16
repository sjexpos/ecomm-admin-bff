package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class DashboardSocialMediaResponse implements Serializable {
    private String icon;
    private LocalDate date;
    private String detail;
}
