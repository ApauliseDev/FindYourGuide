package CONTROLLERS;
import CONTROLLERS.usuarioDTO;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import CLASES.Guia;
import CLASES.ServicioOfrecido;
import CLASES.Usuario;
import CLASES.Turista;
import CLASES.Sistema;


public class UsuarioController {
	private List<Usuario> usuarios;
	
	public UsuarioController() {
        this.usuarios = new ArrayList<>();}
	
	
    public static Usuario registrarUsuario(usuarioDTO usuarioDTO) {
    	Usuario user;
    	if(usuarioDTO.getTipoCuenta() == TipoUsuario.GUIA) {
    		user = new Guia(usuarioDTO.getNombre(), usuarioDTO.getApellido(),usuarioDTO.getSexo() , usuarioDTO.getDni(), usuarioDTO.getEmail(), 
    				usuarioDTO.getTelefono(), usuarioDTO.getTipoCuenta(), usuarioDTO.getTipoAutenticacion(), usuarioDTO.getContraseña(), 
    				usuarioDTO.getCiudades(), usuarioDTO.getPaises(), usuarioDTO.getServiciosOfrecidos());
    		
    		
    	}
    	
    	user.guardar();
    		
    	/*
        if ("Turista".equalsIgnoreCase(usuarioDTO.getTipoCuenta())) {
        	System.out.println("Usuario Turista creado con Exito!");
            return new Turista(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getSexo(), usuarioDTO.getDni(), 
            		usuarioDTO.getEmail(), usuarioDTO.getTelefono(), usuarioDTO.getTipoCuenta(),
            		usuarioDTO.getTipoAutenticacion(), usuarioDTO.getContraseña()  );
        } else 
        	if ("Guia".equalsIgnoreCase(usuarioDTO.getTipoCuenta())) {
        			Scanner Scanner = new Scanner(System.in);
     	
  
     	int i = 1;
     	List<String> ciudades = new ArrayList<>();
     	List<String> paises = new ArrayList<>();
     	List<ServicioOfrecido> services = new ArrayList<>();
     	
     	System.out.println("Elije los paises  en los que ofreceras tu servicios, coloca '0' para finalizar la carga. ");
     	String pais = Scanner.nextLine();
    	while(i != 0 ) {
     		paises.add(pais);
     		pais = Scanner.nextLine();
     		if(pais.equals("0")) {
     			i = 0;
     		}}
    	
     	i = 1;
     	
       	System.out.println("Elije las ciudades en las que ofreceras tu servicios, coloca '0' para finalizar la carga. ");
       	String ciudad = Scanner.nextLine();
     	while(i != 0 ) {
     		ciudades.add(ciudad);
     		ciudad = Scanner.nextLine();
     		if(ciudad.equals("0")) {
     			i = 0;
     		}
     		
     	}
     	i= 1;
     	
     	System.out.println("Elije los servicios predefinidos para ofrecer:, coloca '0' para finalizar la carga. ");
     	System.out.println("1-Tour Individual");  
     	System.out.println("2-Traducciones");
     	System.out.println("3-Tour Grupal");
     	
     	int res = Scanner.nextInt();
     	while (i != 0) {
     			
     		if(res == 1) {
     			services.add(new ServicioOfrecido("Tour individual", "Tour armado especialmente para vos"));
     			}else if(res == 2){
     				services.add(new ServicioOfrecido("Traduccion", "Traduccion unicmanete en Italiano"));	
     			}
     			else {
     				services.add(new ServicioOfrecido("Tour Grupal", "Tour para entre 3 a 8 personas"));
     			}
     		
     		res = Scanner.nextInt();
     		if(res == 0) {
     			i = 0;
     		}

     	}
     	
     		System.out.println("Usuario Guia creado con Exito!");
            return new Guia(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getSexo(), usuarioDTO.getDni(), 
            		usuarioDTO.getEmail(), usuarioDTO.getTelefono(), usuarioDTO.getTipoCuenta(),
            		usuarioDTO.getTipoAutenticacion(), usuarioDTO.getContraseña(),ciudades,paises,services);
        } else {
            throw new IllegalArgumentException("Tipo de cuenta no válido");
        }
        */
    }
    
    
    //LOGICA FUNCION DE INICIO SESION
    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean verificarContraseña(Usuario usuario, String contrasena) {
        return usuario.verificarContraseña(contrasena);
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    

}
