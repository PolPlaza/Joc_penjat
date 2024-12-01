package si;

import java.util.Random;
import java.util.Scanner;

public class Joc_penjat_PolPlaza {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
        Random random = new Random();
        
        // Variables del juego
        String[] nomJugadores; //Array para almacenar los nombres de los jugadores
        int cantJugadores; //Variable para guardar el número de jugadores
        int[] vidas; //Array para almacenar las vidas de cada jugador en cada ronda
        int[] victorias; //Array para almacenar cuántas rondas ha ganado cada jugador
        int rondas; //Variable para definir cuántas rondas se jugaran
        String palabraSec; //Variable para almacenar la palabra secreta

        
     // Normas del juego
        System.out.println("Bienvenido al juego del colgado");
        System.out.println("\nA continuacion las normas del juego:");
        System.out.println("El juego comienza pidiendo al administrador (un jugador) que elija una palabra secreta, la cual debe ser oculta durante el juego."
        		+ "Cada jugador tiene que adivinar una letra de la palabra secreta en cada ronda."
        		+ "El numero maximo de intentos por jugador es 6."
        		+ "Si un jugador adivina correctamente una letra, esta se revela en su posiciÃ³n en la palabra secreta."
        		+ "Si un jugador se queda sin intentos, pierde la ronda."
        		+ "El jugador que adivine toda la palabra primero o quien gane mas rondas sera el ganador.");
        
        // Añadimos el numero de jugadores
        System.out.println("\nCuantos jugadores son: (Maximo 5)");
        cantJugadores = s.nextInt();
        
        // Validamos que haya entre 2 y 5 jugadores
        while (cantJugadores < 2 || cantJugadores > 5) {
            System.out.println("Minimo dos jugadores, maximo cinco jugadores.");
            System.out.println("Cuantos jugadores son?");
            cantJugadores = s.nextInt();
        }

        // Inicializamos las variables de jugadores, vidas y victorias
        nomJugadores = new String[cantJugadores];
        vidas = new int[cantJugadores];
        victorias = new int[cantJugadores];

        // Introducimos los nombres de los jugadores
        for (int i = 0; i < cantJugadores; i++) {
            System.out.println("Nombre del jugador " + (i + 1) + ":");
            nomJugadores[i] = s.next();
        }

        // Mostramos los nombres de los jugadores
        System.out.println("\nLos jugadores son:");
        for (int i = 0; i < cantJugadores; i++) {
            System.out.println(nomJugadores[i]);
        }
        
        // Preguntamos las rondas que se jugaran
        System.out.println("Â¿Cuantas rondas quieres jugar?");
        rondas = s.nextInt();

        // Ciclo principal para las rondas del juego
        for (int ronda = 1; ronda <= rondas; ronda++) {
            System.out.println("\n** Ronda " + ronda + " **");
        }
        
        // Se elige un jugador al azar para que elija la palabra secreta
        int jugadorPalabra = random.nextInt(cantJugadores);
        System.out.println("El jugador " + nomJugadores[jugadorPalabra] + " elige la palabra secreta.");
        System.out.println("Jugador " + nomJugadores[jugadorPalabra] + ", ingresa la palabra secreta (sin mostrarla a los demas):");
        palabraSec = s.next();  // La palabra secreta

        // Inicializamos las vidas para cada jugador en esta ronda
        for (int j = 0; j < cantJugadores; j++) {
            vidas[j] = 6;  // Cada jugador comienza con 6 vidas
        }
        
	}

}
