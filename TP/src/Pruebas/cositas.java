package Pruebas;
//LA USO PARA HACER PRUEBAS A MANO HAY QUE SACARLA DESPUES
import Modelo.Blanca;
import Modelo.Do;
import Modelo.Figura;
import Modelo.Nota;
import Modelo.Sonido;

public class cositas {


	public static void main(String[] args){
		Do notaDo = new Do();
		boolean silencio=true;
		Blanca blanca = new Blanca(silencio);
		Figura unaFigura=blanca;
		Sonido unSonido=notaDo;
		Nota nota=new Nota(unaFigura,unSonido);
		System.out.println(nota.getSonido().getFrecuenciaFundamental());
		System.out.println(notaDo.getFrecuenciaFundamental());

}

}