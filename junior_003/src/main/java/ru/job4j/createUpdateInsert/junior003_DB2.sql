
COMMENT ON DATABASE postgres IS 'database for junior003 exercises';

CREATE TABLE role (
  id            SERIAL PRIMARY KEY,
  role         CHARACTER VARYING(100)
);

CREATE TABLE rules (
  id           SERIAL PRIMARY KEY,
  role_id      INTEGER REFERENCES role(id),
  table_name   CHARACTER VARYING(200)
);

CREATE TABLE users (
  id            SERIAL PRIMARY KEY,
  login         CHARACTER VARYING(50),
  password      CHARACTER VARYING(50),
  role_id       INTEGER REFERENCES role(id),
  name          CHARACTER VARYING(200),
  inserted_date TIMESTAMP
);

CREATE TABLE category (
  id            SERIAL PRIMARY KEY,
  name          CHARACTER VARYING(200),
  descr         CHARACTER VARYING(2000)
);

CREATE TABLE state (
  id            SERIAL PRIMARY KEY,
  name          CHARACTER VARYING(200),
  descr         CHARACTER VARYING(2000)
);

CREATE TABLE todoItem (
  id            SERIAL PRIMARY KEY,
  users_id      INTEGER REFERENCES users(id),
  category_id   INTEGER REFERENCES category(id),
  state_id      INTEGER REFERENCES state(id),
  name          CHARACTER VARYING(200),
  descr         CHARACTER VARYING(2000),
  inserted_date TIMESTAMP
);

CREATE TABLE comments (
  id            SERIAL PRIMARY KEY,
  item_id       INTEGER REFERENCES todoItem(id),
  comments      text,
  inserted_date TIMESTAMP
);

CREATE TABLE attach (
  id            SERIAL PRIMARY KEY,
  item_id       INTEGER REFERENCES todoItem(id),
  file          text,
  inserted_date TIMESTAMP
);
