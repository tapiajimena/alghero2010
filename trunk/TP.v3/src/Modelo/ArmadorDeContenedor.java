package Modelo;



import java.util.ArrayList;

import Modelo.Acorde;
import Modelo.Cancion;
import Modelo.ElementoDePartitura;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Sonido;
import Modelo.TablaDeMapeo;

/*LA IDEA DE ESTA CLASE ES:
 * A PARTIR DE UNA PARTITURA PODER OBTENER UN  CONTENEDOR
 * DE LA FORMA: SEGUNDO-"COLUMNA"
 */


public class ArmadorDeContenedor {


	private TablaDeMapeo tabla;
	private ArrayList<ElementoDeContenedor> contenedor;


	public ArmadorDeContenedor(Partitura unaPartitura){

		  Cancion unaCancion=new Cancion(unaPartitura,"titulo","artista",2);

		    this.tabla=new TablaDeMapeo(unaCancion);

		    this.tabla.armarTabla();
		    this.contenedor=new ArrayList<ElementoDeContenedor>();

	}

	public TablaDeMapeo getTabla(){
		return this.tabla;
	}


	/*Si es sonido 1 o 2 = Columna 1
	  Si es sonido 3 o 4 = Columna 2
	  Si es sonido 5 o 6 = Columna 3
	  Si es sonido 7 o 8 = Columna 4
	  Si es sonido 9 o 10 = Columna 5
	  Si es sonido 11 o 12 = Columna 6
	  */
	//recibe un identificador de sonido y devuelve su
	//columna asociada

	public int asignarColumna(int tipoDeSonido){

		int resultado=0;

		if (tipoDeSonido==1){resultado=1;}
		if (tipoDeSonido==2){resultado=1;}
		if (tipoDeSonido==3){resultado=2;}
		if (tipoDeSonido==4){resultado=2;}
		if (tipoDeSonido==5){resultado=3;}
		if (tipoDeSonido==6){resultado=3;}
		if (tipoDeSonido==7){resultado=4;}
		if (tipoDeSonido==8){resultado=4;}
		if (tipoDeSonido==9){resultado=5;}
		if (tipoDeSonido==10){resultado=5;}
		if (tipoDeSonido==11){resultado=6;}
		if (tipoDeSonido==12){resultado=6;}




		return resultado;


	}


   //ARMA Y DEVUELVE EL CONTENEDOR ( SEGUNDO-COLUMNA)




	public ArrayList<ElementoDeContenedor> getContenedor(){

	for(int i=0; i< tabla.getArrayDeSegundos().size();i++){

		double segundoActual=tabla.getArrayDeSegundos().get(i);

		ElementoDePartitura elementoActual=tabla.getTabla().get((segundoActual));

		if(!elementoActual.getFigura().esSilencio()){

		if (elementoActual instanceof Nota){
			int identificadorActual=((Nota)elementoActual).getSonido().getIdentificador();
			ElementoDeContenedor struct=new ElementoDeContenedor(segundoActual,asignarColumna(identificadorActual));
			this.contenedor.add(struct);
		}

		if (elementoActual instanceof Acorde){

			ArrayList<Sonido> sonidosActuales = ((Acorde)elementoActual).getSonidos();
  		    for(int j=0;j<sonidosActuales.size();j++){
  			   Sonido elSonidoActual = sonidosActuales.get(j);
  			   int identificadorActual= elSonidoActual.getIdentificador();
  			 ElementoDeContenedor struct=new ElementoDeContenedor(segundoActual,asignarColumna(identificadorActual));
				   this.contenedor.add(struct);

		}
		}

	}
	}
	return contenedor;
}


}










