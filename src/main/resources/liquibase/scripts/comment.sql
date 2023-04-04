-- liquibase formatted sql

-- changeset V:1
CREATE TABLE comment (
    id BIGSERIAL PRIMARY KEY ,
    body VARCHAR(255),
    user_id BIGINT REFERENCES user(id),
    post_id BIGINT REFERENCES post(id)
)
//