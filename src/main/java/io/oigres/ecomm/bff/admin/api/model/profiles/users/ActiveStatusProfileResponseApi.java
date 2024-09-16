package io.oigres.ecomm.bff.admin.api.model.profiles.users;

import lombok.Data;

@Data
public class ActiveStatusProfileResponseApi {
    private Long id;
    private Boolean enabled;
}
