-- Ejercicio 1
-- a
SELECT *
FROM film;
-- b
SELECT *
FROM film
ORDER BY rental_duration
DESC;
-- c
SELECT title, rental_duration
FROM film
ORDER BY rental_duration
DESC;
-- d
SELECT *
FROM film
LIMIT 10
OFFSET 40;
-- Ejercicio 2
-- a
SELECT f.rental_duration, COUNT(*) AS Cantidad
FROM public.film AS f
GROUP BY f.rental_duration 
HAVING f.rental_duration > 5
ORDER BY cantidad;
-- b
SELECT f.rental_duration, COUNT(*) AS Cantidad
FROM public.film AS f
GROUP BY f.rental_duration 
ORDER BY cantidad
ASC;
-- Ejercicio 3
-- a
SELECT f.title, cat.name
FROM public.film AS f, public.category AS cat, public.film_category AS fcat
WHERE fcat.film_id = f.film_id AND fcat.category_id = cat.category_id AND cat.name = 'Action';
-- b
SELECT f.title, cat.name
FROM public.film AS f, public.category AS cat, public.film_category AS fcat
WHERE fcat.film_id = f.film_id AND fcat.category_id = cat.category_id
LIMIT 10 
OFFSET 20;
-- Ejercicio 4
-- a
SELECT f.title
FROM public.film AS f
INNER JOIN film_category AS fc on fc.film_id = f.film_id -- se obtiene la interseccion entre los films y la tabla de categorias
INNER JOIN category AS ca on ca.category_id = fc.category_id -- se obtiene la interseccion de la caterogia y la tabla de categorias
GROUP BY f.film_id
HAVING COUNT (f.film_id) = 1;
-- Ejercicio 5
-- a
SELECT ca.name, COUNT(f.film_id) AS cantidad
FROM public.film AS f
INNER JOIN film_category AS fc on fc.film_id = f.film_id -- se obtiene la interseccion entre los films y la tabla de categorias
INNER JOIN category AS ca on ca.category_id = fc.category_id -- se obtiene la interseccion de la caterogia y la tabla de categorias
GROUP BY ca.name;
-- b
SELECT ca.name, COUNT(f.film_id) AS cantidad
FROM public.film AS f
INNER JOIN film_category AS fc on fc.film_id = f.film_id -- se obtiene la interseccion entre los films y la tabla de categorias
INNER JOIN category AS ca on ca.category_id = fc.category_id -- se obtiene la interseccion de la caterogia y la tabla de categorias
GROUP BY ca.name
ORDER BY cantidad
DESC;
-- c
-- Ejercicio 6
-- a
SELECT ca.name, COUNT(f.film_id) AS cantidad
FROM public.film AS f
INNER JOIN film_category AS fc on fc.film_id = f.film_id -- se obtiene la interseccion entre los films y la tabla de categorias
INNER JOIN category AS ca on ca.category_id = fc.category_id -- se obtiene la interseccion de la caterogia y la tabla de categorias
GROUP BY ca.name
HAVING COUNT(f.film_id) > 60;
-- Ejercicio 7
-- a
SELECT f.title, rt.return_date
FROM rental AS rt
INNER JOIN inventory AS inv on inv.inventory_id = rt.inventory_id
INNER JOIN film AS f on f.film_id = inv.film_id
WHERE rt.customer_id = 481;
-- b
SELECT f.title, rt.return_date
FROM rental AS rt
INNER JOIN inventory AS inv on inv.inventory_id = rt.inventory_id
INNER JOIN film AS f on f.film_id = inv.film_id
WHERE rt.customer_id = 481
ORDER BY rt.return_date; -- por defecto es descendente
-- Ejercicio 8
-- a
SELECT cat.name, COUNT(cat.category_id) AS cantidad
FROM category AS cat
INNER JOIN film_category AS fcat on fcat.category_id = cat.category_id -- obtengo las categorias
INNER JOIN film AS f on f.film_id = fcat.film_id -- obtengo las categorias de las peliculas
INNER JOIN inventory AS inv on inv.film_id = f.film_id -- obtengo las peliculas rentadas
INNER JOIN rental AS rt on rt.inventory_id = inv.inventory_id
WHERE rt.customer_id = 481
GROUP BY cat.category_id;	
-- b
SELECT cat.name, COUNT(cat.category_id) AS cantidad
FROM category AS cat
INNER JOIN film_category AS fcat on fcat.category_id = cat.category_id -- obtengo las categorias
INNER JOIN film AS f on f.film_id = fcat.film_id -- obtengo las categorias de las peliculas
INNER JOIN inventory AS inv on inv.film_id = f.film_id -- obtengo las peliculas rentadas
INNER JOIN rental AS rt on rt.inventory_id = inv.inventory_id
WHERE rt.customer_id = 481
GROUP BY cat.category_id
ORDER BY cantidad
DESC
LIMIT 3;
-- Ejercicio 9
-- a
SELECT COUNT(distinct(f.film_id)) AS Cantidad
FROM film AS f
INNER JOIN inventory AS inv on inv.film_id = f.film_id
INNER JOIN rental AS rt on rt.inventory_id = inv.inventory_id
INNER JOIN customer AS cust on cust.customer_id = rt.customer_id
INNER JOIN address AS addr on addr.address_id = cust.address_id
INNER JOIN city AS cty on cty.city_id = addr.city_id
INNER JOIN country AS co on co.country_id = cty.country_id
WHERE co.country = 'Canada';