Задание: 1 
Найдите номер модели, скорость и размер жесткого диска для всех ПК стоимостью менее 500 дол. Вывести: model, speed и hd

select pc.model,
 pc.speed,
 pc.hd
from pc
where pc.price < 500

Задание: 2 
Найдите производителей принтеров. Вывести: maker

select distinct product.maker
from product 
where product.type = 'Printer'

Задание: 3
Найдите номер модели, объем памяти и размеры экранов ПК-блокнотов, цена которых превышает 1000 дол.

select laptop.model, laptop.ram, laptop.screen
from laptop
where laptop.price > 1000

Задание: 4
Найдите все записи таблицы Printer для цветных принтеров.

select * 
from printer
where printer.color = 'y'

Задание: 5
Найдите номер модели, скорость и размер жесткого диска ПК, имеющих 12x или 24x CD и цену менее 600 дол.

Select pc.model, pc.speed, pc.hd
from pc
where pc.cd in ('12x','24x') 
and pc.price < 600

Задание: 6
Для каждого производителя, выпускающего ПК-блокноты c объёмом жесткого диска не менее 10 Гбайт, 
найти скорости таких ПК-блокнотов. Вывод: производитель, скорость.

Select distinct product.maker, laptop.speed
from product
join laptop on product.model = laptop.model
where laptop.hd >= 10


Задание: 7
Найдите номера моделей и цены всех имеющихся в продаже продуктов (любого типа) производителя B (латинская буква).

select a.model, price 
from (select model, price 
 from pc 
 union
 select model, price 
  from laptop
 union
 select model, price 
 from printer
 ) as a join
 product p on a.model = p.model
where p.maker = 'B'

Задание: 8
Найдите производителя, выпускающего ПК, но не ПК-блокноты.

Select distinct maker 
from product
where type = 'PC'
 except
select distinct maker
from product
where type = 'laptop'


Задание: 9
Найдите производителей ПК с процессором не менее 450 Мгц. Вывести: Maker

select distinct maker
from product p
join pc on pc.model = p.model
where pc.speed >= 450

Задание: 10
Найдите модели принтеров, имеющих самую высокую цену. Вывести: model, price

Select model, price
from printer p
where price = (select max(price) from printer)


Задание: 11
Найдите среднюю скорость ПК.
select avg(speed)
from pc

Задание: 12
Найдите среднюю скорость ПК-блокнотов, цена которых превышает 1000 дол.

select avg(speed) 
from laptop
where price > 1000


Задание: 13
Найдите среднюю скорость ПК, выпущенных производителем A.


select avg(pc.speed)
from pc, product
where pc.model = product.model and product.maker = 'A'

Задание: 14
Найдите класс, имя и страну для кораблей из таблицы Ships, имеющих не менее 10 орудий.

select s.class, s.name, c.country
from ships s
left join classes c on s.class = c.class
where c.numGuns >= 10


Задание: 15
Найдите размеры жестких дисков, совпадающих у двух и более PC. Вывести: HD

select hd 
from pc 
group by (hd) 
having count(model) >= 2

Задание: 16
Найдите пары моделей PC, имеющих одинаковые скорость и RAM. 
В результате каждая пара указывается только один раз, т.е. (i,j), 
но не (j,i), Порядок вывода: модель с большим номером, модель с меньшим номером, скорость и RAM.

select distinct p1.model, p2.model, p1.speed, p1.ram
from pc p1, pc p2
where p1.speed = p2.speed and p1.ram = p2.ram and p1.model > p2.model

Задание: 17
Найдите модели ПК-блокнотов, скорость которых меньше скорости каждого из ПК.
Вывести: type, model, speed

select distinct p.type,p.model,l.speed
from laptop l
join product p on l.model=p.model
where l.speed <(select min(speed)
              from pc)

Задание: 18
Найдите производителей самых дешевых цветных принтеров. Вывести: maker, price

select distinct product.maker, printer.price
from product, printer
where product.model = printer.model
and printer.color = 'y'
and printer.price = (
select min(price) from printer
where printer.color = 'y')

Задание: 19
Для каждого производителя, имеющего модели в таблице Laptop, найдите средний размер экрана выпускаемых им ПК-блокнотов.
Вывести: maker, средний размер экрана.

select product.maker, avg(screen)
from laptop
left join product on product.model = laptop.model
group by product.maker


Задание: 20
Найдите производителей, выпускающих по меньшей мере три различных модели ПК. Вывести: Maker, число моделей ПК.

select maker, count(model)
from product
where type = 'pc'
group by product.maker
having count(distinct model) >= 3

Задание: 21
Найдите максимальную цену ПК, выпускаемых каждым производителем, у которого есть модели в таблице PC.
Вывести: maker, максимальная цена.

select product.maker, max(pc.price)
from product, pc
where product.model = pc.model
group by product.maker