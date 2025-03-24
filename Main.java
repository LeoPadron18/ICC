/**
 * Metodo Main para la clase Reloj
 * Angel Leonardo Ramirez Padron
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\nMenú del Reloj");
            System.out.println("1. Simular reloj con ciclo for");
            System.out.println("2. Simular reloj con ciclo while");
            System.out.println("3. Simular reloj con ciclo do-while");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    simularConFor();
                    break;
                case 2:
                    simularConWhile();
                    break;
                case 3:
                    simularConDoWhile();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
        
        scanner.close();
    }
    
    private static void simularConFor() {
        System.out.println("\nSimulación con ciclo for (5 iteraciones):");
        Reloj reloj = new Reloj(23, 59, 55);
        
        for (int i = 0; i < 5; i++) {
            System.out.println(reloj.getHoraFormateada());
            reloj.incrementar();
        }
    }
    
    private static void simularConWhile() {
        System.out.println("\nSimulación con ciclo while (hasta medianoche):");
        Reloj reloj = new Reloj(23, 59, 58);
        
        while (reloj.getHoras() != 0 || reloj.getMinutos() != 0 || reloj.getSegundos() != 0) {
            System.out.println(reloj.getHoraFormateada());
            reloj.incrementar();
        }
        System.out.println(reloj.getHoraFormateada()); // Mostrar 00:00:00
    }
    
    private static void simularConDoWhile() {
        System.out.println("\nSimulación con ciclo do-while (5 iteraciones):");
        Reloj reloj = new Reloj(12, 59, 58);
        int contador = 0;
        
        do {
            System.out.println(reloj.getHoraFormateada());
            reloj.incrementar();
            contador++;
        } while (contador < 5);
    }
}
