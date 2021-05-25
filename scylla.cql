CREATE KEYSPACE travel WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 3} AND durable_writes = true;

use travel;

CREATE TABLE Travel(
    id uuid,
    local text,
    description text,
    days int,
    price double,
    PRIMARY KEY (id)
);

insert into Travel(id, local, description, days, price) values (1, 'Teatro Terra Roxa', 'Nao Funciona', 2, 1499.99);
