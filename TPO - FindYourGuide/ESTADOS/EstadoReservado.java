package ESTADOS;

import CLASES.Reserva;
import INTERFACES.estadoReserva;

public class EstadoReservado implements estadoReserva {
    public void manejar(Reserva reserva) {
        System.out.println("La reserva está en estado reservado.");
    }

}