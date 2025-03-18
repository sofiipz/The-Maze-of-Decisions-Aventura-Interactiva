package aventuraConversacional_SofiaPetrova;
import java.util.Random;
import java.util.Scanner;
public class JuegoDeDados implements Minijuego {

    private Scanner entrada;
    
    public JuegoDeDados() {
        this.entrada = new Scanner(System.in);
    }

    @Override
    public void iniciar() {
        
        System.out.println();
        System.out.println("¡Has elegido bien!");
        System.out.println("Estas son las instrucciones del juego: debes elegir un número entre el 1 y el 6, si el número de Elara es mayor, pierdes.");
        System.out.println("Pero si tu número es mayor al de Elara, ganas y te da una pista para encontrar la salida del laberinto.");
        System.out.println();
        System.out.println("El juego inicia.");
        System.out.print("Debes elegir un número entre el 1 y el 6: ");
        int numeroJugador = entrada.nextInt();

        if (numeroJugador < 1 || numeroJugador > 6) { //el número que ingrese el jugador tiene que estar entre el 1 y 6, si no, dará error
            System.out.println("E R R O R: respuesta no válida.");
            return;
        } else {
            Random random = new Random();
            int numeroElara = random.nextInt(6) + 1;
            System.out.println("El número de Elara es: " + numeroElara);
            System.out.println();
            
            if (numeroJugador == numeroElara) {
                System.out.println("E M P A T E");
                
            } else if (numeroJugador > numeroElara) {
                System.out.println("¡H A S   G A N A D O!");
                System.out.println();
                System.out.println("Elara te dará la pista: el número que te puede salvar la vida es el 367.");
                System.out.println();
                System.out.println("Elara: ¡Buen viaje! Espero que puedas salir del laberinto.");
                
            } else {
                System.out.println("H A S   P E R D I D O");
                System.out.println("Suerte en tu búsqueda de la salida.");
            }
        } 
    }
}
