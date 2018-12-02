
public class Mano {
	
	/**
	 * Atributos
	 */
	
	private CartaModificadora[] mano; //conjunto de cartas modificadoras que tiene
	private int numCartas; //numero de cartas que tiene el jugador en la mano
	
	/**
	 * Constructor
	 */
	
	public Mano(){
		
		mano = new CartaModificadora[5];
		numCartas = 0;
		for(int i = 0; i < 5;i++){
			cogerCartaMazo();	
		}
	}
	
	/**
	 * Métodos
	 */
	
	public int getNumCartas(){
		return numCartas;
	}
	public CartaModificadora getCarta(int posicion){
		
		return mano[posicion];
	}
	/*
	 * Se saca una carta de la mano, el control de que la carta no esté en la mano se realiza fuera de la clase
	 */
	public void sacaCartaMano(CartaModificadora carta){
		
		int i = 0;
		
		while(i < 5 && mano[i] != carta){
			i++;
		}
	
		mano[i] = null;
		numCartas--;
		
	}
	
	//coger una carta del mazo y ponerla en la mano
	public void cogerCartaMazo(){
		
		int contador = 0;
		
		while(contador < 5 && mano[contador] != null){
			contador++;
		}
	
		
		if(contador == 5){	

			System.out.println("No puedes introducir nuevas cartas");
			
		}else{
		
			mano[contador] = Mazo.repartirCarta();
			numCartas++;
		}
		
		
		
		
	}
	
	//Devuelve la información de las cartas que posee el jugador en la mano
	public String toString(){
		
		String toret = "";
		
		for(int i = 0;i < mano.length;i++){
			
			if(mano[i] != null){
				
				toret += (i + 1) + ": " + mano[i].toString();
			}
			
		}
		
		return toret;
	}
	
	

}
