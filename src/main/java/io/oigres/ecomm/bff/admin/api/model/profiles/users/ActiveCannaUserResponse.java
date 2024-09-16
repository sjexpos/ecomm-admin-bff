package io.oigres.ecomm.bff.admin.api.model.profiles.users;

import lombok.Data;

import java.util.List;

@Data
public class ActiveCannaUserResponse {
    private List<Integer> ids;
}
