package LP;

import java.util.ArrayList;
import COMUN.itfProperty;
import LN.clsGestor;
import LN.clsProfesor;
import LN.clsSocio;

import static COMUN.clsConstantes.PROPIEDAD_SOCIO_NOMBRE;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_APELLIDO1;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_APELLIDO2;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_DIRECCION;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_DNI;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_CODIGO_POSTAL;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_FECHA_NACIMIENTO;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_TELEFONO;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_EMAIL;
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_IBAN;
import static COMUN.clsConstantes.PROPIEDAD_PROFESOR_NOMBRE;
import static COMUN.clsConstantes.PROPIEDAD_PROFESOR_APELLIDO1;
import static COMUN.clsConstantes.PROPIEDAD_PROFESOR_APELLIDO2;
import static COMUN.clsConstantes.PROPIEDAD_PROFESOR_DIRECCION;
import static COMUN.clsConstantes.PROPIEDAD_PROFESOR_DNI;






/**
 * @author Ignacio Chapero
 * 		   Alvaro Husillos
 * 
 * La clase men� se encarga de mostrar al usuario el men� con todas las funcionalidades de la aplicaci�n.
 * Posteriormente, se encarga de recoger la opci�n introducida por el usuario, y aplicarle el m�todo 
 * correspondiente. Este men� se mostrar� indefinidamente hasta que el usuario decida salir de la
 * aplicaci�n. Una vez elegida la opci�n, esta clase solicitar� al usuario los datos necesarios para
 * realizar la operacion indicada.
 * Para ejecutar la funcionalidad, la clase men� utilizar� un objeto y los m�todos de la clsGestor.
 *
 */
public class clsMenu {
	
	public static void MenuPrincipal()
	{
		int op = 0;
		clsGestor objGestor = new clsGestor();
		
		System.out.println("Bienvenido a la aplicaci�n Gesti�n del Bakh");
		
		//Con el bucle do-while mostramos el menu continuamente mientras el usuario no decida salir de la aplicacion
		do
		{
			System.out.println("");
			System.out.println("1.- Alta de socio");
			System.out.println("2.- Modificaci�n datos de socio");
			System.out.println("3.- Consulta datos de socio");
			System.out.println("4.- Eliminaci�n socio");
			System.out.println("5.- Alta de profesor");
			System.out.println("6.- Modificaci�n datos de profesor");
			System.out.println("7.- Consulta datos de profesor");
			System.out.println("8.- Eliminaci�n de profesor");
			System.out.println("9.- Reserva de actividad");
			System.out.println("10.- Consulta disponibilidad");
			System.out.println("11.- Anulaci�n reserva");
			System.out.println("12.- SALIR");
			
			System.out.println("");
			System.out.println("Elija la opci�n deseada:");
			
			//Recogemos con el m�todo leerEntero() de la clase utilidadesLP el int introducido por el usuario
			op = utilidadesLP.leerEntero();
			
			//Con el if nos aseguramos de que el n�mero introducido est� entre 1 y 12, las opciones disponibles
			if(op >= 1 & op <= 12)
			{
				switch (op) {
				
					case 1:
						insertarSocio(objGestor);
						break;
						
					case 2:
						modificarSocio(objGestor);
						break;
						
					case 3:
						consultarSocio(objGestor);
						break;
						
					case 4:
						eliminarSocio(objGestor);
						
					case 5:
						insertarProfesor(objGestor);
						break;
						
					case 6:
						modificarProfesor(objGestor);
						break;
						
					case 7:
						consultarProfesor(objGestor);
						break;
						
					case 8:
						eliminarProfesor(objGestor);
						break;
						
					case 9:
						reservar(objGestor);
						break;
						
					case 10:
						consultarDisponibilidad(objGestor);
						break;
						
					case 11:
						anularReserva(objGestor);
						break;
						
					case 12:
						System.out.println("********************");
						System.out.println("FIN DE LA APLICACION");
						System.out.println("Vuelve cuando quieras");
						System.out.println("*********************");
						break;
						
				}
			}else
			{
				System.out.println("Introduzca una opci�n v�lida");
			}
		}while (op!= 12);
			
			}
	
	/**
	 * Este m�todo se encarga de solicitar al usuario alg�n dato del profesor cuyos datos queremos eliminar, de tal
	 * forma que a trav�s de un m�todo de la clase clsGestor se pueda buscar ese profesor y eliminarlo.
	 * 
	 * @param objG
	 */
	private static void eliminarProfesor(clsGestor objG) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Este m�todo se encarga de solicitar al usuario alg�n dato del profesor cuyos datos queremos consultar, de tal
	 * forma que a trav�s de un m�todo de la clase clsGestor se pueda acceder a los datos de dicho
	 * profesor. 
	 * 
	 * @param objG
	 */
	private static void consultarProfesor(clsGestor objG) 
	{
		ArrayList<itfProperty> profesores;
		
		profesores = objG.DameProfesores();
		
		for(itfProperty p:profesores)
		{
			
			
			System.out.println(p.getProperty(PROPIEDAD_PROFESOR_NOMBRE));
			System.out.println(p.getProperty(PROPIEDAD_PROFESOR_APELLIDO1));
			System.out.println(p.getProperty(PROPIEDAD_PROFESOR_APELLIDO2));
			System.out.println(p.getProperty(PROPIEDAD_PROFESOR_DIRECCION));
			System.out.println(p.getProperty(PROPIEDAD_PROFESOR_DNI));
			
			
			
		
		}
		
	}

/**
 * Este m�todo se encarga de solicitar al usuario alg�n dato del profesor cuyos datos queremos modificar, de tal
 * forma que a trav�s de un m�todo de la clase clsGestor se pueda acceder a los datos de dicho
 * profesor y modificar el dato que desee el usuario.
 * 
 * @param objG
 */
private static void modificarProfesor(clsGestor objGestor) {
		// TODO Auto-generated method stub
		
	}
/**
 * Este m�todo se encarga de recoger los datos recogidos por el usuario y pas�rselos a un objeto de la 
 * clase clsGestor para que utilizando el m�todo de la clase clsGestor se pueda crear un nuevo profesor.
 * 
 * @param objG
 */
	private static void insertarProfesor(clsGestor objG) {
		
		System.out.println("Introduzca el nombre:");
		String nombre = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el primer apellido:");
		String apellido1 = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el segundo apellido:");
		String apellido2 = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el DNI:");
		String dni = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca la direcci�n:");
		String direccion = utilidadesLP.leerCadena();
		
		
		objG.CrearProfesor(nombre, apellido1, apellido2, dni, direccion);
	}

	
	/**
	 * Este m�todo se encarga de recoger los datos recogidos por el usuario y pas�rselos a un objeto de la 
	 * clase clsGestor para que utilizando el m�todo de la clase clsGestor se pueda crear un nuevo socio.
	 * 
	 * @param objG
	 */
	private static void insertarSocio(clsGestor objG) {
		
		System.out.println("Introduzca el nombre:");
		String nombre = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el primer apellido:");
		String apellido1 = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el segundo apellido:");
		String apellido2 = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el DNI:");
		String dni = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca la direcci�n :");
		String direccion = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el c�digo postal:");
		String codigoPostal = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca la fecha de nacimiento(DD/MM/YYYY):");
		String fechaNacimiento = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el tel�fono:");
		String telefono = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca la direcci�n de correo electr�nico:");
		String email = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el IBAN de su cuenta bancaria:");
		String iban = utilidadesLP.leerCadena();
		
		objG.CrearSocio(nombre, apellido1, apellido2, dni, direccion, codigoPostal,
				fechaNacimiento, telefono, email, iban);
	}

	/**
	 * Este m�todo se encarga de solicitar al usuario alg�n dato del socio cuyos datos queremos modificar, de tal
	 * forma que a trav�s de un m�todo de la clase clsGestor se pueda acceder a los datos de dicho
	 * socio y modificar el dato que desee el usuario.
	 * 
	 * @param objG
	 */
	private static void modificarSocio(clsGestor objG) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Este m�todo se encarga de solicitar al usuario alg�n dato del socio cuyos datos queremos consultar, de tal
	 * forma que a trav�s de un m�todo de la clase clsGestor se pueda acceder a los datos de dicho
	 * socio. 
	 * 
	 * @param objG
	 */
	private static void consultarSocio(clsGestor objG) {
		
		ArrayList<itfProperty> socios;
		
		socios = objG.DameSocios();
		
		for(itfProperty p:socios)
		{
			
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_NOMBRE));
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_APELLIDO1));
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_APELLIDO2));
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_DIRECCION));
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_DNI));
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_CODIGO_POSTAL));
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_FECHA_NACIMIENTO));
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_TELEFONO));
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_EMAIL));
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_IBAN));
			
			
		}
		}
	

	
	/**
	 * Este m�todo se encarga de solicitar al usuario alg�n dato del socio cuyos datos queremos eliminar, de tal
	 * forma que a trav�s de un m�todo de la clase clsGestor se pueda buscar ese socio y eliminarlo.
	 * 
	 * @param objG
	 */
	private static void eliminarSocio(clsGestor objG)
	{
		
		
	}

	private static void reservar(clsGestor objG) {
		// TODO Auto-generated method stub
		
	}

	private static void consultarDisponibilidad(clsGestor objG) {
		// TODO Auto-generated method stub
		
	}

	private static void anularReserva(clsGestor objG) {
		// TODO Auto-generated method stub
		
	}
			
		
	}


