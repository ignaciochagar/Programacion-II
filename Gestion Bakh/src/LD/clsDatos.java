package LD;

import java.sql.*;

import static LD.clsConstantesDB.SQL_INSERT_SOCIO;
import static LD.clsConstantesDB.SQL_INSERT_PROFESOR;


public class clsDatos 
{
			
		//Nombre de la base de datos	
		public String database="alumnoBD";
		
		//host
		public String hostname="localhost";
		
		//puerto
		public String port="3306";
		
		//Ruta de la base de datos (jdbc:mysql://localhost:3306/alumnoBD?useTimezone=true&serverTimezone=GMT&useSSL=false)
		public String url="jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=GMT&useSSL=false";
		
		//Nombre de usuario
		public String user="root";
		
		//Password
		public String password="";
		
		
		/**
		 * Este m�todo sirve para realizar una conexi�n con la base de datos que le indiquemos a trav�s de
		 * la url, el user y el password. Para ello crea un objeto de la clase Connection ya implementada en
		 * el n�cleo de java.
		 * 
		 * @return: devuelve una conexi�n, es decir, un objeto de la clase Connection.
		 */
		public Connection conectarBD()
		{
			
	        Connection objConn = null;

	        try { 
	        	
	        	objConn = DriverManager.getConnection (url, user, password);
	        
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
		 *Este m�todo se utiliza para insertar los datos de un nuevo socio en la base de datos.Para ello 
		 *primero comprueba que existe conexi�n con la BD y si la conexi�n es correcta, entonces inserta los
		 *datos del nuevo socio.
		 *
		 *No tiene ning�n retorno.
		 */
			
		public void insertarSocio(String nombre, String apellido1, String apellido2, String dni, String direccion,
				String codigo_postal, String fecha_nacimiento, String telefono, String email, String iban) 
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
				    	objSt.setString(4, direccion);
				    	objSt.setString(4, codigo_postal);
				    	objSt.setString(4, fecha_nacimiento);
				    	objSt.setString(4, telefono);
				    	objSt.setString(4, email);
				    	objSt.setString(4, iban);
				    	
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
		 *Este m�todo se utiliza para insertar los datos de un nuevo profesor en la base de datos.Para ello 
		 *primero comprueba que existe conexi�n con la BD y si la conexi�n es correcta, entonces inserta los
		 *datos del nuevo profesor.
		 *
		 *No tiene ning�n retorno.
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
	

}

