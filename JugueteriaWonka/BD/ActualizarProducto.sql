USE [JugueteriaWonka]
GO
/****** Object:  StoredProcedure [dbo].[pa_actProducto]    Script Date: 24-Oct-17 8:02:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[pa_actProducto]
	@Nombre VARCHAR(50),
	@EdadMinima INT,
	@EdadMaxima INT,
	@Descripcion VARCHAR(180),
	@Precio FLOAT,
	@Stock INT,
	@Fotografia TEXT,
	@Activo INT,
	@IdProducto INT
AS
BEGIN
	SET NOCOUNT ON;
	BEGIN TRANSACTION
	BEGIN TRY
	UPDATE Producto SET Nombre = @Nombre, EdadMinima = @EdadMinima, EdadMaxima = @EdadMaxima, Descripcion = @Descripcion, Precio = @Precio, Stock = @Stock, Fotografia = @Fotografia, Activo = @Activo WHERE IdProducto =  @IdProducto;
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