
public class Familia {
	/**
	 * Atributos
	 */
	private CartaPersonaje[] familia; //array de los personajes de la familia del jugador
	private String nombreFamilia;
	/**
	 * Constructor que asigna la familia escogida por el jugador a la familia del objeto
	 */
	
	public Familia(String nombreFamilia,CartaPersonaje[] familia){
		
		this.nombreFamilia = nombreFamilia;
		this.familia = familia;
	}
	
	public String getNombreFamilia(){
		return nombreFamilia;
	}
	
	public boolean estadoFamilia(){
		
		for(int i = 0;i < 5;i++){
			
			if(!familia[i].isEstaMuerto()){ //si el personaje no esta muerto(false)
				return false;//devuelve que la familia aun no está muerta
			}
		}
		return true;//la familia esta muerta
	}
	
	/*
	 * Calcula la puntuación total de la familia
	 */
	public int puntuacion(){
		
		int puntuacion = 0;
		
		for(int i = 0;i < familia.length;i++){
			
			if(familia[i].isEstaMuerto()){
				
				puntuacion += familia[i].getTotalAutoestima();
				
			}
			
		}
		
		return puntuacion;
	}
	
	
	
	/*
	 * Comprueba que el personaje seleccionado pertenece a la familia
	 */
	
	public boolean estaPersonaje(String nombre){
		
		for(int i = 0;i < 5;i++){	
			if(familia[i].getNombre().equals(nombre)){
				
				return true;
				
			}
		}
		
		return false;
		
	}
	
	/*
	 * Devuelve la carta Personaje, se comprueba fuera de la clase que el personaje que está
	 */
	
	public CartaPersonaje getPersonaje(String nombre){
		
		int i = 0;
		
		while(i < 5 && !familia[i].getNombre().equals(nombre)){
			i++;
		}
		
		return familia[i];
		
	}
	
	
	
	public String toString(){
		
		String toret = "";
		
		toret += "Familia " + getNombreFamilia() + ": \n";
		
		for(int i = 0; i < 5; i++){
			
			toret += familia[i].toString() + "\n";
			
		}
		return toret;
	}
	
	
	
}
