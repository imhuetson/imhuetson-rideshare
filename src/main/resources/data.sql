INSERT INTO users (username, password, full_name, email, role)

VALUES
    (
     'admin1',
     '$2a$12$nc6n36dI9Yn0sYhg5MNfJefxZnPp/2u8oVCeb3pTL30JI6g7w5S6K',
     'System Admin',
     'admin@email.com',
     'ADMIN'
    ),
    (
     'user1',
     '$2a$12$F02KSnE/ysSpAzS.KMq25O.f6N/Bg8Gl7jbtJPmu2Wrxe8LfXZ3wW',
     'System User',
     'user@email.com',
     'USER'
    ),
    (
     'driver1',
     '$2a$12$/70K27f4NkrD6dHQZdLt1en.JAU1aJpGEpYwIYRcqefvEQLtRVIjm',
     'Test Driver',
     'driver@email.com',
     'DRIVER'
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
    ),
    (
     'West Omaha',
     'South Omaha Campus',
     '2026-05-21',
     '09:15:00',
     4,
     false,
     false,
     1
    );