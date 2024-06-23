package CLASES;


import java.util.Date;

import INTERFACES.estadoReserva;
import ESTADOS.EstadoReservado; 
import CLASES.ServicioOfrecido;
public class Reserva {
    private static int idCounter = 0;
    private int idReserva;
    private estadoReserva estado;
    private Date fechaDelInicio;
    private Date fechaFin;
    private int montoDeAnticipo;
    private Guia guia;
    private Turista turista;
    private ServicioOfrecido servicio;
    

    public Reserva(ServicioOfrecido servicio,Date fechaDelInicio, Date fechaFin, int montoDeAnticipo,Guia guia, Turista turista) {
        this.idReserva = ++idCounter;
        this.servicio = servicio;
        this.estado = new EstadoReservado();;
        this.fechaDelInicio = fechaDelInicio;
        this.fechaFin = fechaFin;
        this.montoDeAnticipo = montoDeAnticipo;
        this.guia = guia;
        this.turista = turista;
    }
    
    public Guia getGuia() {
		return guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}

	public ServicioOfrecido getServicio() {
		return servicio;
	}

	public void setServicio(ServicioOfrecido servicio) {
		this.servicio = servicio;
	}

	public void setEstado(estadoReserva estado) {
        this.estado = estado;
    }
    
    public void manejarEstado() {
        estado.manejar(this);
    }

    public int getIdReserva() {
        return idReserva;
    }

    public estadoReserva getEstado() {
        return estado;
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

}
