
package Juego;

import Personajes.*;
import java.util.*;

public class Gestor {
    private List<Personaje> personajes;
    private Map<String, Personaje> registro;
    private Scanner sc;

    public Gestor() {
        personajes = new ArrayList<>();
        registro = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void crearGuerrero() {
        System.out.print("Ingrese nombre del Guerrero: ");
        String nombre = sc.next();
        if (registro.containsKey(nombre)) {
            System.out.println("Error: Ya existe un personaje con el nombre '" + nombre + "'.");
            return;
        }
        System.out.print("Nivel: ");
        int nivel = sc.nextInt();
        System.out.print("Vida Máxima: ");
        int vidaMax = sc.nextInt();
        System.out.print("Ataque: ");
        int ataque = sc.nextInt();
        System.out.print("Defensa: ");
        int defensa = sc.nextInt();
        System.out.print("Fuerza: ");
        int fuerza = sc.nextInt();

        Guerrero g = new Guerrero(nombre, nivel, vidaMax, vidaMax, ataque, defensa, fuerza);
        personajes.add(g);
        registro.put(nombre, g);
        System.out.println("¡Guerrero creado exitosamente!");
    }

    public void crearMago() {
        System.out.print("Ingrese nombre del Mago: ");
        String nombre = sc.next();
        if (registro.containsKey(nombre)) {
            System.out.println("Error: Ya existe un personaje con el nombre '" + nombre + "'.");
            return;
        }
        System.out.print("Nivel: ");
        int nivel = sc.nextInt();
        System.out.print("Vida Máxima: ");
        int vidaMax = sc.nextInt();
        System.out.print("Ataque: ");
        int ataque = sc.nextInt();
        System.out.print("Defensa: ");
        int defensa = sc.nextInt();
        System.out.print("Maná: ");
        int mana = sc.nextInt();

        Mago m = new Mago(nombre, nivel, vidaMax, vidaMax, ataque, defensa, mana);
        personajes.add(m);
        registro.put(nombre, m);
        System.out.println("¡Mago creado exitosamente!");
    }

    public void crearArquero() {
        System.out.print("Ingrese nombre del Arquero: ");
        String nombre = sc.next();
        if (registro.containsKey(nombre)) {
            System.out.println("Error: Ya existe un personaje con el nombre '" + nombre + "'.");
            return;
        }
        System.out.print("Nivel: ");
        int nivel = sc.nextInt();
        System.out.print("Vida Máxima: ");
        int vidaMax = sc.nextInt();
        System.out.print("Ataque: ");
        int ataque = sc.nextInt();
        System.out.print("Defensa: ");
        int defensa = sc.nextInt();
        System.out.print("Flechas: ");
        int flechas = sc.nextInt();

        Arquero a = new Arquero(nombre, nivel, vidaMax, vidaMax, ataque, defensa, flechas);
        personajes.add(a);
        registro.put(nombre, a);
        System.out.println("¡Arquero creado exitosamente!");
    }

    public void crearPaladin() {
        System.out.print("Ingrese nombre del Paladín: ");
        String nombre = sc.next();
        if (registro.containsKey(nombre)) {
            System.out.println("Error: Ya existe un personaje con el nombre '" + nombre + "'.");
            return;
        }
        System.out.print("Nivel: ");
        int nivel = sc.nextInt();
        System.out.print("Vida Máxima: ");
        int vidaMax = sc.nextInt();
        System.out.print("Ataque: ");
        int ataque = sc.nextInt();
        System.out.print("Defensa: ");
        int defensa = sc.nextInt();
        System.out.print("Fuerza: ");
        int fuerza = sc.nextInt();
        System.out.print("Energía Sagrada: ");
        int energia = sc.nextInt();

        Paladin p = new Paladin(nombre, nivel, vidaMax, vidaMax, ataque, defensa, fuerza, energia);
        personajes.add(p);
        registro.put(nombre, p);
        System.out.println("¡Paladín creado exitosamente!");
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        for (Personaje p : personajes) {
            p.mostrarInformacion(); // Polimorfismo
        }
    }

    public void buscarPersonaje() {
        System.out.print("Ingrese el nombre del personaje a buscar: ");
        String nombre = sc.next();
        Personaje p = registro.get(nombre); // Uso del HashMap
        if (p != null) {
            System.out.println("¡Personaje encontrado!");
            p.mostrarInformacion();
        } else {
            System.out.println("No se encontró ningún personaje con el nombre '" + nombre + "'.");
        }
    }

    public Personaje seleccionarPersonaje(String mensaje) {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes disponibles.");
            return null;
        }
        System.out.println(mensaje);
        for (int i = 0; i < personajes.size(); i++) {
            System.out.println((i + 1) + ". " + personajes.get(i).getNombre() + " (" + personajes.get(i).getClass().getSimpleName() + " - Vida: " + personajes.get(i).getVida() + "/" + personajes.get(i).getVidaMaxima() + ")");
        }
        System.out.print("Seleccione el número del personaje: ");
        int index = sc.nextInt();
        if (index < 1 || index > personajes.size()) {
            System.out.println("Opción inválida.");
            return null;
        }
        return personajes.get(index - 1);
    }

    public void atacarPersonaje() {
        System.out.println("--- SELECCIONAR ATACANTE ---");
        Personaje atacante = seleccionarPersonaje("Elija el atacante:");
        if (atacante == null || !atacante.estaVivo()) {
            System.out.println("Personaje inválido o derrotado.");
            return;
        }

        System.out.println("--- SELECCIONAR OBJETIVO ---");
        Personaje defensor = seleccionarPersonaje("Elija el objetivo:");
        if (defensor == null || !defensor.estaVivo()) {
            System.out.println("Objetivo inválido o derrotado.");
            return;
        }

        if (atacante == defensor) {
            System.out.println("Un personaje no puede atacarse a sí mismo.");
            return;
        }

        System.out.println("1. Ataque normal");
        System.out.println("2. Ataque con bonificación");
        System.out.print("Elija tipo de ataque: ");
        int tipo = sc.nextInt();

        if (tipo == 1) {
            atacante.atacar(defensor);
        } else if (tipo == 2) {
            System.out.print("Ingrese la bonificación de ataque: ");
            int bonif = sc.nextInt();
            atacante.atacar(defensor, bonif);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public void utilizarHabilidadEspecial() {
        Personaje p = seleccionarPersonaje("Seleccione el personaje para usar habilidad especial:");
        if (p == null || !p.estaVivo()) {
            System.out.println("Personaje inválido o derrotado.");
            return;
        }

        // Uso de instanceof y casting seguro
        if (p instanceof Guerrero && !(p instanceof Paladin)) {
            Guerrero g = (Guerrero) p;
            System.out.println("El Guerrero " + g.getNombre() + " realiza un ataque de fuerza.");
            Personaje enemigo = seleccionarPersonaje("Seleccione el enemigo a atacar:");
            if (enemigo != null && enemigo != g) {
                g.atacar(enemigo);
            }
        } else if (p instanceof Mago) {
            Mago m = (Mago) p;
            Personaje enemigo = seleccionarPersonaje("Seleccione el objetivo del hechizo:");
            if (enemigo != null) {
                m.lanzarHechizo(enemigo);
            }
        } else if (p instanceof Arquero) {
            Arquero a = (Arquero) p;
            Personaje enemigo = seleccionarPersonaje("Seleccione el objetivo del disparo:");
            if (enemigo != null) {
                a.dispararFlecha(enemigo);
            }
        } else if (p instanceof Paladin) {
            Paladin pal = (Paladin) p;
            System.out.println("1. Curar a un aliado");
            System.out.println("2. Activar Escudo Sagrado");
            System.out.print("Seleccione habilidad del Paladín: ");
            int opH = sc.nextInt();
            if (opH == 1) {
                Personaje objetivo = seleccionarPersonaje("Seleccione el objetivo a curar:");
                if (objetivo != null) {
                    pal.curar(objetivo);
                }
            } else if (opH == 2) {
                pal.activarEscudo();
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }

    public void simularCombate() {
        System.out.println("=== SIMULADOR DE COMBATE POR TURNOS ===");
        Personaje p1 = seleccionarPersonaje("Seleccione el primer combatiente:");
        if (p1 == null || !p1.estaVivo()) {
            System.out.println("Combatiente 1 inválido o derrotado.");
            return;
        }

        Personaje p2 = seleccionarPersonaje("Seleccione el segundo combatiente:");
        if (p2 == null || !p2.estaVivo()) {
            System.out.println("Combatiente 2 inválido o derrotado.");
            return;
        }

        if (p1 == p2) {
            System.out.println("Un personaje no puede combatir contra sí mismo.");
            return;
        }

        System.out.println("\n¡COMIENZA EL COMBATE: " + p1.getNombre() + " vs " + p2.getNombre() + "!");
        int turno = 1;

        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");

            // Turno P1 ataca a P2
            if (p1 instanceof Mago) {
                ((Mago) p1).lanzarHechizo(p2);
            } else if (p1 instanceof Arquero) {
                ((Arquero) p1).dispararFlecha(p2);
            } else {
                p1.atacar(p2);
            }

            if (!p2.estaVivo()) {
                break;
            }

            // Turno P2 ataca a P1
            if (p2 instanceof Mago) {
                ((Mago) p2).lanzarHechizo(p1);
            } else if (p2 instanceof Arquero) {
                ((Arquero) p2).dispararFlecha(p1);
            } else {
                p2.atacar(p1);
            }

            turno++;
        }

        System.out.println("\n========================================");
        System.out.println("           FIN DEL COMBATE              ");
        System.out.println("========================================");
        if (p1.estaVivo() && !p2.estaVivo()) {
            System.out.println(" GANADOR: " + p1.getNombre() + " (" + p1.getClass().getSimpleName() + ")");
        } else if (p2.estaVivo() && !p1.estaVivo()) {
            System.out.println(" GANADOR: " + p2.getNombre() + " (" + p2.getClass().getSimpleName() + ")");
        } else {
            System.out.println("¡Empate o combate interrumpido!");
        }
    }

    public void mostrarPersonajesVivos() {
        boolean hayVivos = false;
        System.out.println("--- PERSONAJES VIVOS ---");
        for (Personaje p : personajes) {
            if (p.estaVivo()) {
                p.mostrarInformacion();
                hayVivos = true;
            }
        }
        if (!hayVivos) {
            System.out.println("No hay personajes vivos actualmente.");
        }
    }
}