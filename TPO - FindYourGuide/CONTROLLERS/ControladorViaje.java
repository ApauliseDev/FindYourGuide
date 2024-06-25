package CONTROLLERS;
import java.util.ArrayList;
import CLASES.Turista;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
    
    public void finalizarViaje(Viaje viaje) {
        viajes.remove(viaje);
        System.out.println("El viaje ha sido finalizado y eliminado de la lista.");
    }
    
    
    public void finalizarViajes(Scanner scanner, Guia guia) {
        List<Viaje> viajesGuia = this.listarViajesGuia(guia);  // Asumimos que listarViajesGuia es un método de esta clase
        if (viajesGuia.isEmpty()) {
            System.out.println("No tienes viajes programados.");
            return;
        }

        int index = 0;
        while (index < viajesGuia.size()) {
            Viaje viaje = viajesGuia.get(index);
            System.out.println("Viaje " + (index + 1) + ":");
            System.out.println("Fecha: " + viaje.getFechaInicio());
            System.out.println("Monto Total: " + viaje.getMontoTotal());
            System.out.println("Turista: " + viaje.getReserva().getTurista().getNombre());
            System.out.println("Servicio a brindar: " + viaje.getReserva().getServicio().getTipo());
            System.out.println("-----------------------------------------------------");

            System.out.println("¿Deseas finalizar este viaje? (1-Sí, 2-No):");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                this.finalizarViaje(viaje);  // Asumimos que finalizarViaje es un método de esta clase
                System.out.println("Viaje finalizado exitosamente.");
                viajesGuia.remove(index);  // Eliminamos el viaje de la lista para no volver a mostrarlo
            } else {
                index++;  // Pasamos al siguiente viaje
            }

            if (index >= viajesGuia.size()) {
                System.out.println("No tienes más viajes programados.");
            }
        }
    }
    


}
