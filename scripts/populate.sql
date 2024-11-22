BEGIN;

INSERT INTO addresses (latitude, longitude, postal_code, city, state, street)
VALUES (40.7128, -74.0060, '10007', 'New York', 'NY', '123 Broadway'),
       (34.0522, -118.2437, '90012', 'Los Angeles', 'CA', '456 Sunset Blvd'),
       (41.8781, -87.6298, '60601', 'Chicago', 'IL', '789 Michigan Ave'),
       (37.7749, -122.4194, '94103', 'San Francisco', 'CA', '101 Market St'),
       (47.6062, -122.3321, '98101', 'Seattle', 'WA', '202 Pine St');

COMMIT;

INSERT INTO contacts (phone_number, email, website, additional_phone_number, additional_email, schedule, address_id)
VALUES ('123-456-7890', 'contact1@example.com', 'http://contact1.com', '321-654-0987', 'additional1@example.com',
        '{"MONDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"13:00","breakEndTime":"14:00"},"TUESDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"13:00","breakEndTime":"14:00"},"WEDNESDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"13:00","breakEndTime":"14:00"},"THURSDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"13:00","breakEndTime":"14:00"},"FRIDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"13:00","breakEndTime":"14:00"},"SATURDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"13:00","breakEndTime":"14:00"},"SUNDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"13:00","breakEndTime":"14:00"}}',
        1),
       ('234-567-8901', 'contact2@example.com', 'http://contact2.com', '432-567-8901', 'additional2@example.com',
        '{"MONDAY":{"startTime":"10:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"TUESDAY":{"startTime":"10:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"WEDNESDAY":{"startTime":"10:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"THURSDAY":{"startTime":"10:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"FRIDAY":{"startTime":"10:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"SATURDAY":{"startTime":"10:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"SUNDAY":{"startTime":"10:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"}}',
        2),
       ('345-678-9012', 'contact3@example.com', 'http://contact3.com', '543-678-9012', 'additional3@example.com',
        '{"MONDAY":{"startTime":"08:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"TUESDAY":{"startTime":"08:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"WEDNESDAY":{"startTime":"08:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"THURSDAY":{"startTime":"08:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"FRIDAY":{"startTime":"08:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"SATURDAY":{"startTime":"08:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"},"SUNDAY":{"startTime":"08:00","endTime":"17:00","breakStartTime":"12:00","breakEndTime":"13:00"}}',
        3),
       ('456-789-0123', 'contact4@example.com', 'http://contact4.com', '654-789-0123', 'additional4@example.com',
        '{"MONDAY":{"startTime":"07:00","endTime":"16:00","breakStartTime":"11:00","breakEndTime":"12:00"},"TUESDAY":{"startTime":"07:00","endTime":"16:00","breakStartTime":"11:00","breakEndTime":"12:00"},"WEDNESDAY":{"startTime":"07:00","endTime":"16:00","breakStartTime":"11:00","breakEndTime":"12:00"},"THURSDAY":{"startTime":"07:00","endTime":"16:00","breakStartTime":"11:00","breakEndTime":"12:00"},"FRIDAY":{"startTime":"07:00","endTime":"16:00","breakStartTime":"11:00","breakEndTime":"12:00"},"SATURDAY":{"startTime":"07:00","endTime":"16:00","breakStartTime":"11:00","breakEndTime":"12:00"},"SUNDAY":{"startTime":"07:00","endTime":"16:00","breakStartTime":"11:00","breakEndTime":"12:00"}}',
        4),
       ('567-890-1234', 'contact5@example.com', 'http://contact5.com', '765-890-1234', 'additional5@example.com',
        '{"MONDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"12:00","breakEndTime":"13:00"},"TUESDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"12:00","breakEndTime":"13:00"},"WEDNESDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"12:00","breakEndTime":"13:00"},"THURSDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"12:00","breakEndTime":"13:00"},"FRIDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"12:00","breakEndTime":"13:00"},"SATURDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"12:00","breakEndTime":"13:00"},"SUNDAY":{"startTime":"09:00","endTime":"18:00","breakStartTime":"12:00","breakEndTime":"13:00"}}',
        5);

COMMIT;
INSERT INTO companies (name, description, contact_id)
VALUES ('Company A', 'Description for Company A', 1),
       ('Company B', 'Description for Company B', 2),
       ('Company C', 'Description for Company C', 3),
       ('Company D', 'Description for Company D', 4),
       ('Company E', 'Description for Company E', 5);


COMMIT;
INSERT INTO services (name, description, duration, company_id)
VALUES ('Service 1', 'Description for Service 1', '{"hours":1,"minutes":30}', 1),
       ('Service 2', 'Description for Service 2', '{"hours":2,"minutes":0}', 2),
       ('Service 3', 'Description for Service 3', '{"hours":3,"minutes":15}', 3),
       ('Service 4', 'Description for Service 4', '{"hours":1,"minutes":45}', 4),
       ('Service 5', 'Description for Service 5', '{"hours":2,"minutes":30}', 5);

COMMIT;
INSERT INTO staffs (name, description, company_id)
VALUES ('Staff 1', 'Description for Staff 1', 1),
       ('Staff 2', 'Description for Staff 2', 2),
       ('Staff 3', 'Description for Staff 3', 3),
       ('Staff 4', 'Description for Staff 4', 4),
       ('Staff 5', 'Description for Staff 5', 5);

COMMIT;
INSERT INTO staff_services (staff_id, service_id, price)
VALUES (1, 1, 100.00),
       (1, 2, 150.00),
       (2, 3, 200.00),
       (2, 4, 250.00),
       (3, 5, 300.00),
       (4, 1, 120.00),
       (4, 3, 180.00),
       (5, 2, 160.00),
       (5, 4, 220.00);
END;