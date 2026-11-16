package Personajes;

public class Guerrero extends Personaje {
    protected int fuerza;

    public Guerrero() {
    }

    public Guerrero(String nombre, int nivel, int vida, int vidaMaxima, int ataque, int defensa, int fuerza) {
        super(nombre, nivel, vida, vidaMaxima, ataque, defensa);
        this.fuerza = fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public void atacar(Personaje enemigo) {
        if (!this.estaVivo()) {
            System.out.println(nombre + " está derrotado y no puede atacar.");
            return;
        }
        if (!enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " ya está derrotado.");
            return;
        }
        System.out.println(nombre + " (Guerrero) usa su fuerza física para golpear a " + enemigo.getNombre() + ".");
        super.atacar(enemigo, fuerza);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Fuerza: " + fuerza);
        System.out.println("----------------------------------------");
    }
}