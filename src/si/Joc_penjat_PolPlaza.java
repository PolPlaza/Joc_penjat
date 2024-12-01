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
        System.out.println("El juego comienza pidiendo al administrador (un jugador) que elija una palabra secreta, la cual debe ser oculta durante el juego,"
        		+ "cada jugador tiene que adivinar una letra de la palabra secreta en cada ronda.");
        System.out.println("El numero maximo de intentos por jugador es 6.\""
        		+ "Si un jugador adivina correctamente una letra, esta se revela en su posicion en la palabra secreta.");
        System.out.println("Si un jugador se queda sin intentos, pierde la ronda.");
        System.out.println("El jugador que adivine toda la palabra primero o quien gane mas rondas sera el ganador.");
        
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
            System.out.println("Nombre del jugador: " + (i + 1));
            nomJugadores[i] = s.next();
        }

        // Mostramos los nombres de los jugadores
        System.out.println("\nLos jugadores son:");
        for (int i = 0; i < cantJugadores; i++) {
            System.out.println(nomJugadores[i]);
        }
        
        // Preguntamos las rondas que se jugaran
        System.out.println("¿Cuantas rondas quieres jugar?");
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
        
        // Comenzamos la ronda, la palabra secreta es oculta por guiones bajos
        char[] palabraMostrada = new char[palabraSec.length()];
        for (int i = 0; i < palabraSec.length(); i++) {
            palabraMostrada[i] = '_'; // Inicializamos el array con guiones bajos
        }

        // Cada jugador intentara adivinar una letra en esta ronda
        boolean palabraAdivinada = false;
        while (!palabraAdivinada) {
            for (int i = 0; i < cantJugadores; i++) {
                if (vidas[i] > 0 && i != jugadorPalabra) { // Solo los jugadores con vidas restantes y que no son el que eligiÃ³ la palabra participan
                    System.out.println("\nTurno de " + nomJugadores[i]);
                    System.out.println("Palabra secreta actual: " + new String(palabraMostrada)); // Convertimos char[] a String
                    System.out.println("Tienes " + vidas[i] + " intentos restantes.");
                    System.out.print("Ingresa una letra: ");
                    char letra = s.next().charAt(0);
                    
                    
                    // Comprobamos si la letra es correcta
                    boolean acierto = false;
                    for (int j = 0; j < palabraSec.length(); j++) {
                        if (palabraSec.charAt(j) == letra && palabraMostrada[j] == '_') {
                            palabraMostrada[j] = letra; // Actualizamos la palabra mostrada
                            acierto = true;
                        }
                    }

                    // Si no se acierta, restamos una vida
                    if (!acierto) {
                        vidas[i]--;
                        System.out.println("Letra incorrecta");
                    } else {
                        System.out.println("Letra correcta");
                        
                    // Si un jugador se queda sin vidas, pierde la ronda
                    if (vidas[i] == 0) {
                        System.out.println("Te has quedado sin vidas, " + nomJugadores[i] + "");
                        }
                        
                    // Comprobamos si la palabra ha sido adivinada
                    if (new String(palabraMostrada).equals(palabraSec)) {
                    	System.out.println("\n" + nomJugadores[i] + " ha adivinado la palabra secreta");
                          victorias[i]++;
                          palabraAdivinada = true;
                          	break; // Terminamos la ronda
                        }

                    }
                }
            }
        }
        
        
        
	}

}
