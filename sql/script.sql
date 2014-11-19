
/*
 Empienza bloque para creación de las tablas
 */
USE Quinto3

CREATE TABLE usuarios (
	id_usuario int IDENTITY(1,1) PRIMARY KEY,
	id_preceptor int not null,
	nombre_usuario varchar(30) not null,
	clave_acceso varchar(max) not null,
	nivel_acceso int not null,
	ult_acceso date not null,
	email varchar(100)
)

CREATE TABLE parte_diario (
	id_parte int IDENTITY(1,1) PRIMARY KEY,
	id_alumno int not null,
	id_preceptor int not null,
	id_ano int not null,
	id_division int not null,
	fecha_emision datetime not null
)

CREATE TABLE preceptor (
	id_preceptor int IDENTITY(1,1) PRIMARY KEY,
	nombre varchar(30) not null,
	apellido varchar(30) not null
)

CREATE TABLE alumno (
	id_alumno int IDENTITY(1,1) PRIMARY KEY,
	id_division int not null,
	id_ano int not null,
	nombre varchar(30) not null,
	apellido varchar(30) not null,
	dni int not null
)

CREATE TABLE ano (
	id_ano int IDENTITY(1,1) PRIMARY KEY
)

CREATE TABLE division (
	id_division int IDENTITY(1,1) PRIMARY KEY,
	id_preceptor int not null,
	id_ano int not null
)

CREATE TABLE noticias (
	id_noticia int IDENTITY(1,1) PRIMARY KEY,
	contenido varchar(max) not null,
	fecha_emision datetime not null
)

/*
 Procedimientos almacenados
 */
 
 
 --Para obtener las noticias
 GO
 CREATE PROCEDURE obtener_noticias AS
	SELECT contenido, fecha_emision FROM noticias ORDER BY id_noticia ASC;
 
 --LOGIN. Checkea si el usuario existe por medio del nombre.
 GO
 CREATE PROCEDURE login_check_userExist
	@nombre varchar(30)
	AS
	SELECT null FROM usuarios WHERE nombre_usuario = @nombre;

--LOGIN. Obtiene el hash de la contraseña sabiendo el nombre.
GO
CREATE PROCEDURE login_get_password
	@nombre varchar(30)
	AS
	SELECT clave_acceso FROM usuarios WHERE nombre_usuario = @nombre
	

--LOGIN. Iniciar sesión
GO
CREATE PROCEDURE login_process
	@nombre varchar(30),
	@password varchar(max)
	AS
	SELECT id_usuario, id_preceptor, nombre_usuario, clave_acceso, ult_acceso, email FROM usuarios WHERE nombre_usuario = @nombre AND clave_acceso = @password
 
--USER. Cambiar la fecha del último acceso por la actual.
GO
CREATE PROCEDURE user_set_lastOnline
	AS
	UPDATE usuarios SET ult_acceso = GETDATE()
	
--USER. Obtener la información de un usuario por su nombre.
GO
CREATE PROCEDURE user_get_userinfo 
	@nombre varchar(30)
	AS
	SELECT id_usuario, nombre_usuario, nivel_acceso, email FROM usuarios AS usuario
	INNER JOIN preceptor ON (usuario.id_preceptor = preceptor.id_preceptor)
	
