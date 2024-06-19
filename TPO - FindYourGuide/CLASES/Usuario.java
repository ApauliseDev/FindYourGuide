package CLASES;

import java.util.List;
import CONTROLLERS.TipoUsuario;
import CONTROLLERS.UsuarioController;
import CONTROLLERS.TipoAutenticacion;

public abstract class Usuario {
	
	private String nombre;
	private String apellido;
	private String sexo;
	private int dni;
	private String email;
	private int telefono;
	private String contraseña;
	private TipoAutenticacion tipoAutenticacion;
	private TipoUsuario tipoCuenta;


	
    public Usuario(String nombre, String apellido, String sexo, int dni, String email, int telefono, TipoUsuario tipoCuenta, TipoAutenticacion tipoAutenticacion, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.tipoCuenta = tipoCuenta;
        this.tipoAutenticacion = tipoAutenticacion;
        this.contraseña = contraseña;

    }
    
    // Getters y Setters
    
    
    public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
    public boolean verificarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
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

    // Método abstracto para actualizar perfil
    public abstract void actualizarPerfil(String nombre, String email);
    
    public void guardar() {
        UsuarioController.getUsuarios().add(this);
    }
    
    // Sobrescribir el método toString para imprimir todos los atributos
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Sexo: " + sexo +
                ", DNI: " + dni +
                ", Email: " + email +
                ", Teléfono: " + telefono +
                ", Tipo de Cuenta: " + tipoCuenta +
                ", Tipo de Autenticación: " + tipoAutenticacion;
    }
    
}


