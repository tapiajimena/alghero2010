

public class Piano extends Instrumento {

	public Piano(){
		super(0);
	}
	
	public void reproducir(int numeroDeNota, int duracion){
		super.reproducirAsinc(numeroDeNota,duracion);
	}
}
