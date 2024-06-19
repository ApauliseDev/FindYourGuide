package CLASES;
import java.util.Date;

public class Credencial {

	private String email;
	private Date fechaEmision;
	private Date fechaCaducidad;
	private int idCredencial;
	
	
    public Credencial(String email, Date fechaEmision, Date fechaCaducidad, int idCredencial) {
        this.email = email;
        this.fechaEmision = fechaEmision;
        this.fechaCaducidad = fechaCaducidad;
        this.idCredencial = idCredencial;
    }


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFechaEmision() {
		return fechaEmision;
	}


	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}


	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	public int getIdCredencial() {
		return idCredencial;
	}


	public void setIdCredencial(int idCredencial) {
		this.idCredencial = idCredencial;
	}
	
	
    
     
}

	


