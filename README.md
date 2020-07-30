Программа для бронирования комнаты переговоров.

-Авторизация системы по логину и паролю. Данные пользователей уже содержаться в базе данных, регистрация не нужна;

-При создании события “бронирование переговорки”, мнимальный промежуток бронирования 30 минут, максимальный 24 часа;

-События “бронирования переговорки” нельзя создать в одно и то же время;

-Возможность перелистывания недели как в будущее, так и в прошлое;



Инструкция по запуску:

-Таблица с базой данных эвентов и юзеров в файле SQL.sql

-Все настройки присоединения базы данных к приложению в файле application.properties

-Используемая кодировка UTF-8


-Переключение недель происходит через выбор в календаре.

-Добавление эвента через клик на ячейку таблицы.

-Изменение/Удаление эвента через кнопку, возле эвента в таблице.

-Spring Security защищает все страницы. Тестовые логины и пароли на странице /login присутствуют.





Используемое ПО:

-Apache Maven 3.6.3

-Java version: 11.0.5, vendor: Oracle Corporation 

-spring-boot-starter 2.3.2.RELEASE
