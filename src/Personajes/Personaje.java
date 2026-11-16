package Personajes;

public class Personaje {
    protected String nombre;
    protected int nivel;
    protected int vida;
    protected int vidaMaxima;
    protected int ataque;
    protected int defensa;

    public Personaje() {
    }

    public Personaje(String nombre, int nivel, int vida, int vidaMaxima, int ataque, int defensa) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vida = Math.min(vida, vidaMaxima);
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel > 0) {
            this.nivel = nivel;
        }
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = Math.max(0, Math.min(vida, vidaMaxima));
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        if (vidaMaxima > 0) {
            this.vidaMaxima = vidaMaxima;
            if (this.vida > this.vidaMaxima) {
                this.vida = this.vidaMaxima;
            }
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque >= 0) {
            this.ataque = ataque;
        }
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        if (defensa >= 0) {
            this.defensa = defensa;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDanio(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad de daño debe ser positiva.");
        } else {
            int danioReal = Math.max(1, cantidad - defensa);
            vida = Math.max(0, vida - danioReal);
            System.out.println(nombre + " recibe " + danioReal + " de daño efectivo. Vida restante: " + vida + "/" + vidaMaxima);
        }
    }

    public void atacar(Personaje enemigo) {
        if (!this.estaVivo()) {
            System.out.println(nombre + " está derrotado y no puede atacar.");
            return;
        }
        if (!enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " ya está derrotado.");
            return;
        }
        System.out.println(nombre + " ataca normalmente a " + enemigo.getNombre() + ".");
        enemigo.recibirDanio(this.ataque);
    }

    // Sobrecarga de método atacar con bonificación
    public void atacar(Personaje enemigo, int bonificacion) {
        if (!this.estaVivo()) {
            System.out.println(nombre + " está derrotado y no puede atacar.");
            return;
        }
        if (!enemigo.estaVivo()) {
            System.out.println(enemigo.getNombre() + " ya está derrotado.");
            return;
        }
        System.out.println(nombre + " ataca con bonificación a " + enemigo.getNombre() + ".");
        enemigo.recibirDanio(this.ataque + bonificacion);
    }

    public void mostrarInformacion() {
        System.out.println("----------------------------------------");
        System.out.println("Nombre: " + nombre + " (" + this.getClass().getSimpleName() + ")");
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + vida + "/" + vidaMaxima);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Estado: " + (estaVivo() ? "Vivo" : "Derrotado"));
    }
}
