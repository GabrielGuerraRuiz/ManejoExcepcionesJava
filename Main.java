import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("=== FORMULARIO DE REGISTRO ===");
            
            System.out.print("Ingrese nombre de usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Ingrese edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            validarEdad(edad);
                        
            // Validar contraseña
            System.out.print("Ingrese una contraseña: ");
            String contrasena = scanner.nextLine();
            validarContrasena(contrasena);

            System.out.println("¡Registro exitoso!");
            
        } catch (ContrasenaException | EdadException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("La edad debe ser un número válido.");
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
}

// Excepciones personalizadas

class ContrasenaException extends Exception {
    public ContrasenaException(String mensaje) {
        super(mensaje);
    }
}

class EdadException extends Exception {
    public EdadException(String mensaje) {
        super(mensaje);
    }
}
