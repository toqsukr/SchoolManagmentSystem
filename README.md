# School Management System

Это приложение для управления информацией об учениках и учителях в школе. Оно взаимодействует с базой данных MySQL с помощью ORM Hibernate и предоставляет следующий функционал:

## Основные возможности

- Добавление, удаление и изменение информации об учениках и учителях.
- Просмотр списка учителей и предметов, которые они ведут.
- Информация о том, в каких классах преподают учителя и в каких классах учатся студенты.
- Оценки учеников по предметам.

## Требования

- Java 8 или выше.
- MySQL сервер.
- Hibernate ORM.

## Установка и запуск

1. Клонируйте репозиторий: `git clone https://github.com/yourusername/school-management-system.git`
2. Импортируйте проект в вашу IDE.
3. Настройте конфигурацию базы данных в файле `hibernate.cfg.xml`.
4. Запустите приложение.

Пример конфигурации `persistence.xml`:

```xml
<!-- Укажите настройки для подключения к вашей БД MySQL -->
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
    version="2.1">
    <persistence-unit name="ss_persistence">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/schoolbase" />
            <property name="javax.persistence.jdbc.user" value="username" />
            <property name="javax.persistence.jdbc.password" value="password" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect" />
        </properties>
    </persistence-unit>
</persistence>
```
