package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StrainWithDetailResponse implements Serializable {
    private Integer id;
    private String ucpc;
    private List<ResourceRequest> img;
    private String name;
    private Integer calmingLevel;
    private Integer typeId;
    private Integer seedCompanyId;
    private Float thc;
    private Float cbd;
    private Float cbg;
    private Float thcv;
    private List<Integer> terpenesIds;
    private List<Integer> helpsWithIds;
    private List<Integer> consumeTypesIds;
    private List<Integer> effectsIds;
    private List<Integer> flavorsIds;
    private Boolean isPaused;
    private String description;
}
