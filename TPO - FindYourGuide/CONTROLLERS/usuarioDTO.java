package CONTROLLERS;

import java.util.List;

import CLASES.ServicioOfrecido;
import CLASES.Credencial;
public class usuarioDTO   {

	private String contraseña;
	private TipoAutenticacion tipoAutenticacion;
	private TipoUsuario tipoCuenta;
	private String nombre;
	private String apellido;
	private String sexo;
	private int dni;	
	private String email;
	private int telefono;
	private List<String> ciudades;
	private List<String> paises;
    private List<ServicioOfrecido> servicios ; 
    private Credencial credencial;

    public usuarioDTO(String nombre, String apellido, String sexo, int dni, String email, 
    		int telefono, TipoUsuario tipoCuenta, TipoAutenticacion tipoAutenticacion, String contraseña,
    		List<String> ciudades,  List<String> paises, List<ServicioOfrecido> servicios,Credencial credencial) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.tipoCuenta = tipoCuenta;
        this.tipoAutenticacion = tipoAutenticacion;
        this.contraseña = contraseña;
        this.ciudades = ciudades;
        this.paises = paises;
        this.servicios = servicios;
        this.credencial = credencial;
    }
    
    
    public Credencial getCredencial() {
		return credencial;
	}


	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
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

    
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

    
	public TipoAutenticacion getTipoAutenticacion() {
		return tipoAutenticacion;
	}

	public void setTipoAutenticacion(TipoAutenticacion tipoAutenticacion) {
		this.tipoAutenticacion = tipoAutenticacion;
	}

	public TipoUsuario getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoUsuario tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
