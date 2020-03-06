SET PGPASSWORD=postgres
SET PGCLIENTENCODING=utf-8

chcp 65001

psql.exe -h localhost -d postgres -U postgres -p 5432 -a -w -f db_int.sql
