USE [JugueteriaWonka]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
	CREATE view [dbo].[V_Producto] as
	select P.IdProducto,
		   P.Nombre,
		   P.EdadMinima,
		   P.EdadMaxima,
		   P.Descripcion,
		   P.Precio,
		   P.Stock,
		   M.IdMarca,
		   M.NombreM
	from Producto P INNER JOIN Marca M on M.IdMarca = P.IdMarca
	WHERE P.Activo > 0;
GO
