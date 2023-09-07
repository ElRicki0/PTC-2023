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
insert into tbEmpleados(emp_nombre,emp_fecha, emp_direccion, emp_telefono, emp_correo, idGenero, idTipoEmpleado) values('nombre1','2/2/2','calle1','tel1','correo1',1,1)

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
usr_nombre			varchar(50) not null unique,
usr_contrasenia	varchar(250) not null,
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
insert into tbProductos (Prod_Nombre, id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega) values ('Alfajor miles777', 2, 2, 2, 2);
insert into tbProductos (Prod_Nombre, id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega) values ('Torta miles777', 3, 3, 3, 3);
delete from tbProductos where idProducto =1*/
	go
	select id_MP, MP_Nombre from tbMarcaProductos
	select idBodega, bdg_nombre from tbBodegas
	select*from tbProductos
	select idProducto, Prod_Unidades from tbProductos where idProducto=1
	/*
	select*from tbProductos inner join tbMarcaProductos on tbProductos.Prod_idMarca = tbMarcaProductos.id_MP    *//*comparar tablas */
go

select Prod_Nombre , id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega from tbProductos;

create table tbDatosDistribucion(
idDatoDistribucion	int identity (1,1) primary key,
DaDis_Nombre		varchar(50),
idProducto			int
foreign key references [dbo].[tbProductos]([idProducto]),
DaDis_CantidadProducto	int,
idEmpleado			int
foreign key references [dbo].[tbEmpleados]([idEmpleado])
);
go

select*from tbDatosDistribucion

select idDatoDistribucion, tbProductos.Prod_Nombre, DaDis_CantidadProducto, tbEmpleados.emp_nombre  from tbDatosDistribucion 
inner join tbProductos on tbDatosDistribucion.idProducto= tbProductos.idProducto inner join tbEmpleados on tbDatosDistribucion.idEmpleado=tbEmpleados.idEmpleado

go
create table tbPaqueteria(
idPaqueteria		int identity(1,1) primary key,
pqt_Nombre			varchar(50),
idEmpleado			int
foreign key references [dbo].[tbEmpleados] ([idEmpleado]),
idDatoDistribucion			int
foreign key references [dbo].[tbDatosDistribucion]([idDatoDistribucion]),
Paq_Ubicacion		varchar(5000)
);
go

select*from tbPaqueteria
delete from tbPaqueteria where idPaqueteria =2
/*Proximos contendores de productos nuevo */


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
select idCliente, clie_Nombre, clie_Edad, clie_Telefono, clie_Correo, tbGeneros.Genero from tbClientes inner join tbGeneros on tbClientes.idGenero=tbGeneros.idGenero

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

select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas 
inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda 
/*apartado distribucion de producto*/
create table tbTalleres(
idTaller			int identity(1,1) primary key,
Tall_Nombre		varchar(300) not null,
Tall_Telefono			varchar(10) not null,
Tall_Correo		varchar(30) not null,
Tall_Duenio			varchar(50)
);
go

create table tbMantenimiento(
idMantenimiento		int identity (1,1) primary key,
Mecanico			varchar(50) not null,
TFTaller			varchar(10),
idTaller			int
foreign key references [dbo].[tbTalleres]([idTaller])
);
go
select idMantenimiento, Mecanico, TFTaller, tbTalleres.Tall_Nombre from tbMantenimiento inner join tbTalleres on tbMantenimiento.idTaller=tbTalleres.idTaller

create table tbModelos(
idModelo			int identity (1,1) primary key,
Modelo				varchar(150)not null,
Mo_anio					int, 
Mo_marca			varchar(50)not null
);
go


create table tbVehiculos(
idVehiculo			int identity (1,1) primary key,
vehi_Matricula		varchar(10) not null,
idModelo			int 
foreign key references [dbo].[tbModelos]([idModelo]),
idMantenimeinto		int
foreign key references [dbo].[tbMantenimiento](idMantenimiento)
);
go

select*from tbVehiculos
select idVehiculo, vehi_Matricula, tbModelos.Modelo, tbMantenimiento.Mecanico, tbTalleres.Tall_Nombre from tbVehiculos 
inner join tbModelos on tbVehiculos.idModelo=tbModelos.idModelo inner join tbMantenimiento on tbVehiculos.idMantenimeinto=tbMantenimiento.idMantenimiento inner join tbTalleres on tbMantenimiento.idTaller=tbTalleres.idTaller
go

create table tbEstadoEntrega(
idEstado	int identity(1,1) primary key,
Estado		varchar(10)not null
);
go

insert into tbEstadoEntrega(Estado)values('En proceso');
insert into tbEstadoEntrega(Estado)values('En Ruta');
insert into tbEstadoEntrega(Estado)values('Entregado');

create table tbBitacoraDistribuciones(
idBitacoraDistribucion	int identity(1,1) primary key,
FechaEntrega			date,
idEmpleado			int
foreign key references [dbo].[tbEmpleados]([idEmpleado]),
idUsuario				int
foreign key	references[dbo].[tbUsuarios]([idUsuario]),
idVehiculo				int
foreign key references[dbo].[tbVehiculos]([idVehiculo]),
idPaqueteria			int
foreign key references[dbo].[tbPaqueteria](idPaqueteria),
idEstado				int
foreign key references[dbo].[tbEstadoEntrega]([idEstado])
);
go

select idBitacoraDistribucion, FechaEntrega, tbEmpleados.emp_nombre, tbUsuarios.usr_nombre, tbVehiculos.vehi_Matricula, tbPaqueteria.pqt_Nombre, tbEstadoEntrega.Estado from tbBitacoraDistribuciones 
inner join tbEmpleados		on tbBitacoraDistribuciones.idEmpleado=tbEmpleados.idEmpleado
inner join tbUsuarios		on tbBitacoraDistribuciones.idUsuario=tbUsuarios.idUsuario
inner join tbVehiculos		on tbBitacoraDistribuciones.idVehiculo= tbVehiculos.idVehiculo
inner join tbPaqueteria		on tbBitacoraDistribuciones.idPaqueteria=tbPaqueteria.idPaqueteria
inner join tbEstadoEntrega	on tbBitacoraDistribuciones.idEstado=tbEstadoEntrega.idEstado

