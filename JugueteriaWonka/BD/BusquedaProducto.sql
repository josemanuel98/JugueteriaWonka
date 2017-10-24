USE [JugueteriaWonka]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pa_busqProducto]
	@Nombre VARCHAR(50)
AS
BEGIN
	SET NOCOUNT ON;
	SELECT * FROM Producto WHERE Nombre = @Nombre AND Activo > 0;
END
GO