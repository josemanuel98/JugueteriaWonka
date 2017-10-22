USE [JugueteriaWonka]
GO

/****** Object:  StoredProcedure [dbo].[pa_insVenta]    Script Date: 22-Oct-17 2:12:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[pa_insVenta]
	@Descipcion VARCHAR(180),
	@IdFomaPago INT OUT,
	@Fecha VARCHAR(20),
	@IdEmpleado INT,
	@IdCliente INT, 
	@IdVenta INT OUT,
	@CantidadProducto INT,
	@Precio INT,
	@IdProducto INT
AS
BEGIN
	INSERT INTO FormaPago (Descripcion) VALUES (@Descipcion);
	SET @IdFomaPago = SCOPE_IDENTITY();
	INSERT INTO Venta (Fecha, IdEmpleado, IdCliente, IdFormaPago) VALUES (CONVERT(DATE, @Fecha, 103), @IdEmpleado, @IdCliente, @IdFomaPago);
	SET @IdVenta = SCOPE_IDENTITY();
	INSERT INTO DetalleVenta (CantidadProducto, Precio, IdVenta, IdProducto) VALUES (@CantidadProducto, @Precio, @IdVenta, @IdProducto);
END
GO

