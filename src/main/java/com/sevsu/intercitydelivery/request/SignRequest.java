package com.sevsu.intercitydelivery.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Данные для авторизации/регистрации")
@NoArgsConstructor
@AllArgsConstructor
public class SignRequest {

    @NotEmpty
    @Schema(description = "Логин пользователя", example = "root")
    private String username;

    @NotEmpty
    @Schema(description = "Пароль пользователя", example = "root")
    private String password;

}
