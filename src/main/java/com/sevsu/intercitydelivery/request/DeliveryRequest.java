package com.sevsu.intercitydelivery.request;

import com.sevsu.intercitydelivery.model.Coordinate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Данные для инициализации доставки")
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRequest {

    @NotNull
    @Schema(description = "Уникальный идентификатор пользователя", example = "0")
    private int userId;

    @NotNull
    @Schema(description = "Токен входа пользователя, получается при регистрации/авторизации")
    private String token;

    @NotNull
    @Schema(description = "Географические координаты точки отправления")
    private Coordinate departure;

    @NotNull
    @Schema(description = "Географические координаты точки получения")
    private Coordinate destination;

    @NotNull
    @Schema(description = "Вес посылки, не должен превышать 100кг", example = "58.9")
    private double weight;
}
