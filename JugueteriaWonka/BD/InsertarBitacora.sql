USE [JugueteriaWonka]
GO
/****** Object:  StoredProcedure [dbo].[pa_insBitacora]    Script Date: 22-Oct-17 6:46:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[pa_insBitacora]
	@FechaAbastecimiento  VARCHAR(20),
	@IdBitacora INT OUT,
	@Cantidad INT,
	@PrecioCompra INT,
	@IdProducto INT
AS
BEGIN
	INSERT INTO Bitacora (FechaAbastecimiento) VALUES (CONVERT(DATE, @FechaAbastecimiento, 103));
	SET @IdBitacora= SCOPE_IDENTITY();
	INSERT INTO DetalleBitacora (Cantidad, PrecioCompra, IdBitacora, IdProducto) VALUES (@Cantidad, @PrecioCompra, @IdBitacora, @IdProducto);
END