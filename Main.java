public class Main {
    public static void main(String[] args) {
        // 4.1 Declarar una lista
        ListaLigada lista = new ListaLigada();
        
        // 4.2 Imprimir como se ve la lista
        System.out.println(lista); 
        
        // 4.3 Insertar 5 elementos
        lista.insertar(8);
        lista.insertar(15);
        lista.insertar(30);
        lista.insertar(76);
        lista.insertar(167);
        
        // 4.4 Imprimir como se ve la lista
        System.out.println(lista); 
        
        // 4.5 Eliminar la cabeza
        lista.eliminar(10);
        
        // 4.6 Imprimir como se ve la lista
        System.out.println(lista); 
        // 4.7 Eliminar un elemento que no sea la cabeza ni el elemento final
        lista.eliminar(30);
        
        // 4.8 Imprimir como se ve la lista
        System.out.println(lista); 
        
        // Puntos extras:
        // Insertar un elemento en un índice que no sea 0 y que sea válido
        lista.insertarIndice(25, 1);
        System.out.println(lista); 
        
        // Insertar un elemento en un índice que no sea válido
        lista.insertarIndice(100, 10); // No debería hacer nada
        System.out.println(lista); 
    }
}