# ManejoExcepcionesJava

Aplicación de consola en Java que demuestra el uso de excepciones personalizadas para validar un formulario de registro de usuario. El objetivo es mostrar cómo manejar errores de entrada de manera clara y estructurada, mejorando la experiencia del usuario y la robustez del código.

## Índice

- [Descripción](#descripción)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Validaciones implementadas](#validaciones-implementadas)
- [Ejecución](#ejecución)
- [Ejemplo de uso](#ejemplo-de-uso)

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




