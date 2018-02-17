CREATE TABLE public.users
(
  id SERIAL PRIMARY KEY,
  login character varying(50),
  password character varying(50),
  name character varying(200),
  inserted_date TIMESTAMP,
  email character varying(200)
)

INSERT INTO users (login, password, name, inserted_date, email)
  VALUES('ivan', '123', 'Ivan Ivanov', CURRENT_TIMESTAMP(0), 'ivan@email.ru');