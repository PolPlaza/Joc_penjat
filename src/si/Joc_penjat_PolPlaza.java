package si;

import java.util.Random;
import java.util.Scanner;

public class Joc_penjat_PolPlaza {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
        Random random = new Random();
        
        // Variables del juego
        String[] nomJugadores;
        int cantJugadores;
        
     // Normas del juego
        System.out.println("Bienvenido al juego del colgado");
        System.out.println("\nA continuacion las normas del juego:");
        System.out.println("El juego comienza pidiendo al administrador (un jugador) que elija una palabra secreta, la cual debe ser oculta durante el juego."
        		+ "Cada jugador tiene que adivinar una letra de la palabra secreta en cada ronda."
        		+ "El numero maximo de intentos por jugador es 6."
        		+ "Si un jugador adivina correctamente una letra, esta se revela en su posici√≥n en la palabra secreta."
        		+ "Si un jugador se queda sin intentos, pierde la ronda."
        		+ "El jugador que adivine toda la palabra primero o quien gane mas rondas sera el ganador.");
        
        // AÒadimos el numero de jugadores
        System.out.println("\nCuantos jugadores son: (Maximo 5)");
        cantJugadores = s.nextInt();
		
	}

}
