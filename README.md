# Инструкция по запуску проекта

## Запуск клиентской части

- Зупустить Eclipse IDE for RCP and RAP Developers
- Выбрать меню File - Ореп Projects from File System...
- Нажать кнопку Directory и выбрать папку library.management.client
- Развернуть проект library.management.client
- Открыть файл ru.kazhelandovskiy.library.product
- Нажать Launch an Eclipse application в секции Testing

## Запуск серверной части

### Открытие проекта в Eclipse IDE

- Зупустить Eclipse IDE for Enterprise Java and Web Developers
- Выбрать меню File - Ореп Projects from File System...
- Нажать кнопку Directory и выбрать папку library.management.server

### Запуск проекта на сервере Tomcat

Если нет добавленного web сервера:
- Выбрать меню Window - Show View - Servers
- В отрывшейся вкладке нажать парвой кнопкой мыши, выбрать New - Server
- Выбрать Apache - Tomcat v10.0 Server
- Выбрать директорию установки и нажать Download and Install

- В Project Explorer выбрать проект library.management.server
- Нажать правой кнопкой мыши, выбрать Run As - 1 Run on Server 
- Выбрать сущетвующий сервер Tomcat и нажать Finish
- Проверить работоспособность можно перейдя по ссылке http://localhost:8080/library/ в браузере, должна отображаться пустая страница с надписью Library Management Application

### База данных

Используется H2 база данных, которая разворачивается в оперативной памяти и автоматически удаляется при остановке серверной части, что приводит к потере всех данных.


# Документация API

## Base URL

Все эндпоинты начинаются с базового URL: `http://localhost:8080/library/api/`

## BookController

### GET /book
Возвращает список всех книг.

- **URL**: `http://localhost:8080/library/api/book`

- **Response**: 
```
[
    {
        "id": 1,
        "author": "pushkin",
        "title": "gold fish",
        "year": 2011,
        "genre": "horror",
        "pageCount": 124
    },
    {
        "id": 2,
        "author": "pelevin",
        "title": "ampir v",
        "year": 2020,
        "genre": "horror",
        "pageCount": 235
    }
]
```

### POST /book
Создает новую книгу.

- **URL**: `http://localhost:8080/library/api/book`

- **Request Body**: 
```
{
    "author": "pushkin",
    "title": "gold fish",
    "year": 2011,
    "genre": "horror",
    "pageCount": 124
}
```
- **Response**: 
```
{
    "id": 1,
    "author": "pushkin",
    "genre": "horror",
    "pageCount": 124,
    "title": "gold fish",
    "year": 2011
}
```

### PUT /book
Обновляет информацию о книге.

- **URL**: `http://localhost:8080/library/api/book`
- **Request Body**: 
```
{
    "id": 1,
    "author": "pelevin",
    "genre": "horror",
    "pageCount": 235,
    "title": "ampir v",
    "year": 2020
}
```
- **Response**: 
```
{
    "id": 1,
    "author": "pelevin",
    "genre": "horror",
    "pageCount": 235,
    "title": "ampir v",
    "year": 2020
}
```

### DELETE /book/{id}
Удаляет книгу по идентификатору.

- **URL**: `http://localhost:8080/library/api/book/{id}`
- **Path Parameter**: `id` (Long) - идентификатор книги.
- **Response**: Boolean, результат удаления.

## UserController

### GET /user
Возвращает список всех пользователей.

- **URL**: `http://localhost:8080/library/api/user`

- **Response**: 
```
[
    {
        "id": 1,
        "name": "user1",
        "age": 23,
        "gender": "male"
    },
    {
        "id": 2,
        "name": "user2",
        "age": 31,
        "gender": "male"
    }
]
```

### POST /user
Создает нового пользователя.

- **URL**: `http://localhost:8080/library/api/user`
- **Request Body**: 
```
{
    "name": "user2",
    "gender": "male",
    "age": 31
}
```
- **Response**:
```
{
    "id": 2,
    "name": "user2,
    "age": 31,
    "gender": "male""
}
```

### PUT /user
Обновляет информацию о пользователе.

- **URL**: `http://localhost:8080/library/api/user`
- **Request Body**: 
```
{
    "id": 1,
    "name": "user3"
    "age": 12,
    "gender": "male",
}
```
- **Response**: 
```
{
    "id": 1,
    "name": "user3"
    "age": 12,
    "gender": "male",
}
```

### DELETE /user/{id}
Удаляет пользователя по идентификатору.

- **URL**: `http://localhost:8080/library/api/user/{id}`
- **Path Parameter**: `id` (Long) - идентификатор пользователя.
- **Response**: Boolean, результат удаления.

## BookTransactionController

### GET /book-transaction
Возвращает список всех транзакций с книгами.

- **URL**: `http://localhost:8080/library/api/book-transaction`
- **Response**:
```
[
    {
        "id": 2,
        "issueDate": "2024-08-15T21:53:43.987408",
        "returnDate": "2024-08-15T21:53:43.987408",
        "book": {
            "author": "pushkin",
            "genre": "horror",
            "id": 2,
            "pageCount": 124,
            "title": "gold fish",
            "year": 2011
        },
        "user": {
            "id": 1,
            "name": "user3"
            "age": 12,
            "gender": "male",
        }
    },
    {
        "id": 3,
        "issueDate": "2024-08-15T21:53:43.987408",
        "returnDate": "2024-08-15T21:53:43.987408",
        "book": {
            "author": "pushkin",
            "genre": "horror",
            "id": 3,
            "pageCount": 124,
            "title": "gold fish",
            "year": 2011
        },
        "user": {
            "id": 1,
            "name": "user3"
            "age": 12,
            "gender": "male",
        }
    }
]
```

### POST /book-transaction
Создает новую транзакцию.

- **URL**: `http://localhost:8080/library/api/book-transaction`
- **Request Body**:
```
{
    "book": {
        "id": 1
    },
    "user": {
        "id": 1
    },
    "issueDate": "2024-08-15T21:53:43.987408",
    "returnDate": "2024-08-15T21:53:43.987408"
}
```
- **Response**:
```
{
    "id": 1,
    "issueDate": "2024-08-15T21:53:43.987408",
    "returnDate": "2024-08-15T21:53:43.987408",
    "book": {
        "author": "pushkin",
        "genre": "horror",
        "id": 1,
        "pageCount": 124,
        "title": "gold fish",
        "year": 2011
    },
    "user": {
        "age": 12,
        "gender": "male",
        "id": 1,
        "name": "sdg"
    }
}
```

### PUT /book-transaction
Обновляет информацию о транзакции.

- **URL**: `http://localhost:8080/library/api/book-transaction`
- **Request Body**: 
```
{
    "id": 2,
    "book": {
        "id": 3
    },
    "user": {
        "id": 1
    },
    "issueDate": "2021-08-15T21:53:43.987408",
    "returnDate": "2024-08-15T21:53:43.987408"
}
```
- **Response**:
```
{
    "id": 2,
    "book": {
        "author": "pushkin",
        "genre": "horror",
        "id": 3,
        "pageCount": 124,
        "title": "gold fish",
        "year": 2011
    },
    "user": {
        "age": 12,
        "gender": "male",
        "id": 1,
        "name": "sdg"
    },
    "issueDate": "2021-08-15T21:53:43.987408",
    "returnDate": "2024-08-15T21:53:43.987408"
}
```

### DELETE /book-transaction/{id}
Удаляет транзакцию по идентификатору.

- **URL**: `http://localhost:8080/library/api/book-transaction/{id}`
- **Path Parameter**: `id` (Long) - идентификатор транзакции.
- **Response**: Boolean, результат удаления.

### POST /book-transaction/issue-book?user_id={userId}1&book_id={bookId}
Выдача книги пользователю.

- **URL**: `http://localhost:8080/library/api/book-transaction/issue-book?user_id={userId}1&book_id={bookId}`
- **Query Parameters**:
  - `user_id` (Long) - идентификатор пользователя.
  - `book_id` (Long) - идентификатор книги.
- **Response**:
```
{
    "id": 4,
    "issueDate": "2024-08-28T13:34:55.4023681",
    "book": {
        "author": "pushkin",
        "genre": "horror",
        "id": 2,
        "pageCount": 124,
        "title": "gold fish",
        "year": 2011
    },
    "user": {
        "age": 31,
        "gender": "male",
        "id": 1,
        "name": "user2"
    }
}
```

### POST /book-transaction/return-book/{id}
Возвращение книги по идентификатору транзакции.

- **URL**: `http://localhost:8080/library/api/book-transaction/return-book/{id}`
- **Path Parameter**: `id` (Long) - идентификатор транзакции.
- **Response**: 
```
{
    "id": 4,
    "issueDate": "2024-08-28T13:34:55.402368",
    "returnDate": "2024-08-28T13:37:42.2834627",
    "book": {
        "author": "pushkin",
        "genre": "horror",
        "id": 2,
        "pageCount": 124,
        "title": "gold fish",
        "year": 2011
    },
    "user": {
        "age": 31,
        "gender": "male",
        "id": 2,
        "name": "user2"
    }
}
```
