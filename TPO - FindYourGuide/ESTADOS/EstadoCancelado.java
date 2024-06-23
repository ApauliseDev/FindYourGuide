package ESTADOS;

import CLASES.Reserva;
import INTERFACES.estadoReserva;

public class EstadoCancelado implements estadoReserva {
	   public void manejar(Reserva reserva) {
	        System.out.println("La reserva está en estado cancelado.");
	    }

}
