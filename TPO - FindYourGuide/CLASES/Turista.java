package CLASES;

import java.util.ArrayList;
import java.util.List;
import CONTROLLERS.TipoUsuario;
import CONTROLLERS.TipoAutenticacion;
import CLASES.TrofeoTurista;
public class Turista extends Usuario {
    private List<Reserva> reservas;
    private TrofeoTurista trofeoTurista;

    public Turista(String nombre, String apellido, String sexo, int dni, String email, int telefono, TipoUsuario tipoCuenta, TipoAutenticacion tipoAutenticacion,
                   String contraseña) {
        super(nombre, apellido, sexo, dni, email, telefono, tipoCuenta, tipoAutenticacion, contraseña);
        this.reservas = new ArrayList<>();
        this.trofeoTurista = new TrofeoTurista(new Calificacion(this));
        
        
    }
    
    public void puntuarGuia(Guia guia, double calificacion) {
        guia.setCalificacion(calificacion);
        this.trofeoTurista.incrementarGuiasPuntuados();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
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
