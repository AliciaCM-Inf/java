import java.util.Scanner;

public class ContadorPalabras {

    public static void main(String[] args) {

        // Solicitamos al usuario que introduzca el texto
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un texto: ");
        String texto = sc.nextLine();

        // Eliminamos los espacios iniciales y finales del texto
        texto = texto.trim();

        // Contamos el número de palabras del texto
        int numPalabras = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ') {
                numPalabras++;
            }
        }

        // Contamos el número de caracteres del texto
        int numCaracteres = 0;
        for (int i = 0; i < texto.length(); i++) {
            numCaracteres++;
        }

        // Imprimimos el resultado
        System.out.println("El texto contiene " + numPalabras + " palabras y " + numCaracteres + " caracteres.");
    }
}
