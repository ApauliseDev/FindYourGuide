package CLASES;

import INTERFACES.IObserverTrofeo;
import CLASES.Calificacion;


public class TrofeoTurista implements IObserverTrofeo{
    private Calificacion calificacion;
    private int guiasPuntuados;
    
    
    
    public TrofeoTurista(Calificacion calificacion) {
        this.calificacion = calificacion;
        this.guiasPuntuados = 0;
        this.calificacion.agregarTrofeo(this);
    }
    
    public void incrementarGuiasPuntuados() {
        this.guiasPuntuados++;
        calificacion.setCalificacion(calificacion.getCalificacion()); // Para desencadenar la notificación
    }
    
    public void recibirTrofeo() {
        if (guiasPuntuados > 2) {
            System.out.println("¡Turista " + calificacion.getUsuario().getNombre() + " ha ganado el Trofeo a la reseña!");
        }
    }
    
    
    
    
    
    
    
    
    
    
	

}
