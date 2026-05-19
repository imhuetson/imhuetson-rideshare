INSERT INTO users (username, password, full_name, email, role)

VALUES
    (
     'admin',
     'adminPass1',
     'System Admin',
     'admin@email.com',
     'ADMIN'
    );

INSERT INTO users (username, password, full_name, email, role)

VALUES
    (
     'iliana',
     'password1',
     'Iliana',
     'iliana@mail.com',
     'ADMIN'
    );

INSERT INTO users (username, password, full_name, email, role)

VALUES
    (
     'user',
     'userPass1',
     'System User',
     'user@mail.com',
     'USER'
    );

INSERT INTO ride
(
 pickup_location,
 destination_campus,
 ride_date,
 ride_time,
 max_passengers,
 cancelled,
 completed,
 driver_id
)

VALUES
    (
     'Downtown Omaha',
     'Elkhorn Campus',
     '2026-05-19',
     '08:30:00',
     3,
     false,
     false,
     1
    );