package entity;

import java.util.ArrayList;

import exceptions.ProgrammaNonTrovato;
import exceptions.IscrizioneNonTrovata;
import exceptions.PasswordErrata;
import exceptions.ProgrammaNonTerminato;

public class ApplicazioneCashback {
	
	//ApplicazioneCashback è la classe façade per il nostro package entity
	//inoltre è dichiarata come Singleton, poichè si vuole imporre che nel sistema ce ne sia una sola istanza
	
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

	private ProgrammaCashback ricercaProgramma(int programma) throws ProgrammaNonTrovato, IllegalArgumentException{
		if( String.valueOf(programma).length() != 6){ //7?
			throw new IllegalArgumentException("Un programma deve avere esattamente 6 cifre");	
		}
		return new ProgrammaCashback(programma);
	}
	
	public void richiediRimborso(String idCittadino, String password, int programma)
	throws ProgrammaNonTrovato, IscrizioneNonTrovata,PasswordErrata,ProgrammaNonTerminato, IllegalArgumentException {
		ProgrammaCashback ProgCashback = ricercaProgramma(programma);
		ProgCashback.creaRimborso(idCittadino,password);
	}
	
}
