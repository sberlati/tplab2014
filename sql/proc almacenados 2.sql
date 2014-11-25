USE asistencias
GO
CREATE PROCEDURE user_modificar
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
CREATE PROCEDURE user_modificar_password
@idUsuario int,
@nuevaPassword varchar(max)
AS
BEGIN
	UPDATE usuarios SET clave_acceso=@nuevaPassword WHERE id_usuario=@idUsuario
END
GO
CREATE PROCEDURE alumno_por_curso
@idAno int,
@idDivision int
AS
BEGIN
	SELECT * FROM alumno WHERE id_division=@idDivision AND id_ano=@idAno ORDER BY id_alumno DESC
END
GO
CREATE PROCEDURE alumno_by_faltas_mayor
AS
BEGIN
	SELECT _alumno.id_alumno, _alumno.id_division, _alumno.id_ano, nombre, apellido, dni FROM alumno AS _alumno 
	INNER JOIN parte_diario AS faltas ON (_alumno.id_alumno = faltas.id_alumno)
	ORDER BY faltas.id_alumno DESC
END
GO
CREATE PROCEDURE alumno_by_faltas_menor
AS
BEGIN
	SELECT _alumno.id_alumno, _alumno.id_division, _alumno.id_ano, nombre, apellido, dni FROM alumno AS _alumno 
	INNER JOIN parte_diario AS faltas ON (_alumno.id_alumno = faltas.id_alumno)
	ORDER BY faltas.id_alumno ASC
END
GO
ALTER TABLE usuarios
ADD suspendido bit not null default 0;
GO
CREATE PROCEDURE usuario_delete 
@idUsuario int
AS
BEGIN
	DELETE FROM usuarios WHERE id_usuario = @idUsuario
END
GO
CREATE PROCEDURE preceptor_agregar
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