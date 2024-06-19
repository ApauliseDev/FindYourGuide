package CLASES;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import CONTROLLERS.usuarioDTO;
import CONTROLLERS.TipoAutenticacion;
import CONTROLLERS.TipoUsuario;
import CONTROLLERS.UsuarioController;

public class Sistema {
	private static List<Usuario> usuarios;
	private static List<ServicioOfrecido> serviciosSistema;
	private static UsuarioController usuarioController;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.usuarioController = new UsuarioController();
    }
    
    
    public static void main(String[] args) {
    	
    	//Instancias iniciale del sistema Global
    	Sistema sistema = new Sistema();
    	Scanner Scanner = new Scanner(System.in);
    	
        ServicioOfrecido servicio1 = new ServicioOfrecido("Tour Individual", "Tour armado especialmente para vos");
        ServicioOfrecido servicio2 = new ServicioOfrecido("Traducciones", "Traduccion unicmanete en Italiano");
        ServicioOfrecido servicio3 = new ServicioOfrecido("Tour Grupal", "Tour para entre 3 a 8 personas");
     
        
        // Crear y registrar algunos usuarios
        usuarioDTO user1 = new usuarioDTO("Juan", "Perez", "M", 12345678, "juan@example.com", 123456789, TipoUsuario.TURISTA, TipoAutenticacion.Mail, "password123", null, null, null);
        usuarioDTO user2 = new usuarioDTO("Maria", "Gomez", "F", 87654321, "maria@example.com", 987654321, TipoUsuario.GUIA, TipoAutenticacion.Google, "password456", List.of("Madrid"), List.of("España"), List.of(new ServicioOfrecido("Tour Individual", "Tour personalizado")));

        UsuarioController.registrarUsuario(user1);
        UsuarioController.registrarUsuario(user2);
        
        
        while(true) {
        	
        	System.out.println("¡Bienvenido a FindYourGuide!");System.out.println("");System.out.println("");

        	System.out.println("1- Crear nueva cuenta");
        	System.out.println("2- Iniciar sesion");
        	System.out.println("3- Salir");
        	
        	int opcionAcceso = Scanner.nextInt();
        	
        	switch(opcionAcceso) 
        	{
     
        	case 1: //REGISTRO
                System.out.println("Por favor, seleccione su rol (1-Guia, 2-Turista): ");
                int tipoUsuarioInt = Scanner.nextInt();
                TipoUsuario rol = tipoUsuarioInt == 1 ? TipoUsuario.GUIA : TipoUsuario.TURISTA;

                System.out.println("Por favor, seleccione el modo de autenticación (1-Mail, 2-Apple-ID, 3-Google, 4-Facebook): ");
                int tipoAutenticacionInt = Scanner.nextInt();
                TipoAutenticacion autenticacion = TipoAutenticacion.values()[tipoAutenticacionInt - 1];

                System.out.println("Nombre:");
                String nombre = Scanner.next();
                System.out.println("Apellido:");
                String apellido = Scanner.next();
                System.out.println("Sexo: (M/F)");
                String sexo = Scanner.next();
                System.out.println("DNI:");
                int dni = Scanner.nextInt();
                System.out.println("Email:");
                String email = Scanner.next();
                System.out.println("Teléfono:");
                int telefono = Scanner.nextInt();
                System.out.println("Contraseña:");
                String contrasena = Scanner.next();

                List<String> ciudades = new ArrayList<>();
                List<String> paises = new ArrayList<>();
                List<ServicioOfrecido> servicios = new ArrayList<>();

                if (rol == TipoUsuario.GUIA) {
                    Scanner.nextLine(); // Consumir el salto de línea

                    System.out.println("Elije los países en los que ofrecerás tus servicios, coloca '0' para finalizar la carga.");
                    String pais;
                    while (!(pais = Scanner.nextLine()).equals("0")) {
                        paises.add(pais);
                    }

                    System.out.println("Elije las ciudades en las que ofrecerás tus servicios, coloca '0' para finalizar la carga.");
                    String ciudad;
                    while (!(ciudad = Scanner.nextLine()).equals("0")) {
                        ciudades.add(ciudad);
                    }

                    System.out.println("Elije los servicios predefinidos para ofrecer, coloca '0' para finalizar la carga.");
                    System.out.println("1-Tour Individual");
                    System.out.println("2-Traducciones");
                    System.out.println("3-Tour Grupal");

                    int res;
                    while ((res = Scanner.nextInt()) != 0) {
                        switch (res) {
                            case 1:
                                servicios.add(new ServicioOfrecido("Tour Individual", "Tour armado especialmente para vos"));
                                break;
                            case 2:
                                servicios.add(new ServicioOfrecido("Traducción", "Traducción únicamente en Italiano"));
                                break;
                            case 3:
                                servicios.add(new ServicioOfrecido("Tour Grupal", "Tour para entre 3 a 8 personas"));
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }
                }

                usuarioDTO uDTO = new usuarioDTO(nombre, apellido, sexo, dni, email, telefono,
                		rol, autenticacion, contrasena, ciudades, paises, servicios);

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
        		 usuarioController.imprimirUsuarios();
                 System.out.println("Saliendo del programa.");
                 Scanner.close();
                 	
                 return;
        		}
        	
        	
        		
        		
        		
        		
        	}
        	
        	
        	}    	
        
        
        
    
}
