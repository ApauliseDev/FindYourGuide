package CLASES;

import java.util.Date;

public class IDVerificacionAdapterImpl implements IDVerificacionAdapter {
    private Credencial credencial;
    private UserIDVerificacion userIDVerificacion;

    public IDVerificacionAdapterImpl(Credencial credencial) {
        this.credencial = credencial;
        this.userIDVerificacion = new UserIDVerificacion();
    }

    @Override
    public void verificarCredencial() {
        if (credencial.getFechaCaducidad().before(new Date())) {
            System.out.println("La credencial ha caducado.");
        } else {
            userIDVerificacion.verificarCredencialConEmail(credencial.getEmail());
        }
    }
}