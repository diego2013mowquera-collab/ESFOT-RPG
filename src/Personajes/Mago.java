package Personajes;

public class Mago extends Personaje {
    protected int mana;

    public Mago() {
    }

    public Mago(String nombre, int nivel, int vida, int vidaMaxima, int ataque, int defensa, int mana) {
        super(nombre, nivel, vida, vidaMaxima, ataque, defensa);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void lanzarHechizo(Personaje enemigo) {
        if (!this.estaVivo()) {
            System.out.println(nombre + " está derrotado y no puede lanzar hechizos.");
            return;
        }
        if (mana < 10) {
            System.out.println(nombre + " no tiene suficiente maná (requiere 10, tiene " + mana + ").");
            return;
        }
        if (!enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " ya está derrotado.");
            return;
        }

        mana -= 10;
        System.out.println(nombre + " (Mago) lanza un poderoso hechizo a " + enemigo.getNombre() + "! (Maná restante: " + mana + ")");
        super.atacar(enemigo, 20);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Maná: " + mana);
        System.out.println("----------------------------------------");
    }
}