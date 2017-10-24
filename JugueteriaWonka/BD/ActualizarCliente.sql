USE [JugueteriaWonka]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[pa_actCliente] 
	@id int,
	@Nombre VARCHAR(50),
	@ApellidoPaterno VARCHAR(50),
	@ApellidoMaterno VARCHAR(50),
	@Genero VARCHAR(2),
	@Rfc VARCHAR(14),
	@Curp VARCHAR(20),
	@FechaNacimiento varchar(20), --DD/MM/AAAA
	@Cp VARCHAR(15),
	@Fotografia TEXT,--Se guardará la Imagen como texto.			
	@Domicilio VARCHAR(128),
	@Email VARCHAR(128),
	@Telefono VARCHAR(20)
AS
BEGIN
	SET NOCOUNT ON
	BEGIN TRANSACTION
	BEGIN TRY
	UPDATE Persona SET Nombre=@Nombre, ApellidoPaterno=@ApellidoPaterno, ApellidoMaterno=@ApellidoMaterno,Genero=@Genero, Rfc=@Rfc, Curp=@Curp, FechaNacimiento=CONVERT(DATE, @FechaNacimiento, 103), Cp=@Cp,Fotografia=@Fotografia, Domicilio=@Domicilio WHERE IdPersona=@id
	UPDATE Cliente SET Email=@Email, Telefono=@Telefono WHERE IdPersona=@id
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
