package CLASES;
import INTERFACES.SistemaAutenticacion;

public class SistemaAutenticacionAppleID implements SistemaAutenticacion{
	 public boolean autenticar(String email, String contrasena) {
	        // Lógica simulada para autenticar por AppleID
	        System.out.println("Autenticado con AppleID: " + email);
	        return true;
	    }

}
