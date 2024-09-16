package io.oigres.ecomm.bff.admin.api.model.profiles.dispensaries;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class GetAllDispensariesApiResponse implements Serializable {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "logoImageURL", example = "")
    private String logoImageURL;
    @Schema(name = "email", example = "info@leftcoast.club")
    private String email;
    @Schema(name = "enabled", example = " ")
    private Boolean enabled;
    @Schema(name = "name", example = "")
    private String name;
    @Schema(name = "state", example = "Left Coast Extracts")
    private String state;
    @Schema(name = "licenseStatus", example = "Left Coast Extracts")
    private String licenseStatus;
    @Schema(name = "userId", example = "1")
    private Long userId;
}
