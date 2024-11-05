package com.sevsu.intercitydelivery.enums;

public enum DeliveryStatus {

    PENDING(0, "В обработке"),
    IN_PROGRESS(1, "В работе"),
    COMPLETED(2, "Завершено"),
    CANCELED(3, "Отменена");

    private final int code;

    private final String title;

    DeliveryStatus(int code, String title) {
        this.code = code;
        this.title = title;
    }

    @Override
    public String toString(){
        return this.title;
    }

}
