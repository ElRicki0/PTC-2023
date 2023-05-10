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
idGenero			int
foreign key references [dbo].[tbGeneros] (idGenero),
idTipoEmpleado		int
foreign key references [dbo].[tbTipoEmpleados] ([idTipoEmpleado])
);
go

/*Productos*/
create table tbMarcaProductos(
idMarcaProducto		int identity(1,1) primary key,
MarcaProducto		varchar(1000)not null
);
go

create table tbBodegas(
idBodega			int identity (1,1) primary key,
NombreBodega		varchar(500)not null,
UbicacionBodega		varchar(8000)not null
);
go

create table tbProductos(
idProducto			int identity (1,1) primary key,
idMarcaproducto		int
foreign key references [dbo].[tbMarcaProductos]([idMarcaProducto]),
Unidades			int not null,
PrecioUnitario		money,
idBodega			int
foreign key references [dbo].[tbBodegas] ([idBodega])
);
go

/*Apartado clientes*/


/*apartado distribucion de producto*/
create table tbMarcasvehiculos(
idMarcavehiculo		int identity (1,1) primary key,
Marca				varchar(150) not null
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

create table tbvehiculos(
idVehiculo			int identity (1,1) primary key,
Matricula			varchar(10) not null,
idModelo			int 
foreign key references [dbo].[tbModelos]([idModelo])
);
go

create table tbBitacoraDistribuciones(
idBitacoraDistribucion	int identity(1,1) primary key
);
go