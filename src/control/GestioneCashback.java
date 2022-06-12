package control;

import entity.ApplicazioneCashback;
import exceptions.*;

public class GestioneCashback {

	public static void gesticiRegistraCittadino(){

    }
	
	public static void gestisciRegistraAcquisto(){

    }
	
	public static float gestisciRichiediRimborso(String idCIttadino, String password, int programma)
    throws IscrizioneNonTrovata,ProgrammaNonTrovato,PasswordErrata,ProgrammaNonTerminato, MinAcquistiNonRaggiunto, IllegalArgumentException
    {
        ApplicazioneCashback singleton = ApplicazioneCashback.getInstance();
       return singleton.richiediRimborso(idCIttadino, password, programma);
	}
	
	
}