package herencia;

import herencia.acuatico.Acuatico;
import herencia.acuatico.Barco;
import herencia.acuatico.BarcoVela;
import herencia.aereo.Avion;
import herencia.interfaces.Motor;
import herencia.terrestre.Coche;
import herencia.terrestre.Moto;
import herencia.terrestre.Terrestre;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


public class main {

	public static void main(String[] args) {
		
		Coche car = new Coche(4, 5);
		Moto moto = new Moto();
		Avion avion = new Avion();
		Barco barco = new Barco();
		BarcoVela barcoVela = new BarcoVela();



		

		// No Se Puede por ser abstract
		// Vehiculo veh = new Vehiculo(); 
		
		// Donde Necesito un Vehiculo Terrestre
		Terrestre tCar = car;
		Terrestre tMoto = moto;
		// No hereda de Terrestre
		// Terrestre tAvion = avion;
		
		int puertas = car.getNumeroPuertas();
		int ruedass = car.getRuedas();
		
		// ruedas = moto.ruedas;
		
		// Vehiculo
		car.moverMe();
		moto.moverMe();
		
		// Terrestre
		boolean tieneR1 = car.tieneRuedas;
		boolean tieneR2 = moto.tieneRuedas;
		tieneR1 = tCar.tieneRuedas;
		tieneR2 = tMoto.tieneRuedas;
		
		Vehiculo veh = (Vehiculo) car;
		veh = moto;
		veh = avion;
		
		veh.seMueve();
		
		// Interfaces
		Acuatico acuatico = barco;
		
		acuatico.potencia();
		barco.potencia();
		
		Terrestre terre = car;
		Motor conMotor = acuatico;
		conMotor = barco;
		conMotor = car;
		// Puede Falla, si el terre no lo tiene. 
		conMotor = (Motor) moto;
		boolean isType = terre instanceof Motor;
		String nombreClase = terre.getClass().getName();
		 
		conMotor = new Motor() {

			@Override
			public void arrancar() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int potencia() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void setPotencia(int potencia) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		ArrayList<String> nombres = new ArrayList<String>();
		LinkedList<String> nombres02 = new LinkedList<String>();
		// FIFO -> First IN FIrst Out
		Vector<String> nombres03 = new Vector<String>();
		// LIFO -> LAst IN First Out
		// Pilas -> Heap
		
		List<String> lista = nombres;
		lista = nombres02;
		lista = nombres03;
		
		lista.get( lista.size()-1 );
		lista.isEmpty();
		lista.add("");
		lista.clear();
		lista.size();
		lista.iterator(); // Importante
		
		nombres02.element(); 
		
		

	}

}
