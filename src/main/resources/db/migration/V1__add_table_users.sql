CREATE TABLE users
(
    id               bigint PRIMARY KEY AUTO_INCREMENT,
    date_time_create timestamp(6)        NOT NULL,
    date_time_update timestamp(6)        NOT NULL,
    email            varchar(255) UNIQUE NOT NULL,
    full_name        varchar(255)        NOT NULL,
    image_uri        text                NOT NULL,
    status           varchar(25)         NOT NULL,
    password         varchar(255)        NOT NULL
);

CREATE INDEX users_email_index ON users (email);
