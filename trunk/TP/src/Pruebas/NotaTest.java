package Pruebas;
import Modelo.Blanca;
import Modelo.Do;
import Modelo.Nota;
import Modelo.Figura;
import Modelo.Sonido;
import junit.framework.TestCase;
//ARREGLAAAAAAAAAAAAAAAAAAAAAR
public class NotaTest extends TestCase{

	/*Veamos que el constructor asigne bien la Figura y el Sonido
	 *
	 */

	public void notaTest(){
		Do notaDo = new Do();
		boolean silencio=true;
		Blanca blanca = new Blanca(silencio);

		Sonido unSonido=notaDo;
		Nota nota=new Nota(blanca,notaDo);


		assertEquals((nota.getSonido().getFrecuenciaFundamental()),(notaDo.getFrecuenciaFundamental()));
		assertEquals((nota.getFigura().getIdentificador()),(blanca.getIdentificador()));

	}



}
