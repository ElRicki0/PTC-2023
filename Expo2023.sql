use master
go

create database EXPOdb
go

use EXPOdb
go

create table tbTipoEmpleados(
idTipoEmpleado		int identity (1,1) primary key,
TipoEmpleado		varchar(500) not null
);
go


create table tbGeneros(
idGenero			int identity (1,1) primary key,
Genero				VARCHAR(20) not null
);
go

create table tbEmpleados(
idEmpleado			int identity (1,1) primary key,
emp_nombre			varchar(50) not null,
emp_documento		varchar(8000)not null,
emp_fecha			date,
emp_direccion		varchar(500)not null,
emp_telefono		varchar(10),
emp_correo			varchar(300), 
idGenero			int
foreign key references [dbo].[tbGeneros] (idGenero),
idTipoEmpleado		int
foreign key references [dbo].[tbTipoEmpleados] ([idTipoEmpleado])
);
go

create table tbNivelesUsuarios
(idNivelUser		int identity (1,1) primary key,
NombreNivelUser		varchar(50) not null,
DescripcionUser		varchar(500)
);
go

/*Productos*/
create table tbMarcaProductos(
idMarcaProducto		int identity(1,1) primary key,
MarcaProducto		varchar(1000)not null,
CorreoProducto		varchar(30)
);
go

create table tbBodegas(
idBodega			int identity (1,1) primary key,
NombreBodega		varchar(500)not null,
UbicacionBodega		varchar(8000)not null,
CorreoBodega	varchar(300) not null
);
go

create table tbUsuarios(
idUsuario			int identity (1,1) primary key,
Usuario				varchar(50) not null,
Contraseña			varchar(50) not null,
idEmpleado			int
foreign key references [dbo].[tbEmpleados]([idEmpleado]),
idNivelUser			int
foreign key references [dbo].[tbNivelesUsuarios]([idNivelUser]),
idBodega			int
foreign key references [dbo].[tbBodegas]([idBodega])
);
go

create table tbProductos(
idProducto			int identity (1,1) primary key,
idMarcaproducto		int
foreign key references [dbo].[tbMarcaProductos]([idMarcaProducto]),
Unidades			int not null,
PrecioUnitario		money,
idBodega			int
foreign key references [dbo].[tbBodegas] 
([idBodega])
);
go

create table tbDatosDistribucion(
idDatoDistribucion	int identity (1,1) primary key,
CantidadProducto	int,
idProducto			int
foreign key references [dbo].[tbProductos]([idProducto])
);
go

create table tbPaqueteria(
idPaqueteria		int identity(1,1) primary key,
idUsuario			int
foreign key references [dbo].[tbUsuarios]([idUsuario]),
[idDatoDistribucion]			int
foreign key references [dbo].[tbDatosDistribucion]([idDatoDistribucion])
);
go

/*Proximos contendores de productos nuevo */
create table tbContenedortes (
idContenedor		INT identity (1,1) primary key,
Nombre_ctd			varchar(100),
EmpresaContenedor	varchar(200),
Correo	varchar(300) not null,
idProducto		int
foreign key references  [dbo].[tbProductos]([idProducto]),
idPaqueteria		int
);
go


/*Apartado clientes*/
create table tbClientes(
idCliente			int identity (1,1) primary key,
NombreCliente		varchar(100) not null,
EdadCliente			int not null,
TelefonoCliente		varchar(10),
CorreoElectronico		varchar(300) not null,
idGenero			int
foreign key references  [dbo].[tbGeneros]([idGenero])
);
go

create table tbTiendas(
idTienda			int identity(1,1) primary key,
NombreTd		varchar(500)not null,
DireccionTd		VARCHAR(8000)NOT NULL,
ReferenciasLDireccionTd	varchar(1000),
CorreoElectronico		varchar(300) not null
);
go

create table tbDatosTiendas(
idDatosTienda		int identity(1,1)primary key,
NumeroTelefonoTd	varchar(10)not null,
PersonaDestinatarioTd	varchar(50)not null,
idCliente			int
foreign key references [dbo].[tbClientes] ([idCliente]),
idTienda			int
foreign key references [dbo].[tbTiendas]([idTienda])
);
go

/*apartado distribucion de producto*/
create table tbTalleres(
idTaller			int identity(1,1) primary key,
NombreTaller		varchar(300) not null,
TelTaller			varchar(10) not null,
CorreoTaller		varchar(30) not null,
DueñoTaller			varchar(50)
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
año					int, 
idMarcavehiculo		int
foreign key references tbMarcasvehiculos(idMarcavehiculo)
);
go

create table tbVehiculos(
idVehiculo			int identity (1,1) primary key,
Matricula			varchar(10) not null,
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
