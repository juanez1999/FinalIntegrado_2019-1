package perezbravoquevedomarmolejo;


import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Main extends PApplet implements Observer{
	
	private static Comunicacion com;
	
	public static void main(String[] args) {
		PApplet.main("main.Main");
		com= new Comunicacion();
		Thread t = new Thread(com);
		t.start();
	}
	
	
	public void settings() {
		size(1200,700);
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String notificacion = (String) arg1;
		System.out.println(notificacion);
	}

}
