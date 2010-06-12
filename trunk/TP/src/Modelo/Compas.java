package Modelo;
import java.util.ArrayList;

public class Compas {

	//Atributos:
	private ArrayList<ElementoDePartitura> elementosDePartitura;
	private ArmaduraDeClave armaduraDeClave;

	//Métodos:

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

	//Se podria tirar una excepcion aca
	public void addElementoDePartitura(ElementoDePartitura elemento){
		if(this.sePuedeAgregarElementoDePartitura(elemento)){
			elementosDePartitura.add(elemento);
		}
	}

}