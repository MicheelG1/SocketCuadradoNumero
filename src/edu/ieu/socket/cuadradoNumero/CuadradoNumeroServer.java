package edu.ieu.socket.cuadradoNumero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CuadradoNumeroServer {

	

	public void iniciar() {
        ServerSocket servidor;
        boolean fin = false;
        try {
        servidor = new ServerSocket(6666);// se creo el socket,bind,listen
        System.out.println("Servidor escuchando en el puerto 6666");
        Socket socketManejoCliente = servidor.accept();//aceptamos la conexion del cliente
        //objetos entrada y salida
        DataInputStream in= new DataInputStream(socketManejoCliente.getInputStream());
        DataOutputStream out = new DataOutputStream(socketManejoCliente.getOutputStream());
        do {
        Double mensaje =0d;
        mensaje = in.readDouble();//leemos el mensaje del cliente
        System.out.println("El servidor recibio del cliente:"+ mensaje);
       out.writeDouble(mensaje*mensaje);//enviamos una respuesta al cliente
        if (mensaje.equals("fin")) {
        fin= true;
        System.out.println("EL SERVIDOR SE APAGARA NO RECIVE MAS MENSAJES:");
        }
        }while(!fin);//permite que el mensaje se compare con otro texto como mi texto fin
        in.close();
        out.close();
        socketManejoCliente.close();
        servidor.close();
    }catch (IOException e) {
        	e.printStackTrace();
        }
	}
	public static void main(String args[]) {
		CuadradoNumeroServer servidor = new CuadradoNumeroServer();
		servidor.iniciar();
} 
	} 


