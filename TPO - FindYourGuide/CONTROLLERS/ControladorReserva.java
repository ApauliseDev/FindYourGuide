package CONTROLLERS;
import java.util.ArrayList;
import java.util.List;

import CLASES.Reserva;

public class ControladorReserva {
	
	private List<Reserva> reservas;

    public ControladorReserva() {
        this.reservas = new ArrayList<>();
    }

    public void registrarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public Reserva buscarReservaPorId(int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva() == idReserva) {
                return reserva;
            }
        }
        return null;
    }

    public List<Reserva> obtenerTodasLasReservas() {
        return reservas;
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

}
