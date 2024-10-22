package com.sevsu.intercitydelivery.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Данные для авторизации/регистрации")
@NoArgsConstructor
@AllArgsConstructor
public class SignRequest {

    @NotNull
    @NotBlank
    @Schema(description = "Логин пользователя", example = "root")
    private String username;

    @NotNull
    @NotBlank
    @Schema(description = "Пароль пользователя", example = "root")
    private String password;

}
