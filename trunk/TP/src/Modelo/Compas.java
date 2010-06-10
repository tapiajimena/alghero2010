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

	public boolean sePuedeAgregarElementoDePartitura(ElementoDePartitura unElementoDePartitura){
		double duracionHastaElMomento = 0;
		/* Se cuentan cuantas duraciones fueron cargadas en el arreglo
		 * hasta ahora.
		 */
		for(int i=0 ; i<elementosDePartitura.size() ; i++)
			duracionHastaElMomento = duracionHastaElMomento + ((elementosDePartitura.get(i)).getFigura()).getIdentificador();
		/* Se chequea si la duración hasta el momento y la que se quiere agregar supera a
		 * la impuesta por la armadura de clave, para luego enviar un true o false según corresponda.
		 */
		if(duracionHastaElMomento + (unElementoDePartitura.getFigura()).getIdentificador() <= (armaduraDeClave.getDenominador()).getIdentificador()){
			elementosDePartitura.add(unElementoDePartitura);
			return true;
		}else{
			return false;
		}
	}

	public ArrayList<ElementoDePartitura> getElementosDePartitura(){
		return this.elementosDePartitura;
	}

	public void addElementoDePartitura(ElementoDePartitura elemento){
		if(this.sePuedeAgregarElementoDePartitura(elemento)){
			elementosDePartitura.add(elemento);
		}
	}

	public ArmaduraDeClave getArmaduraDeClave(){
		return this.armaduraDeClave;
	}

}