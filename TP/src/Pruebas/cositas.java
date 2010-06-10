package Pruebas;
//LA USO PARA HACER PRUEBAS A MANO HAY QUE SACARLA DESPUES
import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.Cancion;
import Modelo.Compas;
import Modelo.Do;
import Modelo.Figura;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Sonido;
import Modelo.TablaDeMapeo;

public class cositas {


	public static void main(String[] args){
		int numerador=3;
		boolean silencio=true;
		Blanca blanca = new Blanca(silencio);

		ArmaduraDeClave armadura=new ArmaduraDeClave(numerador,blanca);
		Compas compasUno=new Compas(armadura);
		Partitura partitura= new Partitura();
		partitura.addCompas(compasUno);
		partitura.addCompas(compasUno);
		String unNombre="elNombre";
		String unArtista="elArtista";
		double unTiempo=5;

		Cancion cancion=new Cancion(partitura,unNombre,unArtista,unTiempo);
		TablaDeMapeo tabla=new TablaDeMapeo(cancion);
		tabla.armarTabla();
		System.out.println(tabla.getTabla().get(1).getTiempo());
		

}

}