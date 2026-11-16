package Personajes;

public class Paladin extends Guerrero {
    protected int energiaSagrada;
    protected boolean escudoActivo;

    public Paladin() {
        super();
        this.escudoActivo = false;
    }

    public Paladin(String nombre, int nivel, int vida, int vidaMaxima, int ataque, int defensa, int fuerza, int energiaSagrada) {
        super(nombre, nivel, vida, vidaMaxima, ataque, defensa, fuerza);
        this.energiaSagrada = energiaSagrada;
        this.escudoActivo = false;
    }

    public int getEnergiaSagrada() {
        return energiaSagrada;
    }

    public void setEnergiaSagrada(int energiaSagrada) {
        this.energiaSagrada = energiaSagrada;
    }

    public boolean isEscudoActivo() {
        return escudoActivo;
    }

    public void activarEscudo() {
        if (!this.estaVivo()) {
            System.out.println(nombre + " está derrotado y no puede activar el escudo.");
            return;
        }
        this.escudoActivo = true;
        System.out.println(nombre + " (Paladín) activa su Escudo Sagrado (reducirá en 5 el próximo daño recibido).");
    }

    public void curar(Personaje objetivo) {
        if (!this.estaVivo()) {
            System.out.println(nombre + " está derrotado y no puede curar.");
            return;
        }
        if (energiaSagrada < 10) {
            System.out.println(nombre + " no tiene suficiente energía sagrada (requiere 10, tiene " + energiaSagrada + ").");
            return;
        }
        if (!objetivo.estaVivo()) {
            System.out.println(objetivo.getNombre() + " está derrotado y no puede ser curado.");
            return;
        }

        energiaSagrada -= 10;
        int vidaAnterior = objetivo.getVida();
        int nuevaVida = Math.min(objetivo.getVidaMaxima(), vidaAnterior + 20);
        objetivo.setVida(nuevaVida);
        int curacionReal = nuevaVida - vidaAnterior;
        System.out.println(nombre + " (Paladín) cura a " + objetivo.getNombre() + " por " + curacionReal + " puntos de vida. (Energía sagrada restante: " + energiaSagrada + ")");
    }

    @Override
    public void recibirDanio(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad de daño debe ser positiva.");
            return;
        }
        int cantidadAjustada = cantidad;
        if (escudoActivo) {
            cantidadAjustada = Math.max(0, cantidad - 5);
            System.out.println("¡El Escudo Sagrado de " + nombre + " absorbe parte del impacto!");
            escudoActivo = false;
        }
        super.recibirDanio(cantidadAjustada);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("----------------------------------------");
        System.out.println("Nombre: " + nombre + " (Paladín)");
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + vida + "/" + vidaMaxima);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Energía Sagrada: " + energiaSagrada);
        System.out.println("Escudo activo: " + (escudoActivo ? "Sí" : "No"));
        System.out.println("Estado: " + (estaVivo() ? "Vivo" : "Derrotado"));
        System.out.println("----------------------------------------");
    }
}