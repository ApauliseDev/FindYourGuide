package CONTROLLERS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import CLASES.Guia;
import CLASES.ServicioOfrecido;
import CLASES.Usuario;
import CLASES.Viaje;

public class ControladorViaje {
	
	private List<Viaje> viajes;

    public ControladorViaje() {
        this.viajes = new ArrayList<>();
        
        
        // Crear algunos viajes de ejemplo
        Viaje viaje1 = new Viaje(1, new ServicioOfrecido("Tour Individual", "Tour armado especialmente para vos", 100), "Paris", "Paris", "Francia", new Date(), new Guia("Juan", "Perez", "M", 0, null, 0, null, null, null, null, null, null, null), 1000);
        Viaje viaje2 = new Viaje(2, new ServicioOfrecido("Tour Grupal", "Tour para entre 3 a 8 personas", 250), "Roma", "Roma", "Italia", new Date(), new Guia("Maria", "Gomez", "F", 0, null, 0, null, null, null, null, null, null, null), 1500);
        Viaje viaje3 = new Viaje(3, new ServicioOfrecido("Traducciones", "Traducción únicamente en Italiano", 300), "Madrid", "Madrid", "España", new Date(), new Guia("Carlos", "Lopez", "M", 0, null, 0, null, null, null, null, null, null, null), 1200);

        // Registrar los viajes creados
        registrarViaje(viaje1);
        registrarViaje(viaje2);
        registrarViaje(viaje3);	
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
