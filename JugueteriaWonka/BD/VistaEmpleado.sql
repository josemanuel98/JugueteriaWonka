USE [JugueteriaWonka]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_Empleado]
AS
	SELECT E.IdEmpleado, E.Salario, E.Codigo, E.FechaIngreso, E.Activo, P.Nombre, P.ApellidoPaterno , P.ApellidoMaterno, P.Genero, P.Rfc, P.Curp, P.FechaNacimiento, P.Cp, P.Domicilio FROM Empleado E INNER JOIN Persona P ON E.IdPersona = P.IdPersona WHERE E.Activo > 0;

GO
