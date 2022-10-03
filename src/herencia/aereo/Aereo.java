package herencia.aereo;


import herencia.Vehiculo;

public abstract class Aereo extends Vehiculo {

	public boolean estaVolando() {
		return true;
	}
	
	public void aVolar() {
		System.out.println("Puedo Vuelar");
	}
	
	public void aterrizar() {
		System.out.println("A ver si me acuerdo como va esto");
	}
}
