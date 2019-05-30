package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;

public class Comunicacion extends Observable implements Runnable {

    DatagramSocket socket;
    InetAddress address;
    boolean conectado;

    Comunicacion() {
        conectado = false;
    }



    @Override
    public void run() {
        while (true) {
            if (!conectado) {
                try {
                    socket = new DatagramSocket(5000);
                    System.out.println("Servidor iniciado");
                    address = InetAddress.getByName("172.30.172.241");
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

    public void recibir() throws IOException{ //aqui también se notifica el cambio----------------------
        byte[] buffer = new byte[1000];
        DatagramPacket datagramaRespuesta = new DatagramPacket(buffer, buffer.length);
        socket.receive(datagramaRespuesta);
        String mensaje = new String(datagramaRespuesta.getData()).trim();
        setChanged();
        notifyObservers(mensaje);
        clearChanged();
        System.out.println("MENSAJE RECIBIDO: " + new String(datagramaRespuesta.getData()));
        Log.e("Mensaje recibido:",new String(datagramaRespuesta.getData()).trim());
            /*if(new String(datagramaRespuesta.getData()).equals("apagarAlarma")){
                Log.e("Si entra al metodo","Arre");
                apagar=true;
            }*/
    }

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


