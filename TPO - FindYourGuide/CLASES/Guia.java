package CLASES;

import java.util.List;
import java.util.ArrayList;
import CONTROLLERS.TipoUsuario;
import CONTROLLERS.TipoAutenticacion;

public class Guia extends Usuario {
    private List<String> ciudades;
    private List<String> paises;
    private List<ServicioOfrecido> servicios;
    private Credencial credencial;
    private List<Reserva> reservas;

    public Guia(String nombre, String apellido, String sexo, int dni, String email, int telefono, TipoUsuario tipoCuenta, TipoAutenticacion tipoAutenticacion,
                String contraseña, List<String> ciudades, List<String> paises, List<ServicioOfrecido> servicios, Credencial credencial) {
        super(nombre, apellido, sexo, dni, email, telefono, tipoCuenta.GUIA, tipoAutenticacion, contraseña);
        this.ciudades = ciudades;
        this.paises = paises;
        this.servicios = servicios;
        this.credencial = credencial;
        this.reservas = new ArrayList<>();
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public List<String> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<String> ciudades) {
        this.ciudades = ciudades;
    }

    public List<String> getPaises() {
        return paises;
    }

    public void setPaises(List<String> paises) {
        this.paises = paises;
    }

    public List<ServicioOfrecido> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioOfrecido> servicios) {
        this.servicios = servicios;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public Reserva buscarReservaPorId(int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva() == idReserva) {
                return reserva;
            }
        }
        return null;
    }

    public void cancelarReserva(Reserva reserva) {
        reserva.setEstado("Cancelada");
        eliminarReserva(reserva);
    }

    @Override
    public void actualizarPerfil(String nombre, String email) {
        this.setNombre(nombre);
        this.setEmail(email);
        System.out.println("Perfil del guía actualizado. Nuevo nombre: " + this.getNombre() + ", Nuevo email: " + this.getEmail());
    }

    public void agregarServicio(ServicioOfrecido servicio) {
        servicios.add(servicio);
    }

    public void eliminarServicio(ServicioOfrecido servicio) {
        servicios.remove(servicio);
    }

    private String formatList(List<?> list) {
        return list.toString().replace("[", "").replace("]", "");
    }

    public String toString() {
        return super.toString() +
                ", Ciudades: " + ciudades +
                ", Países: " + paises +
                ", Servicios Ofrecidos: " + formatList(servicios);
    }
}
