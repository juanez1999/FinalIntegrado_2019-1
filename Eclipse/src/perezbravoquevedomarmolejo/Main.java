package perezbravoquevedomarmolejo;

import java.util.Observable;
import java.util.Observer;

import gifAnimation.*;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet implements Observer{
	
	private static Comunicacion ref;
	private PImage imagen;
	private PImage[] respuesta;
	private Gif[] gifs;
	private int variablePintar;
	private boolean correcto;
	
	public static void main(String[] args) {
		PApplet.main("perezbravoquevedomarmolejo.Main");
	}
	
	
	public void settings() {
		size(1200,700);
	}
	
	public void setup() {
		ref = Comunicacion.getRef();
		ref.addObserver(this);
		gifs = new Gif[4];
		
		imagen = loadImage("imagen0.png");
		
		respuesta = new PImage[2];
		for(int i = 0; i < respuesta.length; i++) {
			respuesta[i] = loadImage("imagen"+(i+1)+".png");
		}
		
		gifs[0] = new Gif(this, "gif0.gif");
		gifs[1] = new Gif(this, "gif1.gif");
		gifs[2] = new Gif(this, "gif2.gif");
		gifs[3] = new Gif(this, "gif3.gif");
	}
	
	public void draw() {
		switch(variablePintar) {
			case 0:
				image(imagen, 0, 0);
				break;
				
			case 1:
				if(!gifs[0].isPlaying()) {
					gifs[0].play();
				}
				image(gifs[0], 0, 0);
				break;
				
			case 2:
				if(!gifs[1].isPlaying()) {
					gifs[1].play();
				}
				image(gifs[1], 0, 0);
				break;
				
			case 3:
				if(!gifs[2].isPlaying()) {
					gifs[2].play();
				}
				image(gifs[2], 0, 0);
				break;
				
			case 4:
				if(!gifs[3].isPlaying()) {
					gifs[3].play();
				}
				image(gifs[3], 0, 0);
				break;
				
			case 5:
				if(!gifs[3].isPlaying()) {
					gifs[3].play();
				}
				image(gifs[3], 0, 0);
				imageMode(CENTER);
				if(correcto) {
					image(respuesta[0], width/2, height/2);
				} else {
					image(respuesta[1], width/2, height/2);
				}
				imageMode(CORNER);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String msg = (String) arg1;
		System.out.println(msg);
		
		if(msg.matches("EjemploForma")) {
			variablePintar = 3;
		} else if(msg.matches("EjemploTamano")) {
			variablePintar = 1;
		} else if(msg.matches("EjemploColor")) {
			variablePintar = 2;
		} else if(msg.matches("Continuar")) {
			variablePintar = 4;
		}
		
		if(variablePintar == 4) {
			if(msg.matches("Tamano")) {
				variablePintar = 5;
				correcto = true;
				ref.enviar("Correcto");
			} else if(msg.matches("Color") || msg.matches("Forma")){
				variablePintar = 5;
				correcto = false;
				ref.enviar("Incorrecto");
			}
			
		}
	}

}
