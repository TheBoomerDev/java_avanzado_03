package interfaces;

import interfaces.interfaces.ClickBoton;

public class Tragaperras implements ClickBoton {
	
	public ClickBoton boton01;
	public ClickBoton boton02;
	
	private int total = 0;
	
	public Tragaperras(){
		
		this.boton01 = new ClickBoton() {
			
			int acc = 0;
			
			@Override
			public int getContador() {
				return acc;
			}
			
			@Override
			public void click() {
				acc++;
				total = total + acc;
				System.out.println("Click-01 => "+acc);
				 
			}
		};
		
		this.boton02 = new ClickBoton() {
			
			int acc = 0;
			
			@Override
			public int getContador() {
				return acc;
			}
			
			@Override
			public void click() {
				acc++;
				total++;
				System.out.println("Click-01 => "+acc);
			}
		};
		
	}

	
	public void pulsado01 () {
		this.boton01.click();
	}
	
	public void pulsado02 () {
		this.boton02.click();
	}
	
	public void pulsadoPalanca () {
		this.boton01.click();
		this.boton02.click();
	} 

	@Override
	public void click() {
		if (total%2 == 0) {
			System.out.println("Hay Premio");
		}else {
			System.out.println("NO Hay Premio");
		}
	}


	@Override
	public int getContador() { 
		return total;
	}
}
