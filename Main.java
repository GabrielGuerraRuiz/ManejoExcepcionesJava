import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== FORMULARIO DE REGISTRO ===");

            System.out.print("Ingrese nombre de usuario: ");
            String usuario = scanner.nextLine();

            int edad = 0;
            while (true) {
                System.out.print("Ingrese edad: ");
                try {
                    edad = Integer.parseInt(scanner.nextLine());
                    validarEdad(edad);
                    break;
                } catch (EdadException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("La edad debe ser un número válido.");
                }
            }

            String email = "";
            while (true) {
                System.out.print("Ingrese su correo electrónico: ");
                email = scanner.nextLine();
                try {
                    validarEmail(email);
                    break;
                } catch (EmailException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String contrasena = "";
            while (true) {
                System.out.print("Ingrese una contraseña: ");
                contrasena = scanner.nextLine();
                try {
                    validarContrasena(contrasena);
                    break;
                } catch (ContrasenaException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            System.out.println("¡Registro exitoso!");

        } finally {
            scanner.close();
        }
    }

    private static void validarContrasena(String contrasena) throws ContrasenaException {
        if (contrasena.length() < 8) {
            throw new ContrasenaException("Debe tener al menos 8 caracteres");
        }

        boolean tieneMayuscula = false;
        boolean tieneNumero = false;

        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) tieneMayuscula = true;
            if (Character.isDigit(c)) tieneNumero = true;
        }

        if (!tieneMayuscula || !tieneNumero) {
            throw new ContrasenaException("Debe contener al menos una mayúscula y un número");
        }
    }

    private static void validarEdad(int edad) throws EdadException {
        if (edad < 0 || edad > 120) {
            throw new EdadException("Edad no válida. Debe estar entre 0 y 120 años.");
        }
    }

    private static void validarEmail(String email) throws EmailException {
        String regex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,6}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new EmailException("Correo electrónico no válido.");
        }
    }
}
