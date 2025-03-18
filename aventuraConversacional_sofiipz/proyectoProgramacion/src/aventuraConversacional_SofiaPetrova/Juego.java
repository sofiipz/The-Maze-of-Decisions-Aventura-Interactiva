package aventuraConversacional_SofiaPetrova;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    private Scanner entrada;
    private Random random;
    private int diamantes;
    private boolean juegoTerminado;

    public Juego() {
        this.entrada = new Scanner(System.in);
        this.random = new Random();
        this.diamantes = 0;
        this.juegoTerminado = false;
    }

    public void iniciar() {
        System.out.println("B I E N V E N I D O / A     A     'T H E   M A Z E   O F   D E C I S I O N S'");
        System.out.println();
        System.out.println("Despiertas en un laberinto oscuro sin recordar cómo has llegado aquí.");
        System.out.println("El aire es frío y húmedo, y el eco de pasos lejanos resuena en los pasillos...");
        System.out.println("Tu misión es encontrar la salida y conseguir los máximos diamantes.");

        int decision = 0;
        while (decision != 5 && !juegoTerminado) {
            mostrarMenu();
            decision = entrada.nextInt();
            entrada.nextLine();

            switch (decision) {
                case 1:
                    elegirDireccion();
                    break;
                case 2:
                    mostrarDiamantes();
                    break;
                case 3:
                    pedirAyuda();
                    break;
                case 4:
                    descansar();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Saliendo del juego...."); //fin del juego
                    System.out.println();
                    System.out.println("G R A C I A S   P O R   J U G A R");
                    juegoTerminado = true; 
                    break;
                default:
                    System.out.println();
                    System.out.println("E R R O R: Respuesta no válida.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("1) Elegir dirección.");
        System.out.println("2) Ver la cantidad de diamantes recolectados.");
        System.out.println("3) Pedir ayuda.");
        System.out.println("4) Descansar.");
        System.out.println("5) Salir del juego.");
        System.out.print("Ingresa el número de la opción deseada y presiona 'Enter': ");
    }

    private void elegirDireccion() {
        System.out.print("Elege dirección (N, S, E, O): ");
        String direccion = entrada.nextLine().toUpperCase();
        
        switch (direccion) {
            case "N": //juego tres en raya
                norte();
                break;
            case "S": //+1 diamante
                sur();
                break;
            case "E": //juego de las puertas
                este();
                break;
            case "O": //adivinanza + minijuego con la Guardiana
                oeste();
                break;
            default:
                System.out.println("E R R O R: Respuesta no válida.");
        }
    }

    private void norte() {
        System.out.println();
		System.out.println("Avanzas por el camino al Norte, las antorchas parpadean y el aire se hace más denso... ");
		System.out.println("De frente te encuentras a una mujer que se hace llamar 'La Cazadora de Sombras'. ");
		System.out.println("Te ofrece información sobre el laberinto y sus posibles salidas. ");
		System.out.println("¡Atención! Se la conoce por ser muy mentirosa, así que no te fíes de sus palabras.");
		System.out.println();
        System.out.print("¿Deseas conocer esa información? (S/N): ");
        String infoCazadora = entrada.nextLine().toUpperCase();
        if (infoCazadora.equals("S")) {
            JuegoTresEnRaya tresEnRaya = new JuegoTresEnRaya();
            tresEnRaya.iniciar();
        } else if (infoCazadora.equals("N")) { //vuelta al menú principal
            System.out.println("Debes elegir otra dirección.");
        } else {
            System.out.println("E R R O R: Respuesta no válida."); 
        }
    }

    private void sur() {
        System.out.println();
		System.out.println("Avanzas por el camino iluminado por antorchas.");
		System.out.println("Después de pasar por un túnel, te encuentras un diamante.");
		diamantes++; 
    }

    private void este() {
        System.out.println();
		System.out.println("Sigues el camino al Este, donde una puerta alta y misteriosa te detiene.");
		System.out.println("Dentro, las paredes están cubiertas de espejos que reflejan tus movimientos.");
        System.out.print("¿Deseas jugar al Juego de las Puertas Misteriosas? (S/N): ");
        String juegoPuertas = entrada.nextLine().toUpperCase();
        
        if (juegoPuertas.equals("S")) {
            JuegoDePuertas juegoDePuertas = new JuegoDePuertas();
            juegoDePuertas.iniciar();
        } else if (juegoPuertas.equals("N")) {
            System.out.println("Tienes que cambiar de camino.");
            //vuelta al menú principal
            
        } else {
            System.out.println("E R R O R: Respuesta no válida.");
        }
    }

    private void oeste() {
        System.out.println();
        System.out.println("Avanzas por el camino iluminado por antorchas. En una de las paredes del laberinto,");
        System.out.println("te encuentras unas palabras que te pueden ayudar a encontrar el camino:");
        System.out.println();
        System.out.println("Soy pequeño y brillante, en la tierra estoy.");
        System.out.println("Si me encuentras a mí, feliz serás hoy.");
        System.out.println();
        System.out.println("Cuando intentas coger una antorcha para ver mejor el mensaje de la pared, el ambiente cambia.");
        System.out.println("Las pocas luces que hay, empiezan a parpadear y un eco suave de melodías suena en el aire.");
        System.out.println();
        System.out.println("Al fondo, una majestuosa puerta, cubierta con marcas antiguas, Lira, la Musa del Destino te observa.");
        System.out.println();
        System.out.println("Lira: Has llegado al sitio más importante del laberinto. Te invito a adivinar un número entre el  1 y el 500.");
        System.out.print("Solo tienes 5 intentos, así que, aprovecha bien tus oportunidades. ¿Deseas jugar? (S/N): ");
        
        String adivinarNumero = entrada.nextLine().toUpperCase();
						
        if (adivinarNumero.equals("S")) {
            JuegoDeAdivinanza adivinanza = new JuegoDeAdivinanza(this);
            adivinanza.iniciar();
        } else if (adivinarNumero.equals("N")) {
            System.out.println("Lira: El eco del destino aún no ha resonado a tu favor. Debes regresar y prepararte para otro intento.");
            System.out.println("¡Suerte en tu viaje! Nos volveremos a ver.");
        } else {
            System.out.println("E R R O R: Respuesta no válida.");
        }
    }

    private void mostrarDiamantes() {
        System.out.println();
        System.out.println("Has elegido la opción de ver la cantidad de diamantes recolectados.");
        System.out.println();
        System.out.println("Diamantes: " + diamantes);
    }

    private void pedirAyuda() {
        System.out.println();
        System.out.println("Has pedido ayuda. Ahora puedes elegir llamar a: ");
        System.out.println();
        System.out.println("1) Elara, la Guardiana de la Sabiduría:  ");
        System.out.println("Fue una maga poderosa que descubrió los mejores secretos guardados del laberinto.");
        System.out.println("Puede darte información si ganas al Juego de Dados.");
        System.out.println();
        System.out.println("2)  Lyra, la Maestra del laberinto:");
        System.out.println("Conoce cada rincón del laberinto y sus secretos más oscuros. Ella se quedó atrapada ");
        System.out.println("aquí mismo mucho antes de que tú llegaras. Su misión inicial era escapar, ahora quiere ");
        System.out.println("ayudar a otros a hacerlo. Puede darte un pista, tú eliges cuál.");
        
        int opcion = -1; // primero inicializa con un valor no válido
        while (opcion != 1 && opcion != 2) { // solo 1 o 2 son números válidos
            System.out.print("Elige una opción (1 o 2): ");
            opcion = entrada.nextInt();
            entrada.nextLine(); 

            if (opcion == 1) { // ayuda de Elara, juego de dados
                JuegoDeDados juegoDeDados = new JuegoDeDados();
                juegoDeDados.iniciar();

            } else if (opcion == 2) { // pista exploración/dirección
                AyudaLyra ayudaLyra = new AyudaLyra();
                ayudaLyra.elegirOpcion();

            } else {
                System.out.println("E R R O R: Respuesta no válida. Por favor, elige 1 o 2.");
            }
        }
    }

    private void descansar() {
        System.out.println();
        System.out.println("Te sientas a descansar un momento.");
        System.out.println();
        System.out.println(".........................................................................................");
        System.out.println();
        System.out.println(".........................................................................................");
        System.out.println();
        System.out.println(".........................................................................................");
        System.out.println();
        System.out.println(".........................................................................................");
        System.out.println();
        System.out.println(".........................................................................................");
        System.out.println();
        System.out.println("¡Sorpresa! Has recargado tu energía, así que te has ganado un diamante.");
        diamantes++;
    }

    public void terminarJuego() {
        juegoTerminado = true;
    }

    
    public int getDiamantes() {
        return diamantes;
    }

    

    
}

