# ManejoExcepcionesJava

Aplicación de consola en Java que demuestra el uso de excepciones personalizadas para validar un formulario de registro de usuario. El objetivo es mostrar cómo manejar errores de entrada de manera clara y estructurada, mejorando la experiencia del usuario y la robustez del código.

## Índice

- [Descripción](#descripción)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Validaciones implementadas](#validaciones-implementadas)
- [Ejecución](#ejecución)
- [Ejemplo de uso](#ejemplo-de-uso)
- [Desarrollo](#desarrollo)

## Descripción

Este proyecto solicita al usuario datos básicos para registrarse (nombre, edad, correo electrónico y contraseña) y valida cada campo usando excepciones personalizadas. Si algún dato es incorrecto, se muestra un mensaje específico y se solicita nuevamente la entrada.

## Estructura del proyecto

- `Main.java`: Contiene la lógica principal del formulario y las validaciones.
- `model/ContrasenaException.java`: Excepción personalizada para contraseñas inválidas.
- `model/EdadException.java`: Excepción personalizada para edades inválidas.
- `model/EmailException.java`: Excepción personalizada para correos electrónicos inválidos.

## Validaciones implementadas

- **Edad:** Debe ser un número entre 0 y 120.
- **Correo electrónico:** Debe tener un formato válido.
- **Contraseña:** Debe tener al menos 8 caracteres, una mayúscula y un número.

## Desarrollo

El desarrollo de este proyecto se centra en el uso de excepciones personalizadas para validar la entrada de datos del usuario en un formulario de registro. Cada validación se realiza en métodos separados y, en caso de error, se lanza una excepción específica que es capturada en el flujo principal para mostrar un mensaje claro al usuario.

### Flujo de validación

1. El usuario ingresa sus datos uno por uno.
2. Cada dato es validado mediante un método específico.
3. Si la validación falla, se lanza una excepción personalizada y se solicita nuevamente el dato.
4. Si todos los datos son válidos, el registro es exitoso.

El menú principal y la lógica de validación están en el archivo `Main.java`. El flujo es sencillo: se solicita cada dato, se valida y, si hay error, se muestra el mensaje correspondiente y se vuelve a pedir el dato.

```java
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
```

Este patrón se repite para el correo electrónico y la contraseña, usando sus propias excepciones personalizadas. Así, el usuario siempre recibe retroalimentación clara y puede corregir su entrada.

### Métodos de validación

Cada campo tiene su propio método de validación. Por ejemplo, la contraseña:

```java
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
```

Esto permite centralizar la lógica de validación y reutilizarla fácilmente, además de mantener el código principal limpio y fácil de entender.

## Ejecución

Compila y ejecuta el proyecto con:

```sh
javac Main.java model/*.java
java Main
```

## Ejemplo de uso

```
=== FORMULARIO DE REGISTRO ===
Ingrese nombre de usuario: usuario1
Ingrese edad: -5
Error: Edad no válida. Debe estar entre 0 y 120 años.
Ingrese edad: 25
Ingrese su correo electrónico: correo@invalido
Error: Correo electrónico no válido.
Ingrese su correo electrónico: usuario@dominio.com
Ingrese una contraseña: abc
Error: Debe tener al menos 8 caracteres
Ingrese una contraseña: Abcdefg1
¡Registro exitoso!
```
## Capturas de pantalla del programa en funcionamiento
![Imagen de WhatsApp 2025-05-16 a las 22 54 16_e2fc8a6f](https://github.com/user-attachments/assets/9bfc74ae-c9f4-4524-a2ba-24aaee71d844)
![Imagen de WhatsApp 2025-05-16 a las 22 54 17_b7665576](https://github.com/user-attachments/assets/1b727fd6-e1fa-4549-8c90-bcf253bffb32)
![Imagen de WhatsApp 2025-05-16 a las 22 54 17_2182ebc1](https://github.com/user-attachments/assets/a5daf241-8fbc-49ec-bc96-822c1fa1e67f)
![Imagen de WhatsApp 2025-05-16 a las 22 56 18_f2d84905](https://github.com/user-attachments/assets/cea318b0-d263-437c-98dc-d1f4a1df72b1)
![Imagen de WhatsApp 2025-05-16 a las 22 56 18_edbee117](https://github.com/user-attachments/assets/a5eb8093-d3b4-407a-8660-e6f41d68c9c8)

