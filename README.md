# МойСклад

## Сборка
```shell
$ docker compose build
```

## Запуск
> [!IMPORTANT]
> Перед запуском необходимо создать файл `.env` в корне проекта:
> ```dotenv
> POSTGRES_DB=database
> POSTGRES_USER=username
> POSTGRES_PASSWORD=password
> ```
```shell
$ docker compose up
```
