CREATE VIEW V_Cliente
AS
SELECT Cliente.IdCliente,
		Persona.IdPersona,
		Persona.Nombre,
		Persona.ApellidoPaterno,
		Persona.ApellidoMaterno,
		Persona.Genero,
		Persona.Rfc,
		Persona.Curp,
		CONVERT(NVARCHAR, Persona.FechaNacimiento, 103) AS FechaNacimientol,
		Persona.Cp,
		Persona.Fotografia,
		Persona.Domicilio,
		Cliente.Email,
		Cliente.Telefono,
		Cliente.Activo
		FROM Cliente INNER JOIN Persona ON Cliente.IdPersona = Persona.IdPersona