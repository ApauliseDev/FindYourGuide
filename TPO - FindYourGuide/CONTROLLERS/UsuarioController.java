package CONTROLLERS;
import CONTROLLERS.usuarioDTO;

import java.util.List;

import CLASES.Guia;
import CLASES.ServicioOfrecido;
import CLASES.Usuario;
import CLASES.Turista;
public class UsuarioController {
	
    public Usuario registrarUsuario(usuarioDTO usuarioDTO, String rol) {
        if ("Turista".equalsIgnoreCase(usuarioDTO.getTipoCuenta())) {
            return new Turista(usuarioDTO.getNombre(),usuarioDTO.getApellido(),usuarioDTO.getSexo(),usuarioDTO.getDni(),usuarioDTO.getEmail(),usuarioDTO.getTelefono()  );
        } else if ("Guía".equalsIgnoreCase(usuarioDTO.getTipoCuenta())) {
            return new Guia(usuarioDTO.getNombre(),usuarioDTO.getApellido(),usuarioDTO.getSexo(),usuarioDTO.getDni(),usuarioDTO.getEmail(), usuarioDTO.getTelefono());
        } else {
            throw new IllegalArgumentException("Tipo de cuenta no válido");
        }
    }

}
