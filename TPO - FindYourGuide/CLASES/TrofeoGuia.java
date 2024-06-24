package CLASES;
import INTERFACES.IObserverTrofeo;
import CLASES.Calificacion;

public class TrofeoGuia implements IObserverTrofeo {
	private Calificacion calificacion;
	
	
	
	  public Calificacion getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}


	public TrofeoGuia(Calificacion calificacion) {
	        this.calificacion = calificacion;
	        this.calificacion.agregarTrofeo(this);
	    }

	  
	    public void recibirTrofeo() {
	        if (calificacion.getCalificacion() >= 4.5) {
	            System.out.println("¡Guía " + calificacion.getUsuario().getNombre() + " ha ganado el Trofeo al éxito!");
	        }
	    }

	  
	  
}
