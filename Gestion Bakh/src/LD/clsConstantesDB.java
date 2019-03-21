package LD;

public class clsConstantesDB {

	public static final String SQL_INSERT_SOCIO = "INSERT INTO gestion_bakh.socio (nombre, apellido1, apellido2, dni, direccion,"
			+ " codigo_postal, fecha_nacimiento, telefono, email, iban) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String SQL_INSERT_PROFESOR = "INSERT INTO gestion_bakh.profesor (nombre, apellido1, apellido2, dni, direccion)"
			+ "values (?, ?, ?, ?, ?)";
	
	public static final String PROPIEDAD_SOCIO_NOMBRE = "NOMBRE";
	public static final String PROPIEDAD_SOCIO_APELLIDO1 = "APELLIDO1";
	public static final String PROPIEDAD_SOCIO_APELLIDO2 = "APELLIDO2";
	public static final String PROPIEDAD_SOCIO_DIRECCION = "DIRECCION";
	public static final String PROPIEDAD_SOCIO_DNI = "DNI";
	public static final String PROPIEDAD_SOCIO_CODIGO_POSTAL = "CODIGO POSTAL";
	public static final String PROPIEDAD_SOCIO_TELEFONO = "TELEFONO";
	public static final String PROPIEDAD_SOCIO_EMAIL = "EMAIL";
	public static final String PROPIEDAD_SOCIO_FECHA_NACIMIENTO = "FECHA NACIMIENTO";
	public static final String PROPIEDAD_SOCIO_IBAN = "IBAN";
}
