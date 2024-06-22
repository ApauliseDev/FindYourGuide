package CLASES;
import INTERFACES.SistemaAutenticacion;

public class SistemaAutenticacionMail implements SistemaAutenticacion{
	
	public boolean autenticar(String email, String contrasena) {
        // Lógica simulada para autenticar por Mail
        System.out.println("Autenticado con Mail: " + email);
        return true;
    }

}
