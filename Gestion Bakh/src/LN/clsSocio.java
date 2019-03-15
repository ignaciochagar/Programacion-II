package LN;

import COMUN.itfProperty;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_NOMBRE;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_APELLIDO1;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_APELLIDO2;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_DIRECCION;
/**
 * @author Ignacio Chapero
 * 		   Alvaro Husillos
 * 
 * Esta clase es la encargada de crear distintos socios. Esta clase hereda los atributos y métodos de su
 * clase padre que es clsUsuario. En añadidura a estos atributos heredados, además posee otros propios que son
 * codigoPostal, fechaNacimiento, telefono, email, iban.
 *
 */
public class clsSocio extends clsUsuario {
			
	/**
	 * Atributo del codigo postal del socio del gimnasio.
	 */
	private String codigoPostal ="";
	
	/**
	 * Atributo de la fecha de nacimiento del socio del gimnasio.
	 */
	private String fechaNacimiento ="";
	
	/**
	 * Atributo del telefono del socio del gimnasio.
	 */
	private String telefono ="";
	
	/**
	 * Atributo del email del socio del gimnasio.
	 */
	private String email ="";
	
	/**
	 * Atributo del numero de cuenta del socio del gimnasio.
	 */
	private String iban ="";

	public clsSocio (String _nombre, String _apellido1, String _apellido2, String _dni, String _direccion, String _codigoPostal, String _fechaNacimiento, String _telefono, String _email, String _iban)
	{
		super();
		this.codigoPostal= _codigoPostal;
	}

	
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	

	@Override
	public Object getProperty(String propiedad)
	{
		switch(propiedad)
		{
		case PROPIEDAD_SOCIO_NOMBRE: return this.getNombre();
		case PROPIEDAD_SOCIO_APELLIDO1: return this.getApellido1();
		case PROPIEDAD_SOCIO_APELLIDO2: return this.getApellido2();
		case PROPIEDAD_SOCIO_DIRECCION: return this.getDireccion();
		
		
		}
		
	}

	
	
	
}
