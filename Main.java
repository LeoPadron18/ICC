/**
 * Clase Main que ejecuta la clase Recipiente.java
 * Proyecto 01 ICC
 * Ramirez padron Angel Leonardo 321291389
 */

public class Main {
    public static void main(String[] args) {
        // Crear dos recipientes
        Recipiente recipiente1 = new Recipiente(23, 9, 0);
        Recipiente recipiente2 = new Recipiente(23, 9, 0);

        // Mostrar información inicial de los recipientes
        System.out.println("Recipiente 1: " + recipiente1.muestra());
        System.out.println("Recipiente 2: " + recipiente2.muestra());

        // Rellenar el recipiente 1 con 280 cm cubicos
        System.out.println("Rellenando recipiente 1 con 500 cm CUBICOS");
        double excedente = recipiente1.rellena(280);
        System.out.println("Excedente: " + excedente);
        System.out.println("Recipiente 1: " + recipiente1.muestra());

        // Vaciar el recipiente 1
        System.out.println("Vaciando eL Primer recipiente");
        double cantidadVaciada = recipiente1.vacia();
        System.out.println("Cantidad vaciada: " + cantidadVaciada);
        System.out.println("Recipiente 1: " + recipiente1.muestra());

        // Rellenar el recipiente 1 con 143 cm cubicos
        System.out.println("Rellenando recipiente 1 con 143 cm cubicos");
        excedente = recipiente1.rellena(200);
        System.out.println("Excedente: " + excedente);
        System.out.println("Recipiente 1: " + recipiente1.muestra());

        // Vierte el contenido del recipiente 1 al 2do recipiente
        System.out.println("Vertiendo contenido del 1er al 2d9 recipiente");
        recipiente1.vierte(recipiente2);
        System.out.println("Recipiente 1: " + recipiente1.muestra());
        System.out.println("Recipiente 2: " + recipiente2.muestra());

        // Compara sus dimen siones y cantidades (Que contiene mas)
        System.out.println("¿Tienen las mismas dimensiones? " + recipiente1.mismasDimensiones(recipiente2));
        System.out.println("¿Tienen la misma capacidad? " + recipiente1.mismaCapacidad(recipiente2));
        System.out.println("¿Contiene más el recipiente 1 que el 2? " + recipiente1.contieneMas(recipiente2));
        System.out.println("¿Cabe más en el recipiente 1 que en el 2? " + recipiente1.cabeMas(recipiente2));

        // Crea un nuevo recipiente, partiendo del 1er recipiente 
        System.out.println("Creando un contenedor justo a partir del recipiente 1...");
        Recipiente recipiente3 = recipiente1.creaContenedorJusto();
        System.out.println("Recipiente 3: " + recipiente3.muestra());
    }
}