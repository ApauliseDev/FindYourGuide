package CONTROLLERS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import CLASES.Usuario;
import CLASES.Viaje;

public class ControladorViaje {
	
	private List<Viaje> viajes;

    public ControladorViaje() {
        this.viajes = new ArrayList<>();
    }

    public void registrarViaje(Viaje viaje) {
        viajes.add(viaje);
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
