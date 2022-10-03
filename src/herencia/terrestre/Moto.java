package herencia.terrestre;

public class Moto extends Terrestre {

	public int ruedas = 2;
	

	public boolean moverMe() {
		this.arrancar();	
		System.out.println("Manillar y Palanca. A Rodar");
		
		return true;
	} 
	
}
