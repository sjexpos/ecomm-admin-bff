package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DashboardResponse implements Serializable {
    private DashboardStatusResponse status;
    private DashboardNewUsersResponse newUsers;
    private List<DashboardContentResponse> lastAddedContent;
    private DashboardAppDownloadsResponse googlePlay;
    private DashboardAppDownloadsResponse appStore;
    private List<DashboardSocialMediaResponse> socialMediaFeed;
}
