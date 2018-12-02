

import java.util.Set;
import java.util.TreeSet;
public class Principal {

	// *********************************************************

	public static void main(String[] args) {

		System.out.println("\t----GLOOM-----");
		Mazo mazo = new Mazo();
		int numJugadores = 0;
		int turnoJugador = 0;
	
	
		do{
			
			numJugadores = ES.leeNum("Cuantos jugadores van a jugar: ");
			
			if(numJugadores < 2 || numJugadores > 4){
				
				System.out.println("Opcion incorrecta, solo se puede jugar de 2 a 4 personas");
			}
			
		}while(numJugadores < 2 || numJugadores > 4);
		
		//Se crean los jugadores
		Jugador[] jugadores = new Jugador[numJugadores];
		
		
		//Para no permitir que haya familias repetidas
		Set <Integer> escogidas = new TreeSet <Integer> ();
		
		for (int i = 0; i < jugadores.length; i++) {

			System.out.println("*********************************************************");

			// Se piden los datos del jugador
			jugadores[i] = principioJugador(i,escogidas);

			// Se imprime los datos del jugador, con las cartas que tiene en mano
			System.out.println(jugadores[i].toString());

		}

		do{

			System.out.println("*********************************************************");

			System.out.println("Turno del jugador: " + jugadores[turnoJugador].getNombre());

			turnoJugador(jugadores,turnoJugador);

			turnoJugador++;
			
			if (turnoJugador == jugadores.length){
				
				turnoJugador = 0;
				
			}
		}while (Mazo.getNumCartas() > 0 && !familiasViva(jugadores));
		
		mostrarGanador(jugadores);
	

	}
	/*
	 * Se comparan las puntuaciones de los jugadores y se muestra la tabla de puntuaciones
	 */
	public static void mostrarGanador(Jugador[] jugadores){
		
		Jugador[] puntuaciones = new Jugador[jugadores.length];
		Jugador aux = null;
		/*
		 * Copiamos el array de jugadores en puntuaciones para ordenarlo en función de las puntuaciones obtenidas
		 */
		for(int i = 0 ; i < jugadores.length;i++){
			puntuaciones[i] = jugadores[i];
			
		}
		
		
        for(int i = 0;i < puntuaciones.length - 1;i++){
        	
             for(int j = 0;j < puntuaciones.length - i - 1;j++){
            	 
                  if(puntuaciones[j+1].getFamilia().puntuacion() < puntuaciones[j].getFamilia().puntuacion()){
                	 
                	  aux = puntuaciones[j + 1];
                	  puntuaciones[j+1] = puntuaciones [j];
                	  puntuaciones [j] = aux;
                	  
                  }
             }
        }
        System.out.println("PUNTUACIONES");
        
        for(int i = 0;i < puntuaciones.length;i++){
        	
        	System.out.println(i + 1 + "º.- Nombre del jugador: " + puntuaciones[i].getNombre() + " Puntuacion ---> " + puntuaciones[i].getFamilia().puntuacion());
        	
        }
 
        
	}
	
	public static Jugador principioJugador(int i,Set <Integer> escogidas) {

		String nombre = "";
		int familiaEscogida = 0;
		boolean valido = false;
		
		System.out.println("Introduce tus datos Jugador " + (i + 1));

		// Se pide el nombre del jugador

		nombre = ES.pideCadena("Nombre: ");

		// Se muestra y se pide la familia elegida
	
		
			System.out.println("Las familias que puedes escoger son: ");
			System.out.println(FamiliasDelJuego.mostrarFamilia());
		
		do{

			valido = true;
			
	
			familiaEscogida = ES.leeNum("");
			
			if(escogidas.contains(familiaEscogida)){
				
				valido = true;
				
			}else{
				
				escogidas.add(familiaEscogida);
				valido = false;
				
			}
			
			if(familiaEscogida < 1 || familiaEscogida > 4){
				
				System.out.println("La familia escogida es incorrecta.");
				
			}
			if(valido){
				System.out.println("La familia escogida ya está cogida.");
			}
			
		}while(familiaEscogida < 1 || familiaEscogida > 4 || valido);
			
	
		

		// Se reparten las cartas

		

		// Se crea el jugador

		return new Jugador(nombre, FamiliasDelJuego.getFamilia(--familiaEscogida), new Mano());

	}
	/**
	 * Realiza las acciones del jugador en cada turno
	 * @param jugadores para permitir acceder a la información de los jugadores
	 * @param turnoJugador para saber a quien le toca jugar
	 */

	public static void turnoJugador(Jugador[] jugadores, int turnoJugador) {

		String opcion = "";
		CartaModificadora cartaEscogida = null;
		CartaPersonaje cartaJugador = null;
		int contadorTurno = 1;
		boolean valido = true;
		
		
	
		do {
			
			System.out.println(jugadores[turnoJugador].getFamilia());
			System.out.println(jugadores[turnoJugador].getMano().toString());
	
			System.out.println("Fase " + contadorTurno + " de " + jugadores[turnoJugador].getNombre());
	        System.out.println("Numero de cartas restantes en el mazo: " + Mazo.getNumCartas());
			opcion = ES.pideCadena("Puedes jugar cualquier carta(j) o pasar (cualquier tecla menos la j)");
	                    
	
			if (opcion.trim().toLowerCase().equals("j")) 
			{
				System.out.println("-----------------------------------------------------");		
				
				//Nos aseguramos que si todas las cartas son del tipo de muerte prematura y es el segundo turno, se tenga que pasar obligatoriamente
				
				for(int i = 0; i < jugadores[turnoJugador].getMano().getNumCartas(); i++){
					
					if(jugadores[turnoJugador].escogerCarta(i) != null && !jugadores[turnoJugador].escogerCarta(i).isEsMuerte()){
						valido = false;
					}
					
					
				}
				
				if(valido && contadorTurno == 2){
					
					System.out.println("No puedes aplicar ninguna carta ya que todas tus cartas son de muerte prematura y te encuentres en la 2º fase, pulse intro para continuar...");
					ES.pideCadena("");
				}else{
					/*
					 * Escoger carta modificadora que se va a usar
					 */
					do{
						/*
						 * Selecciona la carta Modificadora
						 */
						cartaEscogida = elegirCarta(contadorTurno,jugadores,turnoJugador);
						
						/*
						 * Escoger personaje al cual atacar
						 */
						cartaJugador = elegirPersonaje(jugadores,turnoJugador);
		
						/*
						 *  Seleccionar personaje y aplicar la carta, dependiendo de si es de muerte o no
						 */
						if (cartaEscogida.isEsMuerte()){
		
							/*
							 *  el personaje escogido tiene autoestima baja
							 */
							if (cartaJugador.getTotalAutoestima() >= 0) {
								
								System.out.println("No puedes matar a un personaje que no tiene la autoestima baja");
		
							}else{
								
								modificarPuntos(cartaEscogida,cartaJugador);
								jugadores[turnoJugador].sacarCarta(cartaEscogida);
								cartaJugador.setCartaModificadora(cartaEscogida);
								cartaJugador.setEstaMuerto(true);
								
							}
						}else{
					

							modificarPuntos(cartaEscogida,cartaJugador);
							
							jugadores[turnoJugador].sacarCarta(cartaEscogida);
							cartaJugador.setCartaModificadora(cartaEscogida);
						}		
						
				//Vuelve a escoger una carta, si antes ha escogida una carta de muerte y un personaje con la autoestima positiva
				}while(cartaEscogida.isEsMuerte() && cartaJugador.getTotalAutoestima() >= 0);	
					
				}
			}	
		
			contadorTurno++;
		
		}while (contadorTurno < 3 && !familiasViva(jugadores));
		
		/**
		 * Completar la mano del jugador
		 */

		while(jugadores[turnoJugador].getMano().getNumCartas() < 5){
		
			jugadores[turnoJugador].cogerCarta();
		
		}
		
	}
	
	/**
	 * Elegir una carta Modificadora
	 * @param contadorTurno para permitir escoger una de muerte o no
	 * @param jugadores y turnoJugador sirven para acceder al jugador que le toca
	 * @return la carta Modificadora escogida
	 */
	public static CartaModificadora elegirCarta(int contadorTurno,Jugador[] jugadores,int turnoJugador){
		
		int opcionNum = 0;
		
		do {

			opcionNum = ES.leeNum("Selecciona un carta: ");
			
			if (opcionNum < 1 || opcionNum > 5 
					|| jugadores[turnoJugador].escogerCarta(opcionNum - 1) == null
						||(contadorTurno == 2 && jugadores[turnoJugador].escogerCarta(opcionNum - 1).isEsMuerte())){
				
				System.out.println("Carta incorrecta, vuelva a intentarlo");
				
			}
			

		}while (opcionNum < 1 || opcionNum > 5 
				|| jugadores[turnoJugador].escogerCarta(opcionNum - 1) == null
					||(contadorTurno == 2 && jugadores[turnoJugador].escogerCarta(opcionNum - 1).isEsMuerte()) );

		return jugadores[turnoJugador].escogerCarta(opcionNum - 1);
	}
	/**
	 * Elegir una carta Personaje
	 * @param turnoJugador sirven para acceder a los jugadores
	 * @return la carta personaje escogida
	 */
	public static CartaPersonaje elegirPersonaje(Jugador[] jugadores,int turnoJugador){


		boolean valido = false;
		String opcion = "";
		CartaPersonaje carta = null;
		
		do{
			if(valido){
				
				System.out.println("El personaje selecionado es incorrecto,pruebe otra vez");
				
			}

			valido = true;
			System.out.println(mostrarEstadoFamilias(jugadores, turnoJugador));
			opcion = ES.pideCadena("Selecciona un personaje: ");

			/*
			 * Si el personaje introducido se encuentra entre las familias y está vivo
			 */
			

			for (int i = 0; i < jugadores.length ; i++) {

				if (jugadores[i].getFamilia().estaPersonaje(opcion)
						&& !jugadores[i].getFamilia().getPersonaje(opcion).isEstaMuerto()) {
					
					valido = false;
					carta = jugadores[i].getFamilia().getPersonaje(opcion);
					
				}

			}
			
		}while (valido);
		
		return carta;

	}
	
	
	/**
	 * Modificamos la carta del personaje escogido
	 * @param cartaEscogida la carta que indica los puntos que se aplican al personaje
	 * @param cartaJugador la carta personaje escogida por el jugador
	 */
	public static void modificarPuntos(CartaModificadora cartaEscogida,CartaPersonaje cartaJugador){

		// Se modifican los puntos altos

		if (cartaEscogida.getPuntosAlto() > 0 || cartaEscogida.getPuntosAlto() < -1){
			cartaJugador.setPuntosAlto(cartaEscogida.getPuntosAlto());
		} else {
			if (cartaEscogida.getPuntosAlto() == -1) {
				cartaJugador.setPuntosAlto(0);
			}
		}

		// Se modifican los puntos medio

		if (cartaEscogida.getPuntosMedio() > 0 || cartaEscogida.getPuntosMedio() < -1) {
			cartaJugador.setPuntosMedio(cartaEscogida.getPuntosMedio());
		} else {
			if (cartaEscogida.getPuntosMedio() == -1) {
				cartaJugador.setPuntosMedio(0);
			}
		}

		// Se mofican los puntos medios

		if (cartaEscogida.getPuntosBajo() > 0 || cartaEscogida.getPuntosBajo() < -1) {
			cartaEscogida.getPuntosBajo();
		} else {
			if (cartaEscogida.getPuntosBajo() == -1) {
				cartaJugador.setPuntosBajo(0);
			}
		}

	}
	
	
	/*
	 * Comprueba si alguna familia ha muerto
	 */
	
	public static boolean familiasViva(Jugador[] jugadores) {

		for (int i = 0; i < jugadores.length; i++) {

			if (jugadores[i].getFamilia().estadoFamilia()) { 
															
				return true;// devuelve que una familia ya está muerta, por lo que el juego terminaría
			}
		}
		return false;// las familias  aun no están muertas
	}
	
	/*
	 * Muestra todas las familias
	 */
	public static String mostrarEstadoFamilias(Jugador[] jugadores, int turnoJugador) {

		String toret = "";

		for (int i = 0; i < jugadores.length; i++) {
			
				toret += "\nFamilia de: " + jugadores[i].getNombre() + "\n";
				toret += jugadores[i].getFamilia();
		}
		return toret;
	}

}
