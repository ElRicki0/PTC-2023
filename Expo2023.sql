create database EXPOdb
go

use EXPOdb
go

create table tbTiposEmpleados(		
idTipoEmpleado		int identity (1,1) primary key,
Tipo_Emp		varchar(500) not null,
Descripcion_Emp	varchar(500)
);
go
select*from tbTiposEmpleados
insert into tbTiposEmpleados(Tipo_Emp, Descripcion_Emp) values('Administrador','Administrador'); 
go
select*from tbTiposEmpleados;
go

create table tbGeneros(
idGenero			int identity (1,1) primary key,
Genero				VARCHAR(20) not null
);
go
insert into tbGeneros(Genero) values('Hombre');
insert into tbGeneros(Genero) values('Mujer');
go
select*from tbgeneros
go

create table tbEmpleados(
idEmpleado			int identity (1,1) primary key,
emp_nombre			varchar(50) not null,
emp_documento		varchar(8000),
emp_fecha			date,
emp_direccion		varchar(500)not null,
emp_telefono		varchar(10),
emp_correo			varchar(300), 
idGenero			int
foreign key references [dbo].[tbGeneros] (idGenero),
idTipoEmpleado		int
foreign key references [dbo].[tbTiposEmpleados] ([idTipoEmpleado])
);
go

/*
insert into tbEmpleados(emp_nombre,emp_fecha, emp_direccion, emp_telefono, emp_correo, idGenero, idTipoEmpleado) values('nombre1','2/2/2','calle1','tel1','correo1',1,1)*/
/*
insert into tbEmpleados(emp_nombre, emp_direccion,		emp_telefono, emp_correo,			idGenero, idTipoEmpleado) 
values                 ('Ricardo Melara',  'AV. Los Proceres', '7229-1462', 'Ricdo06melara@gmail.com', 1, 1);
go*/

create table tbNivelesUsuarios(
idNivelUser		int identity (1,1) primary key,
usr_Nivel		varchar(50) not null,
usr_Descripcion varchar(500)
);
go

select idNivelUser, usr_Nivel, usr_Descripcion from tbNivelesUsuarios
insert into tbNivelesUsuarios(usr_Nivel, usr_Descripcion) values('Administrador', 'Controlador total del sistema');
insert into tbNivelesUsuarios(usr_Nivel, usr_Descripcion) values('Controlador', 'Manejo de datos');
insert into tbNivelesUsuarios(usr_Nivel, usr_Descripcion) values('Repartidor', 'Distribucion de producto a clientes');
insert into tbNivelesUsuarios(usr_Nivel, usr_Descripcion) values('Usuario', 'Vista de los pproductos, bopdegas y de sus datos personales ');
go


/*Productos*/
create table tbMarcaProductos(
id_MP				int identity(1,1) primary key,
MP_Nombre			varchar(1000)not null,
MP_NumeroContacto	varchar(10),
MP_Correo			varchar(30)
);
go
insert into tbMarcaProductos (MP_Nombre, MP_NumeroContacto, MP_Correo) values('Nombre1','11111111','Correo1@gmail.com');
insert into tbMarcaProductos (MP_Nombre, MP_NumeroContacto, MP_Correo) values('Nombre2','22222222','Correo2@gmail.com');
insert into tbMarcaProductos (MP_Nombre, MP_NumeroContacto, MP_Correo) values('Nombre3','33333333','Correo3@gmail.com');
go
	select*from tbMarcaProductos
select MP_Nombre, MP_NumeroContacto, MP_Correo from tbMarcaProductos

create table tbBodegas(
idBodega			int identity (1,1) primary key,
bdg_nombre		varchar(500)not null,
bdg_ubicacion	varchar(8000)not null,
bdg_correo		varchar(300) not null
);
go
insert into tbBodegas(bdg_nombre, bdg_ubicacion, bdg_correo) VALUES('Bodega de paco', 'calle1', 'bodega1@gmail.com');
insert into tbBodegas(bdg_nombre, bdg_ubicacion, bdg_correo) VALUES('Bodega 2', 'calle2', 'bodega2@gmail.com');
insert into tbBodegas(bdg_nombre, bdg_ubicacion, bdg_correo) VALUES('Bodega 3', 'calle3', 'bodega3@gmail.com');
go
select*from tbBodegas

create table tbUsuarios(
idUsuario			int identity (1,1) primary key,
usr_nombre			varchar(50) not null,
usr_contrasenia	varchar(50) not null,
usr_preguntasSeguridad	varchar(50),
idEmpleado			int unique
foreign key references [dbo].[tbEmpleados]([idEmpleado]),
idNivelUser			int
foreign key references [dbo].[tbNivelesUsuarios]([idNivelUser])
);
go
select * from tbUsuarios
select tbUsuarios.idUsuario, tbUsuarios.usr_nombre, tbUsuarios.usr_contrasenia, tbEmpleados.emp_nombre, tbNivelesUsuarios.usr_Nivel from tbUsuarios inner join tbEmpleados on tbUsuarios.idEmpleado=tbEmpleados.idEmpleado INNER JOIN tbNivelesUsuarios on tbUsuarios.idNivelUser=tbNivelesUsuarios.idNivelUser
select tbUsuarios.idUsuario, tbUsuarios.usr_nombre, tbUsuarios.usr_contrasenia, tbEmpleados.emp_nombre, tbNivelesUsuarios.usr_Nivel from tbUsuarios inner join tbEmpleados on tbUsuarios.idEmpleado=tbEmpleados.idEmpleado INNER JOIN tbNivelesUsuarios on tbUsuarios.idNivelUser=tbNivelesUsuarios.idNivelUser
/*
insert into tbUsuarios(usr_nombre, usr_contrasenia, idEmpleado, idNivelUser)values('123', '123', 2, 2);
insert into tbUsuarios(usr_nombre, usr_contrasenia, idEmpleado, idNivelUser, idBodega)values('admin2', 'pass1234', 1, 1, 1);*/
select*from tbUsuarios
go

create table tbProductos(
idProducto				int identity (1,1) primary key,
Prod_Nombre				varchar(50	),
id_MP					int
foreign key references [dbo].[tbMarcaProductos](id_MP),
Prod_Unidades			int not null,
Prod_PrecioUnitario		float,
idBodega			int
foreign key references [dbo].[tbBodegas] 
([idBodega])
);
go

select*from tbProductos
select tbProductos.idProducto, tbProductos.Prod_Nombre, tbMarcaProductos.MP_Nombre, tbProductos.Prod_Unidades, tbProductos.Prod_PrecioUnitario, tbBodegas.bdg_nombre
from tbProductos inner join tbMarcaProductos  on tbProductos.id_MP = tbMarcaProductos.id_MP inner join tbBodegas on tbProductos.idBodega = tbBodegas.idBodega

select tbProductos.idProducto, tbProductos.Prod_Nombre, tbMarcaProductos.MP_Nombre, tbProductos.Prod_Unidades, tbProductos.Prod_PrecioUnitario, tbBodegas.bdg_nombre 
from tbProductos inner join tbMarcaProductos  on tbProductos.idProducto = tbMarcaProductos.id_MP inner join tbBodegas on tbProductos.idBodega = tbBodegas.idBodega
/*
insert into tbProductos (Prod_Nombre, id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega) values ('Papass miles', 1, 10, 3, 1);
insert into tbProductos (Prod_Nombre, id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega) values ('Alfajor miles', 2, 10, 2, 2);
insert into tbProductos (Prod_Nombre, id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega) values ('Torta miles', 3, 10, 3, 3);
delete from tbProductos where idProducto =1*/
	go
	select id_MP, MP_Nombre from tbMarcaProductos
	select idBodega, bdg_nombre from tbBodegas
	select*from tbProductos
	/*
	select*from tbProductos inner join tbMarcaProductos on tbProductos.Prod_idMarca = tbMarcaProductos.id_MP    *//*comparar tablas */
go

select Prod_Nombre , id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega from tbProductos;

create table tbDatosDistribucion(
idDatoDistribucion	int identity (1,1) primary key,
DaDis_CantidadProducto	int,
idProducto			int
foreign key references [dbo].[tbProductos]([idProducto])
);
go

create table tbPaqueteria(
idPaqueteria		int identity(1,1) primary key,
idUsuario			int
foreign key references [dbo].[tbUsuarios]([idUsuario]),
idDatoDistribucion			int
foreign key references [dbo].[tbDatosDistribucion]([idDatoDistribucion])
);
go

/*Proximos contendores de productos nuevo */
create table tbContenedortes (
idContenedor		INT identity (1,1) primary key,
ctd_Nombre			varchar(100),
ctd_Empresa	varchar(200),
ctd_Correo      varchar(300) not null,
idProducto		int
foreign key references  [dbo].[tbProductos]([idProducto]),
idPaqueteria		int
);
go


/*Apartado clientes*/
create table tbClientes(
idCliente			int identity (1,1) primary key,
clie_Nombre		varchar(100) not null,
clie_Edad			int not null,
clie_Telefono		varchar(10), 
clie_Correo		varchar(300) not null,
idGenero			int
foreign key references  [dbo].[tbGeneros]([idGenero])
);
go
insert into tbClientes(clie_Nombre, clie_Edad, clie_Telefono, clie_Correo, idGenero) values ('luis', 45, '12345678', 'correo1@gmail.com', 1)
select idCliente, clie_Nombre, clie_Edad, clie_Telefono, clie_Correo, tbGeneros.idGenero from tbClientes inner join tbGeneros on tbClientes.idGenero=tbGeneros.idGenero

create table tbTiendas(
idTienda			int identity(1,1) primary key,
Tien_Nombre		varchar(500)not null,
Tien_Direccion  Varchar(8000)NOT NULL,
Tien_ReferenciasLDireccion	varchar(1000),
Tien_Correo 	varchar(300) not null
);
go

create table tbDatosTiendas(
idDatosTienda		int identity(1,1)primary key,
DT_NumeroTelefono	varchar(10)not null,
DT_PersonaDestinatario	varchar(50)not null,
idCliente			int
foreign key references [dbo].[tbClientes] ([idCliente]),
idTienda			int
foreign key references [dbo].[tbTiendas]([idTienda])
);
go

/*apartado distribucion de producto*/
create table tbTalleres(
idTaller			int identity(1,1) primary key,
Tall_Nombre		varchar(300) not null,
Tall_Telefono			varchar(10) not null,
Tall_Correo		varchar(30) not null,
Tall_Duenio			varchar(50)
);
go

create table tbMarcasvehiculos(
idMarcavehiculo		int identity (1,1) primary key,
Marca				varchar(150) not null
);
go

create table tbMantenimiento(
idMantenimiento		int identity (1,1) primary key,
Taller				varchar(8000) not null,
Mecanico			varchar(50) not null,
TFTaller			varchar(10),
idTaller			int
foreign key references [dbo].[tbTalleres]([idTaller])
);
go

create table tbModelos(
idModelo			int identity (1,1) primary key,
Modelo				varchar(150)not null,
Mo_anio					int, 
idMarcavehiculo		int
foreign key references tbMarcasvehiculos(idMarcavehiculo)
);
go


create table tbVehiculos(
idVehiculo			int identity (1,1) primary key,
vehi_Matricula			varchar(10) not null,
idModelo			int 
foreign key references [dbo].[tbModelos]([idModelo]),
idMantenimeinto		int
foreign key references [dbo].[tbMantenimiento](idMantenimiento)
);
go

create table tbBitacoraDistribuciones(
idBitacoraDistribucion	int identity(1,1) primary key,
FechaEntrega			date,
idDatosTienda			int
foreign key references[dbo].[tbDatosTiendas]([idDatosTienda]),
idUsuario				int
foreign key	references[dbo].[tbUsuarios]([idUsuario]),
idVehiculo				int
foreign key references[dbo].[tbVehiculos]([idVehiculo]),
idPaqueteria			int
foreign key references[dbo].[tbPaqueteria](idPaqueteria)
);
go
