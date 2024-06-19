package CLASES;
import java.util.List;
import CONTROLLERS.TipoUsuario;
import CONTROLLERS.TipoAutenticacion;
public class Guia extends Usuario {
	 private List<String> ciudades;
	 private List<String> paises;
     private List<ServicioOfrecido> servicios ;

    public Guia(String nombre, String apellido, String sexo, int dni, String email, int telefono, TipoUsuario tipoCuenta, TipoAutenticacion tipoAutenticacion,
    		String contraseña, List<String> ciudades,  List<String> paises, List<ServicioOfrecido> servicios) {
        super(nombre, apellido, sexo, dni, email, telefono, tipoCuenta, tipoAutenticacion, contraseña);
        this.ciudades = ciudades;
        this.paises = paises;
        this.servicios = servicios;
    }



	public List<String> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<String> ciudades) {
        this.ciudades = ciudades;
    }

    public List<String> getPaises() {
        return paises;
    }

    public void setPaises(List<String> paises) {
        this.paises = paises;
    }
    public List<ServicioOfrecido> getServiciosOfrecidos() {
        return servicios;
    }

    public void setServiciosOfrecidos(List<ServicioOfrecido> servicios) {
        this.servicios = servicios;
    }

    @Override
    public void actualizarPerfil(String nombre, String email) {
        this.setNombre(nombre);
        this.setEmail(email);
        System.out.println("Perfil del guía actualizado. Nuevo nombre: " + this.getNombre() + ", Nuevo email: " + this.getEmail());
    }

    public void agregarServicio(ServicioOfrecido servicio) {
    	servicios.add(servicio);
    }

    public void eliminarServicio(ServicioOfrecido servicio) {
        servicios.remove(servicio);
    }
    
    public String toString() {
        return super.toString() +
                ", Ciudades: " + ciudades +
                ", Países: " + paises +
                ", Servicios Ofrecidos: " + servicios;
    }
}