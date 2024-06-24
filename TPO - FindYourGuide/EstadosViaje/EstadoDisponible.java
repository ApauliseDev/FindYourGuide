package EstadosViaje;
import CLASES.Viaje;
import INTERFACES.EstadoViaje;

public class EstadoDisponible implements EstadoViaje {
    public void manejarEstado(Viaje viaje) {
        System.out.println("El viaje está disponible y en curso.");
    }

    @Override
    public String obtenerEstado() {
        return "Disponible";
    }

}
