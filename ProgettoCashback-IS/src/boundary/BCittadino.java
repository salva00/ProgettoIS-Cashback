package boundary;
import exceptions.*;

public class BCittadino {

	
	public BCittadino() {
		super();
	}
	
	public void registraCittadino() {}
	public void richiediRimborso() {}
	public void registraAcquisto() {}
	
	public void richiediRimborso(int idProgramma, String codiceFiscale, String password) 
	throws ProgrammaNonTrovato, IscrizioneNonTrovata {
		
		if(idProgramma>0)
			throw new ProgrammaNonTrovato("vvvvvvvv");
		else
			throw new IscrizioneNonTrovata("vvvvvvvv");
		
		
	}
}
