package LN;

import COMUN.itfProperty;

public class clsTipoSocio implements itfProperty {
	
	/**
	 * Atributo de clase tipo de socio que define la modalidad de socio.
	 */
	private String nombre = "";
	
	/**
	 * Atributo descripcion de cada modalidad de tipo de socio.
	 */
	private String descripcion = "";
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public Object getObjectProperty(Object propiedad) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
