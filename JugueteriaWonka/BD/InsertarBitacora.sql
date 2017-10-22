USE [JugueteriaWonka]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pa_insBitacora]
	@IdBitacora INT OUT,
	@FechaAbastecimiento  VARCHAR(20),
	@Cantidad INT,
	@PrecioCompra INT,
	@IdProducto INT
AS
BEGIN
	INSERT INTO Bitacora (FechaAbastecimiento) VALUES (CONVERT(DATE, @FechaAbastecimiento, 103));
	SET @IdBitacora= SCOPE_IDENTITY();
	INSERT INTO DetalleBitacora (Cantidad, PrecioCompra, IdBitacora, IdProducto) VALUES (@Cantidad, @PrecioCompra, @IdBitacora, @IdProducto);
END