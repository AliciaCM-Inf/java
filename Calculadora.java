import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        // Declaramos las variables que almacenarán los números ingresados por el usuario
        int num1, num2;

        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitamos al usuario que ingrese el primer número
        System.out.println("Ingrese el primer número:");
        num1 = scanner.nextInt();

        // Solicitamos al usuario que ingrese el segundo número
        System.out.println("Ingrese el segundo número:");
        num2 = scanner.nextInt();

        // Realizamos las operaciones matemáticas básicas
        int suma = num1 + num2;
        int resta = num1 - num2;
        int multiplicacion = num1 * num2;
        float division = (float) num1 / num2;

        // Mostramos los resultados
        System.out.println("La suma de los números es: " + suma);
        System.out.println("La resta de los números es: " + resta);
        System.out.println("La multiplicación de los números es: " + multiplicacion);
        System.out.println("La división de los números es: " + division);
    }
}
