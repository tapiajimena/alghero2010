package persistenciaNoOficial;
/*
 * Created on 01/06/2005
 */

import java.io.IOException;

/**
 * @author Nicolas
 */
public class Principal {

    public static void main(String[] args) {
        Anotador anotador = null;
        if(args.length == 0){
	        anotador = new Anotador();
	        Nota nota1 = new Nota("EL CALAMAR", "PLATENSE");
	        Nota nota2 = new Nota("titulo 2", "texto 2");
	        Nota nota5 = new Nota("titulo 5", "texto 5");
	        anotador.addNota(nota1);
	        anotador.addNota(nota2);
	        anotador.addNota(nota5);
	        try{
	        anotador.guardar("fede.xml");
	        }catch(IOException ex){
	           System.out.println("Problemas" + ex);
	        }
        }
        else{
            try{
                anotador = Anotador.recuperar("fede.xml");
            }catch(IOException ex){
                System.out.println(ex);
            }
        }
        System.out.println(anotador);
    }
}

