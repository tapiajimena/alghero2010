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

	//M�todos:

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

	         /*   String nombre = elemCancion.attributeValue("Nombre");
	            String artista = elemCancion.attributeValue("Artista");
	            String tiempoEnString=elemCancion.attributeValue("Tiempo de negra");
	            double tiempoDeNegra=Double.valueOf(tiempoEnString).doubleValue();*/
	            Element elementoDePartitura=elemCancion.element("Partitura");

	            Partitura unaPartitura = Partitura.recuperar(elementoDePartitura);
	            Cancion cancion=new Cancion(unaPartitura,"nombre","artista",2);


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
     /*  PRIMER OPCION AGREGAR NOMBRE COMO ELEMENTO
       Element elemNombre = DocumentHelper.createElement("Nombre");
       elemNombre.setText(this.getNombre());
       elemCancion.add(elemNombre);
*/

    /*   SEGUNDA OPCION AGREGAR NOMBRE COMO ATRIBUTO
     * elemCancion.addAttribute("Nombre", this.getNombre());
       elemCancion.addAttribute("Artista", this.getArtista());
       elemCancion.addAttribute("TiempoDeNegra", String.valueOf(this.getTiempoDeNegra()));
*/
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




