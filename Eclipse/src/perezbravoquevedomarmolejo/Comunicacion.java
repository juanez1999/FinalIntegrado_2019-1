package perezbravoquevedomarmolejo;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;

public class Comunicacion extends Observable implements Runnable{

	DatagramSocket socket;
    InetAddress address;
	boolean conectado;


	public Comunicacion() {
		conectado = false;

	}

	@Override
	public void run() {
		while (true) {
			if (!conectado) {
				try {
					//Se dice a que socket se realizara la comunicacion
					socket = new DatagramSocket(5000);
					System.out.println("Servidor iniciado");
					//La ip a donde se conectara para la comunicacion de envio
                    address = InetAddress.getByName("172.30.156.151");
					conectado = true;
				} catch (SocketException e) {
					e.printStackTrace();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					// operación de recepción
					recibir();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//Metodo encargado de recibir los mensajes de Android
	public void recibir() throws IOException{ //aqui también se notifica el cambio----------------------
        byte[] buffer = new byte[1000];
        DatagramPacket datagramaRespuesta = new DatagramPacket(buffer, buffer.length);
        socket.receive(datagramaRespuesta);
        String mensaje = new String(datagramaRespuesta.getData(), 0 , datagramaRespuesta.getLength());
        setChanged();
        notifyObservers(mensaje);
        clearChanged();
        System.out.println("MENSAJE RECIBIDO: " + new String(datagramaRespuesta.getData()));
 
    }
	
	//Metodo encargado de enviar mensajes para Android
	public void enviar(String msj){
        new Thread(()->{
            try {
                String mensaje = msj;
                DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, address, 5000);
                socket.send(datagrama);
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
	

}
