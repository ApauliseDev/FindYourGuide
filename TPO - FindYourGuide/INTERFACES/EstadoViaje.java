package INTERFACES;

import CLASES.Viaje;
public interface EstadoViaje {
    void manejarEstado(Viaje viaje);
    String obtenerEstado();
}
