package aventuraConversacional_SofiaPetrova;

import java.util.Scanner;

public class JuegoDeAdivinanza implements Minijuego {

    private Scanner entrada;
    private Juego juego;

    public JuegoDeAdivinanza(Juego juego) {
        this.entrada = new Scanner(System.in);
        this.juego = juego;
    }

    @Override
    public void iniciar() {

        System.out.println("Lira: Buena elección. Estas son las instrucciones: como ya te he dicho, tienes que adivinar un número entre");
        System.out.println("el 1 y el 500. Si no lo aciertas, te diré si es mayor o menor que el correcto. Para eso, tienes 5 intentos.");
        System.out.println("El juego comienza ahora.");
        
        //juego de adivinanza
        final int NUMERO_CORRECTO = 367; //el número es una constante (si no se pone final, puede tener error de compilación)
        int intentos = 0;
        int numeroIntento = 0;
        
        boolean juegoTerminado = false; //variable para después poder salir del bucle principal
        
        do {
            System.out.print("Ingresa el número en el que estás pensando: ");
            numeroIntento = entrada.nextInt();
            intentos++;
            
            if (NUMERO_CORRECTO > numeroIntento) {
                System.out.println("El número que buscas es mayor.");
                
            }else if (NUMERO_CORRECTO < numeroIntento) {
                System.out.println("El número que buscas es menor");
            }
            
            if (NUMERO_CORRECTO == numeroIntento) { //fin de juego
                System.out.println();
                System.out.println("¡Has desvelado el secreto! La puerta está abierta ante ti. Adelante, cruza y descubre tu destino.");
                System.out.println("Enhorabuena, has ganado. Has terminado 'The Maze of Decisions' con " + juego.getDiamantes() + " diamantes.");
                System.out.println();
                System.out.println("G R A C I A S   P O R   J U G A R");
                juegoTerminado = true; //para poder salir del bucle while principal
                break;
                
            } else if (intentos == 5) {
                System.out.println("El eco del destino aún no ha resonado a tu favor. Debes regresar y prepararte para otro intento.");
                System.out.println("¡Mucha suerte! Nos volveremos a ver");
                break;
            }
        } while (NUMERO_CORRECTO != numeroIntento);
        
        if (juegoTerminado) {
            juego.terminarJuego();
        }
        

        //fin juego de adivinanza
    }
}
