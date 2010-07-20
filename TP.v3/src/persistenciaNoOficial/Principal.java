package persistenciaNoOficial;
/*
 * Created on 01/06/2005
 */

import java.io.IOException;

import Modelo.Cancion;
import Modelo.Partitura;

/**
 * @author Nicolas
 */
public class Principal {

    public static void main(String[] args) {
        Anotador anotador = null;
        if(args.length == 0){
        	Partitura parti=new Partitura();
        	Cancion cancion = new Cancion(parti,"untema","unartista",5);
        	try {
				cancion.guardar("empezando.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      /*  anotador = new Anotador();
	        Nota nota1 = new Nota("hola", "hola");
	        Nota nota2 = new Nota("titulo1", "texto1 ");
	        Nota nota5 = new Nota("titulo2", "texto2 ");
	        anotador.addNota(nota1);
	        anotador.addNota(nota2);
	        anotador.addNota(nota5);
	        try{
	        anotador.guardar("PRUEBA.xml");
	        }catch(IOException ex){
	           System.out.println("Problemas" + ex);
	        }/*
        }
        else{
            try{
                anotador = Anotador.recuperar("fede.xml");
            }catch(IOException ex){
                System.out.println(ex);
            }
        }
        System.out.println(anotador);
    */}}
}

