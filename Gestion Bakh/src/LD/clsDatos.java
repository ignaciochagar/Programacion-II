package LD;

import java.sql.*;

import COMUN.itfProperty;

import static LD.clsConstantesDB.SQL_INSERT_ALUMNO;



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
		 * Este método sirve para realizar una conexión con la base de datos que le indiquemos a través de
		 * la url, el user y el password. Para ello crea un objeto de la clase Connection ya implementada en
		 * el núcleo de java.
		 * 
		 * @return: devuelve una conexión, es decir, un objeto de la clase Connection.
		 */
		public Connection conectarBD()
		{
			
	        Connection objConn = null;

	        try { 
	        	
	        	objConn = DriverManager.getConnection (url, user, password);
	        
	        } catch (SQLException e) {
	            System.out.println("Ha fallado la conexión" + e);
	        }

	        return objConn;

		}	
		
		public void desconectarBD(Connection conexion) 
		{
			
	        try { 
	        	
	        	conexion.close();
	        	
	        } catch (SQLException e) {
	            System.out.println("Ha fallado la desconexión");
	        }

		}
		/**
		 * @author Ignacio Chapero
		 * 		   Alvaro Husillos
		 * 
		 *Este método se utiliza para insertar los datos de un nuevo socio en la base de datos.Para ello 
		 *primero comprueba que existe conexión con la BD y si la conexión es correcta, entonces inserta los
		 *datos del nuevo socio.
		 *
		 *No tiene ningún retorno.
		 */
			
		public void insertarSocio(itfProperty socios) 
		{
				
				// Instancias la clase que hemos creado anteriormente
			    clsDatos SQL = new clsDatos();
			    
				// Llamas al método que tiene la clase y te devuelve una conexión
			    Connection objConn = SQL.conectarBD();
			    
			    try { 
				    if ( objConn != null ) {
				    	// Preparamos la insert 
				    	String query = "insert into socio (get, nombre, apellido, dni) values (?, ?, ?, ?)";
				    	
				    	//Creamos las preparedstaments
				    	PreparedStatement objSt = objConn.prepareStatement(query);
				    	objSt.setInt(1, id);
				    	objSt.setString(2, nombre);
				    	objSt.setString(3, apellido);
				    	objSt.setString(4, dni);
				    	
				    	//Ejecutamos la query que hemos preparado
				  		objSt.execute();
				    	
				    	System.out.println("Se ha insertado el registro correctamente");
				    	
				    	//Cerramos el preparedStatement
				    	objSt.close();
				    	
				    	//Cerramos la conexión
				    	objConn.close();
				    	
				    } else {
				    	System.out.println("No existe conexión");
				    }
			    
			    } catch (SQLException e) {
			        System.out.println("No se ha podido realizar el insert: " + e);
			    }
			}
	

}

