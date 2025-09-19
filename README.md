Java/Spring Boot сервис для управления жителями города, их паспортами, домами и автомобилями. Включает CRUD-операции, поиск и доменные операции (назначение владельцев домов/авто, перевод жителя в пенсионеры и т. п.).

## Стек
- Spring Boot (Web, Validation)
- Spring Data JPA (PostgreSQL)
- Liquibase
- MapStruct
- Lombok

## Быстрый старт

### Требования
- JDK 17+
- Maven 3.8+
- Запущенная БД PostgreSQL

### Переменные окружения
- `DB_USER` — пользователь PostgreSQL
- `DB_PASSWORD` — пароль PostgreSQL

### Конфигурация (application.yml)
Основные параметры уже заданы:
- JDBC URL: `jdbc:postgresql://localhost:5432/postgres`
- Hibernate DDL: `validate`
- Liquibase включен, changelog: `classpath:db/changelog/db.changelog-master.yaml`

### Сборка и запуск
```bash
# Сборка
mvn clean package

# Запуск приложения
mvn spring-boot:run
```
Приложение стартует на порту 8080 (по умолчанию Spring Boot). Базовый префикс API: `/api/v1`.

## Архитектура
- `controller` — REST-контроллеры
- `service` — бизнес-логика и сервисы управления
- `dto` — контракты запросов/ответов
- `mapper` — MapStruct мапперы между сущностями и DTO
- `resources/db/changelog` — Liquibase миграции

## Эндпоинты

Ниже перечислены доступные ресурсы и операции. Типы тел запросов/ответов берутся из DTO пакетов (`dto.*`). Все идентификаторы — UUID, если не указано иное.

### Residents (`/api/v1/residents`)
- POST `/` — создать жителя вместе с паспортом. Body: `CreateResidentRq`. Response: `CreateResidentRs`. Status: 201.
- GET `/{residentId}` — получить жителя по ID. Response: `ReadResidentRs`.
- GET `/` — получить список жителей (с паспортами). Response: `GetAllResidentRs`.
- GET `/city/{cityName}/count` — получить статистику по количеству жителей в городе (не реализовано, возвращает 501/UnsupportedOperationException).
- GET `/houses/street/{street}` — получить владельцев домов по названию улицы. Response: `GetAllResidentRs`.
- PATCH `/{residentId}` — обновить жителя. Body: `UpdateResidentRq`. Response: `UpdateResidentRs`.
- POST `/{residentId}/retire` — перевести жителя в пенсионеры (не реализовано, UnsupportedOperationException). Response: `ReadResidentRs` (по контракту метода).
- DELETE `/{residentId}` — удалить жителя. Status: 204.

### Houses (`/api/v1/houses`)
- POST `/` — создать дом. Body: `CreateHouseRq`. Response: `CreateHouseRs`. Status: 201.
- POST `/{houseId}/residents/{residentId}` — добавить владельца дому. Response: `ReadHouseRs`. Status: 201.
- GET `/{houseId}` — получить дом по ID. Response: `ReadHouseRs`.
- GET `/` — получить список домов. Response: `GetAllHouseRs`.
- PATCH `/{houseId}` — обновить дом. Body: `UpdateHouseRq`. Response: `UpdateHouseRs`.
- DELETE `/{houseId}` — удалить дом. Status: 204.
- DELETE `/{houseId}/residents/{residentId}` — удалить владельца дома. Status: 204.

### Cars (`/api/v1/cars`)
- POST `/` — создать автомобиль. Body: `CreateCarRq`. Response: `CreateCarRs`. Status: 201.
- POST `/{carId}/residents/{residentId}` — назначить владельца авто. Response: `UpdateCarRs`.
- GET `/residents/{residentId}` — получить автомобили по ID жителя. Response: `GetAllCarRs`.
- GET `/brand/{brandName}` — получить автомобили по бренду (не реализовано, UnsupportedOperationException). Response: `GetAllCarRs`.
- PATCH `/brand/{brandId}` — сменить имя бренда (не реализовано, UnsupportedOperationException).
- GET `/{carId}` — получить авто по ID. Response: `ReadCarRs`.
- PATCH `/{carId}` — обновить авто. Body: `UpdateCarRq`. Response: `UpdateCarRs`.
- DELETE `/{carId}` — удалить авто. Status: 204.

### Passports (`/api/v1/passports`)
- GET `/gender/{gender}/surname/{letter}` — получить паспорта по полу и первой букве фамилии. Response: `GetAllPassportRs`.

### Pensioners (`/api/v1/pensioners`)
- POST `/pension/credit` — начислить пенсию (не реализовано, UnsupportedOperationException).
- GET `/city/{cityName}` — получить пенсионеров по городу (не реализовано, UnsupportedOperationException). Response: `Set<ReadResidentRs>`.

## Обработка ошибок
В проекте предусмотрен глобальный обработчик исключений (`exception/handler/GlobalExceptionHandler`). Некоторый функционал помечен как не реализованный и кидает `UnsupportedOperationException`.

## Разработка
- Стиль кода: Lombok/MapStruct, слои контроллеров/сервисов/мапперов.
- Для миграций БД используется Liquibase. При запуске миграции применяются автоматически.
