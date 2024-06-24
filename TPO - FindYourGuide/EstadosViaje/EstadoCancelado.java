package EstadosViaje;
import CLASES.Viaje;
import INTERFACES.EstadoViaje;

public class EstadoCancelado implements EstadoViaje  {
    @Override
    public void manejarEstado(Viaje viaje) {
        System.out.println("El viaje ha sido cancelado.");
    }

    @Override
    public String obtenerEstado() {
        return "Cancelado";
    }
	

}
