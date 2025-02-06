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

package io.oigres.ecomm.bff.admin.api;

public class Routes {
  public static final String API_PREFIX = "/api";

  public static final String AUTH_PATH = "/v1/auth";
  public static final String PRODUCTS_PATH = "/v1/products";
  public static final String CATEGORIES_PATH = API_PREFIX + "/v1/categories";
  public static final String BRANDS_PATH = "/v1/brands";
  public static final String BRANDS_QUANTITY_PATH = "/v1/brands-with-quantity";
  public static final String ORDERS_PATH = API_PREFIX + "/v1/orders";
  public static final String STRAINS_PATH = "/v1/strains";
  public static final String USERS_PATH = "/v1/users";
  public static final String DASHBOARD_PATH = "/v1/dashboard";
  public static final String EFFECTS_PATH = "/v1/effects";
  public static final String UNITS_PATH = "/v1/units";
  public static final String UTILS_PATH = "/v1/utils";
  public static final String REGION_PATH = "/v1/regions";
  public static final String STRAINS_BASIC_DATA_PATH = "/v1/strains-basic-data";
  public static final String BRANDS_BASIC_DATA_PATH = "/v1/brands-basic-data";

  public static final String SIGN_IN = "/signin";
  public static final String CATEGORIES_WITH_QUANTITY = "/with-quantity";
  public static final String SUBCATEGORIES = "/{categoryId}/subcategories";
  public static final String CANNA_USERS = "/cannausers";
  public static final String CANNA_USERS_BY_ID = "/cannausers/{userId}";
  public static final String DISPENSARY_USERS = "/dispensaries";
  public static final String DISPENSARY_USERS_UPDATE = "/dispensaries/{dispensaryId}";
  public static final String DISPENSARY_USERS_GET_BY_ID = "/dispensaries/{dispensaryId}";
  public static final String ACTIVATE_DISPENSARY_USER_BY_DISPENSARY_USER_ID =
      "/dispensaries/{userId}/activate";
  public static final String DEACTIVATE_DISPENSARY_USER_BY_DISPENSARY_USER_ID =
      "/dispensaries/{userId}/deactivate";
  public static final String ADMIN_USERS = "/admins";
  public static final String ADMIN_USERS_UPDATE = "/admins/{userId}";
  public static final String ADMIN_USERS_BY_ID = "/admins/{userId}";
  public static final String GROWER_USERS = "/growers";
  public static final String GROWER_USERS_UPDATE = "/growers/{userId}";
  public static final String PRODUCTS_TO_APPROVE = "/approve";
  public static final String ORDERS_BY_ID = "/{orderId}";
  public static final String GENDERS = "/genders";
  public static final String STATES = "/states";
  public static final String ZIP_CODES = "/states/{stateId}/zipcodes";
  public static final String USER_TYPES = "/usertypes";
  public static final String ACTIVE = "/active";
  public static final String BRANDS_WITH_AMOUNT = "/brands-with-quantity";
  public static final String GET_BRAND_BY_ID = "/{brandId}";
  public static final String BRAND_BY_ID_ACTIVATE = "/{brandId}/activate";
  public static final String BRAND_BY_ID_DEACTIVATE = "/{brandId}/deactivate";
  public static final String GET_SIGNED_URL_TO_UPLOAD_BRAND_IMAGE = "/uploads/image";
  public static final String GET_SIGNED_URL_TO_UPLOAD_BRAND_VIDEO = "/uploads/video";
  public static final String DELETE_BRAND_BY_ID = "/{brandId}";
  public static final String BRAND_UPDATE = "/{brandId}";
  public static final String GET_STRAIN_BY_ID = "/{strainId}";
  public static final String DELETE_STRAIN_BY_ID = "/{strainId}";
  public static final String STRAIN_UPDATE = "/{strainId}";
  public static final String DEACTIVATE_STRAIN_BY_ID = "/{strainId}/deactivate";
  public static final String ACTIVATE_STRAIN_BY_ID = "/{strainId}/activate";
  public static final String GET_SIGNED_URL_TO_UPLOAD_STRAIN_IMAGE = "/uploads/image";
  public static final String CATALOG_PRODUCTS = "/catalog";
  public static final String CATALOG_PRODUCTS_BY_ID = "/catalog/{catalogProductId}";

  public static final String DEACTIVATE_CATALOG_PRODUCT_BY_ID =
      "/catalog/{catalogProductId}/deactivate";
  public static final String ACTIVATE_CATALOG_PRODUCT_BY_ID =
      "/catalog/{catalogProductId}/activate";
  public static final String ADD_CATALOG_PRODUCT = "/catalog";
  public static final String EDIT_CATALOG_PRODUCT = "/catalog/{catalogProductId}";
  public static final String GET_CATALOG_PRODUCTS_BY_BRAND_ID = "/catalog/brand/{brandId}";
  public static final String ACTIVATE_CATALOG_PRODUCTS = "/catalog/activate";
  public static final String DEACTIVATE_CATALOG_PRODUCTS = "/catalog/deactivate";
  public static final String FLAVORS_PATH = "/v1/flavors";
  public static final String GET_FLAVOR_BY_ID = "/{flavorId}";

  public static final String CONDITIONS_PATH = "/v1/conditions";
  public static final String CONDITION_BY_ID = "/{conditionId}";

  public static final String TERPENES_PATH = "/v1/terpenes";
  public static final String GET_TERPENE_BY_ID = "/{terpeneId}";
  public static final String SEED_COMPANIES_PATH = "/v1/seed-companies";
  public static final String GET_SEED_COMPANY_BY_ID = "/{seedCompanyId}";

  public static final String STRAIN_TYPES_PATH = "/v1/strain-types";
  public static final String GET_STRAIN_TYPE_BY_ID = "/{strainTypeId}";
  public static final String CREATE_CANNA_USER = "/cannausers";
  public static final String EDIT_CANNA_USER_BY_ID = "/cannausers/{userId}";
  public static final String DELETE_CANNA_USER_BY_ID = "/cannausers/{userId}";
  public static final String CREATE_DISPENSARY_USER = "/dispensaries";
  public static final String CREATE_ADMIN_USER = "/admins";
  public static final String DELETE_ADMIN_USER_BY_ID = "/admins/{userId}";
  public static final String ACTIVATE_ADMIN_USER = "/admins/{userId}/activate";
  public static final String DEACTIVATE_ADMIN_USER = "/admins/{userId}/deactivate";
  public static final String BULK_DELETE_ADMIN_USERS = "/admins";
  public static final String BULK_DELETE_CANNA_USERS = "/cannausers";
  public static final String ACTIVATE_CONSUMER_USER = "/consumers/{userId}/activate";
  public static final String DEACTIVATE_CONSUMER_USER = "/consumers/{userId}/deactivate";
  public static final String CREATE_GROWER_USER = "/growers";
  public static final String BULK_DELETE_DISPENSARY_USERS = "/dispensaries";
  public static final String GET_ORDER_STATUS_AMOUNT = "/status/amounts";
  public static final String BULK_DELETE_STRAINS = "/strains";
  public static final String GET_MMJCARD_IMAGE_UPLOAD_LOCATION = "/uploads/mmjcard";

  //    public static final Set<Pair<String, String>> PERMIT_ALL_PATHS = Set.of(
  //            ImmutablePair.of(javax.ws.rs.HttpMethod.OPTIONS, "/**"),
  //            ImmutablePair.of(javax.ws.rs.HttpMethod.GET, SWAGGER_PATH),
  //            ImmutablePair.of(javax.ws.rs.HttpMethod.GET, ACTUATOR_PATH.concat(GIT_INFO)),
  //            ImmutablePair.of(javax.ws.rs.HttpMethod.POST, AUTH_PATH.concat(SIGN_IN))
  //    );

  private Routes() {}
}
