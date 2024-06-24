package CLASES;

import INTERFACES.IObserverTrofeo;
import java.util.ArrayList;
import java.util.List;
public class Calificacion {
	
    private double calificacion;
    private String reseña;
    private List<IObserverTrofeo> observers;
    private Usuario usuario;
    
    
    
    
    public Calificacion(Usuario usuario) {
        this.usuario = usuario;
        this.observers = new ArrayList<>();
    }
    
    
    public double getCalificacion() {
        return calificacion;
    }
    
    public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
        notificar();
    }
    
    public String getReseña() {
        return reseña;
    }
    
    public void setReseña(String reseña) {
        this.reseña = reseña;
    }
    
    public void agregarTrofeo(IObserverTrofeo observer) {
        observers.add(observer);
    }
    
    
    private void notificar() {
        for (IObserverTrofeo observer : observers) {
            observer.recibirTrofeo();
        }
    }
    
    
    

}
