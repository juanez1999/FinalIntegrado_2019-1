package perezbravoquevedomarmolejo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Observable;

public class Comunicacion extends Observable implements Runnable{

    private DatagramSocket socket;
    private InetAddress ip;
    private static Comunicacion ref;

    private Comunicacion() {
    }

    public static Comunicacion getRef() {
        if(ref == null) {
            ref = new Comunicacion();
            Thread t = new Thread(ref);
            t.start();
        }
        return ref;
    }

    public void run() {
        try {
            socket = new DatagramSocket(5000);

            while(true) {
                byte[] buf = new byte[1024];
                DatagramPacket p = new DatagramPacket(buf, buf.length);
                socket.receive(p);
                String msg = new String(buf).trim();
                
                ip = p.getAddress();
                
                setChanged();
                notifyObservers(msg);
                clearChanged();

                Thread.sleep(33);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enviar(String msg) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] buf = msg.getBytes();
                    DatagramPacket p = new DatagramPacket(buf, buf.length, ip, 5000);
                    socket.send(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
