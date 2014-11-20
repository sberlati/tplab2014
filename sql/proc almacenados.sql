
--Obtener el password de un usuario por su nombre
CREATE PROCEDURE login_get_password
@password varchar(max) OUTPUT,
@nombre varchar(30)
AS
BEGIN
	SELECT @password=clave_acceso FROM usuarios WHERE nombre=@nombre
END 

--Obtener datos del usuario para crear la clase
CREATE PROCEDURE user_get_info
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
	FROM usuarios WHERE nombre = @nombre
END 

--Registra un usuario en el sistema
CREATE PROCEDURE user_register
@idPreceptor int,
@nombre varchar(30),
@claveAcceso varchar(max),
@nivelAcceso int,
@ultimoAcceso date,
@email varchar(100)
AS
BEGIN
	INSERT INTO usuarios VALUES (@idPreceptor, @nombre, @claveAcceso, @nivelAcceso, @ultimoAcceso, @email)
END 
