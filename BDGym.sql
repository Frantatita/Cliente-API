create database gymfort;
drop database gymfort;
use gymfort;

drop table colaborador;
create table colaborador(
idColaborador integer auto_increment not null primary key,
nombre varchar(30),
apellidoPaterno varchar(30),
apellidoMaterno varchar(30),
fechaNacimiento date,
noPersonal varchar(10),
telefono varchar(30),
correo varchar(30),
rfc varchar(30),
curp varchar(30),
password varchar(30),
 idRol integer, -- Campo para la relación con la tabla roles
    foreign key (idRol) references rol(idRol) -- Definir la llave foránea
);



drop table cliente;
create table cliente(
idCliente integer auto_increment not null primary key,
nombre varchar(30),
apellidoP varchar(30),
apellidoM varchar(30),
fechaN date,
telefono varchar(30),
peso float,
estatura integer,
correo varchar(30),
contrasena varchar(30),
idRol integer, -- Campo para la relación con la tabla roles
    foreign key (idRol) references rol(idRol) -- Definir la llave foránea
);

drop table rol;
create table rol(
idRol integer primary key,
nombre varchar(30)
);

select * from rol;
select * from colaborador;

#Consultas
select idColaborador, colaborador.nombre, apellidoP, apellidoM, fechaN, 
numeroP, telefono, correo, rfc, curp, colaborador.idRol, rol.nombre as 'rol'
from colaborador 
inner join rol on rol.idRol = colaborador.idRol
where numeroP = 'gymfort' and 'password' = 'qwerty';
