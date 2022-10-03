package herencia.acuatico;


import herencia.Vehiculo;
import herencia.interfaces.Motor;

public abstract class Acuatico extends Vehiculo implements Motor {
	
	public final boolean puedeFlotar = true;
	private int potenciaMotor = 0;
	
	public void arrancar() {
		System.out.println("Arrancamos Motor");
	}

	public int potencia() {
		return this.potenciaMotor;
	}
	
	public void setPotencia(int potencia) {
		this.potenciaMotor = potencia;
	}
	
}
