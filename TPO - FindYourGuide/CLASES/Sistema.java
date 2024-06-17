package CLASES;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import CONTROLLERS.usuarioDTO;
import CONTROLLERS.UsuarioController;

public class Sistema {
	private List<Usuario> usuarios;
	private static List<ServicioOfrecido> serviciosSistema;

    public Sistema() {
        this.usuarios = new ArrayList<>();
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
        	
        	case 1: //REGISTRO
        			
        			System.out.println("Por favor, seleccione su rol (Guia/Turista): ");
        			String rol = Scanner.next();
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
        			
       
        			usuarioDTO uDTO = new usuarioDTO(rol,name,apellido,sexo,DNI,mail,telefono);
        			
        		Usuario nuevoUsuario = UsuarioController.registrarUsuario(uDTO);
        		}
        		
        		
        		
        		
        	}
        	
        	
        	}
        	
        //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        	
        
        
        
    
}
