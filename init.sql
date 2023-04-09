CREATE SCHEMA IF NOT EXISTS data;

CREATE TABLE data.users
(
    id               uuid PRIMARY KEY,
    date_time_create timestamp(6)        NOT NULL,
    date_time_update timestamp(6)        NOT NULL,
    email            varchar(255) UNIQUE NOT NULL,
    full_name        varchar(255)        NOT NULL,
    role             varchar(25)         NOT NULL,
    status           varchar(25)         NOT NULL,
    password         varchar(255)        NOT NULL
);

CREATE INDEX users_email_index ON data.users (email);

INSERT INTO data.users(id, date_time_create, date_time_update, email, full_name, role, status, password)
VALUES (gen_random_uuid(),
        NOW(),
        NOW(),
        'admin@admin.com',
        'admin',
        '$2a$10$y8W1uCY4lbkHs7bHfACBqefZElsVmMkRpE0DmgeOzzBSrwh2pXHl6',
        'ADMIN',
        'ACTIVATED')


