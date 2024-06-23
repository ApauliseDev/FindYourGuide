package CONTROLLERS;
import java.util.ArrayList;
import java.util.Date;
import CLASES.Guia;
import CLASES.Turista;
import ESTADOS.EstadoCancelado;
import ESTADOS.EstadoConfirmado;
import ESTADOS.EstadoReservado;
import CONTROLLERS.ControladorViaje;
import java.util.List;
import CLASES.Reserva;
import CLASES.ServicioOfrecido;
import CLASES.Reserva;

public class ControladorReserva {
	
	 private ControladorViaje viajeController = new ControladorViaje();
	private List<Reserva> reservas;

    public ControladorReserva() {
        this.reservas = new ArrayList<>();
    }

    public void crearReserva(ServicioOfrecido servicio,Date fechaInicio,Date fechaFin,int montoAnticipo,Guia guia,Turista turista) {
    	
    	Reserva reserva = new Reserva(servicio,fechaInicio, fechaFin, montoAnticipo, guia, turista);
        reservas.add(reserva);
        guia.getReservas().add(reserva);
        turista.getReservas().add(reserva);
        
        System.out.println("Reserva creada correctamente. Notificando al guía: " + guia.getNombre());
        
        reserva.setEstado(new EstadoReservado());
        
        reserva.manejarEstado();
        
    }
    
    public void aceptarReserva(Reserva reserva) {
        reserva.setEstado(new EstadoConfirmado());
        System.out.println("Reserva aceptada por el guía. Estado cambiado a 'Confirmado'.");
        reserva.manejarEstado();
        
        viajeController.registrarViaje(reserva);
    }
    
    public void cancelarReserva(Reserva reserva) {
        reserva.setEstado(new EstadoCancelado());
        System.out.println("Reserva cancelada por el guía. Estado cambiado a 'Cancelado'.");
        reserva.manejarEstado();
    }
    
    
    public List<Reserva> listarReservasGuia(Guia guia) {
        return guia.getReservas();
    }
    public List<Reserva> listarReservasTurista(Turista turista) {
        return turista.getReservas();
    }
   
   

    public Reserva buscarReservaPorId(int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva() == idReserva) {
                return reserva;
            }
        }
        return null;
    }

    public List<Reserva> obtenerTodasLasReservas() {
        return reservas;
    }

 

}
