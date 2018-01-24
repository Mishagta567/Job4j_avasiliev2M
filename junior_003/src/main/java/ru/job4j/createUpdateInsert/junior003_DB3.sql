
INSERT INTO role (role) VALUES ('admin');

INSERT INTO rules (role_id, table_name) VALUES ((SELECT id FROM role WHERE role = 'admin'), 'all');

INSERT INTO users(login, role_id, name,         password, inserted_date)
          VALUES ('alex', (SELECT id FROM role WHERE role = 'admin'),
                                'Alexander V',  'qwerty', CURRENT_TIMESTAMP(0));  -- or NOW()


INSERT INTO category (name, descr) VALUES ('Подсчет', 'Считать всех');
INSERT INTO category (name, descr) VALUES ('Стричь', 'Стричь всех');
INSERT INTO category (name, descr) VALUES ('Мыть', 'Мыть всех');


INSERT INTO state(name, descr) VALUES ('Поступила', 'Заявка только поступила');
INSERT INTO state(name, descr) VALUES ('К выполнению', 'Модератор просмотрел. Нормальная заявка');
INSERT INTO state(name, descr) VALUES ('В работе', 'Кто-то там начал выполнять');
INSERT INTO state(name, descr) VALUES ('Отказ', 'Отказ в исполнении из-за разных причин');
INSERT INTO state(name, descr) VALUES ('Выполнена', 'Кто-то там начал выполнять');


INSERT INTO item (users_id, category_id,  name, descr, inserted_date)  VALUES ((SELECT id FROM users WHERE login = 'alex'),
                    1, 'Посчитать овец', 'Пересчетать всех овец в стаде', CURRENT_TIMESTAMP(0));
INSERT INTO item (users_id, category_id,  name, descr, inserted_date)  VALUES ((SELECT id FROM users WHERE login = 'alex'),
                    2, 'Постричь овец', 'Пострич всех овец в стаде', CURRENT_TIMESTAMP(0));
INSERT INTO item (users_id, category_id,  name, descr, inserted_date)  VALUES ((SELECT id FROM users WHERE login = 'alex'),
                    3, 'Мыть овец', 'Помыть всех овец в стаде', CURRENT_TIMESTAMP(0));
INSERT INTO item (users_id, category_id,  name, descr, inserted_date)  VALUES ((SELECT id FROM users WHERE login = 'alex'),
                    3, 'Мыть овец ТЩАТЕЛЬНО', 'Помыть всех овец в стаде ОЧЕНЬ ТЩАТЕЛЬНО', CURRENT_TIMESTAMP(0));



INSERT INTO comments (item_id, comments, inserted_date) VALUES ((SELECT MIN(id) FROM item), 'считал Вася', CURRENT_TIMESTAMP(0));
INSERT INTO comments (item_id, comments, inserted_date) VALUES ((SELECT MIN(id) FROM item), 'считал Петя', CURRENT_TIMESTAMP(0));
INSERT INTO comments (item_id, comments, inserted_date) VALUES ((SELECT MIN(id) FROM item), 'считал Олег', CURRENT_TIMESTAMP(0));


INSERT INTO attach(item_id, file, inserted_date) VALUES ((SELECT MIN(id) FROM item), 'Это файл - 1', CURRENT_TIMESTAMP(0));
INSERT INTO attach(item_id, file, inserted_date) VALUES ((SELECT MIN(id) FROM item), 'Это файл - 2', CURRENT_TIMESTAMP(0));
