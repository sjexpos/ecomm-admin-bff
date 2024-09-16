package io.oigres.ecomm.bff.admin.api.model.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageUploadLocationApiResponse {
    private String uploadURL;
    private String httpMethod;
    private String key;
    
}
