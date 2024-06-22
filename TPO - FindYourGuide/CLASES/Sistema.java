package CLASES;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import CONTROLLERS.usuarioDTO;
import CONTROLLERS.TipoAutenticacion;
import CONTROLLERS.TipoUsuario;
import CONTROLLERS.UsuarioController;
import INTERFACES.SistemaAutenticacion;
import INTERFACES.SistemaVerificacion;
import CONTROLLERS.ControladorReserva;
import CONTROLLERS.ControladorViaje;

public class Sistema {
    private static List<Usuario> usuarios;
    private static List<ServicioOfrecido> serviciosSistema;
    private static UsuarioController usuarioController;
    private static ControladorViaje controladorViaje;
    private static ControladorReserva controladorReserva;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.usuarioController = new UsuarioController();
        this.controladorViaje = new ControladorViaje();
        this.controladorReserva = new ControladorReserva();
        
    }

    public static void main(String[] args) {
        //Instancias iniciales del sistema Global
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);

        // Crear y registrar algunos usuarios
        usuarioDTO user1 = new usuarioDTO("Juan", "Perez", "M", 12345678, "juan@example.com", 123456789, TipoUsuario.TURISTA, TipoAutenticacion.Mail, "password123", null, null, null, null);
        usuarioDTO user2 = new usuarioDTO("Maria", "Gomez", "F", 87654321, "maria@example.com", 987654321, TipoUsuario.GUIA, TipoAutenticacion.Google, "password456", List.of("Madrid"), List.of("España"), List.of(new ServicioOfrecido("Tour Individual", "Tour grupal", 250)), null);
        usuarioDTO user3 = new usuarioDTO("Carlos", "Lopez", "M", 23456789, "carlos@example.com", 234567890, TipoUsuario.TURISTA, TipoAutenticacion.Facebook, "password789", null, null, null, null);
        usuarioDTO user4 = new usuarioDTO("Ana", "Martinez", "F", 34567890, "ana@example.com", 345678901, TipoUsuario.GUIA, TipoAutenticacion.AppleID, "password012", List.of("Barcelona", "Valencia"), List.of("España"), List.of(new ServicioOfrecido("Traducciones", "Tour Individual", 100), new ServicioOfrecido("Tour Grupal", "Tour para grupos grandes", 250)), null);
        usuarioDTO user5 = new usuarioDTO("David", "Garcia", "M", 45678901, "david@example.com", 456789012, TipoUsuario.GUIA, TipoAutenticacion.Google, "password345", List.of("Sevilla", "Granada"), List.of("España"), List.of(new ServicioOfrecido("Tour Grupal", "Traducciones", 300), new ServicioOfrecido("Tour de Naturaleza", "Tour por parques y reservas naturales", 10)), null);
        usuarioDTO user6 = new usuarioDTO("Laura", "Fernandez", "F", 56789012, "laura@example.com", 567890123, TipoUsuario.TURISTA, TipoAutenticacion.Mail, "password678", null, null, null, null);
        usuarioDTO user7 = new usuarioDTO("Maria", "Gomez", "F", 87654321, "maria@example.com", 987654321, TipoUsuario.GUIA, TipoAutenticacion.Google, "password456", List.of("Madrid"), List.of("España"), List.of(new ServicioOfrecido("Tour Individual", "Tour grupal", 250)), null);

        usuarioController.registrarUsuario(user1);
        usuarioController.registrarUsuario(user2);
        usuarioController.registrarUsuario(user3);
        usuarioController.registrarUsuario(user4);
        usuarioController.registrarUsuario(user5);
        usuarioController.registrarUsuario(user6);

        SistemaVerificacion sistemaVerificacion = new SistemaVerificacionIA();
        AdaptadorVerificacion adaptadorVerificacion = new AdaptadorVerificacion(sistemaVerificacion);

        while (true) {
            System.out.println("¡Bienvenido a FindYourGuide!");
            System.out.println("1- Crear nueva cuenta");
            System.out.println("2- Iniciar sesión");
            System.out.println("3- Salir");

            int opcionAcceso = scanner.nextInt();

            switch (opcionAcceso) {
                case 1: // REGISTRO
                    registrarCuenta(scanner, sistema, adaptadorVerificacion);
                    break;
                case 2: // INICIO SESIÓN
                    iniciarSesion(scanner, sistema);
                    break;
                case 3: // SALIR
                    usuarioController.imprimirUsuarios();
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void registrarCuenta(Scanner scanner, Sistema sistema, AdaptadorVerificacion adaptadorVerificacion) {
        System.out.println("Por favor, seleccione su rol (1-Guia, 2-Turista): ");
        int tipoUsuarioInt = scanner.nextInt();
        TipoUsuario rol = tipoUsuarioInt == 1 ? TipoUsuario.GUIA : TipoUsuario.TURISTA;

        System.out.println("Por favor, seleccione el modo de autenticación (1-Mail, 2-Facebook, 3-Google, 4-AppleID): ");
        int tipoAutenticacionInt = scanner.nextInt();
        TipoAutenticacion autenticacion = TipoAutenticacion.values()[tipoAutenticacionInt - 1];

        System.out.println("Nombre:");
        String nombre = scanner.next();
        System.out.println("Apellido:");
        String apellido = scanner.next();
        System.out.println("Sexo: (M/F)");
        String sexo = scanner.next();
        System.out.println("DNI:");
        int dni = scanner.nextInt();
        System.out.println("Email:");
        String email = scanner.next();
        System.out.println("Teléfono:");
        int telefono = scanner.nextInt();
        System.out.println("Contraseña:");
        String contrasena = scanner.next();

        List<String> ciudades = new ArrayList<>();
        List<String> paises = new ArrayList<>();
        List<ServicioOfrecido> servicios = new ArrayList<>();

        if (rol == TipoUsuario.GUIA) {
            scanner.nextLine(); // Consumir el salto de línea

            System.out.println("Elije los países en los que ofrecerás tus servicios, coloca '0' para finalizar la carga.");
            String pais;
            while (!(pais = scanner.nextLine()).equals("0")) {
                paises.add(pais);
            }

            System.out.println("Elije las ciudades en las que ofrecerás tus servicios, coloca '0' para finalizar la carga.");
            String ciudad;
            while (!(ciudad = scanner.nextLine()).equals("0")) {
                ciudades.add(ciudad);
            }

            System.out.println("Elije los servicios predefinidos para ofrecer, coloca '0' para finalizar la carga.");
            System.out.println("1-Tour Individual");
            System.out.println("2-Traducciones");
            System.out.println("3-Tour Grupal");

            int res;
            while ((res = scanner.nextInt()) != 0) {
                switch (res) {
                    case 1:
                        servicios.add(new ServicioOfrecido("Tour Individual", "Tour armado especialmente para vos", 100));
                        break;
                    case 2:
                        servicios.add(new ServicioOfrecido("Traducciones", "Traducción únicamente en Italiano", 300));
                        break;
                    case 3:
                        servicios.add(new ServicioOfrecido("Tour Grupal", "Tour para entre 3 a 8 personas", 250));
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }

            Credencial credencial = new Credencial(email, new Date(), new Date(System.currentTimeMillis() + 86400000), dni);
            boolean credencialVerificada = adaptadorVerificacion.verificar(credencial);

            if (credencialVerificada) {
                usuarioDTO uDTO = new usuarioDTO(nombre, apellido, sexo, dni, email, telefono,
                        rol, autenticacion, contrasena, ciudades, paises, servicios, credencial);
                boolean autenticacionExitosa = sistema.autenticarUsuario(uDTO);

                if (autenticacionExitosa) {
                    usuarioController.registrarUsuario(uDTO);
                    System.out.println("Guía registrado exitosamente con credencial verificada.");
                } else {
                    System.out.println("Error al autenticar el usuario. Registro fallido.");
                }
            } else {
                System.out.println("Error al verificar la credencial. Registro de guía fallido.");
            }
        } else {
            usuarioDTO uDTO = new usuarioDTO(nombre, apellido, sexo, dni, email, telefono,
                    rol, autenticacion, contrasena, null, null, null, null);
            boolean autenticacionExitosa = sistema.autenticarUsuario(uDTO);

            if (autenticacionExitosa) {
                usuarioController.registrarUsuario(uDTO);
                System.out.println("Turista registrado exitosamente.");
            } else {
                System.out.println("Error al autenticar el usuario. Registro fallido.");
            }
        }
    }

    private static void iniciarSesion(Scanner scanner, Sistema sistema) {
        System.out.println("Por favor, seleccione el modo de autenticación (1-Mail, 2-Facebook, 3-Google, 4-AppleID): ");
        int tipoAutenticacionIntInicioSesion = scanner.nextInt();
        TipoAutenticacion autenticacionInicioSesion = TipoAutenticacion.values()[tipoAutenticacionIntInicioSesion - 1];

        System.out.println("Usted está iniciando sesión con " + autenticacionInicioSesion + ":");
        System.out.println("Email:");
        String emailLogin = scanner.next();
        Usuario usuario = sistema.usuarioController.buscarUsuarioPorEmail(emailLogin);

        if (usuario != null) {
            System.out.println("Contraseña:");
            String contraseñaLogin = scanner.next();

            if (sistema.usuarioController.verificarContraseña(usuario, contraseñaLogin)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido " + usuario.getNombre());

                if (usuario.getTipoCuenta() == TipoUsuario.GUIA) {
                    menuGuia(scanner, sistema, (Guia) usuario);
                } else if (usuario.getTipoCuenta() == TipoUsuario.TURISTA) {
                    menuTurista(scanner, sistema, (Turista) usuario);
                }
            } else {
                System.out.println("Contraseña incorrecta.");
            }
        } else {
            System.out.println("Email no encontrado.");
        }
    }

    private static void menuGuia(Scanner scanner, Sistema sistema, Guia guia) {
        while (true) {
            System.out.println("Menú de Guía:");
            System.out.println("1- Ver reservas asociadas");
            System.out.println("2- Cancelar reserva");
            System.out.println("3- Cerrar sesión");

            int opcionGuia = scanner.nextInt();

            switch (opcionGuia) {
                case 1:
                    verReservas(guia);
                    break;
                case 2:
                    cancelarReserva(scanner, guia);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuTurista(Scanner scanner, Sistema sistema, Turista turista) {
        while (true) {
            System.out.println("Menú de Turista:");
            System.out.println("1- Realizar reserva");
            System.out.println("2- Buscar guía");
            System.out.println("3- Cerrar sesión");

            int opcionTurista = scanner.nextInt();

            switch (opcionTurista) {
                case 1:
                    realizarReserva(scanner, sistema, turista);
                    break;
                case 2:
                    buscarGuiaSubmenu(scanner, sistema);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    
    private static void buscarGuiaSubmenu(Scanner scanner, Sistema sistema) {
        System.out.println("Buscar guía por:");
        System.out.println("1- Nombre");
        System.out.println("2- Ciudad");
        System.out.println("3- País");

        int opcionBusqueda = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcionBusqueda) {
            case 1:
                buscarGuiaPorNombre(scanner, sistema);
                break;
            case 2:
                buscarGuiaPorCiudad(scanner, sistema);
                break;
            case 3:
                buscarGuiaPorPais(scanner, sistema);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void buscarGuiaPorNombre(Scanner scanner, Sistema sistema) {
        System.out.println("Ingrese el nombre del guía que desea buscar:");
        String nombreGuia = scanner.nextLine();
        List<Guia> guias = sistema.usuarioController.buscarGuiasPorNombre(nombreGuia);

        mostrarGuias(guias);
    }

    private static void buscarGuiaPorCiudad(Scanner scanner, Sistema sistema) {
        System.out.println("Ingrese la ciudad del guía que desea buscar:");
        String ciudadGuia = scanner.nextLine();
        List<Guia> guias = sistema.usuarioController.buscarGuiasPorCiudad(ciudadGuia);

        mostrarGuias(guias);
    }

    private static void buscarGuiaPorPais(Scanner scanner, Sistema sistema) {
        System.out.println("Ingrese el país del guía que desea buscar:");
        String paisGuia = scanner.nextLine();
        List<Guia> guias = sistema.usuarioController.buscarGuiasPorPais(paisGuia);

        mostrarGuias(guias);
    }

    private static void mostrarGuias(List<Guia> guias) {
        if (guias != null && !guias.isEmpty()) {
            for (Guia guia : guias) {
                System.out.println("Guía encontrado:");
                System.out.println("Nombre: " + guia.getNombre());
                System.out.println("Servicios ofrecidos: ");
                for (ServicioOfrecido servicio : guia.getServicios()) {
                    System.out.println("- " + servicio.getTipo() + ": " + servicio.getDescripcion());
                }
                System.out.println("Países donde ofrece servicios: " + guia.getPaises());
                System.out.println("Ciudades donde ofrece servicios: " + guia.getCiudades());
            }
        } else {
            System.out.println("Guía no encontrado.");
        }}
    

    private static void verReservas(Guia guia) {
        List<Reserva> reservas = guia.getReservas();
        if (reservas.isEmpty()) {
            System.out.println("No tiene reservas asociadas.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println("ID Reserva: " + reserva.getIdReserva() + ", Estado: " + reserva.getEstado() +
                        ", Fecha de Inicio: " + reserva.getFechaDelInicio() + ", Fecha Fin: " + reserva.getFechaFin() +
                        ", Monto de Anticipo: " + reserva.getMontoDeAnticipo() + ", Viaje: " + reserva.getViaje().getDestino());
            }
        }
    }

    private static void cancelarReserva(Scanner scanner, Guia guia) {
        System.out.println("Ingrese el ID de la reserva que desea cancelar:");
        int idReserva = scanner.nextInt();
        Reserva reserva = guia.buscarReservaPorId(idReserva);

        if (reserva != null) {
            guia.cancelarReserva(reserva);
            System.out.println("Reserva cancelada con éxito.");
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }
    
    

    private static void realizarReserva(Scanner scanner, Sistema sistema, Turista turista) {
        System.out.println("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd):");
        String fechaInicioStr = scanner.next();
        Date fechaInicio = java.sql.Date.valueOf(fechaInicioStr);

        System.out.println("Ingrese la fecha de fin de la reserva (yyyy-MM-dd):");
        String fechaFinStr = scanner.next();
        Date fechaFin = java.sql.Date.valueOf(fechaFinStr);

        System.out.println("Ingrese el monto de anticipo:");
        int montoDeAnticipo = scanner.nextInt();

        System.out.println("Ingrese el ID del viaje que desea reservar:");
        int idViaje = scanner.nextInt();
        Viaje viaje = sistema.controladorViaje.buscarViajePorId(idViaje);

        if (viaje != null) {
            if (viaje.getEstado().equals("DISPONIBLE")) { // Verificar si el viaje está disponible
                Reserva reserva = new Reserva(fechaInicio, fechaFin, montoDeAnticipo, viaje);
                turista.agregarReserva(reserva);
                viaje.reservar();
                sistema.controladorReserva.registrarReserva(reserva);
                System.out.println("Reserva realizada con éxito.");
            } else {
                System.out.println("El viaje no está disponible para ser reservado.");
            }
        } else {
            System.out.println("El viaje no existe.");
        }
    }




    private boolean autenticarUsuario(usuarioDTO usuario) {
        SistemaAutenticacion sistemaAutenticacion;

        switch (usuario.getTipoAutenticacion()) {
            case Mail:
                sistemaAutenticacion = new SistemaAutenticacionMail();
                break;
            case AppleID:
                sistemaAutenticacion = new SistemaAutenticacionAppleID();
                break;
            case Google:
                sistemaAutenticacion = new SistemaAutenticacionGoogle();
                break;
            case Facebook:
                sistemaAutenticacion = new SistemaAutenticacionFacebook();
                break;
            default:
                throw new IllegalArgumentException("Tipo de autenticación no soportado: " + usuario.getTipoAutenticacion());
        }

        return sistemaAutenticacion.autenticar(usuario.getEmail(), usuario.getContraseña());
    }
}
