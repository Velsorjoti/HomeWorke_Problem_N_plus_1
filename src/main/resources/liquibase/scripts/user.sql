-- liquibase formatted sql

-- changeset V:1
CREATE TABLE user (
     id         BIGSERIAL PRIMARY KEY,
     username   VARCHAR(255)
)
//