package control;

import entity.ApplicazioneCashback;
import exceptions.ProgrammaNonTrovato;
import exceptions.ProgrammaNonTerminato;
import exceptions.IscrizioneNonTrovata;
import exceptions.PasswordErrata;

public class GestioneCashback {

	public static void gesticiRegistraCittadino(){

    }
	
	public static void gestisciRegistraAcquisto(){

    }
	
	public static void gestisciRichiediRimborso(String idCIttadino, String password, int programma)
    throws IscrizioneNonTrovata,ProgrammaNonTrovato,PasswordErrata,ProgrammaNonTerminato, IllegalArgumentException
    {
        ApplicazioneCashback singleton = ApplicazioneCashback.getInstance();
        singleton.richiediRimborso(idCIttadino, password, programma);
	}
	
	
}