import java.util.ArrayList;

public class Compas {

	//Atributos:
	private ArrayList<ElementoDePartitura> elementosDePartitura;
	private ArmaduraDeClave armaduraDeClave;

	//Métodos:
	public Compas(ArmaduraDeClave unaArmaduraDeClave){
		this.armaduraDeClave = unaArmaduraDeClave;
		//Solamente creamos el arreglo elementosDeParitura. Luego
		//para agregar notas o acordes se usa el método
		//addElementosDePartitura, ya que de esta forma podemos
		//chequear que no se carguen mas notas de las impuesta
		//por la armadura de clave.
		this.elementosDePartitura = new ArrayList<ElementoDePartitura>();
    }

	public boolean addElementoDePartitura(ElementoDePartitura unElementoDePartitura){

		double duracionHastaElMomento = 0;
		//Contamos cuantas duraciones fueron cargadas en el arreglo
		//hasta ahora.
		for(int i=0 ; i<elementosDePartitura.size() ; i++)
			duracionHastaElMomento = duracionHastaElMomento + ((elementosDePartitura.get(i)).getFigura()).getIdentificador();

		//Nos fijamos si la duración hasta el momento y la que queremos agregar supera a
		//la impuesta por la armadura de clave, para luego enviar un true o false según
		//corresponda.
		if(duracionHastaElMomento + (unElementoDePartitura.getFigura()).getIdentificador() <= (armaduraDeClave.getDenominador()).getIdentificador()){
			elementosDePartitura.add(unElementoDePartitura);
			return true;
		}else{
			return false;
		}
	}

	public ElementoDePartitura getElementoDePartitura(int index){
		//Aca no habría que tirar alguna excepcion? Que onda?
		return (elementosDePartitura.get(index));
	}

}
