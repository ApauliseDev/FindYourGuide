package CLASES;

public class ServicioOfrecido {

    private String tipo;
    private String descripcion;
    private int precio;
    
    
    
	public ServicioOfrecido(String tipo, String descripcion,int precio) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    
    
    public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public void add(ServicioOfrecido servicio) {
		// TODO Auto-generated method stub
		
	}

	public void remove(ServicioOfrecido servicio) {
		// TODO Auto-generated method stub
		
	}
	
    public String toString() {
        return "ServicioOfrecido{" +
               "tipo='" + tipo + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", precio=" + precio +
               '}';
    }
	


}
