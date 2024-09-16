package io.oigres.ecomm.bff.admin.api.model.profiles.users;

import io.oigres.ecomm.bff.admin.api.model.enums.UserTypeApi;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CreateCannaUserApiRequest implements Serializable {
    @Schema(name = "email", required = true)
    @NotEmpty
    @Email
    private String email;
    @Schema(name = "password", required = true)
    @NotEmpty
    private String password;
    @Schema(name = "firstName", required = true)
    @NotEmpty
    private String firstName;
    @Schema(name = "lastName", required = true)
    @NotEmpty
    private String lastName;
    @Schema(name = "genderId", required = true)
    @NotNull
    private Long genderId;
    @Schema(name = "stateId", required = true)
    @NotNull
    private Long stateId;
    @Schema(name = "zipCodeId", required = true)
    @NotNull
    private Long zipCodeId;
    @Schema(name = "phone", required = true)
    @NotEmpty
    private String phone;

    @Schema(name = "avatar", required = false, allowableValues = "avatar image URL")
    private String avatar;

    @Schema(name = "card", example = "/id_card_image.png", required = false, allowableValues = "card image URL (no matter what type of card it is)")
    @NotEmpty
    private String card;
    @Schema(name = "userType", required = true)
    @NotEmpty
    private UserTypeApi userType;
}
