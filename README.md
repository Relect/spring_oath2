# spring_oath2

Для запуска приложения требуется maven, jdk 17 <br>
и установленная база postgresql c созданной базой 'testdb'.<br>
Приложение запускается командой в терминале<br>
mvn spring-boot:run

 При входе в приложение на адрес http://localhost:8180 <br>
 приложение попросит авторизоваться на github.
 
 При запуске с включённым профилем спринга nosecurity:
 
![метод GET](1.png)
![метод POST](2.png)
![метод PUT](3.png)
![метод DELETE](4.png) <br>
Повторное удаление возвращает 404 как и ожидалось. <br>
![метод DELETE](5.png)