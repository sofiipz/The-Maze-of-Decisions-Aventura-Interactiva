package aventuraConversacional_SofiaPetrova;

import java.util.Scanner;

public class JuegoDePuertas implements Minijuego {

    private Scanner entrada;

    public JuegoDePuertas() {
        this.entrada = new Scanner(System.in);
    }

    @Override
    public void iniciar() {
        System.out.println("¡Bienvenido al Juego de las Puertas!");
        System.out.println();
        System.out.println("Unas flechas luminosas aparecen en el suelo, te señalan seguir hacia delante.");
        System.out.println("Las sigues sin pensar en los peligros a los que puede llevarte, pero sabiendo que tienes");
        System.out.println("que salir de una vez por todas de este oscuro laberinto.");
        System.out.println("Cuando las flechas se detienen, llegas a 4 puertas, cada una con un número.");
        System.out.println("Un papel misterioso aparece en tu visión, y sin pensarlo, lo agarras para ver qué es.");
        System.out.println();
        System.out.println("Debes elegir el número de una puerta. Tu camino solo depende de ti, así que elige bien.");
        System.out.println("Si eliges la puerta incorrecta, tienes que volver por donde has venido, pero si eliges la correcta,");
        System.out.println("podrás seguir adelante sin interrupciones.");
        System.out.println();
        System.out.print("Así que, ¿cuál es tu decisión? ¿1, 2, 3 o 4?: ");

        int puertaIntento = entrada.nextInt();
        int puertaCorrecta = 2;
        
        System.out.println();
        if (puertaIntento < 1 || puertaIntento > 4) {
            System.out.println("E R R O R: Respuesta no válida.");
            return;
        } else if (puertaIntento == puertaCorrecta) {
            System.out.println("¡Buena elección! Puedes seguir adelante.");
            System.out.println("La puerta número 2 se abre, dejándote ver el siguiente cruce.");
            System.out.println("Decide qué harás ahora:");
            
        } else {
            System.out.println("Mala elección. La puerta correcta era la segunda.");
            System.out.println("Debes volver por donde has venido.");
            System.out.println("Así que vuelves sobre tus pasos, pensando en la siguiente opción.");
            //vuelta al menú principal
        }
    }
    
}
