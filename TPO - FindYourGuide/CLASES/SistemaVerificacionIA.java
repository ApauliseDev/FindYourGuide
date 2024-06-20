package CLASES;
import INTERFACES.SistemaVerificacion;
public class SistemaVerificacionIA implements SistemaVerificacion {

	@Override
	public boolean verificarCredencial(Credencial credencial) {
        if (credencial.getEmail() != null && !credencial.getEmail().isEmpty()) {
            System.out.println("La credencial con email " + credencial.getEmail() + " ha sido verificada con éxito.");
            return true;
        } else {
            System.out.println("La credencial no pudo ser verificada.");
            return false;
        }
    }
	}




