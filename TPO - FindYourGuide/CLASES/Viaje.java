package CLASES;

import java.util.Date;

public class Viaje {
    private int idViaje;
    private ServicioOfrecido servicioOfrecido;
    private String destino;
    private String ciudad;
    private String pais;
    private Date fechaInicio;
    private Guia guiaAsociado;
    private int montoTotal;
    private Reserva reserva;
    private String estado;

    public Viaje(int idViaje, ServicioOfrecido servicioOfrecido, String destino, String ciudad, String pais, Date fechaInicio, Guia guiaAsociado, int montoTotal) {
        this.idViaje = idViaje;
        this.servicioOfrecido = servicioOfrecido;
        this.destino = destino;
        this.ciudad = ciudad;
        this.pais = pais;
        this.fechaInicio = fechaInicio;
        this.guiaAsociado = guiaAsociado;
        this.montoTotal = montoTotal;
        this.estado = "DISPONIBLE";
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public ServicioOfrecido getServicioOfrecido() {
        return servicioOfrecido;
    }

    public void setServicioOfrecido(ServicioOfrecido servicioOfrecido) {
        this.servicioOfrecido = servicioOfrecido;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Guia getGuiaAsociado() {
        return guiaAsociado;
    }

    public void setGuiaAsociado(Guia guiaAsociado) {
        this.guiaAsociado = guiaAsociado;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void reservar() {
        this.estado = "RESERVADO";
    }

    public void cancelarReserva() {
        this.estado = "DISPONIBLE";
    }
}
