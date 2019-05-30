package perezbravoquevedomarmolejo;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet implements Observer{
	
	private static Comunicacion ref;
	private PImage[] imagenes;
	private int variablePintar;
	
	public static void main(String[] args) {
		PApplet.main("perezbravoquevedomarmolejo.Main");
	}
	
	
	public void settings() {
		size(1200,700);
	}
	
	public void setup() {
		ref = Comunicacion.getRef();
		imagenes = new PImage[5];
		
		
	}
	
	public void draw() {
		
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
