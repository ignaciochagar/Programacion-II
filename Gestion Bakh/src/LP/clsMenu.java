package LP;

import java.util.ArrayList;

import COMUN.itfProperty;
import LN.clsGestor;



/**
 * @author Ignacio Chapero
 * 		   Alvaro Husillos
 * 
 * La clase menú se encarga de mostrar al usuario el menú con todas las funcionalidades de la aplicación.
 * Posteriormente, se encarga de recoger la opción introducida por el usuario, y aplicarle el método 
 * correspondiente. Este menú se mostrará indefinidamente hasta que el usuario decida salir de la
 * aplicación. Una vez elegida la opción, esta clase solicitará al usuario los datos necesarios para
 * realizar la operacion indicada.
 * Para ejecutar la funcionalidad, la clase menú utilizará un objeto y los métodos de la clsGestor.
 *
 */
public class clsMenu {
	
	public static void MenuPrincipal()
	{
		int op = 0;
		clsGestor objGestor = new clsGestor();
		
		System.out.println("Bienvenido a la aplicación Gestión del Bakh");
		
		//Con el bucle do-while mostramos el menu continuamente mientras el usuario no decida salir de la aplicacion
		do
		{
			System.out.println("");
			System.out.println("1.- Alta de socio");
			System.out.println("2.- Modificación datos de socio");
			System.out.println("3.- Consulta datos de socio");
			System.out.println("4.- Eliminación socio");
			System.out.println("5.- Alta de profesor");
			System.out.println("6.- Modificación datos de profesor");
			System.out.println("7.- Consulta datos de profesor");
			System.out.println("8.- Eliminación de profesor");
			System.out.println("9.- Reserva de actividad");
			System.out.println("10.- Consulta disponibilidad");
			System.out.println("11.- Anulación reserva");
			System.out.println("12.- SALIR");
			
			System.out.println("");
			System.out.println("Elija la opción deseada:");
			
			//Recogemos con el método leerEntero() de la clase utilidadesLP el int introducido por el usuario
			op = utilidadesLP.leerEntero();
			
			//Con el if nos aseguramos de que el número introducido esté entre 1 y 12, las opciones disponibles
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
				System.out.println("Introduzca una opción válida");
			}
		}while (op!= 12);
			
			}
	
	/**
	 * Este método se encarga de solicitar al usuario algún dato del profesor cuyos datos queremos eliminar, de tal
	 * forma que a través de un método de la clase clsGestor se pueda buscar ese profesor y eliminarlo.
	 * 
	 * @param objG
	 */
	private static void eliminarProfesor(clsGestor objGestor) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Este método se encarga de solicitar al usuario algún dato del profesor cuyos datos queremos consultar, de tal
	 * forma que a través de un método de la clase clsGestor se pueda acceder a los datos de dicho
	 * profesor. 
	 * 
	 * @param objG
	 */
	private static void consultarProfesor(clsGestor objGestor) {
		// TODO Auto-generated method stub
		
	}

/**
 * Este método se encarga de solicitar al usuario algún dato del profesor cuyos datos queremos modificar, de tal
 * forma que a través de un método de la clase clsGestor se pueda acceder a los datos de dicho
 * profesor y modificar el dato que desee el usuario.
 * 
 * @param objG
 */
private static void modificarProfesor(clsGestor objGestor) {
		// TODO Auto-generated method stub
		
	}
/**
 * Este método se encarga de recoger los datos recogidos por el usuario y pasárselos a un objeto de la 
 * clase clsGestor para que utilizando el método de la clase clsGestor se pueda crear un nuevo profesor.
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
		
		System.out.println("Introduzca la dirección:");
		String direccion = utilidadesLP.leerCadena();
		
		
		objG.CrearProfesor(nombre, apellido1, apellido2, dni, direccion);
	}

	
	/**
	 * Este método se encarga de recoger los datos recogidos por el usuario y pasárselos a un objeto de la 
	 * clase clsGestor para que utilizando el método de la clase clsGestor se pueda crear un nuevo socio.
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
		
		System.out.println("Introduzca la dirección :");
		String direccion = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el código postal:");
		String codigoPostal = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca la fecha de nacimiento(DD/MM/YYYY):");
		String fechaNacimiento = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el teléfono:");
		String telefono = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca la dirección de correo electrónico:");
		String email = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el IBAN de su cuenta bancaria:");
		String iban = utilidadesLP.leerCadena();
		
		objG.CrearSocio(nombre, apellido1, apellido2, dni, direccion, codigoPostal,
				fechaNacimiento, telefono, email, iban);
	}

	/**
	 * Este método se encarga de solicitar al usuario algún dato del socio cuyos datos queremos modificar, de tal
	 * forma que a través de un método de la clase clsGestor se pueda acceder a los datos de dicho
	 * socio y modificar el dato que desee el usuario.
	 * 
	 * @param objG
	 */
	private static void modificarSocio(clsGestor objG) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Este método se encarga de solicitar al usuario algún dato del socio cuyos datos queremos consultar, de tal
	 * forma que a través de un método de la clase clsGestor se pueda acceder a los datos de dicho
	 * socio. 
	 * 
	 * @param objG
	 */
	private static void consultarSocio(clsGestor objG) {
		
		ArrayList<itfProperty> usuarios;
		
		usuarios = objG.DameUsuarios();
		
		for(itfProperty p:usuarios)
		{
			System.out.println(p.getProperty("Nombre"));
			System.out.println(p.getProperty("Creditos"));
		}
	}

	
	/**
	 * Este método se encarga de solicitar al usuario algún dato del socio cuyos datos queremos eliminar, de tal
	 * forma que a través de un método de la clase clsGestor se pueda buscar ese socio y eliminarlo.
	 * 
	 * @param objG
	 */
	private static void eliminarSocio(clsGestor objG) {
		// TODO Auto-generated method stub
		
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


