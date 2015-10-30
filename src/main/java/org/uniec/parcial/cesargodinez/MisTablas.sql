create table animal(
animal_id integer primary key auto_increment,
nombre varchar(100),
edad integer,
fecha_nacimiento date);

select * from animal;


create table vuelo(
id_avion integer,
id_vuelo integer primary key auto_increment,
origen varchar(180),
destino varchar(180),
foreign key(id_avion) references avion(id_avion));



