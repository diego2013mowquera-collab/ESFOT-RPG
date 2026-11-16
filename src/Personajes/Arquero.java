package Personajes;

public class Arquero extends Personaje {
    protected int flechas;

    public Arquero() {
    }

    public Arquero(String nombre, int nivel, int vida, int vidaMaxima, int ataque, int defensa, int flechas) {
        super(nombre, nivel, vida, vidaMaxima, ataque, defensa);
        this.flechas = flechas;
    }

    public int getFlechas() {
        return flechas;
    }

    public void setFlechas(int flechas) {
        this.flechas = flechas;
    }

    public void dispararFlecha(Personaje enemigo) {
        if (!this.estaVivo()) {
            System.out.println(nombre + " está derrotado y no puede disparar.");
            return;
        }
        if (flechas <= 0) {
            System.out.println(nombre + " no tiene flechas disponibles.");
            return;
        }
        if (!enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " ya está derrotado.");
            return;
        }

        flechas--;
        System.out.println(nombre + " (Arquero) dispara una flecha precisa a " + enemigo.getNombre() + "! (Flechas restantes: " + flechas + ")");
        super.atacar(enemigo, 5);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Flechas: " + flechas);
        System.out.println("----------------------------------------");
    }
}
