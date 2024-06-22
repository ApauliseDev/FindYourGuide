package CONTROLLERS;
import CONTROLLERS.usuarioDTO;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import CLASES.Guia;
import CLASES.ServicioOfrecido;
import CLASES.Usuario;
import CLASES.Turista;
import CLASES.Sistema;


public class UsuarioController {
	private static List<Usuario> usuarios = new ArrayList<>();;
	
	public UsuarioController() {}
	
	  public static List<Usuario> getUsuarios() {
	        return usuarios;
	    }
	
	
    public static void registrarUsuario(usuarioDTO usuarioDTO) {
    	
        // Verificar si el usuario ya existe
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(usuarioDTO.getEmail())) {
                System.out.println("Error: Ya existe un usuario con este email.");
            }
        }
    	
    	
    	Usuario user;
    	if(usuarioDTO.getTipoCuenta() == TipoUsuario.GUIA) {
    		user = new Guia(usuarioDTO.getNombre(), usuarioDTO.getApellido(),usuarioDTO.getSexo() , usuarioDTO.getDni(), usuarioDTO.getEmail(), 
    				usuarioDTO.getTelefono(), usuarioDTO.getTipoCuenta(), usuarioDTO.getTipoAutenticacion(), usuarioDTO.getContraseña(), 
    				usuarioDTO.getCiudades(), usuarioDTO.getPaises(), usuarioDTO.getServiciosOfrecidos(),usuarioDTO.getCredencial());
    	}else if (usuarioDTO.getTipoCuenta() == TipoUsuario.TURISTA) {
    		user = new Turista(usuarioDTO.getNombre(), usuarioDTO.getApellido(),usuarioDTO.getSexo() , usuarioDTO.getDni(), usuarioDTO.getEmail(), 
    				usuarioDTO.getTelefono(), usuarioDTO.getTipoCuenta(), usuarioDTO.getTipoAutenticacion(), usuarioDTO.getContraseña());
    	}else {
            throw new IllegalArgumentException("Tipo de cuenta no válido");
        }

    	user.guardar();
    	System.out.println("Usuario " + usuarioDTO.getTipoCuenta() + " creado con éxito!");
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
    
    // Método para imprimir la lista de usuarios con todos sus atributos
    public void imprimirUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
       }
    
    
    //FUNCIONES PARA BUSCAR GUIA POR NOMBRE, CIUDAD Y PAIS
    
    public List<Guia> buscarGuiasPorNombre(String nombre) {
    	 return usuarios.stream()
    	 .filter(u -> u instanceof Guia)
    	 .map(u -> (Guia) u)
    	 .filter(g -> g.getNombre().equalsIgnoreCase
    	(nombre))
    	 .collect(Collectors.toList());
    	 }
    
    public List<Guia> buscarGuiasPorCiudad(String ciudad) {
    	 return usuarios.stream()
    	 .filter(u -> u instanceof Guia)
    	 .map(u -> (Guia) u)
    	 .filter(g -> g.getCiudades().contains(ciudad))
    	 .collect(Collectors.toList());
    	 }
    
    public List<Guia> buscarGuiasPorPais(String pais) {
    	 return usuarios.stream()
    	 .filter(u -> u instanceof Guia)
    	 .map(u -> (Guia) u)
    	 .filter(g -> g.getPaises().contains(pais))
    	 .collect(Collectors.toList());
    	 }
    	


    

}
