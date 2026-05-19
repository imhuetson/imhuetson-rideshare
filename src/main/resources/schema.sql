CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(255),
    full_name VARCHAR(100),
    email VARCHAR(100),
    role VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS ride (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pickup_location VARCHAR(255),
    destination_campus VARCHAR(255),
    ride_date DATE,
    ride_time TIME,
    max_passengers INT,
    cancelled BOOLEAN,
    driver_id BIGINT,
    CONSTRAINT fk_driver FOREIGN KEY (driver_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS ride_passengers (
    ride_id BIGINT,
    passenger_id BIGINT,
    CONSTRAINT fk_ride FOREIGN KEY (ride_id) REFERENCES ride(id),
    CONSTRAINT fk_passenger FOREIGN KEY (passenger_id) REFERENCES users(id)
);

