package com.praktikum;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket soket = null;
		Data x = null;
		MathObject y = null;
		try {
			System.out.print("Server is Running...........");
			server = new ServerSocket(4343);
			soket = server.accept();
			InputStream is = soket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			OutputStream os = soket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
	
			x = (Data) ois.readObject();
			y = new MathObject();
			y.jumlah(x);
			
			oos.writeObject(y);
			oos.flush();
			ois.close();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
