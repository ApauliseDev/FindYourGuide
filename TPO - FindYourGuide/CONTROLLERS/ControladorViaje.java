package CONTROLLERS;
import java.util.ArrayList;
import CLASES.Turista;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import EstadosViaje.EstadoCancelado;
import CLASES.Guia;
import CLASES.ServicioOfrecido;
import CLASES.Usuario;
import CLASES.Viaje;
import CLASES.Reserva;
public class ControladorViaje {
	
	private List<Viaje> viajes;

    public ControladorViaje() {
        this.viajes = new ArrayList<>();
        
   }

    public void registrarViaje(Reserva reserva) {
    	Viaje viaje = new Viaje(reserva);
        viajes.add(viaje);
        System.out.println("Viaje registrado con éxito basado en la reserva confirmada.");
    }
    
    
    public List<Viaje> listarViajesGuia(Guia guia) {   	
        List<Viaje> viajesGuia = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if (viaje.getGuiaAsociado().equals(guia)) {
            }
                viajesGuia.add(viaje);     
        }
        return viajesGuia;
    }

    public List<Viaje> obtenerViajesPorTurista(Turista turista) {
        List<Viaje> resultado = new ArrayList<>();
        if (!viajes.isEmpty()) {
        }
        for (Viaje viaje : viajes) {
            if (viaje.getReserva().getTurista().equals(turista)) {
                resultado.add(viaje);
            }
        }
        return resultado;
    }
    
    
    
    public Viaje buscarViajePorId(int idViaje) {
        for (Viaje viaje : viajes) {
            if (viaje.getIdViaje() == idViaje) {
                return viaje;
            }
        }
        return null;
    }

    public List<Viaje> obtenerTodosLosViajes() {
        return viajes;
    }

    public void cancelarViaje(Viaje viaje) {
    	  if (viaje.getFechaInicio().after(new Date())) {
            viaje.setEstado(new EstadoCancelado());
            System.out.println("El viaje ha sido cancelado.");
        } else {
            System.out.println("No se puede cancelar el viaje porque ya ha comenzado.");
        }
    }
    


}
