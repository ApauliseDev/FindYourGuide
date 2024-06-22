package CLASES;
import INTERFACES.SistemaAutenticacion;

public class SistemaAutenticacionFacebook implements SistemaAutenticacion {
	public boolean autenticar(String email, String contrasena) {
        // Lógica simulada para autenticar por Facebook
        System.out.println("Autenticado con Facebook: " + email);
        return true;
    }

}
