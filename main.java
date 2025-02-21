// practica 1 Introduccion a las Ciencias de la Computacion
// Alumno: Ramikrez Padron Angel Leonardo
// Calculadora Basica

import java.util.Scanner;
public class main {
    public static void main (String args[]){
        //atributos
        int opcion;
        double numeroUno, numeroDos, resultado;

        System.out.println("Calculadora Basica, por favor selecciona tus opciones");
        System.out.println("1 -> Suma");
        System.out.println("2 -> Resta");
        System.out.println("3 -> Multiplicacion");
        System.out.println("4 -> Division");
        Scanner scanner = new Scanner(System.in);

        opcion = scanner.nextInt();


        if (opcion == 1){
          System.out.println("Ingresa el primer número que quieras sumar ");  

          numeroUno = scanner.nextDouble();

          System.out.println("Ahora ingresa el segundo número");

          numeroDos = scanner.nextDouble();

          resultado = numeroUno + numeroDos;

          System.out.println("El resultado es: " + resultado);
        }

        if (opcion == 2){
            System.out.println("Ingresa el primer número que quieras Restar ");  
  
            numeroUno = scanner.nextDouble();
  
            System.out.println("Ahora ingresa el segundo número");
  
            numeroDos = scanner.nextDouble();
  
            resultado = numeroUno - numeroDos;
            if(numeroUno < numeroDos){
                System.out.println("Lo sentimos, pero esta operacion no se puede realizar");
            }else{
  
            System.out.println("El resultado es: " + resultado);
          }
        }
          if (opcion == 3){
            System.out.println("Ingresa el primer número que quieras multiplicar ");  
  
            numeroUno = scanner.nextDouble();
  
            System.out.println("Ahora ingresa el segundo número");
  
            numeroDos = scanner.nextDouble();
  
            resultado = numeroUno * numeroDos;
  
            System.out.println("El resultado es: " + resultado);
          }
          if (opcion == 4){
            System.out.println("Ingresa el primer número que quieras dividir ");  
  
            numeroUno = scanner.nextDouble();
  
            System.out.println("Ahora ingresa el segundo número");
  
            numeroDos = scanner.nextDouble();
  
            resultado = numeroUno / numeroDos;
            if(numeroUno < numeroDos){
                System.out.println("Lo siento, esta operacion no se puede hacer");
            } else{
  
            System.out.println("El resultado es: " + resultado);
          }
          scanner.close();
        }
        }



    }
