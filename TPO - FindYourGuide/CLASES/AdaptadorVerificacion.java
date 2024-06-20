package CLASES;
import INTERFACES.SistemaVerificacion;


public class AdaptadorVerificacion {
	private SistemaVerificacion sistemaVerificacion;
	
	
    public AdaptadorVerificacion(SistemaVerificacion sistemaVerificacion) {
        this.sistemaVerificacion = sistemaVerificacion;
    }
    
    
    public boolean verificar(Credencial credencial) {
        return sistemaVerificacion.verificarCredencial(credencial);
    }
    
    
    
    
	
	
	

}
