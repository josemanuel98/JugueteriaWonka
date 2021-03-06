USE [JugueteriaWonka]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[pa_insCliente]
	@Nombre VARCHAR(50),
	@APaterno VARCHAR(50),
	@AMaterno VARCHAR(50),
	@Genero	VARCHAR(2),
	@RFC VARCHAR(13),
	@CURP VARCHAR(20),
	@FNacimiento VARCHAR(20),
	@CP VARCHAR(15),
	@Domicilio VARCHAR(128),
	@Fotografia	TEXT,
	@Email VARCHAR(128),
	@Telefono VARCHAR(20),
	@IDPersonaGenerado INT OUT,
	@IDClienteGenerado INT OUT
AS
BEGIN
	SET NOCOUNT ON;
	BEGIN TRANSACTION
	BEGIN TRY
	INSERT INTO Persona (Nombre, ApellidoPaterno, ApellidoMaterno, Genero, RFC, CURP, CP, Fotografia, Domicilio, FechaNacimiento) VALUES (@Nombre, @APaterno, @AMaterno, @Genero, @RFC, @CURP, @CP, @Fotografia, @Domicilio, CONVERT(DATE, @FNacimiento, 103));
	SET @IDPersonaGenerado= SCOPE_IDENTITY();
	INSERT INTO Cliente (Email, Telefono, Activo, IDPersona) VALUES (@Email, @Telefono, 1, @IDPersonaGenerado);
	SET @IDClienteGenerado = SCOPE_IDENTITY();
	END TRY
	BEGIN CATCH
		declare @errnumber int=0, 
		@errseverity int=0, 
		@errstate int=0,
		@errproc nvarchar(126)=N'',
		@errline int=0,
		@errmsg nvarchar(2048)=N''
		select	@errnumber=ERROR_NUMBER(),
				@errseverity=ERROR_SEVERITY(),
				@errstate=ERROR_STATE(),
				@errproc=ERROR_PROCEDURE(),
				@errline=ERROR_LINE(),
				@errmsg=ERROR_MESSAGE()
		select ERROR_NUMBER(),ERROR_SEVERITY(),ERROR_STATE(),ERROR_PROCEDURE(),ERROR_LINE(),ERROR_MESSAGE()
		ROLLBACK TRANSACTION
	END CATCH
END
