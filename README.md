 ESFOT RPG: La Batalla de los ReinosPrototipo de videojuego de rol (RPG) por consola desarrollado en Java para aplicar los fundamentos de la Programación Orientada a Objetos (POO). Permite crear distintos tipos de héroes, consultar sus estadísticas, usar habilidades especiales y simular combates por turnos.📂 Estructura del ProyectoESFOT-RPG/
├── src/
│   ├── Personajes/
│   │   ├── Personaje.java
│   │   ├── Guerrero.java
│   │   ├── Mago.java
│   │   ├── Arquero.java
│   │   └── Paladin.java
│   └── Juego/
│       ├── Gestor.java
│       └── Main.java
└── README.md
Diagrama de Clases (UML)classDiagram
    Personaje <|-- Guerrero
    Personaje <|-- Mago
    Personaje <|-- Arquero
    Guerrero <|-- Paladin

    class Personaje {
        #String nombre
        #int nivel
        #int vida
        #int vidaMaxima
        #int ataque
        #int defensa
        +atacar(Personaje enemigo) void
        +atacar(Personaje enemigo, int bonificacion) void
        +recibirDanio(int cantidad) void
        +estaVivo() boolean
        +mostrarInformacion() void
    }
    class Guerrero {
        #int fuerza
        +atacar(Personaje enemigo) void
    }
    class Mago {
        #int mana
        +lanzarHechizo(Personaje enemigo) void
    }
    class Arquero {
        #int flechas
        +dispararFlecha(Personaje enemigo) void
    }
    class Paladin {
        #int energiaSagrada
        #boolean escudoActivo
        +curar(Personaje objetivo) void
        +activarEscudo() void
    }
Respuestas a las Preguntas de Análisis

1. ¿Dónde se aplica herencia simple en el proyecto?**  
Se aplica  cuando una clase hija hereda de una única clase padre, por ejemplo: `Guerrero extends Personaje`, `Mago extends Personaje` o `Arquero extends Personaje`.

2. ¿Por qué `Personaje → Guerrero → Paladin` representa herencia multinivel?**  
Porque existe una cadena de herencia de más de dos niveles: `Paladin` hereda de `Guerrero`, y a su vez `Guerrero` hereda de `Personaje`. De este modo, el Paladín obtiene tanto los atributos básicos de un Personaje como la fuerza de un Guerrero.

3. ¿Qué relación ejemplifica herencia jerárquica?**  
La relación donde múltiples clases derivan de una misma clase base común. En este caso, `Guerrero`, `Mago` y `Arquero` heredan directamente de `Personaje`.

4. ¿Cuál es la diferencia entre sobrescritura y sobrecarga de `atacar()`?**  
* **Sobrecarga:** Existen dos métodos llamados `atacar` en la misma clase (`Personaje`), pero con diferentes parámetros (`atacar(Personaje)` y `atacar(Personaje, int)`).
* **Sobrescritura (`@Override`):** La clase hija (`Guerrero`) redefine el comportamiento exacto del método `atacar(Personaje)` heredado de la clase padre para sumar su atributo `fuerza` al daño.

5. ¿Qué aporta `super` en constructores y métodos?**  
En los constructores, `super()` permite inicializar los atributos heredados de la clase padre sin repetir código. En los métodos (como `super.mostrarInformacion()` o `super.recibirDanio()`), permite reutilizar la lógica base del padre y complementarla con la lógica específica de la clase hija.

6. ¿Por qué `List<Personaje>` admite guerreros, magos, arqueros y paladines?**  
Gracias al **polimorfismo** y al principio de sustitución ("es un"): como todas estas subclases heredan de `Personaje`, cualquier objeto de ellas es considerado también un `Personaje` y puede almacenarse en la misma lista.

7. ¿Qué versión de `mostrarInformacion()` se ejecuta al recorrer la lista y por qué?**  
Se ejecuta la versión sobrescrita correspondiente al tipo real del objeto instanciado en memoria (enlace dinámico o *dynamic binding*), aunque la referencia en el ciclo `for` sea de tipo genérico `Personaje`.

8. ¿Cuándo se necesita `instanceof` antes de hacer casting?**  
Se necesita cuando tenemos una referencia general (como `Personaje`) y queremos invocar un método exclusivo de una subclase (como `lanzarHechizo()` de `Mago` o `curar()` de `Paladin`). `instanceof` verifica de forma segura que el objeto pertenece a esa clase antes de convertirlo, evitando errores en tiempo de ejecución (`ClassCastException`).

9. ¿Qué ventaja aporta `HashMap` para localizar un personaje por nombre?**  
Permite realizar búsquedas directas e instantáneas  utilizando el nombre como clave única, sin necesidad de recorrer toda la lista elemento por elemento, además de facilitar la validación de nombres duplicados con `containsKey()`.

10. ¿Cómo se protege la consistencia de los atributos mediante encapsulamiento?**  
Restringiendo el acceso directo a los atributos (usando modificadores como `protected` o `private`) y controlando su lectura y modificación a través de *getters* y *setters* con validaciones (por ejemplo, evitar que la vida sea menor a 0, que supere `vidaMaxima` o que existan ataques negativos).
