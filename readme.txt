Manual de instalación:
Requerimientos:
1- Microsoft SQL JDBC 4.0

Pasos:
1- Crear una base de datos con el nombre deseado.
2- Ejecutar el script "schema final.sql" que está en la carpeta sql
3- Importar el proyecto en Eclipse y configurar la vía de construcción del proyecto.
4- Ir al paquete "pkg.Database" y abrir el archivo "SQLConnector.java" y rellenar los campos con los datos correspondientes:

	> String  hostname 	     : Host del servidor SQL Server.
	> String  database 	     : Nombre de la base de datos con las tablas (Base de datos creada en el paso 1, con el script cargado del paso 2).
	> Int	  port	  	     : Puerto del servidor SQL Sever (1433 por defecto).
	> Boolean integratedSecurity : Indica si se autentifica por seguridad integrada o no.

	>>>>>>  Si integratedSecurity es FALSE
	        > String username    : Nombre de usuario para entrar al servidor.
	        > String password    : Contraseña del usuario para entrar al servidor.