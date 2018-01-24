
CREATE TABLE transmission (
  id           SERIAL PRIMARY KEY,
  name         VARCHAR(100)
);

INSERT INTO transmission(name) VALUES('Ручная. 4 скорости');
INSERT INTO transmission(name) VALUES('Ручная. 5 скоростей');
INSERT INTO transmission(name) VALUES('Ручная. 6 скоростей');
INSERT INTO transmission(name) VALUES('Автоматическая. 4 скорости');
INSERT INTO transmission(name) VALUES('Автоматическая. 5 скоростей');
INSERT INTO transmission(name) VALUES('Автоматическая. 6 скоростей');


CREATE TABLE engine (
  id           SERIAL PRIMARY KEY,
  name         VARCHAR(200)
);

INSERT INTO engine(name) VALUES('4 цилинда 150 л.с.');
INSERT INTO engine(name) VALUES('4 цилинда 160 л.с.');
INSERT INTO engine(name) VALUES('4 цилинда 170 л.с.');
INSERT INTO engine(name) VALUES('6 цилиндров 210 л.с.');
INSERT INTO engine(name) VALUES('6 цилиндров 240 л.с.');
INSERT INTO engine(name) VALUES('6 цилиндров 280 л.с.');


CREATE TABLE body (
  id           SERIAL PRIMARY KEY,
  name         CHARACTER VARYING(100)
);

INSERT INTO body(name) VALUES('Седан 2 двери');
INSERT INTO body(name) VALUES('Седан 4 двери');
INSERT INTO body(name) VALUES('Кабриолет 2 двери');
INSERT INTO body(name) VALUES('Кабриолет 4 двери');
INSERT INTO body(name) VALUES('Паркетник 2 двери');
INSERT INTO body(name) VALUES('Паркетник 4 двери');


CREATE TABLE car (
  id                SERIAL PRIMARY KEY,
  transmission_id   INTEGER REFERENCES transmission(id),
  engine_id         INTEGER REFERENCES engine(id),
  body_id           INTEGER REFERENCES body(id),
  name              CHARACTER VARYING(200)
);

INSERT INTO car(transmission_id, engine_id, body_id, name) VALUES(1, 2, 1, 'Эконом - 1');
INSERT INTO car(transmission_id, engine_id, body_id, name) VALUES(4, 3, 4, 'Среднияя - 1');
INSERT INTO car(transmission_id, engine_id, body_id, name) VALUES(6, 5, 6, 'Максималка - 1');


---- Хотелось извратиться и сделать без UNION ALL, но что-то не получается.

SELECT tr.name dont_use
  FROM car cr
  RIGHT OUTER JOIN transmission tr on tr.id = cr.transmission_id
  WHERE cr.transmission_id IS null
UNION ALL
SELECT en.name dont_use
  FROM car cr
  RIGHT OUTER JOIN engine en on en.id = cr.engine_id
  WHERE cr.engine_id IS null
UNION ALL
SELECT bd.name dont_use
  FROM car cr
  RIGHT OUTER JOIN body bd on bd.id = cr.body_id
  WHERE cr.body_id IS null;

