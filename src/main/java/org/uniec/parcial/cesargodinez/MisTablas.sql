create table cliente (
id_cliente integer primary key auto_increment,
nombre varchar(100),
email varchar(100),
paterno varchar(100));

select * from cliente;


create table tarjeta1 (
id_tarjeta integer primary key auto_increment,
id_cliente integer,
nombre_tarjeta varchar(180),
saldo float,
numero_tarjeta integer,
foreign key(id_cliente) references cliente(id_cliente));


create table reservacion(
id_reservacion integer primary key auto_increment,
id_cliente integer,
id_tarjeta integer,
ciudad_destino varchar(120),
nombre_hotel varchar(120),
numero_personas integer,
foreign key(id_cliente) references cliente (id_cliente),
foreign key(id_tarjeta) references tarjeta1 (id_tarjeta));

select * from reservacion;
