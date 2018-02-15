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