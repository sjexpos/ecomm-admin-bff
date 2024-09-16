package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DashboardAppDownloadsResponse implements Serializable {
    private Integer downloads;
    private Integer reviews;
    private Float average;
    private Integer oneStarPercent;
    private Integer twoStarPercent;
    private Integer threeStarPercent;
    private Integer fourStarPercent;
    private Integer fiveStarPercent;
}
