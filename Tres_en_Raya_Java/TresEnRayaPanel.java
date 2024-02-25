import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TresEnRayaPanel extends JPanel {

    private char[][] tablero;
    private char jugadorActual;

    private ImageIcon imagenX;
    private ImageIcon imagenO;

    public TresEnRayaPanel() {
        tablero = new char[3][3];
        jugadorActual = 'X';
        // Inicializar el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Cargar imágenes para X y O
        imagenX = new ImageIcon("Equis.png");
        imagenO = new ImageIcon("Circulo.png");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = e.getY() / (getHeight() / 3);
                int columna = e.getX() / (getWidth() / 3);

                if (tablero[fila][columna] == ' ') {
                    tablero[fila][columna] = jugadorActual;
                    repaint();

                    if (hayGanador()) {
                        mostrarResultado("¡Jugador " + jugadorActual + " ha ganado!");
                        reiniciarJuego();
                    } else if (empate()) {
                        mostrarResultado("¡Empate!");
                        reiniciarJuego();
                    } else {
                        cambiarTurno();
                    }
                }
            }
        });
    }

    private void cambiarTurno() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
    private void mostrarResultado(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
    private boolean hayGanador() {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (sonIguales(i, 0, i, 1, i, 2)) {
                return true;
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (sonIguales(0, j, 1, j, 2, j)) {
                return true;
            }
        }

        // Verificar diagonales
        if (sonIguales(0, 0, 1, 1, 2, 2)) {
            return true;
        }

        if (sonIguales(0, 2, 1, 1, 2, 0)) {
            return true;
        }

        return false;
    }

    private boolean sonIguales(int fila1, int columna1, int fila2, int columna2, int fila3, int columna3) {
        return (tablero[fila1][columna1] == tablero[fila2][columna2]
                && tablero[fila2][columna2] == tablero[fila3][columna3]
                && tablero[fila1][columna1] != ' ');
    }

    private boolean empate() {
        // Verificar si hay algún espacio vacío en el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    // Todavía hay espacios vacíos, el juego no ha terminado
                    return false;
                }
            }
        }

        // Si no hay espacios vacíos, el juego está empatado
        return true;
    }

    private void reiniciarJuego() {
        // Reiniciar el tablero y el turno del jugador
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
        jugadorActual = 'X';
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el tablero y las fichas
        int cellWidth = getWidth() / 3;
        int cellHeight = getHeight() / 3;

        // Dibujar líneas del tablero
        for (int i = 1; i < 3; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
            g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
        }

        // Dibujar fichas centradas en las celdas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = j * cellWidth + cellWidth / 2 - imagenX.getIconWidth() / 2;
                int y = i * cellHeight + cellHeight / 2 - imagenX.getIconHeight() / 2;

                if (tablero[i][j] == 'X') {
                    imagenX.paintIcon(this, g, x, y);
                } else if (tablero[i][j] == 'O') {
                    imagenO.paintIcon(this, g, x, y);
                }
            }
        }
    }
}