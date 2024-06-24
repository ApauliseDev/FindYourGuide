package EstadosViaje;
import CLASES.Viaje;
import INTERFACES.EstadoViaje;

public class EstadoReservado implements EstadoViaje {
	
    public void manejarEstado(Viaje viaje) {
        System.out.println("El viaje está actualmente reservado.");
    }

    @Override
    public String obtenerEstado() {
        return "Reservado";
    }

}
