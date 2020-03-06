CREATE TABLE role
(
  id      BIGSERIAL PRIMARY KEY       NOT NULL,
  name    CHARACTER VARYING(100)      NOT NULL,
  title   CHARACTER VARYING(255)      NOT NULL,
  version BIGINT                      NOT NULL,
  CONSTRAINT role_name_unique UNIQUE (id)
);