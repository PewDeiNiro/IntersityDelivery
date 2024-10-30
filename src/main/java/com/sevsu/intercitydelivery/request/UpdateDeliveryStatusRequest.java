package com.sevsu.intercitydelivery.request;

import com.sevsu.intercitydelivery.enums.DeliveryStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Данные для изменения состояния посылки")
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDeliveryStatusRequest {

    @NotNull
    @Schema(description = "Уникальный идентификатор посылки", example = "0")
    private int id;

    @NotNull
    @Schema(description = "Новый статус отправки посылки", example = "IN_PROGRESS")
    private DeliveryStatus status;

}
