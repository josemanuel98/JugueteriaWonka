USE [JugueteriaWonka]
GO
/****** Object:  StoredProcedure [dbo].[pa_insVentaDetalle]    Script Date: 24-Oct-17 8:11:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[pa_insVentaDetalle]
	@CantidadProducto INT,
	@Precio INT,
	@IdVenta INT,
	@IdProducto INT
AS
BEGIN
	SET NOCOUNT ON;
	BEGIN TRANSACTION
	BEGIN TRY
	INSERT INTO DetalleVenta (CantidadProducto, Precio, IdVenta, IdProducto) VALUES (@CantidadProducto, @Precio, @IdVenta, @IdProducto);
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
