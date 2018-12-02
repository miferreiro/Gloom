
public class Jugador {
	
	/**
	 * Atributos
	 */
	private String nombre; //Nombre del jugador
	private Familia familia; //Familia escogida por el jugador 
	private Mano mano;//Cartas que el jugador tiene en la mano
	
	/**
	 * Constructor
	 */
	
	public Jugador(String nombre, Familia familia, Mano mano) {

		this.nombre = nombre;
		this.familia = familia;
		this.mano = mano;
	}


	/**
	 * Observadores
	 */
	
	public String getNombre() {
		return nombre;
	}


	public Familia getFamilia() {
		return familia;
	}
	
	public Mano getMano(){
		return mano;
	}
	
	public CartaModificadora escogerCarta(int carta){
		return getMano().getCarta(carta);
	}
	
	public void cogerCarta(){
		
		getMano().cogerCartaMazo();
		
	}
	
	public void sacarCarta(CartaModificadora cartaNueva){
		getMano().sacaCartaMano(cartaNueva);
	}

	@Override
	public String toString() {
		return "Nombre = " + getNombre() + "\nFamilia " + getFamilia() + "\n" +getMano() ;
	}
	
	

}
