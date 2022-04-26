/*1.Вывести список самолетов с кодами 320, 321, 733;*/
/*SELECT
	*
FROM
	lanit.AIRCRAFTS_DATA ad
WHERE
	ad.AIRCRAFT_CODE IN ('320', '321', '733')
*/
/*2.Вывести список самолетов с кодом не на 3;*/
/*SELECT
	*
FROM
	lanit.AIRCRAFTS_DATA ad
WHERE
	ad.AIRCRAFT_CODE NOT LIKE '3%'
*/
/*3.Найти билеты оформленные на имя «OLGA», с емайлом «OLGA» или без емайла;*/
/*SELECT
	*
FROM
	lanit.TICKETS t
WHERE
	t.PASSENGER_NAME LIKE 'OLGA%'
	AND (t.EMAIL LIKE 'OLGA%'
		OR t.EMAIL IS NULL) 
*/
/*4.Найти самолеты с дальностью полета 5600, 5700. Отсортировать список по убыванию дальности полета;*/
/*SELECT
	*
FROM
	lanit.AIRCRAFTS_DATA ad
WHERE 
	ad."RANGE" IN (5600, 5700)
ORDER BY
	ad."RANGE" DESC
*/
/*5.Найти аэропорты в Moscow. Вывести название аэропорта вместе с городом. Отсортировать по полученному названию;*/
/*SELECT
	*
FROM
	lanit.AIRPORTS_DATA ad
WHERE
	ad.CITY = 'Moscow'
ORDER BY
	ad.AIRPORT_CODE
*/

/*6.Вывести список всех городов без повторов в зоне «Europe»;*/
/*SELECT
	DISTINCT 
	ad.CITY ,
	ad.TIMEZONE
FROM
	lanit.AIRPORTS_DATA ad
WHERE
	ad.TIMEZONE LIKE 'Europe%'
ORDER BY
	ad.CITY
*/
/*7.Найти бронирование с кодом на «3A4» и вывести сумму брони со скидкой 10%*/
/*SELECT
	b.BOOK_REF , b.TOTAL_AMOUNT , b.TOTAL_AMOUNT*0.9 
FROM
	lanit.BOOKINGS b 
WHERE
	b.BOOK_REF like '3A4%'
*/
/*8. Вывести все данные по местам в самолете с кодом 320 и классом «Business» строками вида «Данные по месту: номер места 1», «Данные по месту: номер места 2» … и тд*/

/*SELECT
	CONCAT('Data for seat no: ', s.seat_no)
FROM
	lanit.SEATS s
WHERE
	s.AIRCRAFT_CODE = '320'
	AND s.FARE_CONDITIONS = 'Business'
*/	
/*9.Найти максимальную и минимальную сумму бронирования в 2017 году;*/
/*SELECT
	MAX(b.TOTAL_AMOUNT),
	MIN(b.TOTAL_AMOUNT)
FROM
	lanit.BOOKINGS b
WHERE
	b.BOOK_DATE = TO_DATE('2017', 'YYYY')
*/	
/*10.Найти количество мест во всех самолетах, вывести в разрезе самолетов;*/
/*SELECT
	s.AIRCRAFT_CODE , ad.MODEL , COUNT(s.SEAT_NO)
FROM
	lanit.SEATS s 
	JOIN LANIT.AIRCRAFTS_DATA ad ON s.AIRCRAFT_CODE = ad.AIRCRAFT_CODE  
group BY s.AIRCRAFT_CODE, ad.MODEL
*/
/*11.Найти количество мест во всех самолетах с учетом типа места, вывести в разрезе самолетов и типа мест;*/
/*SELECT
	s.AIRCRAFT_CODE ,
	ad.MODEL ,
	s.FARE_CONDITIONS,
	COUNT(s.SEAT_NO)
FROM
	lanit.SEATS s
JOIN LANIT.AIRCRAFTS_DATA ad ON
	s.AIRCRAFT_CODE = ad.AIRCRAFT_CODE
GROUP BY
	s.AIRCRAFT_CODE,
	ad.MODEL,
	s.FARE_CONDITIONS
ORDER BY
	s.AIRCRAFT_CODE,
	s.FARE_CONDITIONS
*/
/*12.Найти количество билетов пассажира ALEKSANDR STEPANOV, телефон которого заканчивается на 11;*/
/*SELECT
	t.PASSENGER_NAME ,
	count(t.TICKET_NO)
FROM
	lanit.TICKETS t
WHERE
	t.PASSENGER_NAME = 'ALEKSANDR STEPANOV'
	AND t.PHONE LIKE '%11'
GROUP BY
	t.PASSENGER_NAME
*/
/*13.Вывести всех пассажиров с именем ALEKSANDR, у которых количество билетов больше 2000. Отсортировать по убыванию количества билетов;*/
/*SELECT
	t.PASSENGER_NAME ,
	count(t.TICKET_NO)
FROM
	lanit.TICKETS t
WHERE
	t.PASSENGER_NAME LIKE 'ALEKSANDR%'
GROUP BY
	t.PASSENGER_NAME
HAVING
	count(t.TICKET_NO) > 2000
ORDER BY
	count(t.TICKET_NO) DESC
*/	
/*14.Вывести дни в сентябре 2017 с количеством рейсов больше 500.*/
/*SELECT
	trunc(t.date_departure) date_departure,
	count(*) countFlight
FROM
	lanit.flights t
WHERE
	trunc(t.date_departure, 'mm')= to_date('01.09.2017', 'dd.mm.yyyy')
GROUP BY
	trunc(t.date_departure)
HAVING	count(*)>500
ORDER BY date_departure 
*/
/*15.Вывести список городов, в которых несколько аэропортов*/
/*SELECT
	 ad.CITY ,
	COUNT(ad.AIRPORT_CODE)
FROM
	lanit.AIRPORTS_DATA ad
GROUP BY
	ad.CITY
HAVING
	count(ad.AIRPORT_CODE) > 1
*/
/*16.Вывести модель самолета и список мест в нем, т.е. на самолет одна строка результата*/
/*SELECT ad.MODEL , LISTAGG(s.SEAT_NO,',') WITHIN GROUP (ORDER BY s.SEAT_NO) AS SEATSOFAIR
FROM
	lanit.SEATS s  
	JOIN LANIT.AIRCRAFTS_DATA ad ON s.AIRCRAFT_CODE = ad.AIRCRAFT_CODE  
group BY ad.MODEL
*/
/*17.Вывести информацию по всем рейсам из аэропортов в г.Москва за сентябрь 2017*/
/*SELECT
	f.FLIGHT_NO,
	f.DATE_DEPARTURE ,
	f.DEPARTURE_AIRPORT ,
	f.ARRIVAL_AIRPORT ,
	f.STATUS ,
	f.AIRCRAFT_CODE ,
	f.ACTUAL_DEPARTURE 
FROM
	lanit.FLIGHTS f
JOIN lanit.AIRPORTS_DATA ad ON
	f.DEPARTURE_AIRPORT = ad.AIRPORT_CODE
WHERE
	ad.CITY = 'Moscow'
	AND TO_CHAR(f.DATE_DEPARTURE , 'YYYY-MM') = '2017-09'
ORDER BY
	f.DATE_DEPARTURE 
*/
/*18.Вывести кол-во рейсов по каждому аэропорту в г.Москва за 2017*/
/*SELECT
	ad.AIRPORT_CODE,
	count(f.FLIGHT_NO)
FROM
	lanit.FLIGHTS f
JOIN lanit.AIRPORTS_DATA ad ON
	(f.DEPARTURE_AIRPORT = ad.AIRPORT_CODE)
	OR (f.ARRIVAL_AIRPORT = ad.AIRPORT_CODE)
WHERE
	ad.CITY = 'Moscow'
	AND ((TO_CHAR(f.DATE_DEPARTURE , 'YYYY') = '2017')
		OR (TO_CHAR(f.DATE_ARRIVAL, 'YYYY') = '2017'))
GROUP BY 
	ad.AIRPORT_CODE
ORDER BY
	ad.AIRPORT_CODE
*/
/*19.Вывести кол-во рейсов по каждому аэропорту, месяцу в г.Москва за 2017*/
/*SELECT
	f.departure_airport ,
	TO_CHAR(f.date_departure, 'yyyy-mm'),
	COUNT(f.flight_no)
FROM
	lanit.flights f
JOIN lanit.AIRPORTS_DATA ad ON
	f.DEPARTURE_AIRPORT = ad.AIRPORT_CODE
WHERE
	to_char(f.date_departure, 'yyyy')= '2017'
	AND ad.CITY = 'Moscow'
GROUP BY
	f.departure_airport,
	TO_CHAR(f.date_departure, 'yyyy-mm')
ORDER BY
	f.departure_airport,
	TO_CHAR(f.date_departure, 'yyyy-mm')
	 */
/*20.Найти все билеты по бронированию на «3A4B»*/
/*SELECT
	b.BOOK_REF ,
	b.BOOK_DATE ,
	t.TICKET_NO ,
	t.PASSENGER_NAME
FROM
	lanit.BOOKINGS b
JOIN lanit.TICKETS t ON
	b.BOOK_REF = t.BOOK_REF
WHERE
	b.BOOK_REF LIKE '3A4B%'
ORDER BY
	b.BOOK_DATE
*/	
/*21. Найти все перелеты по бронированию на «3A4B»*/
/*SELECT
	b.BOOK_REF ,
	b.BOOK_DATE ,
	t.TICKET_NO ,
	tf.FLIGHT_ID ,
	tf.FARE_CONDITIONS ,
	tf.AMOUNT, 
	t.PASSENGER_NAME
FROM
	lanit.BOOKINGS b
JOIN lanit.TICKETS t ON
	b.BOOK_REF = t.BOOK_REF
	JOIN LANIT.TICKET_FLIGHTS tf ON t.TICKET_NO = tf.TICKET_NO 
WHERE
	b.BOOK_REF LIKE '3A4B%'
ORDER BY
	b.BOOK_DATE
*/