package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DashboardStatusResponse implements Serializable {
    private Integer newOrders;
    private Integer ordersToConfirm;
    private Double salesThisMonth;
    private Integer expiredLicenses;
}
