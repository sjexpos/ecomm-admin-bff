/**********
 This project is free software; you can redistribute it and/or modify it under
 the terms of the GNU General Public License as published by the
 Free Software Foundation; either version 3.0 of the License, or (at your
 option) any later version. (See <https://www.gnu.org/licenses/gpl-3.0.html>.)

 This project is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 more details.

 You should have received a copy of the GNU General Public License
 along with this project; if not, write to the Free Software Foundation, Inc.,
 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 **********/
// Copyright (c) 2024-2025 Sergio Exposito.  All rights reserved.              

package io.oigres.ecomm.bff.admin.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiV3Configuration {

  @Bean
  public OpenAPI customOpenAPI(OpenApiV3Properties openApiV3Properties) {
    return new OpenAPI()
        .info(
            new Info()
                .title(openApiV3Properties.getBff().getAdmin().getName())
                .version(openApiV3Properties.getBff().getAdmin().getVersion())
                .description(openApiV3Properties.getBff().getAdmin().getDescription())
                .termsOfService(openApiV3Properties.getTermsOfService())
                .license(
                    new License().name("Private License").url(openApiV3Properties.getLicense())));
  }
}
