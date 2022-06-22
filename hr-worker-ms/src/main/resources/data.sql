create table tb_worker(
    id integer auto_increment primary key,
    name varchar(255),
    daily_Income decimal(10,2)
);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Bob', 200.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Maria', 300.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Alex', 250.0);