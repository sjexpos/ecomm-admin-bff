package io.oigres.ecomm.bff.admin.api.model.profiles.dispensaries;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BulkDeleteDispensaryUserErrorResponse {
    private Long id;
    private String data;
}
