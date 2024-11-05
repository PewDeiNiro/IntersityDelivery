package com.sevsu.intercitydelivery.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Данные для отмены доставки")
@NoArgsConstructor
@AllArgsConstructor
public class CancelDeliveryRequest {

    @NotNull
    @Schema(description = "Уникальный идентификатор пользователя", example = "1")
    private int userId;

    @NotEmpty
    @Schema(description = "Токен авторизации пользователя")
    private String token;

    @NotNull
    @Schema(description = "Уникальный идентификатор доставки", example = "1")
    private int deliveryId;

}
