package aventuraConversacional_SofiaPetrova;

import java.util.Random;
import java.util.Scanner;

public class JuegoTresEnRaya implements Minijuego{

    private Scanner entrada;
    private char[][] tablero;
    private char jugador;
    private char maquina;
    private boolean ganador; // para ver si hay un ganador

    public JuegoTresEnRaya() {
        this.tablero = new char[3][3];
        this.jugador = 'X';
        this.maquina = 'O'; // La Cazadora de Sombras
        this.ganador = false;
        this.entrada = new Scanner(System.in);
    }

    @Override
    public void iniciar() {
        System.out.println("Si ganas a La Cazadora de Sombras, ella te podrá dar información muy valiosa.");
        System.out.println("Ten cuidado, como ya te he dicho, puede ser muy mentirosa. Disfruta viendo sufrir a los demás.");
        System.out.println("Y ahora, inicia el juego.");
        System.out.println();
        boolean turnoJugador = true;
        
        while (!ganador) {
            mostrarTablero();
            if (turnoJugador) {
                hacerMovimientoJugador(entrada);
            } else {
                hacerMovimientoMaquina();
            }
            turnoJugador = !turnoJugador;
            verificarGanador();
        }
    }

    private void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] == '\0' ? "-" : tablero[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void hacerMovimientoJugador(Scanner entrada) {
        System.out.println("Haz tu movimiento (fila y columna entre 1 y 3): ");
        int fila = entrada.nextInt() - 1;
        int col = entrada.nextInt() - 1;
        if (tablero[fila][col] == '\0') {
            tablero[fila][col] = jugador;
        } else {
            System.out.println("Espacio ocupado, intenta de nuevo.");
            hacerMovimientoJugador(entrada);
        }
    }

    private void hacerMovimientoMaquina() {
        Random random = new Random();
        int fila, col;
        do {
            fila = random.nextInt(3);
            col = random.nextInt(3);
        } while (tablero[fila][col] != '\0');
        tablero[fila][col] = maquina;
        System.out.println("La máquina hizo su movimiento.");
    }

    private void verificarGanador() {
        // verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] != '\0' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) ||
                (tablero[0][i] != '\0' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i])) {
                ganador = true;
                
                if (tablero[i][i] == jugador) {
                    System.out.println("¡Felicidades! Has ganado a La Cazadora de Sombras.");
                    System.out.println("Como has ganado, te debe una pista: Debes seguir el camino hacia el Oeste.");
                    System.out.println("El número que te puede salvar está entre el 300 y el 400. Utiliza bien esta información.");
                    System.out.println();
                } else {
                    System.out.println("Ha ganado La Cazadora de Sombras.");
                }
                return;
            }
        }
        if ((tablero[0][0] != '\0' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) ||
            (tablero[0][2] != '\0' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0])) {
            ganador = true;
            
            if (tablero[1][1] == jugador) {
                System.out.println("¡Felicidades! Has ganado a La Cazadora de Sombras.");
                System.out.println("Como has ganado, te debe una pista: Debes seguir el camino hacia el Oeste.");
                System.out.println("El número que te puede salvar está entre el 300 y el 400. Utiliza bien esta información.");
                System.out.println();
            } else {
                System.out.println("Ha ganado La Cazadora de Sombras.");
            }
            return;
        }
    
        // si hay empate
        boolean empate = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '\0') { // si hay alguna casilla vacía
                    empate = false;
                    break;
                }
            }
            if (!empate) break;
        }
    
        if (empate) {
            System.out.println("¡Es un empate! Debes volver a elegir una dirección."); //vuelta al menú principal
        }
    }
    
    
    
}
