package interfaces;

import interfaces.interfaces.ClickBoton;

public class Main {
	
	public void argumentos(String...strings) {
		int longitud = strings.length;
		System.out.println("Longitud: "+longitud);
	}
	
	public void hagoCosas(ClickBoton boton) {
		
		for (int i = 0; i < 10000; i++) {
			continue;
		}
		
		int contador = boton.getContador();
		boton.click();
	}

	public static void main(String[] args) {

		ClickBoton boton = new ClickBoton() {
			
			int acumulador = 0;
			
			@Override
			public int getContador() {
				return acumulador;
			}
			
			@Override
			public void click() {
				acumulador++;
				System.out.println("Clickado");
			}
		};

		for (int i = 0; i < 1500; i++) {
			boton.click();
			int contador = boton.getContador();
			
			
			String fecha = "%d-%d-%d - %d:%d.%d";
			String msgF = String.format(fecha, 3, 10, 22, 11,36, 0);
			System.out.println(msgF);
			
			String format = "Clicks %d";
			String msg = String.format(format, contador);
			System.out.println(msg);
		} 
		
		Main main = new Main();
		main.hagoCosas(boton);
		
		main.argumentos("", "","","","", "","");
		
		
		Tragaperras maquina = new Tragaperras();
		maquina.pulsado01();
		maquina.pulsado02();
		maquina.pulsadoPalanca();
		
		int contado = maquina.getContador();
		maquina.click();
		
		ClickBoton btn = maquina;
		btn = maquina.boton01;
		btn = maquina.boton02;
		
		btn = new ClickBoton() {
			
			@Override
			public int getContador() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void click() {
				// TODO Auto-generated method stub
				
			}
		};
		
	};
	
	

}
