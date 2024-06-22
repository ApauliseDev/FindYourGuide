package CLASES;

import java.util.Date;

public class Reserva {
    private static int idCounter = 0;
    private int idReserva;
    private String estado;
    private Date fechaDelInicio;
    private Date fechaFin;
    private int montoDeAnticipo;
    private Viaje viaje;

    public Reserva(Date fechaDelInicio, Date fechaFin, int montoDeAnticipo, Viaje viaje) {
        this.idReserva = ++idCounter;
        this.estado = "Activa";
        this.fechaDelInicio = fechaDelInicio;
        this.fechaFin = fechaFin;
        this.montoDeAnticipo = montoDeAnticipo;
        this.viaje = viaje;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaDelInicio() {
        return fechaDelInicio;
    }

    public void setFechaDelInicio(Date fechaDelInicio) {
        this.fechaDelInicio = fechaDelInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getMontoDeAnticipo() {
        return montoDeAnticipo;
    }

    public void setMontoDeAnticipo(int montoDeAnticipo) {
        this.montoDeAnticipo = montoDeAnticipo;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
}
