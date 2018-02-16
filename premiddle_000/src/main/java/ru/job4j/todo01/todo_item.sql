CREATE TABLE todo_item (
  id            SERIAL PRIMARY KEY,
  descr         CHARACTER VARYING(500),
  created		TIMESTAMP,
  done			BOOLEAN
);

INSERT INTO todo_item (descr, created, done) VALUES ('Tax call', CURRENT_TIMESTAMP(0), false);
INSERT INTO todo_item (descr, created, done) VALUES ('Get shower', CURRENT_TIMESTAMP(0), true);
INSERT INTO todo_item (descr, created, done) VALUES ('Have breakfast', CURRENT_TIMESTAMP(0), true);
INSERT INTO todo_item (descr, created, done) VALUES ('Get to work', CURRENT_TIMESTAMP(0), false);
INSERT INTO todo_item (descr, created, done) VALUES ('finish project', CURRENT_TIMESTAMP(0), false);



CREATE TABLE public.users
(
  id SERIAL PRIMARY KEY,
  login character varying(50),
  password character varying(50),
  name character varying(200),
  inserted_date TIMESTAMP,
  email character varying(200)
);

INSERT INTO users (login, password, name, inserted_date, email) VALUES('alex', '123', 'Alex', CURRENT_TIMESTAMP(0), 'alex@mail.ru');
INSERT INTO users (login, password, name, inserted_date, email) VALUES('agent007', '123', 'Agent 007', CURRENT_TIMESTAMP(0), '007@mail.ru');
INSERT INTO users (login, password, name, inserted_date, email) VALUES('agent009', '123', 'Agent KGB', CURRENT_TIMESTAMP(0), 'kgb@mail.ru');
