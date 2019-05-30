package perezbravoquevedomarmolejo;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet implements Observer{
	
	private static Comunicacion com;
	private ArrayList<PImage> imagenes;
	private int variablePintar;
	
	public static void main(String[] args) {
		PApplet.main("Main");
		com= new Comunicacion();
		Thread t = new Thread(com);
		t.start();
	}
	
	
	public void settings() {
		size(1200,700);
	}
	
	public void setup() {
		imagenes = new ArrayList<PImage>();
	}
	
	public void draw() {
		background(255);
		for (int i = 0; i < imagenes.size(); i++) {
			if(variablePintar==1) {
				
			}
		}
	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String notificacion = (String) arg1;
		System.out.println(notificacion);
		
		if(notificacion.equals("EjemploContinuidad")) {
			variablePintar=1;
		}
	}

}
