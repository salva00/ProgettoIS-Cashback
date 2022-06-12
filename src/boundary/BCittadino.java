package boundary;
import exceptions.*;
import control.*;

public class BCittadino {

	
	public BCittadino() {
		super();
	}
	
	public void registraCittadino() {}
	public void richiediRimborso() {}
	public void registraAcquisto() {}
	
	public float richiediRimborso(int idProgramma, String idCittadino, String password) 
	throws ProgrammaNonTrovato, IscrizioneNonTrovata, PasswordErrata, ProgrammaNonTerminato, IllegalArgumentException {
		
		return GestioneCashback.gestisciRichiediRimborso(idCittadino, password, idProgramma);
		
	}
}
