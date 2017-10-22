USE [JugueteriaWonka]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER VIEW [dbo].[V_Empleado]
AS
	SELECT E.IdEmpleado, P.Nombre FROM Empleado E INNER JOIN Persona P ON E.IdPersona = P.IdPersona WHERE E.Activo > 0;
GO