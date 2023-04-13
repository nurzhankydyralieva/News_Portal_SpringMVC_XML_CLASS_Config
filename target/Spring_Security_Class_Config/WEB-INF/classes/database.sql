CREATE TABLE users (
                       username VARCHAR(15),
                       password VARCHAR(100),
                       enabled INT DEFAULT(1),
                       PRIMARY KEY (username)
) ;

CREATE TABLE authorities (
                             username VARCHAR(15),
                             authority VARCHAR(25),
                             FOREIGN KEY (username) REFERENCES users(username)
) ;

INSERT INTO users (username, password, enabled)
VALUES
    ('user', '{bcrypt}$2a$12$gj.gXuTIKVKMq9mBa.4miOmydnZTwpK1F8RG/GvXTQc83clnn/83G', 1),
    ('admin', '{bcrypt}$2a$12$mlnYPHxCLwonrIfCI.2UI.cOUnjHKaGsJ6z3qxSEwhYgxU/nywXcS', 1);

INSERT INTO authorities (username, authority)
VALUES
    ('user', 'ROLE_USER'),
    ('admin', 'ROLE_ADMIN');

