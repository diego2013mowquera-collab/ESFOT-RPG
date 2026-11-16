package Juego;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestor gestor = new Gestor();
        int opcion = 0;

        do {
            System.out.println("\n====================================");
            System.out.println("       ESFOT RPG - JAVA POO         ");
            System.out.println("====================================");
            System.out.println("1. Crear Guerrero");
            System.out.println("2. Crear Mago");
            System.out.println("3. Crear Arquero");
            System.out.println("4. Crear Paladín");
            System.out.println("5. Mostrar personajes");
            System.out.println("6. Buscar personaje por nombre");
            System.out.println("7. Atacar a otro personaje");
            System.out.println("8. Utilizar habilidad especial");
            System.out.println("9. Simular combate por turnos");
            System.out.println("10. Mostrar personajes vivos");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next(); // Limpiar entrada incorrecta
                continue;
            }

            switch (opcion) {
                case 1:
                    gestor.crearGuerrero();
                    break;
                case 2:
                    gestor.crearMago();
                    break;
                case 3:
                    gestor.crearArquero();
                    break;
                case 4:
                    gestor.crearPaladin();
                    break;
                case 5:
                    gestor.mostrarPersonajes();
                    break;
                case 6:
                    gestor.buscarPersonaje();
                    break;
                case 7:
                    gestor.atacarPersonaje();
                    break;
                case 8:
                    gestor.utilizarHabilidadEspecial();
                    break;
                case 9:
                    gestor.simularCombate();
                    break;
                case 10:
                    gestor.mostrarPersonajesVivos();
                    break;
                case 11:
                    System.out.println("¡Gracias por jugar ESFOT RPG! Saliendo...");
                    break;
                default:
                    System.out.println("Opción fuera de rango (1-11). Intente nuevamente.");
            }
        } while (opcion != 11);

        sc.close();
    }
}
