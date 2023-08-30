-- Добавление данных в таблицу users
INSERT INTO users (full_name, role) VALUES
                                        ('Иван Иванов', 'Клиент'),
                                        ('Петр Петров', 'Клиент'),
                                        ('Админ Админов', 'Администратор');

-- Добавление данных в таблицу rooms
INSERT INTO rooms (photo_url, address, cost, seats, class) VALUES
                                                               (NULL, 'ул. Первая, 1', 1000, 2, 'эконом'),
                                                               ('http://example.com/room2.jpg', 'ул. Вторая, 2', 2000, 4, 'бизнес'),
                                                               ('http://example.com/room3.jpg', 'ул. Третья, 3', 1500, 3, 'эконом');

-- Добавление данных в таблицу room_occupancy
INSERT INTO room_occupancy (room_id, date_from, date_to) VALUES
                                                             (1, '2023-09-01', '2023-09-10'),
                                                             (2, '2023-09-05', '2023-09-15'),
                                                             (3, '2023-09-20', '2023-09-30');

-- Добавление данных в таблицу requests
INSERT INTO requests (class, date_from, date_to, seats) VALUES
                                                            ('эконом', '2023-10-01', '2023-10-10', 2),
                                                            ('бизнес', '2023-10-05', '2023-10-15', 4),
                                                            ('эконом', '2023-10-20', '2023-10-30', 3);
