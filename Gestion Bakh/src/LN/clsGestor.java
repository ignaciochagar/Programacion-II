package LN;

import java.util.ArrayList;

import COMUN.itfProperty;
import LD.clsDatos;

/**
 * @author Industria 4.0
 * 
 *Esta clase se encarga de hacer de intermediario entre la capa de presentaci�n y la capa de negocio
 *Para ello, utilizar� todos los m�todos necesarios para realizar las funcionalidades del men�.
 */


public class clsGestor {
	
	private ArrayList<clsUsuario>miLista;
	private clsDatos objDatos;
	
	public clsGestor()
	{
		miLista = new ArrayList<clsUsuario>();
		objDatos = new clsDatos();
		//objDatos.Connect();
		
	}
	
	
	/**
	 * Este m�todo permite crear objetos de la clase clsSocio. Como par�metros le pasamos todos los atributos
	 * de su clase padre clsUsuario y todos los atributos propios de la clase clsSocio. Estos valores se los 
	 * pasamos como par�metros porque ser�n introducidos por teclado por el usuario de la aplicaci�n.
	 * 
	 * @param _nombre
	 * @param _apellido1
	 * @param _apellido2
	 * @param _dni
	 * @param _direccion
	 * @param _codigoPostal
	 * @param _fechaNacimiento
	 * @param _telefono
	 * @param _email
	 * @param _iban
	 * 
	 * El m�todo no tiene ning�n retorno, simplemente a�ade un nuevo socio al ArrayList miLista
	 */
	public void CrearSocio(String _nombre, String _apellido1, String _apellido2, String _dni,
			String _direccion, String _codigoPostal, String _fechaNacimiento, String _telefono,
			String _email, String _iban)
	{
		clsSocio objSocio;
		
		objSocio = new clsSocio(_nombre, _apellido1, _apellido2, _dni,
				_direccion, _codigoPostal, _fechaNacimiento, _telefono,
				_email, _iban);
		
		objSocio.setNombre(_nombre);
		objSocio.setApellido1(_apellido1);
		objSocio.setApellido2(_apellido2);
		objSocio.setDNI(_dni);
		objSocio.setCodigoPostal(_codigoPostal);
		objSocio.setFechaNacimiento(_fechaNacimiento);
		objSocio.setTelefono(_telefono);
		objSocio.setEmail(_email);
		objSocio.setIban(_iban);
		
		miLista.add(objSocio);
		}
	/**
	 * Este m�todo permite crear objetos de la clase clsProfesor. Como par�metros le pasamos todos los atributos
	 * de su clase padre clsUsuario y todos los atributos propios de la clase clsProfesor. Estos valores se los 
	 * pasamos como par�metros porque ser�n introducidos por teclado por el usuario de la aplicaci�n.
	 * 
	 * @param _nombre
	 * @param _apellido1
	 * @param _apellido2
	 * @param _dni
	 * @param _direccion
	 * 
	 * El m�todo no tiene ning�n retorno, simplemente a�ade un objeto profesor al ArrayList miLista
	 */
	public void CrearProfesor(String _nombre, String _apellido1, String _apellido2, String _dni, String _direccion)
	{
		clsProfesor objProfesor;
		
		objProfesor = new clsProfesor();
		
		objProfesor.setNombre(_nombre);
		objProfesor.setApellido1(_apellido1);
		objProfesor.setApellido2(_apellido2);
		objProfesor.setDNI(_dni);
		objProfesor.setDireccion(_direccion);
		
		miLista.add(objProfesor);
	}
	public ArrayList<itfProperty>DameSocios()
	{
		ArrayList<itfProperty> retorno;
		
		retorno = new ArrayList<itfProperty>();
		
		for(clsUsuario a: miLista)
			if(a instanceof clsSocio)
			retorno.add(a);
		
		return retorno;

	}
	
	public ArrayList<itfProperty>DameProfesores()
	{
		ArrayList<itfProperty> retorno;
		
		retorno = new ArrayList<itfProperty>();
		
		
		for(clsUsuario a: miLista)
			if(a instanceof clsProfesor)
				retorno.add(a);
		
		return retorno;

	}

	
	
	
}
