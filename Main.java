import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Esteganografia estego = new Esteganografia();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcion(scanner);
            
            if (opcion == 6) break;
            
            switch (opcion) {
                case 1:
                    ejecutarCifradoNuloConN(estego, scanner);
                    break;
                case 2:
                    ejecutarCifradoNuloConEspacios(estego, scanner);
                    break;
                case 3:
                    ejecutarBuscarNombre(estego, scanner);
                    break;
                case 4:
                    ejecutarPalabrasMarcadas(estego, scanner);
                    break;
                case 5:
                    ejecutarLetrasMarcadas(estego, scanner);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            
            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine(); // Esperar entrada del usuario
        }
        
        scanner.close();
        System.out.println("Programa terminado.");
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== PROYECTO ESTEGANOGRAFÍA ===");
        System.out.println("1. Cifrado nulo con n específico");
        System.out.println("2. Cifrado nulo con espacios finales");
        System.out.println("3. Buscar nombre oculto");
        System.out.println("4. Descifrar palabras marcadas");
        System.out.println("5. Descifrar letras marcadas");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private static int obtenerOpcion(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Ingrese un número (1-6): ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    private static void ejecutarCifradoNuloConN(Esteganografia estego, Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el mensaje original: ");
        String original = scanner.nextLine();
        System.out.print("Ingrese el valor de n (comenzando en 0): ");
        int n = scanner.nextInt();
        System.out.println("\nResultado: " + estego.descifraNulo(original, n));
    }
    
    private static void ejecutarCifradoNuloConEspacios(Esteganografia estego, Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el mensaje con espacios al final: ");
        String original = scanner.nextLine();
        System.out.println("\nResultado: " + estego.descifraNulo(original));
    }
    
    private static void ejecutarBuscarNombre(Esteganografia estego, Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el texto donde buscar: ");
        String mensaje = scanner.nextLine();
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = scanner.nextLine();
        boolean encontrado = estego.contieneNombre(mensaje, nombre);
        System.out.println("\nResultado: El nombre " + (encontrado ? "SÍ" : "NO") + " está oculto");
    }
    
    private static void ejecutarPalabrasMarcadas(Esteganografia estego, Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el mensaje M: ");
        String m = scanner.nextLine();
        System.out.print("Ingrese el mensaje E: ");
        String e = scanner.nextLine();
        System.out.println("\nResultado: " + estego.descifraPalabrasMarcadas(m, e));
    }
    
    private static void ejecutarLetrasMarcadas(Esteganografia estego, Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el mensaje M: ");
        String m = scanner.nextLine();
        System.out.print("Ingrese el mensaje E: ");
        String e = scanner.nextLine();
        System.out.println("\nResultado: " + estego.descifraLetrasMarcadas(m, e));
    }
}