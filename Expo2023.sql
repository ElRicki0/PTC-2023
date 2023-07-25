create database EXPOdb
go

use EXPOdb
go

create table tbTiposEmpleados(
idTipoEmpleado		int identity (1,1) primary key,
Tipo_Emp		varchar(500) not null
);
go

insert into tbTiposEmpleados(Tipo_Emp) values('Administrador'); 
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
foreign key references [dbo].[tbTiposEmpleados] ([idTipoEmpleado]),
emp_imagen			image
);
go
select*from tbEmpleados
/*
delete from tbEmpleados where emp_nombre = 'Ricardo Melara'
insert into tbEmpleados(emp_nombre, emp_fecha, emp_direccion, emp_telefono, emp_correo, idGenero, idTipoEmpleado) 
values                 ('Ricardo Melara', '2006/12/1',  'AV. Los Proceres', '7229-1462', 'Ricdo06melara@gmail.com', 1, 1);*/
go

create table tbNivelesUsuarios
(idNivelUser		int identity (1,1) primary key,
usr_Nivel		varchar(50) not null,
usr_Descripcion varchar(500)
);
go
insert into tbNivelesUsuarios(usr_Nivel, usr_Descripcion) values('Administrador', 'Controlador del sistema');
go
select*from tbNivelesUsuarios


/*Productos*/
create table tbMarcaProductos(
id_MP				int identity(1,1) primary key,
MP_Nombre			varchar(1000)not null,
MP_NumeroContacto	varchar(10),
MP_Correo			varchar(30),
MP_Imagen			image
);
go


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

create table tbUsuarios(
idUsuario			int identity (1,1) primary key,
usr_nombre			varchar(50) not null,
usr_contrasenia	varchar(50) not null,
idEmpleado			int
foreign key references [dbo].[tbEmpleados]([idEmpleado]),
idNivelUser			int
foreign key references [dbo].[tbNivelesUsuarios]([idNivelUser]),
usr_imagen image
);
go
/*
select idUsuario from tbUsuarios
insert into tbUsuarios(usr_nombre, usr_contrasenia, idEmpleado, idNivelUser)values('admin', 'pass123', 1, 1);
insert into tbUsuarios(usr_nombre, usr_contrasenia, idEmpleado, idNivelUser)values('admin2', 'pass1234', 1, 1);

go*/
select*from tbUsuarios where usr_nombre='ricardo' and usr_contrasenia = 'melara2006';

create table tbProductos(
idProducto				int identity (1,1) primary key,
Prod_Nombre				varchar(50	),
Prod_idMarca				int
foreign key references [dbo].[tbMarcaProductos](id_MP),
Prod_Unidades			int not null,
Prod_PrecioUnitario		float,
idBodega			int
foreign key references [dbo].[tbBodegas] ([idBodega]),
Prod_imagen				image
);
go
/*
insert into tbProductos (Prod_Nombre, Prod_idMarca, Prod_Unidades, Prod_PrecioUnitario, idBodega) values('nom1',1,1,1,1)*/
select Prod_Nombre , Prod_idMarca, Prod_Unidades, Prod_PrecioUnitario, idBodega from tbProductos;
select tbProductos.idProducto, tbProductos.Prod_Nombre, tbMarcaProductos.MP_Nombre, tbProductos.Prod_Unidades, tbProductos.Prod_PrecioUnitario, tbBodegas.bdg_nombre from tbProductos inner join tbMarcaProductos  on tbProductos.Prod_idMarca = tbMarcaProductos.id_MP inner join tbBodegas on tbProductos.idBodega = tbBodegas.idBodega


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
foreign key references  [dbo].[tbGeneros]([idGenero]),
clie_imagen			image
);
go

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
foreign key references [dbo].[tbTiendas]([idTienda]),
DT_Imagen			image
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
