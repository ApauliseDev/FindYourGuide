package CONTROLLERS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
        if(viajes.isEmpty()) {
        	System.out.println("F23EGQ2HGBQAHB");
        }
        System.out.println("Viaje registrado con éxito basado en la reserva confirmada.");
    }
    
    
    public List<Viaje> listarViajesGuia(Guia guia) {
        List<Viaje> viajesGuia = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if (viaje.getGuiaAsociado().equals(guia)) {
                viajesGuia.add(viaje);
            }
        }
        return viajesGuia;
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
        viajes.remove(viaje);
    }

	public Collection<Usuario> getViajes() {
		// TODO Auto-generated method stub
		return null;
	}

}
