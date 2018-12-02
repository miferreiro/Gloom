
public class CartaPersonaje {
	
	/**
	 * Atributos
	 */
	
	private boolean estaMuerto;
	private int puntosAlto;
	private int puntosMedio;
	private int puntosBajo;
	private String nombre;
	private CartaModificadora[] cartasModificadoras;
	private int numCartMod;
	
	/**
	 * Constructor
	 * 
	 */
	
	public CartaPersonaje(String nombre){
		
		this.nombre = nombre;
		puntosAlto = 0;
		puntosMedio = 0;
		puntosBajo = 0;
		estaMuerto = false;
		cartasModificadoras = new CartaModificadora[59];
		numCartMod = 0;
		
	}
	/**
	 * Observadores
	 * 
	 */
	public boolean isEstaMuerto() {
		return estaMuerto;
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
	public String getNombre() {
		return nombre;
	}	
	
	public int getTotalAutoestima(){
		
		return getPuntosAlto() + getPuntosMedio() + getPuntosBajo();
		
	}
	/**
	 * Modificadores
	 */
		
	
	public void setEstaMuerto(boolean estaMuerto) {
		this.estaMuerto = estaMuerto;
	}
	public void setPuntosAlto(int puntosAlto) {
		this.puntosAlto = puntosAlto;
	}
	public void setPuntosMedio(int puntosMedio) {
		this.puntosMedio = puntosMedio;
	}
	public void setPuntosBajo(int puntosBajo) {
		this.puntosBajo = puntosBajo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void setCartaModificadora(CartaModificadora carta){
		
		cartasModificadoras [numCartMod] = carta;
		numCartMod++;
			
	}
	
	public String toString(){
		
		String toret = "";
		
		toret += getNombre() + "(Muerto: " + isEstaMuerto() + ") " + " PA: " + getPuntosAlto() 
				+ " PM: " + getPuntosMedio() + " PB: " + getPuntosBajo();
		
		return toret;
	}
	
	
}
