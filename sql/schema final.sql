USE Quinto3
GO
/****** Object:  Table [dbo].[division]    Script Date: 11/25/2014 02:48:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[division](
	[id_division] [int] IDENTITY(1,1) NOT NULL,
	[id_preceptor] [int] NOT NULL,
	[id_ano] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_division] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ano]    Script Date: 11/25/2014 02:48:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ano](
	[id_ano] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_ano] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[noticias]    Script Date: 11/25/2014 02:48:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[noticias](
	[id_noticia] [int] IDENTITY(1,1) NOT NULL,
	[contenido] [varchar](max) NOT NULL,
	[fecha_emision] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_noticia] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[usuarios]    Script Date: 11/25/2014 02:48:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[usuarios](
	[id_usuario] [int] IDENTITY(1,1) NOT NULL,
	[id_preceptor] [int] NOT NULL,
	[nombre_usuario] [varchar](30) NOT NULL,
	[clave_acceso] [varchar](max) NOT NULL,
	[nivel_acceso] [int] NOT NULL,
	[ult_acceso] [date] NOT NULL,
	[email] [varchar](100) NULL,
	[suspendido] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_usuario] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[alumno]    Script Date: 11/25/2014 02:48:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[alumno](
	[id_alumno] [int] IDENTITY(1,1) NOT NULL,
	[id_division] [int] NOT NULL,
	[id_ano] [int] NOT NULL,
	[nombre] [varchar](30) NOT NULL,
	[apellido] [varchar](30) NOT NULL,
	[dni] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_alumno] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[preceptor]    Script Date: 11/25/2014 02:48:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[preceptor](
	[id_preceptor] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](30) NOT NULL,
	[apellido] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_preceptor] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[parte_diario]    Script Date: 11/25/2014 02:48:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[parte_diario](
	[id_parte] [int] IDENTITY(1,1) NOT NULL,
	[id_alumno] [int] NOT NULL,
	[id_preceptor] [int] NOT NULL,
	[id_ano] [int] NOT NULL,
	[id_division] [int] NOT NULL,
	[fecha_emision] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_parte] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[obtener_noticias]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[obtener_noticias] AS
	SELECT contenido, fecha_emision FROM noticias ORDER BY id_noticia ASC;
 
 --LOGIN. Checkea si el usuario existe por medio del nombre.
GO
/****** Object:  StoredProcedure [dbo].[noticias_existentes]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[noticias_existentes]
@cantidad int OUTPUT
AS
BEGIN
	SELECT @cantidad=COUNT(*) FROM noticias
END
GO
/****** Object:  StoredProcedure [dbo].[usuario_delete]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[usuario_delete] 
@idUsuario int
AS
BEGIN
	DELETE FROM usuarios WHERE id_usuario = @idUsuario
END
GO
/****** Object:  StoredProcedure [dbo].[users_get_preceptores]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[users_get_preceptores]
AS
BEGIN
	SELECT * FROM usuarios WHERE nivel_acceso = 1 ORDER BY id_usuario DESC
END
GO
/****** Object:  StoredProcedure [dbo].[user_set_lastOnline]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[user_set_lastOnline]
	AS
	UPDATE usuarios SET ult_acceso = GETDATE()
	
--USER. Obtener la información de un usuario por su nombre.
GO
/****** Object:  StoredProcedure [dbo].[user_register]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Registra un usuario en el sistema
CREATE PROCEDURE [dbo].[user_register]
@idPreceptor int,
@nombre varchar(30),
@claveAcceso varchar(max),
@nivelAcceso int,
@ultimoAcceso date,
@email varchar(100)
AS
BEGIN
	INSERT INTO usuarios (id_preceptor, nombre_usuario, clave_acceso, nivel_acceso, ult_acceso, email)
	VALUES (@idPreceptor, @nombre, @claveAcceso, @nivelAcceso, @ultimoAcceso, @email)
END
GO
/****** Object:  StoredProcedure [dbo].[user_modificar_password]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[user_modificar_password]
@idUsuario int,
@nuevaPassword varchar(max)
AS
BEGIN
	UPDATE usuarios SET clave_acceso=@nuevaPassword WHERE id_usuario=@idUsuario
END
GO
/****** Object:  StoredProcedure [dbo].[user_modificar]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[user_modificar]
@idUsuario int,
@nombreUsuario varchar(30),
@nivelAcceso int,
@ultAcceso date,
@email varchar(100)
AS
BEGIN
	UPDATE usuarios SET nombre_usuario = @nombreUsuario,
						nivel_acceso = @nivelAcceso,
						ult_acceso = @ultAcceso,
						email = @email
	WHERE id_usuario = @idUsuario
END
GO
/****** Object:  StoredProcedure [dbo].[user_get_userinfo]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[user_get_userinfo] 
	@nombre varchar(30)
	AS
	SELECT id_usuario, nombre_usuario, nivel_acceso, email FROM usuarios AS usuario
	INNER JOIN preceptor ON (usuario.id_preceptor = preceptor.id_preceptor)
GO
/****** Object:  StoredProcedure [dbo].[user_get_preceptores]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[user_get_preceptores]
@idUsuario int OUTPUT,
@idPreceptor int OUTPUT,
@nombre varchar(30) OUTPUT,
@nivelAcceso int OUTPUT,
@ultAcceso date OUTPUT,
@email varchar(100) OUTPUT
AS
BEGIN
	SELECT @idUsuario=id_usuario, 
		   @idPreceptor=id_preceptor, 
		   @nombre=nombre_usuario,
		   @nivelAcceso=nivel_acceso,
		   @ultAcceso=ult_acceso,
		   @email=email
	FROM usuarios ORDER BY id_usuario DESC
END
GO
/****** Object:  StoredProcedure [dbo].[user_get_info]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Obtener datos del usuario para crear la clase
CREATE PROCEDURE [dbo].[user_get_info]
@nombre varchar(30),
@idUsuario int OUTPUT,
@idPreceptor int OUTPUT,
@nivelAcceso int OUTPUT,
@ultimoAcceso date OUTPUT,
@email varchar(100) OUTPUT
AS
BEGIN
	SELECT 	@idUsuario		=	id_usuario, 
			@idPreceptor	=	id_preceptor, 
			@nivelAcceso	=	nivel_acceso, 
			@ultimoAcceso	=	ult_acceso,
			@email			= 	email
	FROM usuarios WHERE nombre_usuario = @nombre
END
GO
/****** Object:  StoredProcedure [dbo].[preceptor_agregar]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[preceptor_agregar]
@nombreUsuario varchar(30),
@claveAcceso varchar(max),
@nivelAcceso int,
@email varchar(100),
@nombre varchar(30),
@apellido varchar(30),
@idUsuario int OUTPUT
AS
BEGIN
	INSERT INTO preceptor VALUES(@nombre, @apellido);
	DECLARE 
	@idPreceptor int
	SELECT @idPreceptor=id_preceptor FROM preceptor WHERE nombre=@nombre;
	INSERT INTO usuarios (id_preceptor, nombre_usuario, clave_acceso, nivel_acceso, ult_acceso, email) 
				   VALUES(@idPreceptor, @nombreUsuario, @claveAcceso, @nivelAcceso, GETDATE(), @email);
	SELECT @idUsuario=id_usuario FROM usuarios WHERE id_preceptor=@idPreceptor;
END
GO
/****** Object:  StoredProcedure [dbo].[noticia_get_noticias]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Obtiene las noticias por orden descendente
CREATE PROCEDURE [dbo].[noticia_get_noticias] AS
	SELECT * FROM noticias ORDER BY id_noticia ASC
GO
/****** Object:  StoredProcedure [dbo].[noticia_agregar]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Agrega una noticia
CREATE PROCEDURE [dbo].[noticia_agregar]
@contenido varchar(max),
@fechaEmision date
AS
BEGIN
	INSERT INTO noticias VALUES(@contenido, @fechaEmision)
END
GO
/****** Object:  StoredProcedure [dbo].[login_get_password]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[login_get_password]
@password varchar(max) OUTPUT,
@nombre varchar(30)
AS
BEGIN
	SELECT @password=clave_acceso FROM usuarios WHERE nombre_usuario=@nombre
END
GO
/****** Object:  StoredProcedure [dbo].[login_check_userExist]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[login_check_userExist]
@existe int OUTPUT,
@nombre varchar(30)
AS
BEGIN
	SELECT @existe=COUNT(*) FROM usuarios WHERE nombre_usuario=@nombre
END
GO
/****** Object:  StoredProcedure [dbo].[alumno_register]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Insertar un nuevo alumno
CREATE PROCEDURE [dbo].[alumno_register]
@idDivision int,
@idAno int,
@nombre varchar(30),
@apellido varchar(30),
@dni int
AS
BEGIN
	INSERT INTO alumno VALUES(@idDivision, @idAno, @nombre, @apellido, @dni)
END
GO
/****** Object:  StoredProcedure [dbo].[alumno_por_curso]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[alumno_por_curso]
@idAno int,
@idDivision int
AS
BEGIN
	SELECT * FROM alumno WHERE id_division=@idDivision AND id_ano=@idAno ORDER BY id_alumno DESC
END
GO
/****** Object:  StoredProcedure [dbo].[alumno_get_info]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Obtener info de un alumno
CREATE PROCEDURE [dbo].[alumno_get_info]
@idAlumno int OUTPUT,
@apellido varchar(30) OUTPUT,
@dni int OUTPUT,
@idDivision int OUTPUT,
@idAno int OUTPUT,
@nombre varchar(30)
AS
BEGIN
	SELECT @idAlumno=id_alumno,
		   @idDivision=id_division,
		   @idAno=id_ano,
		   @apellido=apellido,
		   @dni=dni
	FROM alumno
	WHERE nombre=@nombre
END
GO
/****** Object:  StoredProcedure [dbo].[alumno_get_faltas]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Obtener faltas de un alumno
CREATE PROCEDURE [dbo].[alumno_get_faltas]
@idAlumno int,
@faltas int OUTPUT
AS
BEGIN
	SELECT @faltas=COUNT(*) FROM parte_diario WHERE id_alumno=@idAlumno
END
GO
/****** Object:  StoredProcedure [dbo].[alumno_by_faltas_menor]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[alumno_by_faltas_menor]
AS
BEGIN
	SELECT _alumno.id_alumno, _alumno.id_division, _alumno.id_ano, nombre, apellido, dni FROM alumno AS _alumno 
	INNER JOIN parte_diario AS faltas ON (_alumno.id_alumno = faltas.id_alumno)
	ORDER BY faltas.id_alumno ASC
END
GO
/****** Object:  StoredProcedure [dbo].[alumno_by_faltas_mayor]    Script Date: 11/25/2014 02:48:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[alumno_by_faltas_mayor]
AS
BEGIN
	SELECT _alumno.id_alumno, _alumno.id_division, _alumno.id_ano, nombre, apellido, dni FROM alumno AS _alumno 
	INNER JOIN parte_diario AS faltas ON (_alumno.id_alumno = faltas.id_alumno)
	ORDER BY faltas.id_alumno DESC
END
GO
/****** Object:  Default [DF__usuarios__suspen__4CA06362]    Script Date: 11/25/2014 02:48:50 ******/
ALTER TABLE [dbo].[usuarios] ADD  DEFAULT ((0)) FOR [suspendido]
GO
