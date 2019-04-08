package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import COMUN.clsSocioRepetidoException;
import COMUN.itfProperty;
import LD.clsDatos;
import LN.clsTipoSocio;
import LN.clsSocio;

/**
 * @author Industria 4.0
 * 
 *Esta clase se encarga de hacer de intermediario entre la capa de presentacion y la capa de negocio
 *Para ello, utilizara todos los metodos necesarios para realizar las funcionalidades del menu.
 */

/**
 * @author Industria 4.0
 *
 */
public class clsGestor {
	
	private ArrayList<clsUsuario>miLista;
	private clsDatos objDatos;
	private clsSocio objSocio;
	private HashSet<clsUsuario>miListaDiferentes;
	
	public clsGestor()
	{
		miLista = new ArrayList<clsUsuario>();
		objDatos = new clsDatos();
		
	}
	
	
	/**
	 * Este metodo permite crear objetos de la clase clsSocio. Como parametros le pasamos todos los atributos
	 * de su clase padre clsUsuario y todos los atributos propios de la clase clsSocio. Estos valores se los 
	 * pasamos como parametros porque seran introducidos por teclado por el usuario de la aplicacion.
	 * 
	 * @param _nombre Nombre del Socio
	 * @param _apellido1 Primer apellido del socio
	 * @param _apellido2 Segundo apellido del socio
	 * @param _dni DNI del socio
	 * @param _direccion Direccion del socio
	 * @param _codigoPostal Codigo Postal del socio
	 * @param _fechaNacimiento Fecha de namiciento del socio
	 * @param _telefono Telefono del socio
	 * @param _email Email del socio
	 * @param _iban IBAN del socio
	 * @param _idtipo_socio Tipo socio del socio
	 * 
	 * El metodo no tiene ningun retorno, simplemente a�ade un nuevo socio al ArrayList miLista
	 */
	public void CrearSocio(String _nombre, String _apellido1, String _apellido2, String _dni,
			String _direccion, String _codigoPostal, String _fechaNacimiento, String _telefono,
			String _email, String _iban, int _idtipo_socio) throws clsSocioRepetidoException
	{
		
		objSocio = new clsSocio(_nombre, _apellido1, _apellido2, _dni,
				_direccion, _codigoPostal, _fechaNacimiento, _telefono,
				_email, _iban, _idtipo_socio);
		
		objSocio.setNombre(_nombre);
		objSocio.setApellido1(_apellido1);
		objSocio.setApellido2(_apellido2);
		objSocio.setDNI(_dni);
		objSocio.setDireccion(_direccion);
		objSocio.setCodigoPostal(_codigoPostal);
		objSocio.setFechaNacimiento(_fechaNacimiento);
		objSocio.setTelefono(_telefono);
		objSocio.setEmail(_email);
		objSocio.setIban(_iban);
		objSocio.setIdtipo_socio(_idtipo_socio);
		
		miLista.add(objSocio);
		
		//Introducimos el objSocio en un HashSet para comprobar si ya existe en el sistema. Si ya 
		//existe, lanzaremos una excepcion
		
		miListaDiferentes = new HashSet<clsUsuario>();
		miListaDiferentes.add(objSocio);
		
		
		if(miListaDiferentes.add(objSocio) == false)
		{
			throw new clsSocioRepetidoException ();
		
		//Llamamos al metodo de la clase clsDatos, para poder insertar el socio creado en la base de datos
		}else {
		objDatos.insertarSocio(_nombre, _apellido1, _apellido2, _dni, _direccion, _codigoPostal, _fechaNacimiento, _telefono, _email, _iban, _idtipo_socio);
		System.out.println("Bien");
		}
		
	
	}
	/**
	 * Este metodo permite crear objetos de la clase clsProfesor. Como parametros le pasamos todos los atributos
	 * de su clase padre clsUsuario y todos los atributos propios de la clase clsProfesor. Estos valores se los 
	 * pasamos como parametros porque seran introducidos por teclado por el usuario de la aplicacion.
	 *
	 * @param _nombre Nombre del Profesor
	 * @param _apellido1 Primer apellido del profesor
	 * @param _apellido2 Segundo apellido del profesor
	 * @param _dni DNI del profesor
	 * @param _direccion Direccion del profesor
	 * 
	 * El metodo no tiene ningun retorno, simplemente añade un objeto profesor al ArrayList miLista
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
		
		//Creamos un objeto de la clase clsDatos, para poder insertar el profesor creado en la base de datos
				clsDatos objDatos = new clsDatos();
				objDatos.insertarProfesor (_nombre, _apellido1, _apellido2, _dni, _direccion);
	}
	

	/**
	 * Este metodo permite recuperar los datos de un socio a partir del DNI que se le pasa como parametro.
	 *
	 * @param dni DNI del socio
	 * 
	 * @return Devuelve un objeto de tipo socio con los datos del socio recuperados de la base de datos
	*/
	public clsSocio mostrarUnSocio (String dni)
	{
		objSocio = objDatos.recuperarUnSocio(dni);
		
		return objSocio;
	}
	
 /**
  * Con este metodo vamos a buscar un socio por su dni, que lo pasamos por parámetro, y eliminarlo.
  * 
 * @param dni DNI del socio
 * 
 * No devuelve nada
 */
	public void borrarSocio(String dni)	{
	clsSocio objSocioBorrar = new clsSocio(null, null, null, dni, null, null, null, null, null, null, 0);
	}
	
	/**
	 * Este método crea un array con los socios que estén en la lista de usuarios, para luego poder mostrarlos por pantalla
	 * No hace falta pasarle ningún parámetro
	 * @return retorno. Devuelve un ArrayList de objetos itfProperty que se llama retorno.
	 */
	public ArrayList<itfProperty> descargaSocios()
 {
		ArrayList<itfProperty> retorno;
		
		retorno = new ArrayList<itfProperty>();
		
		ResultSet misSocios = objDatos.recuperarSocios();
		
		try {
		while (misSocios.next())
    	{
    	objSocio = new clsSocio();
    		
  		objSocio.setNombre(misSocios.getString("Nombre"));
  		objSocio.setApellido1(misSocios.getString("Apellido1"));
  		objSocio.setApellido2(misSocios.getString("Apellido2"));
  		objSocio.setDNI(misSocios.getString("DNI"));
  		objSocio.setDireccion(misSocios.getString("Direccion"));
  		objSocio.setCodigoPostal(misSocios.getString("Codigo_Postal"));
  		objSocio.setFechaNacimiento(misSocios.getString("Fecha_Nacimiento"));
  		objSocio.setTelefono(misSocios.getString("Telefono"));
  		objSocio.setEmail(misSocios.getString("email"));
  		objSocio.setIban(misSocios.getString("IBAN"));
  		objSocio.setIdtipo_socio(misSocios.getInt("idTIPO_SOCIO"));
  		
  		retorno.add(objSocio);
  		
  		
    	}
  		

} catch (SQLException e) {
    System.out.println("No se ha podido realizar la consulta: " + e);
}
		
		
		
		return retorno;

	}
	
	/**
	 * Este método crea un array con los profesores que estén lista de usuarios para luego poder mostrarlo por pantalla.
	 * No hace falta pasarle ningún parámetro
	 * @return retorno. Devuelve un ArrayList de objetos itfProperty que se llama retorno.
	 */
	public ArrayList<itfProperty> DameProfesores()	{
		ArrayList<itfProperty> retorno;
		
		retorno = new ArrayList<itfProperty>();
		
		
		for(clsUsuario a: miLista)
			if(a instanceof clsProfesor)
				retorno.add(a);
		
		return retorno;

	}
	
	public ArrayList<itfProperty> consultarSocios()
	 {
			ArrayList<itfProperty> socios;
			
			socios = objDatos.recuperarSocios();
				
			return socios;

		}
	
	
	public ArrayList<itfProperty> mostrarTipoSocio()
	 {
			ArrayList<itfProperty> retorno = new ArrayList<itfProperty>();
			
			ResultSet miTipoSocio = objDatos.mostrarTipoSocio();
			
			try
			{
			while (miTipoSocio.next())
	    	{
	    	clsTipoSocio objTipoSocio = new clsTipoSocio();
	    		
	  		objTipoSocio.setIdTipo_Socio(miTipoSocio.getInt("idTipo_Socio"));
	  		objTipoSocio.setNombre(miTipoSocio.getString("Nombre"));
	  		objTipoSocio.setDescripcion(miTipoSocio.getString("Descripcion"));
	  		objTipoSocio.setCuota(miTipoSocio.getDouble("cuota"));
	  		
	  		retorno.add(objTipoSocio);
	    	}
			 } catch (SQLException e) {
			        System.out.println("No se ha podido realizar la consulta: " + e);
			    }
				
			return retorno;

		}
	
	
	
	
}
