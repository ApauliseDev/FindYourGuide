package CLASES;
import INTERFACES.SistemaAutenticacion;

public class SistemaAutenticacionGoogle implements SistemaAutenticacion {
	 public boolean autenticar(String email, String contrasena) {
	        // Lógica simulada para autenticar por Google
	        System.out.println("Autenticado con Google: " + email);
	        return true;
	    }
	

}
