public class ListaLigada {
    private Nodo cabeza;
    private int tamano;

    // Constructor
    public ListaLigada() {
        this.cabeza = null;
        this.tamano = 0;
    }

    // Método para insertar al final
    public void insertar(int elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamano++;
    }

    // Método para eliminar un elemento
    public void eliminar(int elemento) {
        if (cabeza == null) return; // Lista vacía
        
        // Caso 1: Eliminar la cabeza
        if (cabeza.elemento == elemento) {
            cabeza = cabeza.siguiente;
            tamano--;
            return;
        }
        
        // Caso 2 y 3: Eliminar elemento intermedio o final
        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;
        
        while (actual != null) {
            if (actual.elemento == elemento) {
                anterior.siguiente = actual.siguiente;
                tamano--;
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    // Método toString
    @Override
    public String toString() {
        if (cabeza == null) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        Nodo actual = cabeza;
        
        while (actual != null) {
            sb.append(actual.elemento);
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }

    // Método para insertar en índice (punto extra)
    public void insertarIndice(int elemento, int indice) {
        if (indice < 0 || indice > tamano) return; // Índice inválido
        
        Nodo nuevoNodo = new Nodo(elemento);
        
        // Insertar al inicio
        if (indice == 0) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            // Insertar en medio o al final
            Nodo actual = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
        tamano++;
    }

    // Método para obtener el tamaño
    public int getTamano() {
        return tamano;
    }
}