# Recrutation app Inteca
If you need to run tests, you need to run database. To do that, run command below:
```bash
docker compose up database
```
If tests finished, run:
```bash
docker compose down
```

To start all 3 containers, run
```bash
docker compose up
```

If you change something in code. Run package in Maven, and later run:
```bash
docker compose build
docker compose up
```

To stop applications run:
```bash
docker compose down
```

#### Tests, are disabled from maven package script, because of database needs. In long-time usage that solution is easier to manage project, and quicker in building *.jar files.