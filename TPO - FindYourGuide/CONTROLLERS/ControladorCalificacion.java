package CONTROLLERS;
import java.util.List;


import CLASES.Calificacion;
public class ControladorCalificacion {
	private List<Calificacion> listaCalificaciones;
	
	
	   public ControladorCalificacion(List<Calificacion> listaCalificaciones) {
	        this.listaCalificaciones = listaCalificaciones;
	    }
	   
	   
	   
	   
	   public void agregarCalificacion(Calificacion calificacion) {
	        listaCalificaciones.add(calificacion);
	    }
	   
	   
	   public List<Calificacion> getListaCalificaciones() {
	        return listaCalificaciones;
	    }

	
	

}
