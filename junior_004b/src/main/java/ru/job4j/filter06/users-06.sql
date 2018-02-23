CREATE TABLE role (
  id            SERIAL PRIMARY KEY,
  role         CHARACTER VARYING(100)
);

CREATE TABLE public.users
(
  id SERIAL PRIMARY KEY,
  login character varying(50),
  role_id INTEGER REFERENCES role(id),
  password character varying(50),
  name character varying(200),
  inserted_date TIMESTAMP,
  email character varying(200)
);

INSERT INTO role(id, role) VALUES(1, 'admin');
INSERT INTO role(id, role) VALUES(2, 'normal_user');

INSERT INTO users (login, password, role_id, name, inserted_date, email) VALUES('alex', '123', 1, 'Alex', CURRENT_TIMESTAMP(0), 'alex@mail.ru');
INSERT INTO users (login, password, role_id, name, inserted_date, email) VALUES('agent007', '123', 2, 'Agent 007', CURRENT_TIMESTAMP(0), '007@mail.ru');
INSERT INTO users (login, password, role_id, name, inserted_date, email) VALUES('agent009', '123', 2, 'Agent KGB', CURRENT_TIMESTAMP(0), 'kgb@mail.ru');

