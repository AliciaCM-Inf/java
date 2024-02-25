import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tres en Raya ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Crear una instancia de tu panel de juego y agregarlo al frame
        TresEnRayaPanel panel = new TresEnRayaPanel();
        frame.getContentPane().add(panel);
        // Establecer un tamaño específico 
        frame.setSize(650, 650);
        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Crear un JLabel para mostrar el mensaje en la parte inferior
        JLabel mensajeLabel = new JLabel("Alicia Campo Miron");
        
        // Centrar el JLabel en la parte inferior usando FlowLayout
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.add(mensajeLabel);
        frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
