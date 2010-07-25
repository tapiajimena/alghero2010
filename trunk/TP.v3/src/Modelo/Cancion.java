package Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class Cancion {

	//Atributos:
	private Partitura partitura;
	private String nombre;
	private String artista;
	private double tiempoDeNegra;
	private double puntajeIdeal;

	//Métodos:

	public static Cancion recuperar(String archivo) throws IOException{
	       Cancion cancion = null;
	       SAXReader reader = new SAXReader();
	       try{
		        Document document = reader.read(archivo);
		        Element elemCancion = document.getRootElement();
		        cancion = recuperar(elemCancion);
	       }catch(DocumentException ex){
	           throw new IOException();
	       }
	       return cancion;
	   }





 public static Cancion recuperar(Element elemCancion) {

        Element elementoDeTiempo=elemCancion.element("TiempoDeNegra");
        Element elementoDePartitura=elemCancion.element("Partitura");
        Element elementoDeArtista=elemCancion.element("Artista");
        Element elementoDeNombre=elemCancion.element("Nombre");

        String tiempoDeNegraEnString=elementoDeTiempo.getText();
        double tiempoDeNegra=new Double(tiempoDeNegraEnString).doubleValue();
        Partitura unaPartitura = Partitura.recuperar(elementoDePartitura);
        String artista=elementoDeArtista.getText();
        String nombre=elementoDeNombre.getText();


        Cancion cancion=new Cancion(unaPartitura,nombre,artista,tiempoDeNegra);


    return cancion;
}

		   public void guardar(String archivo) throws IOException{
		       Document doc = DocumentHelper.createDocument();
		       doc.add(this.guardar());
		       FileWriter writer = new FileWriter(archivo);
		       doc.write( writer);
		       writer.close();
		   }


	   public Element guardar() {

	       Element elemCancion = DocumentHelper.createElement("Cancion");
	       elemCancion.add(this.getPartitura().guardar());

	       Element elemNombre = DocumentHelper.createElement("Nombre");
	       elemNombre.setText((this.getNombre()));
	       elemCancion.add(elemNombre);

	      	       Element elemArtista = DocumentHelper.createElement("Artista");
	       elemArtista.setText(this.getArtista());
	       elemCancion.add(elemArtista);

	       	       Element elemTiempo = DocumentHelper.createElement("TiempoDeNegra");
	       elemTiempo.setText(String.valueOf(this.getTiempoDeNegra()));
	       elemCancion.add(elemTiempo);


	       return elemCancion;
	   }

	/* Obtencion de datos desde el  xml, por el momento se usa como un costructor comun */
	public Cancion(Partitura unaPartitura, String unNombre, String unArtista, double unTiempoDeNegra){
		this.partitura = unaPartitura;
		this.tiempoDeNegra = unTiempoDeNegra;
		this.nombre = unNombre;
		this.artista = unArtista;
		this.puntajeIdeal = (this.obtenerCantidadDeNotas()*5);
	}

	public Cancion(Cancion unaCancion){

		this.partitura = unaCancion.partitura;
		this.tiempoDeNegra = unaCancion.tiempoDeNegra;
		this.nombre = unaCancion.nombre;
		this.artista = unaCancion.artista;
		this.puntajeIdeal = unaCancion.puntajeIdeal;

	}

	public Partitura getPartitura(){
		return(this.partitura);
	}

	public String getNombre(){
		return(this.nombre);
	}

	public String getArtista(){
		return(this.artista);
	}

	public double getTiempoDeNegra(){
		return (this.tiempoDeNegra);
	}

	public double getPuntajeIdeal(){
		return this.puntajeIdeal;
	}

	public void setTiempoDeNegra(double tiempo){
		this.tiempoDeNegra = tiempo;
	}

	public int obtenerCantidadDeNotas(){
		int cantidadTotal=0;
		int cantidadDeCompases=this.getPartitura().getCompases().size();

		for (int i = 0; i < cantidadDeCompases ; i++){

			Compas compasActual=this.getPartitura().getCompases().get(i);

			for (int j = 0; j < compasActual.getElementosDePartitura().size(); j++){
				ElementoDePartitura elementoActual=compasActual.getElementosDePartitura().get(j);
				cantidadTotal= cantidadTotal + elementoActual.obtenerCantidadDeSonidos();

			}


		}
		return cantidadTotal;

	}
}




