package io.oigres.ecomm.bff.admin.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ResourceResponse implements Serializable {
    @Schema(name = "id", example = "1")
    private Integer id;
    @Schema(name = "src", example = "http://resource.src", required = true)
    private String src;
    @Schema(name = "fileType", example = "file_type", required = true)
    private String fileType;
}