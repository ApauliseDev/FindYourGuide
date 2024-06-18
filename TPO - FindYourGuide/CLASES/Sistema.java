package CLASES;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import CONTROLLERS.usuarioDTO;
import CONTROLLERS.TipoUsuario;
import CONTROLLERS.UsuarioController;

public class Sistema {
	private List<Usuario> usuarios;
	private static List<ServicioOfrecido> serviciosSistema;
	private UsuarioController usuarioController;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.usuarioController = new UsuarioController();
    }
    
    public void actualizarPerfil(String tipoUsuario, String nombre, String email) {
        for (Usuario usuario : usuarios) {
            if ((usuario instanceof Guia && tipoUsuario.equalsIgnoreCase("Guia")) ||
                (usuario instanceof Turista && tipoUsuario.equalsIgnoreCase("Turista"))) {
                usuario.actualizarPerfil(nombre, email);
                return;
            }
        }
        System.out.println("Usuario no encontrado o tipo de usuario incorrecto.");
    }
    
    
    public static void main(String[] args) {
    	
    	//Instancias iniciale del sistema Global
    	Sistema sistema = new Sistema();
    	Scanner Scanner = new Scanner(System.in);
    	
        ServicioOfrecido servicio1 = new ServicioOfrecido("Tour Individual", "Tour armado especialmente para vos");
        ServicioOfrecido servicio2 = new ServicioOfrecido("Traducciones", "Traduccion unicmanete en Italiano");
        ServicioOfrecido servicio3 = new ServicioOfrecido("Tour Grupal", "Tour para entre 3 a 8 personas");
     
        
        
        while(true) {
        	
        	System.out.println("¡Bienvenido a FindYourGuide!");System.out.println("");System.out.println("");

        	System.out.println("1- Crear nueva cuenta");
        	System.out.println("2- Iniciar sesion");
        	
        	int opcionAcceso = Scanner.nextInt();
        	
        	switch(opcionAcceso) {
        	
        	System.out.println("Por favor, seleccione su rol (Guia/Turista): ");
			TipoUsuario rol = Scanner.next();
			
			
			if(rol == TipoUsuario.GUIA) {
				
			}
        	
        	case 1: //REGISTRO
        			System.out.print("Por favor, seleccione el modo de autenticacion (Mail/Apple-ID/Google/Facebook): ");
        			String autenticacion = Scanner.next();
        			
        			System.out.println("======================================================" );
        			System.out.println("Usted esta creando una cuenta de " + rol + " con: " + autenticacion + "\n");
        			System.out.println("Nombre:");
        			String name = Scanner.next();
        			System.out.println("Apellido:");
        			String apellido = Scanner.next();
        			System.out.println("Sexo: (M/F)");
        			String sexo = Scanner.next();
        			System.out.println("DNI:");
        			int DNI = Scanner.nextInt();
        			System.out.println("Email:");
        			//Verificacion para ver si el mail ya existe
        			String mail = Scanner.next();
        			System.out.println("Telefono:");
        			int telefono = Scanner.nextInt();
        			System.out.println("Contraseña:");
        			String contraseña = Scanner.next();
        			
       
        			usuarioDTO uDTO = new usuarioDTO(name,apellido,sexo,DNI,mail,telefono,rol,autenticacion,contraseña);
        			
        		Usuario nuevoUsuario = UsuarioController.registrarUsuario(uDTO);
        		//VALIDACION DE QUE NO SE REPITA EL USUARIO
        		if (nuevoUsuario != null) {
                    System.out.println("Cuenta creada exitosamente.");
                } else {
                    System.out.println("Error al crear la cuenta.");
                }
                break;
        		
        	case 2: //INICIO SESION
        		System.out.println("Email:");
                String emailLogin = Scanner.next();
                Usuario usuario = sistema.usuarioController.buscarUsuarioPorEmail(emailLogin);

                if (usuario != null) {
                    System.out.println("Contraseña:");
                    String contraseñaLogin = Scanner.next();

                    if (sistema.usuarioController.verificarContraseña(usuario, contraseñaLogin)) {
                        System.out.println("Inicio de sesión exitoso. Bienvenido " + usuario.getNombre());
                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }
                } else {
                    System.out.println("Email no encontrado.");
                }
                break;
        		
        		
        		
        	 case 3: // SALIR
                 System.out.println("Saliendo del programa.");
                 Scanner.close();
                 return;
                 
        		}
        	
        	
        		
        		
        		
        		
        	}
        	
        	
        	}
        	
        //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        	
        
        
        
    
}
