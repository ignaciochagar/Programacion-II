package LP;

//Importamos todas las clases y todas las constantes que vamos a utilizar en la clsMenu
import java.util.ArrayList;

import COMUN.itfProperty;
import EXCEPCIONES.clsSocioRepetidoException;
import LN.clsGestor;
import LN.clsProfesor;
import LN.clsSocio;

//Constantes relacionadas con la clase clsSocio
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
import static COMUN.clsConstantes.PROPIEDAD_SOCIO_IDTIPO_SOCIO;

//Constantes relacionadas con la clase clsProfesor
import static COMUN.clsConstantes.PROPIEDAD_PROFESOR_NOMBRE;
import static COMUN.clsConstantes.PROPIEDAD_PROFESOR_APELLIDO1;
import static COMUN.clsConstantes.PROPIEDAD_PROFESOR_APELLIDO2;
import static COMUN.clsConstantes.PROPIEDAD_PROFESOR_DIRECCION;
import static COMUN.clsConstantes.PROPIEDAD_PROFESOR_DNI;

//Constantes relacionadas con la clase clsTipoSocio
import static COMUN.clsConstantes.PROPIEDAD_TIPO_SOCIO_ID;
import static COMUN.clsConstantes.PROPIEDAD_TIPO_SOCIO_NOMBRE;
import static COMUN.clsConstantes.PROPIEDAD_TIPO_SOCIO_DESCRIPCION;
import static COMUN.clsConstantes.PROPIEDAD_TIPO_SOCIO_CUOTA;

/**
 * @author Ignacio Chapero
 * 		   Alvaro Husillos
 * 
 * La clase menu se encarga de mostrar al usuario el menu con todas las funcionalidades de la aplicacion.
 * Posteriormente, se encarga de recoger la opcion introducida por el usuario, y aplicarle el metodo 
 * correspondiente. Este menu se mostrara indefinidamente hasta que el usuario decida salir de la
 * aplicacion. Una vez elegida la opcion, esta clase solicitara al usuario los datos necesarios para
 * realizar la operacion indicada.
 * Para ejecutar la funcionalidad, la clase menu utilizara un objeto y los metodos de la clsGestor.
 *
 */
public class clsMenu {
	
	public static void MenuPrincipal()
	{
		int op = 0;
		clsGestor objGestor = new clsGestor();

		
		System.out.println("Bienvenido a la aplicaciï¿½n Gestiï¿½n del Bakh");

		//
		System.out.println("Bienvenido a la aplicación Gestión del Bakh");

		
		//Con el bucle do-while mostramos el menu continuamente mientras el usuario no decida salir de la aplicacion
		do
		{
			System.out.println("");
			System.out.println("1.- Alta de socio");
			System.out.println("2.- Modificaciï¿½n datos de socio");
			System.out.println("3.- Consulta datos de socio");
			System.out.println("4.- Eliminaciï¿½n socio");
			System.out.println("5.- Alta de profesor");
			System.out.println("6.- Modificaciï¿½n datos de profesor");
			System.out.println("7.- Consulta datos de profesor");
			System.out.println("8.- Eliminaciï¿½n de profesor");
			System.out.println("9.- Reserva de actividad");
			System.out.println("10.- Consulta disponibilidad");
			System.out.println("11.- Anulaciï¿½n reserva");
			System.out.println("12.- SALIR");
			
			System.out.println("");
			System.out.println("Elija la opciï¿½n deseada:");
			
			//Recogemos con el metodo leerEntero() de la clase utilidadesLP el int introducido por el usuario
			op = utilidadesLP.leerEntero();
			
			//Con el if nos aseguramos de que el numero introducido este entre 1 y 12, las opciones disponibles
			if(op >= 1 & op <= 12)
			{
				switch (op) {
				
					case 1:
						insertarSocio();
						break;
						
					case 2:
						modificarSocio();
						break;
						
					case 3:
						consultarSocios();
						break;
						
					case 4:
						eliminarSocio();
					/**	
					case 5:
						insertarProfesor(objGestor);
						break;
						*/
						
					case 6:
						modificarProfesor();
						break;
						
					case 7:
						consultarProfesor();
						break;
						
					case 8:
						eliminarProfesor();
						break;
						
					case 9:
						reservar();
						break;
						
					case 10:
						consultarDisponibilidad();
						break;
						
					case 11:
						anularReserva();
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
				System.out.println("Introduzca una opciï¿½n vï¿½lida");
			}
		}while (op!= 12);
			
			}
	
	/**
	 * Este metodo se encarga de solicitar al usuario algï¿½n dato del profesor cuyos datos queremos eliminar, de tal
	 * forma que a traves de un metodo de la clase clsGestor se pueda buscar ese profesor y eliminarlo.
	 * 
	 * @param objG
	 */
	private static void eliminarProfesor() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Este metodo se encarga de solicitar al usuario algun dato del profesor cuyos datos queremos consultar, de tal
	 * forma que a traves de un metodo de la clase clsGestor se pueda acceder a los datos de dicho
	 * profesor. 
	 * 
	 * @param objG
	 */
	private static void consultarProfesor() 
	{
		ArrayList<itfProperty> profesores;
		
		clsGestor objG = new clsGestor();
		
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
 * Este metodo se encarga de solicitar al usuario algï¿½n dato del profesor cuyos datos queremos modificar, de tal
 * forma que a travï¿½s de un metodo de la clase clsGestor se pueda acceder a los datos de dicho
 * profesor y modificar el dato que desee el usuario.
 * 
 * @param objG
 */
private static void modificarProfesor() {
		// TODO Auto-generated method stub
		
	}
/**
 * Este metodo se encarga de recoger los datos recogidos por el usuario y pasarselos a un objeto de la 
 * clase clsGestor para que utilizando el metodo de la clase clsGestor se pueda crear un nuevo profesor.
 * 
 * @param objG
 
	private static void insertarProfesor(clsGestor objG) {
		
		System.out.println("Introduzca el nombre:");
		String nombre = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el primer apellido:");
		String apellido1 = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el segundo apellido:");
		String apellido2 = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el DNI:");
		String dni = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca la direcciï¿½n:");
		String direccion = utilidadesLP.leerCadena();
		
		
		objG.CrearProfesor(nombre, apellido1, apellido2, dni, direccion);
	}
*/

	
	private static void visualizarTipoSocio() {
	
		ArrayList<itfProperty> tipoSocio;
	
		clsGestor objG = new clsGestor();
		tipoSocio = objG.mostrarTipoSocio();
	
		for(itfProperty p:tipoSocio)
		{
		
			System.out.println(p.getProperty(PROPIEDAD_TIPO_SOCIO_ID) + " " + p.getProperty(PROPIEDAD_TIPO_SOCIO_NOMBRE) + " " +
					p.getProperty(PROPIEDAD_TIPO_SOCIO_CUOTA));
			
			System.out.println("---------------------------------------------------");

		}
	}
	


	/**
	 * Este metodo se encarga de recoger los datos recogidos por el usuario y pasarselos a un objeto de la 
	 * clase clsGestor para que utilizando el metodo de la clase clsGestor se pueda crear un nuevo socio.
	 * 
	 * @param objG
	 * @param  
	 */
	private static void insertarSocio() {
		
		clsGestor objG = new clsGestor();
		
		System.out.println("Introduzca el nombre:");
		String nombre = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el primer apellido:");
		String apellido1 = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el segundo apellido:");
		String apellido2 = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el DNI:");
		String dni = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca la direcciï¿½n :");
		String direccion = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el codigo postal:");
		String codigoPostal = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca la fecha de nacimiento(DD/MM/YYYY):");
		String fechaNacimiento = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el telefono:");
		String telefono = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca la direccion de correo electronico:");
		String email = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el IBAN de su cuenta bancaria:");
		String iban = utilidadesLP.leerCadena();
		
		System.out.println("Introduzca el tipo de socio segun la tabla adjuntada:");
		
		visualizarTipoSocio();
		
		int idtipo_socio = utilidadesLP.leerEntero();
		
		
		
		try {
			
			objG.CrearSocio(nombre, apellido1, apellido2, dni, direccion, codigoPostal,
					fechaNacimiento, telefono, email, iban, idtipo_socio);
		} catch (clsSocioRepetidoException e) {
			
			System.out.println(e.getMessage(dni));
		}
	}

	/**
	 * Este metodo se encarga de solicitar al usuario algun dato del socio cuyos datos queremos modificar, de tal
	 * forma que a traves de un metodo de la clase clsGestor se pueda acceder a los datos de dicho
	 * socio y modificar el dato que desee el usuario.
	 * 
	 * @param objG
	 */
	private static void modificarSocio() {
		
		clsGestor objG = new clsGestor();
		
		// Pedimos al usuario el dni del socio que quiere modificar
		System.out.println("Introduzca el dni del socio que quiere modificar:");
		String dni = utilidadesLP.leerCadena();
		
		itfProperty p = objG.mostrarUnSocio(dni);
		
		//Mostramos al usuario los datos del socio que quiere modificar
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
		System.out.println(p.getProperty(PROPIEDAD_SOCIO_IDTIPO_SOCIO));
		
		
		
	}
	
	/**
	 * Este metodo se encarga de mostrar todo el listado de socios que se encuentran actualmente en nuestra base de datos.
	 * 
	 * @param objG
	 */
	private static void consultarSocios() {
		
		ArrayList<itfProperty> socios;
		
		clsGestor objG = new clsGestor();
		
		socios = objG.descargaSocios();
		
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
			System.out.println(p.getProperty(PROPIEDAD_SOCIO_IDTIPO_SOCIO));
			System.out.println("************************");
			System.out.println("");
			
			
		}
		}
	
	
	/**
	 * Este metodo se encarga de mostrar la tabla con los tipos de socio existentes
	 * 
	 * @param objG
	 */
	
	
	/**
	 * Este metodo se encarga de solicitar al usuario algun dato del socio cuyos datos queremos eliminar, de tal
	 * forma que a traves de un metodo de la clase clsGestor se pueda buscar ese socio y eliminarlo.
	 * 
	 * @param objG
	 */
	private static void eliminarSocio()
	{
		
		
	}

	private static void reservar() {
		// TODO Auto-generated method stub
		
	}

	private static void consultarDisponibilidad() {
		// TODO Auto-generated method stub
		
	}

	private static void anularReserva() {
		// TODO Auto-generated method stub
		
	}
			
		
	
}




