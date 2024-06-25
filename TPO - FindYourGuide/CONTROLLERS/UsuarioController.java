package CONTROLLERS;
import CONTROLLERS.usuarioDTO;
import INTERFACES.SistemaAutenticacion;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import CLASES.Guia;
import CLASES.ServicioOfrecido;
import CLASES.Usuario;
import CLASES.Turista;
import CLASES.Sistema;
import CLASES.SistemaAutenticacionAppleID;
import CLASES.SistemaAutenticacionFacebook;
import CLASES.SistemaAutenticacionGoogle;
import CLASES.SistemaAutenticacionMail;


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
    
    public Guia buscarGuiaPorMail(String mail) {
        Optional<Guia> guiaEncontrado = usuarios.stream()
                .filter(u -> u instanceof Guia)
                .map(u -> (Guia) u)
                .filter(g -> g.getEmail().equals(mail)) // Filtrar por el correo electrónico
                .findFirst(); // Encontrar el primero que coincida

        return guiaEncontrado.orElse(null); // Devolver el Guia encontrado o null si no se encuentra
    }
    
    
    
    
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
    
    
    public boolean autenticarUsuario(usuarioDTO usuario) {
        SistemaAutenticacion sistemaAutenticacion;

        switch (usuario.getTipoAutenticacion()) {
            case Mail:
                sistemaAutenticacion = new SistemaAutenticacionMail();
                break;
            case AppleID:
                sistemaAutenticacion = new SistemaAutenticacionAppleID();
                break;
            case Google:
                sistemaAutenticacion = new SistemaAutenticacionGoogle();
                break;
            case Facebook:
                sistemaAutenticacion = new SistemaAutenticacionFacebook();
                break;
            default:
                throw new IllegalArgumentException("Tipo de autenticación no soportado: " + usuario.getTipoAutenticacion());
        }

        return sistemaAutenticacion.autenticar(usuario.getEmail(), usuario.getContraseña());
    }

	public Turista buscarTuristaPorEmail(String emailLogin) {
        Optional<Turista> turistaEncontrado = usuarios.stream()
                .filter(u -> u instanceof Turista)
                .map(u -> (Turista) u)
                .filter(g -> g.getEmail().equals(emailLogin)) // Filtrar por el correo electrónico
                .findFirst(); // Encontrar el primero que coincida

        return turistaEncontrado.orElse(null); // Devolver el Guia encontrado o null si no se encuentraub

	}
    

}
