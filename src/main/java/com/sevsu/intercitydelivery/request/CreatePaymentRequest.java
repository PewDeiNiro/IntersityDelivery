package com.sevsu.intercitydelivery.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Данные для создания платежа")
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {

    @Schema(description = "Сумма платежа")
    @NotNull
    private double amount;

    @Schema(description = "Название товара")
    @NotEmpty
    private String title;

    @Schema(description = "Уникальный идентификатор пользователя")
    @NotNull
    private int userId;

    @Schema(description = "Токен пользователя")
    @NotEmpty
    private String token;

}
