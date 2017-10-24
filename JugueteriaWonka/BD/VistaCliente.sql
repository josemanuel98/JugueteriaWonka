USE [JugueteriaWonka]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE view [dbo].[V_Cliente] as
	select C.IdCliente,
		   P.IdPersona,
		   P.Nombre,
		   P.ApellidoPaterno,
		   P.ApellidoMaterno,
		   P.Genero,
		   P.Rfc,
		   P.Curp,
		   CONVERT(nvarchar, P.FechaNacimiento, 103) as FechaNacimiento,
		   P.Cp,
		   P.Fotografia,
		   P.Domicilio,
		   C.Email,
		   C.Telefono,
		   C.Activo
	from   Cliente C INNER JOIN Persona P on C.IdPersona = P.IdPersona
	WHERE C.Activo > 0;

GO
