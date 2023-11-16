public class CuadradoAsteriscos {
    public static void main(String[] args) {
        System.out.println("Introduzca el tamaño del cuadrado: ");
        Scanner sc = new Scanner(System.in);
        int tamaño = sc.nextInt();
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
