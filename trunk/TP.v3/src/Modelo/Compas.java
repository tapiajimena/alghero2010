package Modelo;
import java.util.ArrayList;
import java.util.Iterator;



import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import Excepciones.CompasLlenoException;

public class Compas {

	//Atributos:
	private ArrayList<ElementoDePartitura> elementosDePartitura;
	private ArmaduraDeClave armaduraDeClave;

	//Métodos:

	  public static Compas recuperar(Element elemCompas) {

		  ArmaduraDeClave armadura=null;
          Element elementoDeArmadura=elemCompas.element("ArmaduraDeClave");
          armadura = ArmaduraDeClave.recuperar(elementoDeArmadura);
		  Compas compas=new Compas(armadura);
	      Iterator it = elemCompas.elementIterator();
	       while(it.hasNext()){
	           Element elemDePartitura = (Element)it.next();

	           if(elemDePartitura.getName()=="Nota"){
	        	   try {
						compas.addElementoDePartitura(Nota.recuperar(elemDePartitura));
					} catch (CompasLlenoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

	           }
					if(elemDePartitura.getName()=="Acorde"){
			        	   try {
								compas.addElementoDePartitura(Acorde.recuperar(elemDePartitura));
							} catch (CompasLlenoException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();

			           }


	       }

	   }
	       }
	       return compas;
	  }

	 public Element guardar() {
	       Element elemCompas = DocumentHelper.createElement("Compas");
	       elemCompas.add(this.getArmaduraDeClave().guardar());
	       Iterator it = elementosDePartitura.iterator();
	       while(it.hasNext()){
	           ElementoDePartitura elemento = (ElementoDePartitura)it.next();
	           elemCompas.add(elemento.guardar());
	       }


	       return elemCompas;
	   }



	/* Solamente se crea el arreglo elementosDeParitura. Luego para
	 * agregar notas o acordes se usa el método addElementosDePartitura,
	 * ya que de esta forma se puede chequear que no se carguen mas
	 * notas de las impuesta por la armadura de clave.
	 */
	public Compas(ArmaduraDeClave unaArmaduraDeClave){
		this.armaduraDeClave = unaArmaduraDeClave;
		this.elementosDePartitura = new ArrayList<ElementoDePartitura>();
    }

	public double obtenerDuracionHastaElMomento(){
		double duracionHastaElMomento = 0;
		for(int i=0 ; i<elementosDePartitura.size() ; i++){

			double duracionActual=elementosDePartitura.get(i).getFigura().getIdentificador();
			duracionHastaElMomento = duracionHastaElMomento + duracionActual;

		}
		return duracionHastaElMomento;

	}

	public boolean sePuedeAgregarElementoDePartitura(ElementoDePartitura unElementoDePartitura){


		/* Se chequea si la suma de la duración hasta el momento y la que se quiere agregar supera a
		 * la impuesta por la armadura de clave, para luego enviar un true o false según corresponda.
		 */

		boolean sePuede;
		double tiemposDelElemento;
		tiemposDelElemento= (unElementoDePartitura.obtenerCantidadDeElementos())* (unElementoDePartitura.getFigura().getIdentificador());

		sePuede=((tiemposDelElemento+this.obtenerDuracionHastaElMomento()) <= ((armaduraDeClave.getDenominador().getIdentificador())* (armaduraDeClave.getNumerador())));

		return sePuede;
	}


	public ArrayList<ElementoDePartitura> getElementosDePartitura(){
		return this.elementosDePartitura;
	}

	/* Este método lanza una excepcion del tipo CompasLlenoException */
	public void addElementoDePartitura(ElementoDePartitura elemento) throws CompasLlenoException{
		if(this.sePuedeAgregarElementoDePartitura(elemento)){
			elementosDePartitura.add(elemento);
		}
			else{
				throw new CompasLlenoException("No puede agregarse mas elementos De Partitura");
			}
	}

	public ArmaduraDeClave getArmaduraDeClave(){

		return this.armaduraDeClave;
	}

}