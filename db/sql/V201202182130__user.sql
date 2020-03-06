CREATE TABLE user_tbl
(
  id       BIGSERIAL PRIMARY KEY       NOT NULL,
  name     CHARACTER VARYING(100)      NOT NULL,
  login    CHARACTER VARYING(50)       NOT NULL,
  password CHARACTER VARYING(50)       NOT NULL,
  version  BIGINT                      NOT NULL,
  CONSTRAINT user_login_unique UNIQUE (login)
);

