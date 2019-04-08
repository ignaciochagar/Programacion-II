package LD;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import static LD.clsConstantesDB.SQL_INSERT_SOCIO;
import static LD.clsConstantesDB.SQL_SELECT_SOCIO;
import static LD.clsConstantesDB.SQL_SELECT_SOCIOS;
import static LD.clsConstantesDB.SQL_SELECT_TIPO_SOCIO;

import static LD.clsConstantesDB.SQL_INSERT_PROFESOR;
import static LD.clsConstantesDB.TIME;
import static LD.clsConstantesDB.SSL;
import static LD.clsConstantesDB.URL;
import static LD.clsConstantesDB.USER;
import static COMUN.clsConstantes.PROPIEDAD_TIPO_SOCIO_CUOTA;
import static COMUN.clsConstantes.PROPIEDAD_TIPO_SOCIO_DESCRIPCION;
import static COMUN.clsConstantes.PROPIEDAD_TIPO_SOCIO_ID;
import static COMUN.clsConstantes.PROPIEDAD_TIPO_SOCIO_NOMBRE;
import static LD.clsConstantesDB.PASSWORD;


/**
 * @author Industria 4.0
 *
 */
/**
 * @author Industria 4.0
 *
 */
/**
 * @author Industria 4.0
 *
 */
public class clsDatos 
{
			
						
		/**
		 * Este metodo sirve para realizar una conexion con la base de datos que le indiquemos a traves de
		 * la url, el user y el password. Para ello crea un objeto de la clase Connection ya implementada en
		 * el nucleo de java.
		 * 
		 * @return Connection devuelve una conexion, es decir, un objeto de la clase Connection.
		 */
		public Connection conectarBD()
		{
			
	        Connection objConn = null;

	        try { 
	        	
	        	objConn = DriverManager.getConnection (URL, USER, PASSWORD);
	        
	        } catch (SQLException e) {
	            System.out.println("Ha fallado la conexi�n" + e);
	        }

	        return objConn;

		}	
		
		public void desconectarBD(Connection conexion) 
		{
			
	        try { 
	        	
	        	conexion.close();
	        	
	        } catch (SQLException e) {
	            System.out.println("Ha fallado la desconexi�n");
	        }

		}
		
		/**
		 * @author Ignacio Chapero
		 * 		   Alvaro Husillos
		 * 
		 *Este metodo se utiliza para insertar los datos de un nuevo socio en la base de datos.Para ello 
		 *primero comprueba que existe conexi�n con la BD y si la conexion es correcta, entonces inserta los
		 *datos del nuevo socio.
		 *
		 * @param nombre Nombre del socio
		 * @param apellido1 Primer apellido del socio
		 * @param apellido2 Segundo apellido del socio
		 * @param dni DNI del socio
		 * @param direccion Direccion del socio
		 * @param codigo_postal Codigo Postal del socio
		 * @param fecha_nacimiento Fecha nacimiento del socio
		 * @param telefono Telefono del socio
		 * @param email email del socio
		 * @param iban IBAN del socio
		 * @param idtipo_socio Tipo de socio
		 * 
		 *No tiene ningun retorno.
		 */
		public void insertarSocio(String nombre, String apellido1, String apellido2, String dni, String direccion,
				String codigo_postal, String fecha_nacimiento, String telefono, String email, String iban, int idtipo_socio) 
		{
				
				// Instancias la clase que hemos creado anteriormente
			    clsDatos SQL = new clsDatos();
			    
				// Llamas al m�todo que tiene la clase y te devuelve una conexi�n
			    Connection objConn = SQL.conectarBD();
			    
			    try { 
				    if ( objConn != null ) {
				    	// Preparamos la insert 
				    	String query = SQL_INSERT_SOCIO;
				    	
				    	//Creamos las preparedstaments
				    	PreparedStatement objSt = objConn.prepareStatement(query);
				    	
				    	objSt.setString(1, nombre);
				    	objSt.setString(2, apellido1);
				    	objSt.setString(3, apellido2);
				    	objSt.setString(4, dni);
				    	objSt.setString(5, direccion);
				    	objSt.setString(6, codigo_postal);
				    	
				    	//Convertir la fecha
				    	SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy"); 
				    	java.util.Date dateStr = formatter.parse(fecha_nacimiento);
				    	java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
				    	
				    	objSt.setDate(7, dateDB);
				 		objSt.setString(8, telefono);
				    	objSt.setString(9, email);
				    	objSt.setString(10, iban);
				    	objSt.setInt(11, idtipo_socio);
				    	
				    	
				    	//Ejecutamos la query que hemos preparado
				  		objSt.execute();
				    	
				    	System.out.println("Se ha insertado el registro correctamente");
				    	
				    	//Cerramos el preparedStatement
				    	objSt.close();
				    	
				    	//Cerramos la conexi�n
				    	objConn.close();
				    	
				    } else {
				    	System.out.println("No existe conexi�n");
				    }
			    
			    } catch (ParseException pe) {
			        System.out.println("El formato de fecha no es correcto: " + pe);
			    } catch (SQLException e) {
			        System.out.println("No se ha podido realizar el insert: " + e);
			    }
		}


		/**
		 * @author Ignacio Chapero
		 * 		   Alvaro Husillos
		 * 
		 *Este metodo se utiliza para insertar los datos de un nuevo profesor en la base de datos.Para ello 
		 *primero comprueba que existe conexion con la BD y si la conexion es correcta, entonces inserta los
		 *datos del nuevo profesor.
		 *
		 *No tiene ningun retorno.
		*/ 
			
		public void insertarProfesor(String nombre, String apellido1, String apellido2, String dni, String direccion) 
		{
				
				// Instancias la clase que hemos creado anteriormente
			    clsDatos SQL = new clsDatos();
			    
				// Llamas al m�todo que tiene la clase y te devuelve una conexi�n
			    Connection objConn = SQL.conectarBD();
			    
			    try { 
				    if ( objConn != null ) {
				    	// Preparamos la insert 
				    	String query = SQL_INSERT_PROFESOR;
				    	
				    	//Creamos las preparedstaments
				    	PreparedStatement objSt = objConn.prepareStatement(query);
				    	
				    	objSt.setString(1, nombre);
				    	objSt.setString(2, apellido1);
				    	objSt.setString(3, apellido2);
				    	objSt.setString(4, dni);
				    	objSt.setString(4, direccion);
				    	
				    	
				    	//Ejecutamos la query que hemos preparado
				  		objSt.execute();
				    	
				    	System.out.println("Se ha insertado el registro correctamente");
				    	
				    	//Cerramos el preparedStatement
				    	objSt.close();
				    	
				    	//Cerramos la conexi�n
				    	objConn.close();
				    	
				    } else {
				    	System.out.println("No existe conexi�n");
				    }
			    
			    } catch (SQLException e) {
			        System.out.println("No se ha podido realizar el insert: " + e);
			    }
			}
	

		/**
		 * @author Ignacio Chapero
		 * 		   Alvaro Husillos
		 * 
		 *Este metodo se utiliza para recuperar un socio a partir del dni que le llega por parametro
		 * 
		 * @param dni DNI del socio
		 * 
		 * @return clsSocio Devuelve un objeto socio con todos los datos del socio
		*/ 
		public clsSocio recuperarUnSocio(String dni) 
		{
				clsSocio objSocio = new clsSocio();
				
				// Instancias la clase que hemos creado anteriormente
			    clsDatos SQL = new clsDatos();
			    
				// Llamas al m�todo que tiene la clase y te devuelve una conexi�n
			    Connection objConn = SQL.conectarBD();
			    
		  		
			    try { 
				    if ( objConn != null ) {
				    	
				    	// Preparamos la consulta 
				    	String query = SQL_SELECT_SOCIO;
				    	
				    	//Creamos las preparedstaments
				    	PreparedStatement objSt = objConn.prepareStatement(query);
				    	
				    	objSt.setString (1, dni);
				    					    	
				    	//Ejecutamos la query que hemos preparado
				    	ResultSet objRs = objSt.executeQuery();
				  		
				    	while (objRs.next())
				    	{
				  		objSocio.setNombre(objRs.getString("Nombre"));
				  		objSocio.setApellido1(objRs.getString("Apellido1"));
				  		objSocio.setApellido2(objRs.getString("Apellido2"));
				  		objSocio.setDNI(objRs.getString("DNI"));
				  		objSocio.setDireccion(objRs.getString("Direccion"));
				  		objSocio.setCodigoPostal(objRs.getString("Codigo_Postal"));
				  		objSocio.setFechaNacimiento(objRs.getString("Fecha_Nacimiento"));
				  		objSocio.setTelefono(objRs.getString("Telefono"));
				  		objSocio.setEmail(objRs.getString("email"));
				  		objSocio.setIban(objRs.getString("IBAN"));
				  		objSocio.setIdtipo_socio(objRs.getInt("idTIPO_SOCIO"));
				    	}
				  		//Cerramos el resultSet
				  		objRs.close();
				  		
				    	//Cerramos el preparedStatement
				    	objSt.close();
				    	
				    	//Cerramos la conexi�n
				    	objConn.close();
				    	
				    } else {
				    	System.out.println("No existe conexi�n");
				    }
			    
			    } catch (SQLException e) {
			        System.out.println("No se ha podido realizar la consulta: " + e);
			    }
			    
			    return objSocio;
		}


		/**
		 * @author Ignacio Chapero
		 * 		   Alvaro Husillos
		 * 
		 *Este metodo se utiliza para recuperar todos los socios existentes en la base de datos
		 * 
		 * @return ArrayListitfProperty Devuelve un array list de itfProperty
		*/ 
		public ResultSet recuperarSocios () 
		{
				ResultSet objRs = null;			
				// Instancias la clase que hemos creado anteriormente
			    clsDatos SQL = new clsDatos();
			    
				// Llamas al metodo que tiene la clase y te devuelve una conexi�n
			    Connection objConn = SQL.conectarBD();
			    
		  		try {
			   
				 
				    if ( objConn != null ) {
				    	
				    	// Preparamos la consulta 
				    	String query = SQL_SELECT_SOCIOS;
				    	
				    	//Creamos las preparedstaments
				    	PreparedStatement objSt = objConn.prepareStatement(query);
				    					    					    					    	
				    	//Ejecutamos la query que hemos preparado
				    	 objRs = objSt.executeQuery();
				    	 
				    } else {
				    	System.out.println("No existe conexion");
				    }
				    }catch (SQLException e) {
				        System.out.println("No se ha podido realizar la consulta: " + e);
				    }
				    		
				    	
			    
			    return objRs;
		}
		
		
		/**
		 * @author Ignacio Chapero
		 * 		   Alvaro Husillos
		 * 
		 *Este metodo se utiliza para recuperar todos los tipos de socios existentes en la base de datos
		 * 
		 * @return ArrayListitfProperty Devuelve un array list de itfProperty
		*/ 
		public ResultSet mostrarTipoSocio() 
		{
			ResultSet objRs = null;
			
				// Instancias la clase que hemos creado anteriormente
			    clsDatos SQL = new clsDatos();
			    
				// Llamas al m�todo que tiene la clase y te devuelve una conexi�n
			    Connection objConn = SQL.conectarBD();
			    
			   
				try { 
				    if ( objConn != null ) {
				    	
				    	// Preparamos la consulta 
				    	String query = SQL_SELECT_TIPO_SOCIO;
				    	
				    	//Creamos las preparedstaments
				    	PreparedStatement objSt = objConn.prepareStatement(query);
				    					    					    					    	
				    	//Ejecutamos la query que hemos preparado
				    	objRs = objSt.executeQuery();
				  		
				    	
				  						    	
				    } else {
				    	System.out.println("No existe conexi�n");
				    }
			    
			    } catch (SQLException e) {
			        System.out.println("No se ha podido realizar la consulta: " + e);
			    }
			    
			    return objRs;

		}
}
		

