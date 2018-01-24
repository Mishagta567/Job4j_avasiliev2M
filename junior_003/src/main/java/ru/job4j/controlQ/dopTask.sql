CREATE TABLE company (
  id SERIAL,
  name character varying,
  CONSTRAINT company_pkey PRIMARY KEY (id)
);

INSERT INTO company(name) VALUES ('Пятерочка');
INSERT INTO company(name) VALUES ('1 канал');
INSERT INTO company(name) VALUES ('Архыз');
INSERT INTO company(name) VALUES ('Камаз');
INSERT INTO company(name) VALUES ('Руснефть');
INSERT INTO company(name) VALUES ('Оборон-экспорт');


CREATE TABLE person (
  id SERIAL,
  name character varying,
  company_id integer,
  CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO person(name, company_id) VALUES ('Иван', 1);
INSERT INTO person(name, company_id) VALUES ('Василий', 2);
INSERT INTO person(name, company_id) VALUES ('Олег', 3);
INSERT INTO person(name, company_id) VALUES ('Маша', 4);
INSERT INTO person(name, company_id) VALUES ('САША', 4);
INSERT INTO person(name, company_id) VALUES ('Глаша', 5);
INSERT INTO person(name, company_id) VALUES ('Даша', 6);
INSERT INTO person(name) VALUES ('Jhon');
INSERT INTO person(name) VALUES ('Bill');

--- 1) Retrieve in a single query:
--// - names of all persons that are NOT in the company with id = 5
--// - company name for each person

SELECT pr.name, cm.name
  FROM person pr
  LEFT OUTER JOIN company cm ON pr.company_id = cm.id
  WHERE (cm.id != 5 OR cm.id IS NULL);

---  2) Select the name of the company with the maximum number of persons + number of persons in this company

SELECT cm.name, count(*) persons_amount
  FROM person pr
  INNER JOIN company cm ON pr.company_id = cm.id
  GROUP BY cm.id, cm.name
  HAVING count(*) = (SELECT MAX(count) FROM
			                (SELECT count(*) count FROM person pr
				                  INNER JOIN company cm ON pr.company_id = cm.id
			                    GROUP BY cm.id, cm.name
			                 ) AS foo
			              );


