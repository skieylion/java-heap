-- Создание ENUM типов
CREATE TYPE room_class AS ENUM ('эконом', 'бизнес');
CREATE TYPE user_role AS ENUM ('Клиент', 'Администратор');

-- Создание таблицы для номеров с использованием ENUM
CREATE TABLE rooms (
                       id SERIAL PRIMARY KEY,
                       photo_url TEXT,
                       address TEXT NOT NULL,
                       cost NUMERIC CHECK (cost > 0),
                       seats INTEGER CHECK (seats > 0),
                       class room_class NOT NULL
);

-- Создание таблицы для занятости номеров
CREATE TABLE room_occupancy (
                                id SERIAL PRIMARY KEY,
                                room_id INTEGER REFERENCES rooms(id),
                                date_from DATE NOT NULL,
                                date_to DATE NOT NULL
);

-- Создание таблицы для заявок с использованием ENUM
CREATE TABLE requests (
                          id SERIAL PRIMARY KEY,
                          class room_class NOT NULL,
                          date_from DATE NOT NULL,
                          date_to DATE NOT NULL,
                          seats INTEGER NOT NULL
);

-- Создание таблицы для пользователей с использованием ENUM
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       full_name TEXT NOT NULL,
                       role user_role NOT NULL
);
