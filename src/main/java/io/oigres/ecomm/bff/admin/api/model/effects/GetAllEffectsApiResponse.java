package io.oigres.ecomm.bff.admin.api.model.effects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllEffectsApiResponse implements Serializable {
    private Long id;
    private String name;
    private String tagIcon;
}
