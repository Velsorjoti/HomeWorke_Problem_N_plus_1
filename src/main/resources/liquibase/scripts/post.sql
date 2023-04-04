-- liquibase formatted sql

-- changeset V:1
CREATE TABLE post (
    id      BIGSERIAL PRIMARY KEY,
    title   VARCHAR(255) NOT NULL,
    body    VARCHAR(255) NOT NULL,
    user_id BIGINT REFERENCES user(id)
)
//