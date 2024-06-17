package CLASES;

import java.util.Date;

public class Reserva {
	
	private String Estado;
	private Date FechaDeInicio;
	private Date FechaFin;
	private int MontoDeAnticipo;
	private Viaje Viaje;
	
	
	
	public Reserva(String estado, Date fechaDeInicio, Date fechaFin, int montoDeAnticipo, CLASES.Viaje viaje) {
		super();
		Estado = estado;
		FechaDeInicio = fechaDeInicio;
		FechaFin = fechaFin;
		MontoDeAnticipo = montoDeAnticipo;
		Viaje = viaje;
	}



	public String getEstado() {
		return Estado;
	}



	public void setEstado(String estado) {
		this.Estado = estado;
	}



	public Date getFechaDeInicio() {
		return FechaDeInicio;
	}



	public void setFechaDeInicio(Date fechaDeInicio) {
		this.FechaDeInicio = fechaDeInicio;
	}



	public Date getFechaFin() {
		return FechaFin;
	}



	public void setFechaFin(Date fechaFin) {
		this.FechaFin = fechaFin;
	}



	public int getMontoDeAnticipo() {
		return MontoDeAnticipo;
	}



	public void setMontoDeAnticipo(int montoDeAnticipo) {
		this.MontoDeAnticipo = montoDeAnticipo;
	}



	public Viaje getViaje() {
		return Viaje;
	}



	public void setViaje(Viaje viaje) {
		this.Viaje = viaje;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
