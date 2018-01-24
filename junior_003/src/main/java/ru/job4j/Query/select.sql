product(id, name, type_id, expired_date, price)
type(id, name);

CREATE table product (
  id            SERIAL PRIMARY KEY,
  name          CHARACTER VARYING(200),
  type_id       INTEGER REFERENCES type(id),
  expired_date  TIMESTAMP,
  price         FLOAT
);

CREATE table type (
  id            SERIAL PRIMARY KEY,
  name          CHARACTER VARYING(200)
);

--- 1) Написать запрос получение всех продуктов с типом "СЫР"
SELECT pr.name, pr.expired_date, pr.price
  FROM product AS pr
  INNER JOIN type AS tp on pr.type_id = tp.id
  WHERE tp.name = 'CSH';

SELECT pr.name, pr.expired_date, pr.price
  FROM product AS pr
  WHERE pr.type_id IN (SELECT tp.id FROM type AS tp WHERE tp.name = 'СЫР')

--- Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"

SELECT pr.name, pr.expired_date, pr.price
  FROM product AS pr
  INNER JOIN type AS tp on pr.type_id = tp.id
  WHERE tp.name like '%мороженное%';

SELECT pr.name, pr.expired_date, pr.price
  FROM product AS pr
  WHERE pr.type_id IN (SELECT tp.id FROM type AS tp WHERE like '%мороженное%')

--- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.

SELECT pr.name, pr.expired_date, pr.price
  FROM product AS pr
  WHERE EXTRACT(YEAR FROM pr.expired_date) = SELECT EXTRACT(YEAR FROM NOW())
    AND EXTRACT(MONTH FROM pr.expired_date) = SELECT EXTRACT(MONTH FROM NOW()) + 1;

--- 4. Написать запрос, который вывод самый дорогой продукт.

SELECT pr.name, pr.expired_date, pr.price
  FROM product AS pr
  WHERE pr.price = (SELECT MAX(pr1.price) FROM product AS pr1)

--- 5. Написать запрос, который выводит количество всех продуктов определенного типа.

SELECT pr.type_id, count(pr.type_id)
  FROM product AS pr
  INNER JOIN type AS tp on pr.type_id = tp.id
  WHERE tp.name = 'СЫР'
  GROUP BY pr.type_id;

SELECT pr.type_id, count(pr.type_id)
  FROM product AS pr
  INNER JOIN type AS tp on pr.type_id = tp.id
  --WHERE tp.name = 'СЫР'
  GROUP BY pr.type_id;

--- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"

SELECT pr.name, pr.expired_date, pr.price
  FROM product AS pr
  INNER JOIN type AS tp on pr.type_id = tp.id
  WHERE tp.name IN ('СЫР', 'МОЛОКО');

---- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.

SELECT pr.type_id, count(pr.type_id)
  FROM product AS pr
  INNER JOIN type AS tp on pr.type_id = tp.id
  GROUP BY pr.type_id
  HAVING count(pr.type_id) < 10;

--- 8. Вывести все продукты и их тип.

SELECT pr.name, tp.name  -- можно добавить: , pr.expired_date, pr.price,
  FROM product AS pr
  INNER JOIN type AS tp on pr.type_id = tp.id
