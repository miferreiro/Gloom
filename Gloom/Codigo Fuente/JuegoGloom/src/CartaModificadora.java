
public class CartaModificadora {
	
	/**
	 * Atributos
	 */
	private boolean esMuerte; //si es carta modificadora o de muerte
	private int puntosAlto;
	private int puntosMedio;
	private int puntosBajo;
	
	public CartaModificadora(boolean esMuerte, int puntosAlto, int puntosMedio, int puntosBajo) {

		this.esMuerte = esMuerte;
		this.puntosAlto = puntosAlto;
		this.puntosMedio = puntosMedio;
		this.puntosBajo = puntosBajo;
		
	}
	
	public boolean isEsMuerte() {
		return esMuerte;
	}

	public int getPuntosAlto() {
		return puntosAlto;
	}

	public int getPuntosMedio() {
		return puntosMedio;
	}

	public int getPuntosBajo() {
		return puntosBajo;
	}

	public String toString(){
		
		String toret = "";
		
		if(isEsMuerte()){
			toret += "Carta de muerte prematura: ";
		}else{
			toret += "Carta modificadora: ";
		}
		
		toret += " PA: ";
		
		if(getPuntosAlto() == - 1){
			toret += "0";
		}else{
			if(getPuntosAlto() == 0){
				toret += " ";
			}else{
				toret += getPuntosAlto();
			}
		}
		 toret += " PM: ";
		 
		 if(getPuntosMedio() == - 1){
				toret += "0";
			}else{
				if(getPuntosMedio() == 0){
					toret += " ";
				}else{
					toret += getPuntosMedio();
				}
			}
		 
		 
		 toret += " PB: ";
		
		 if(getPuntosBajo() == - 1){
				toret += "0";
			}else{
				if(getPuntosBajo() == 0){
					toret += " ";
				}else{
					toret += getPuntosBajo();
				}
			}
		toret += "\n"; 
		return toret;
		
	}
	
	
	
	
	

}
