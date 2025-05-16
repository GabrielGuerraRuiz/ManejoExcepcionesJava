import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("=== FORMULARIO DE REGISTRO ===");
            
            System.out.print("Ingrese nombre de usuario: ");
            String usuario = scanner.nextLine();
                        
            //Validar contraseña
            System.out.print("Ingrese una contraseña: ");
            String contrasena = scanner.nextLine();
            validarContrasena(contrasena);

            
            
        } catch (ContrasenaException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }


    //Funcion para validar la contraseña
    private static void validarContrasena(String contrasena) throws ContrasenaException{
        //Validar longitud minima
        if (contrasena.length() < 8) {
            throw new ContrasenaException("Debe tener al menos 8 caracteres");
        }
        
        //Validar que contenga al menos una mayuscula y un numero
        boolean tieneMayuscula = false;
        boolean tieneNumero = false;
        
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) tieneMayuscula = true;
            if (Character.isDigit(c)) tieneNumero = true;
        }
        
        if (!tieneMayuscula || !tieneNumero) {
            throw new ContrasenaException(
                "Debe contener al menos una mayuscula y un numero");
        }
    }


}