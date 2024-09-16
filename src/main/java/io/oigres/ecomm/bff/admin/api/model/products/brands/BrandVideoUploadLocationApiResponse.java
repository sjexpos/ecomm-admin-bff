package io.oigres.ecomm.bff.admin.api.model.products.brands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandVideoUploadLocationApiResponse {
    private String uploadURL;
    private String httpMethod;
    private String key;
    
}
