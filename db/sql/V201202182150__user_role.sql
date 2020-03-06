CREATE TABLE user_role
(
  id      BIGSERIAL PRIMARY KEY NOT NULL,
  user_id BIGINT                NOT NULL,
  role_id BIGINT                NOT NULL,
  CONSTRAINT user_role_user_id_fkey FOREIGN KEY (user_id) REFERENCES user_tbl (id),
  CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id) REFERENCES role (id),
  CONSTRAINT user_role_id_unique UNIQUE (user_id, role_id)
);