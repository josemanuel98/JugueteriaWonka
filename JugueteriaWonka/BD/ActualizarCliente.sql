CREATE PROCEDURE uspActualizarCliente
@Nombre VARCHAR(50),
@Paterno VARCHAR(50),
@Materno VARCHAR(50),
@Genero VARCHAR(2),
@Rfc VARCHAR(14),
@Curp VARCHAR(20),
@FechaNacimiento VARCHAR(20),
@Cp VARCHAR(15),
@Fotografia TEXT,
@Domicilio VARCHAR(128),
@Email VARCHAR(128),
@Telefono VARCHAR(20),
@IdPersona INT,
@IdCliente INT,
@Activo INT
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRANSACTION
	BEGIN TRY
		UPDATE Persona
			SET Nombre = @Nombre,
				ApellidoPaterno = @Paterno,
				ApellidoMaterno = @Materno,
				Genero = @Genero,
				Rfc = @Rfc,
				Curp = @Curp,
				FechaNacimiento = @FechaNacimiento,
				Cp = @Cp,
				Fotografia = @Fotografia,
				Domicilio = @Domicilio
			WHERE IdPersona = @IdPersona
		UPDATE Cliente
			SET Email = @Email,
				Telefono = @Telefono,
				Activo = @Activo
			WHERE IdCliente = @IdCliente
		COMMIT TRANSACTION
	END TRY
	BEGIN CATCH
		declare @errnumber int=0, 
		@errseverity int=0, 
		@errstate int=0,
		@errproc nvarchar(126)=N'',
		@errline int=0,
		@errmsg nvarchar(2048)=N''

		select @errnumber=ERROR_NUMBER(),
			@errseverity=ERROR_SEVERITY(),
			@errstate=ERROR_STATE(),
			@errproc=ERROR_PROCEDURE(),
			@errline=ERROR_LINE(),
			@errmsg=ERROR_MESSAGE()

		select ERROR_NUMBER(),ERROR_SEVERITY(),ERROR_STATE(),ERROR_PROCEDURE(),ERROR_LINE(),ERROR_MESSAGE()
		ROLLBACK TRANSACTION
	END CATCH
END