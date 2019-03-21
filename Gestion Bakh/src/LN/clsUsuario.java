package LN;

import static COMUN.clsConstantes.PROPIEDAD_USUARIO_NOMBRE;
import static COMUN.clsConstantes.PROPIEDAD_USUARIO_APELLIDO1;
import static COMUN.clsConstantes.PROPIEDAD_USUARIO_APELLIDO2;
import static COMUN.clsConstantes.PROPIEDAD_USUARIO_DIRECCION;
import static COMUN.clsConstantes.PROPIEDAD_USUARIO_DNI;

import COMUN.itfProperty;

/**
 * @author Ignacio Chapero
 * 		   Alvaro Husillos
 * 
 * Esta clase es abstracta para que por higiene de programación no nos deje crear objetos de la misma.
 * Esta clase es la clase padre de clsSocio y clsProfesor, de tal forma que los atributos y métodos de 
 * esta clasé serán heredados por clsSocio y clsProfesor.
 *
 */
public abstract class clsUsuario implements itfProperty {
	
	/**
    Atributo nombre de la persona.
    */
    private String nombre;
    /**
     *  Atributo apellido1 de la persona.
     */
    private String apellido1;
    /**
     *  Atributo apellido2 de la persona.
     */
    private String apellido2;
    /**
     *  Atributo dni de la persona.
     */
    private String dni;
    /**
     *  Atributo dirección de la persona.
     */
    private String direccion;
    
    public clsUsuario() {
    	
    	
    	this.nombre="";
    	this.apellido1="";
    	this.apellido2="";
    	this.dni="";
    	this.direccion="";
    	
    }
    /**
     * Constructor de la clase clsUsuario. Necesita como parámetros los atributos de esta clase, que son los
     * inicializados anteriormente.
     * 
     * @param _nombre
     * @param _apellido1
     * @param _apellido2
     * @param _dni
     * @param _direccion
     * 
     * No tiene ningún retorno.
     */
	public clsUsuario(String _nombre, String _apellido1, String _apellido2, String _dni, String _direccion) {
		
		
		this.dni = _dni;
		this.nombre = _nombre;
		this.apellido1 = _apellido1;
		this.apellido2 = _apellido2;
		this.direccion = _direccion;
	}

	public String getDNI() {
		return dni;
	}

	public void setDNI(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Object getProperty(String propiedad) 
	{
		
			switch(propiedad)
			{
			case PROPIEDAD_USUARIO_NOMBRE: return this.getNombre();
			case PROPIEDAD_USUARIO_APELLIDO1: return this.getApellido1();
			case PROPIEDAD_USUARIO_APELLIDO2: return this.getApellido2();
			case PROPIEDAD_USUARIO_DIRECCION: return this.getDireccion();
			case PROPIEDAD_USUARIO_DNI: return this.getDNI();
			
			
			}
			return propiedad;
			
		}
	}
	
	
    



