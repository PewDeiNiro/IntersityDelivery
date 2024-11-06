CREATE SCHEMA IF NOT EXISTS interdel;

CREATE TABLE IF NOT EXISTS interdel.users
(
    id            INT AUTO_INCREMENT,
    user_name     VARCHAR(50),
    user_password VARCHAR(50),
    amount        FLOAT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS interdel.deliveries
(
    id                    INT AUTO_INCREMENT,
    departure_latitude    FLOAT,
    departure_longitude   FLOAT,
    destination_latitude  FLOAT,
    destination_longitude FLOAT,
    weight                FLOAT,
    delivery_status       VARCHAR(30),
    user_id               INT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES interdel.users (id)
);

CREATE TABLE IF NOT EXISTS interdel.invoices
(
    id             INT AUTO_INCREMENT,
    amount         FLOAT,
    title          VARCHAR(100),
    user_id        INT,
    payment_status VARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES interdel.users (id)
);

INSERT IGNORE INTO interdel.users VALUES (1, "admin", "admin", "10000000");
INSERT IGNORE INTO interdel.users VALUES (2, "user", "user", "0");
INSERT IGNORE INTO interdel.deliveries VALUES (1, 44.5848, 33.4376, 44.5955, 33.4760, 50, "PENDING", 1);
INSERT IGNORE INTO interdel.deliveries VALUES (2, 44.5848, 33.4376, 44.5955, 33.4760, 50, "PENDING", 2);
INSERT IGNORE INTO interdel.invoices VALUES (1, 1000, "Тестовый платеж", 1, "CANCELLED");
INSERT IGNORE INTO interdel.invoices VALUES (2, 1000, "Тестовый платеж", 2, "PENDING");
INSERT IGNORE INTO interdel.invoices VALUES (3, 1000, "Тестовый платеж", 2, "SUCCEEDED");