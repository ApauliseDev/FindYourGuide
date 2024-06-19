package CLASES;
import CONTROLLERS.TipoUsuario;
import CONTROLLERS.TipoAutenticacion;

public class Turista extends Usuario {
    public Turista(String nombre, String apellido, String sexo, int dni, String email, int telefono, TipoUsuario tipoCuenta, TipoAutenticacion tipoAutenticacion,
    		String contraseña) {
        super(nombre, apellido, sexo, dni, email, telefono, tipoCuenta, tipoAutenticacion, contraseña);
    }

    @Override
    public void actualizarPerfil(String nombre, String email) {
        this.setNombre(nombre);
        this.setEmail(email);
        System.out.println("Perfil del turista actualizado. Nuevo nombre: " + this.getNombre() + ", Nuevo email: " + this.getEmail());
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}