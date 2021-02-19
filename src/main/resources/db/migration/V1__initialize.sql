drop table if exists shops cascade;
create table shops (id bigserial PRIMARY KEY, name varchar(255), email varchar(100) not null UNIQUE, inn varchar(12) not null UNIQUE, domain_name varchar(100) not null UNIQUE, type varchar(100));
insert into shops
(name, email, inn, domain_name, type) values
('obi', 'obi@mail.ru', '35533557788', 'obi.ru', 'ONLINE'),
('ikea', 'ikea@mail.ru', '35533557755', 'ikea.ru', 'ONLINE'),
('lenta', 'lenta@mail.ru', '35533557745', 'lenta.ru', 'ONLINE');

