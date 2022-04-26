�������: 1 
������� ����� ������, �������� � ������ �������� ����� ��� ���� �� ���������� ����� 500 ���. �������: model, speed � hd

select pc.model,
 pc.speed,
 pc.hd
from pc
where pc.price < 500

�������: 2 
������� �������������� ���������. �������: maker

select distinct product.maker
from product 
where product.type = 'Printer'

�������: 3
������� ����� ������, ����� ������ � ������� ������� ��-���������, ���� ������� ��������� 1000 ���.

select laptop.model, laptop.ram, laptop.screen
from laptop
where laptop.price > 1000

�������: 4
������� ��� ������ ������� Printer ��� ������� ���������.

select * 
from printer
where printer.color = 'y'

�������: 5
������� ����� ������, �������� � ������ �������� ����� ��, ������� 12x ��� 24x CD � ���� ����� 600 ���.

Select pc.model, pc.speed, pc.hd
from pc
where pc.cd in ('12x','24x') 
and pc.price < 600

�������: 6
��� ������� �������������, ������������ ��-�������� c ������� �������� ����� �� ����� 10 �����, 
����� �������� ����� ��-���������. �����: �������������, ��������.

Select distinct product.maker, laptop.speed
from product
join laptop on product.model = laptop.model
where laptop.hd >= 10


�������: 7
������� ������ ������� � ���� ���� ��������� � ������� ��������� (������ ����) ������������� B (��������� �����).

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

�������: 8
������� �������������, ������������ ��, �� �� ��-��������.

Select distinct maker 
from product
where type = 'PC'
 except
select distinct maker
from product
where type = 'laptop'


�������: 9
������� �������������� �� � ����������� �� ����� 450 ���. �������: Maker

select distinct maker
from product p
join pc on pc.model = p.model
where pc.speed >= 450

�������: 10
������� ������ ���������, ������� ����� ������� ����. �������: model, price

Select model, price
from printer p
where price = (select max(price) from printer)


�������: 11
������� ������� �������� ��.
select avg(speed)
from pc

�������: 12
������� ������� �������� ��-���������, ���� ������� ��������� 1000 ���.

select avg(speed) 
from laptop
where price > 1000


�������: 13
������� ������� �������� ��, ���������� �������������� A.


select avg(pc.speed)
from pc, product
where pc.model = product.model and product.maker = 'A'

�������: 14
������� �����, ��� � ������ ��� �������� �� ������� Ships, ������� �� ����� 10 ������.

select s.class, s.name, c.country
from ships s
left join classes c on s.class = c.class
where c.numGuns >= 10


�������: 15
������� ������� ������� ������, ����������� � ���� � ����� PC. �������: HD

select hd 
from pc 
group by (hd) 
having count(model) >= 2

�������: 16
������� ���� ������� PC, ������� ���������� �������� � RAM. 
� ���������� ������ ���� ����������� ������ ���� ���, �.�. (i,j), 
�� �� (j,i), ������� ������: ������ � ������� �������, ������ � ������� �������, �������� � RAM.

select distinct p1.model, p2.model, p1.speed, p1.ram
from pc p1, pc p2
where p1.speed = p2.speed and p1.ram = p2.ram and p1.model > p2.model

�������: 17
������� ������ ��-���������, �������� ������� ������ �������� ������� �� ��.
�������: type, model, speed

select distinct p.type,p.model,l.speed
from laptop l
join product p on l.model=p.model
where l.speed <(select min(speed)
              from pc)

�������: 18
������� �������������� ����� ������� ������� ���������. �������: maker, price

select distinct product.maker, printer.price
from product, printer
where product.model = printer.model
and printer.color = 'y'
and printer.price = (
select min(price) from printer
where printer.color = 'y')

�������: 19
��� ������� �������������, �������� ������ � ������� Laptop, ������� ������� ������ ������ ����������� �� ��-���������.
�������: maker, ������� ������ ������.

select product.maker, avg(screen)
from laptop
left join product on product.model = laptop.model
group by product.maker


�������: 20
������� ��������������, ����������� �� ������� ���� ��� ��������� ������ ��. �������: Maker, ����� ������� ��.

select maker, count(model)
from product
where type = 'pc'
group by product.maker
having count(distinct model) >= 3

�������: 21
������� ������������ ���� ��, ����������� ������ ��������������, � �������� ���� ������ � ������� PC.
�������: maker, ������������ ����.

select product.maker, max(pc.price)
from product, pc
where product.model = pc.model
group by product.maker