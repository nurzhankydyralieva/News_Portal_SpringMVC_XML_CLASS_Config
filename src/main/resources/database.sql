CREATE TABLE users
(
    id       BIGSERIAL,
    username VARCHAR(40) NOT NULL,
    password VARCHAR(255),
    email    VARCHAR(50) UNIQUE,
    PRIMARY KEY (id)
);
CREATE TABLE roles
(
    id   SERIAL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE users_roles
(
    user_id BIGINT NOT NULL,
    role_id INT    NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);
INSERT INTO roles(name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');
INSERT INTO users(username, password, email)
VALUES ('user', '$2a$12$pDXNLws39odiyPuo4cgU2OHwj3AKYQhDyVC3LaylXrVsnpH2h.Bnm', 'user@gmail.com');
INSERT INTO users(username, password, email)
VALUES ('admin', '$2a$12$PCMy5a9Yy5UFHaKTUpycCuDOQ2nel3zQ.8qdMjyEuGrKJu9bp9odq', 'admin@gmail.com');

INSERT INTO users_roles(user_id, role_id) VALUES (1,1);
INSERT INTO users_roles(user_id, role_id) VALUES (2,2);


