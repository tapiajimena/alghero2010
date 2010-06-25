package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Modelo.Cancion;



public class Archivador {

	public static void guardar(Cancion unaCancion, String pathArchivo) {
		try {
			FileOutputStream fos = new FileOutputStream(pathArchivo);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(unaCancion);
			out.close();
		} catch(IOException e) {
			throw new RuntimeException(e);
		}

	}

	public static Cancion cargar(String pathArchivo) {
		try {
			FileInputStream fis = new FileInputStream(pathArchivo);
			ObjectInputStream in = new ObjectInputStream(fis);
			Cancion unaCancion = (Cancion)in.readObject();
			in.close();
			return unaCancion;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}

