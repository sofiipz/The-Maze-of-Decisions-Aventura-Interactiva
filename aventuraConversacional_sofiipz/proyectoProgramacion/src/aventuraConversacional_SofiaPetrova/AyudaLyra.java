package aventuraConversacional_SofiaPetrova;
import java.util.Scanner;
public class AyudaLyra {

    private Scanner entrada;
    private int opcion;

    public AyudaLyra() {
        this.entrada = new Scanner(System.in);
    }

    public void elegirOpcion() {
        System.out.println();
        System.out.println("1) Sobre direcciones.");
        System.out.println("2) Sobre la exploración. ");
        int opcion = entrada.nextInt();

        if (opcion == 1) {
            mostrarPistaDirecciones();
        } else if (opcion == 2) {
            mostrarPistaExploracion();
        } else {
            System.out.println();
            System.out.println("E R R O R: Respuesta no válida.");
        }
    }

    public void mostrarPistaDirecciones() {
        System.out.println();
        System.out.println("Sobre direcciones: Si quieres hallar el camino correcto, recuerda:");
        System.out.println("al Este el sol sale, pero al Oeste se esconden los tesoros.");
        System.out.println("El número que te puede salvar está entre el 300 y el 400. Utiliza bien esta información.");
        
    }

    public void mostrarPistaExploracion() {
        System.out.println();
        System.out.println("Sobre la exploración: Cuidado con las puertas cerradas, a menudo ocultan");
        System.out.println("lo que más deseas. Pero solo el que es valiente podrá atravesarlas.");
        System.out.println("El número que te puede salvar es el 367. Utilízalo bien.");
        
    }

    
}
