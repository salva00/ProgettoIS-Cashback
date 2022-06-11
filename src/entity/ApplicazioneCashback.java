package entity;

import java.util.ArrayList;

import exceptions.ProgrammaNonTrovato;
import exceptions.IscrizioneNonTrovata;
import exceptions.PasswordErrata;
import exceptions.ProgrammaScaduto;

public class ApplicazioneCashback {
	
	//façade e singleton
	
	private static ApplicazioneCashback instance=null;
	
	private ArrayList<Iscrizione> iscrizioni;
	private ArrayList<Cittadino> cittadini;
	
	protected ApplicazioneCashback() {
		//costruttore
		iscrizioni = new ArrayList<Iscrizione>();
		cittadini = new ArrayList<Cittadino>();
	}
	
	public static ApplicazioneCashback getInstance() {
		
		if(instance==null) {
			instance = new ApplicazioneCashback();
		}
		return instance;
			
	}
	
	public void registraCittadino() {}

	public void registraAcquisti() {}

	private ProgrammaCashback ricercaProgramma(int programma) throws ProgrammaNonTrovato{
		if( String.valueOf(programma).length() == 6){
			return new ProgrammaCashback(programma);
		}
		else{
			throw new IllegalArgumentException("Un programma deve avere esattamente 6 cifre");
		}
	}
	
	public void richiediRimborso(String idCittadino, String password, int programma)
	throws ProgrammaNonTrovato, IscrizioneNonTrovata,PasswordErrata,ProgrammaScaduto {
		ProgrammaCashback ProgCashback = ricercaProgramma(programma);
		ProgCashback.creaRimborso(idCittadino,password);
	}
	
}
