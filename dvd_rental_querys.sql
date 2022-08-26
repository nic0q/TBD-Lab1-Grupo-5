-- Ejercicio 1
-- a
select *
from film;
-- b
select *
from film
order by rental_duration
DESC;
-- c
select title, rental_duration
from film
order by rental_duration
DESC;
-- d
select *
from film
limit 10
offset 40;
-- Ejercicio 2
-- a
SELECT f.rental_duration, COUNT(*) as Cantidad
FROM public.film AS f
GROUP BY f.rental_duration 
HAVING f.rental_duration > 5
ORDER BY cantidad;
-- b
SELECT f.rental_duration, COUNT(*) as Cantidad
FROM public.film AS f
GROUP BY f.rental_duration 
ORDER BY cantidad
ASC;
-- Ejercicio 3
-- a
SELECT f.title, cat.name
FROM public.film as f, public.category as cat, public.film_category as fcat
WHERE fcat.film_id = f.film_id and fcat.category_id = cat.category_id and cat.name = 'Action';
-- b
SELECT f.title, cat.name
FROM public.film as f, public.category as cat, public.film_category as fcat
WHERE fcat.film_id = f.film_id and fcat.category_id = cat.category_id
LIMIT 10 OFFSET 20;
-- Ejercicio 4
-- a
SELECT f.title
FROM public.film as f
inner join film_category as fc on fc.film_id = f.film_id -- se obtiene la interseccion entre los films y la tabla de categorias
inner join category as ca on ca.category_id = fc.category_id -- se obtiene la interseccion de la caterogia y la tabla de categorias
group by f.film_id
having count (f.film_id) = 1;
-- Ejercicio 5
-- a
SELECT ca.name, count(f.film_id) as cantidad
FROM public.film as f
inner join film_category as fc on fc.film_id = f.film_id -- se obtiene la interseccion entre los films y la tabla de categorias
inner join category as ca on ca.category_id = fc.category_id -- se obtiene la interseccion de la caterogia y la tabla de categorias
group by ca.name;
-- b
SELECT ca.name, count(f.film_id) as cantidad
FROM public.film as f
inner join film_category as fc on fc.film_id = f.film_id -- se obtiene la interseccion entre los films y la tabla de categorias
inner join category as ca on ca.category_id = fc.category_id -- se obtiene la interseccion de la caterogia y la tabla de categorias
group by ca.name
order by cantidad
DESC;
-- c
-- Ejercicio 6
-- a
SELECT ca.name, count(f.film_id) as cantidad
FROM public.film as f
inner join film_category as fc on fc.film_id = f.film_id -- se obtiene la interseccion entre los films y la tabla de categorias
inner join category as ca on ca.category_id = fc.category_id -- se obtiene la interseccion de la caterogia y la tabla de categorias
group by ca.name
having count(f.film_id) > 60;
-- Ejercicio 7
-- a
select f.title, rt.return_date
from rental as rt
inner join inventory as inv on inv.inventory_id = rt.inventory_id
inner join film as f on f.film_id = inv.film_id
where rt.customer_id = 481;
-- b
select f.title, rt.return_date
from rental as rt
inner join inventory as inv on inv.inventory_id = rt.inventory_id
inner join film as f on f.film_id = inv.film_id
where rt.customer_id = 481
order by rt.return_date; -- por defecto es descendente
-- Ejercicio 8
-- a
select f.title, rt.return_date
from rental as rt
inner join inventory as inv on inv.inventory_id = rt.inventory_id
inner join film as f on f.film_id = inv.film_id
where rt.customer_id = 481
order by rt.return_date;
-- b
select cus.customer_id
from customer as cus
where cus.customer_id = 481;
inner join