package entity;

import java.util.ArrayList;

import exceptions.*;

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
		
		if( !(String.valueOf(programma).matches("[0-9]{6}$")) || programma<0){ 
			throw new IllegalArgumentException("Un programma deve essere un intero positivo su 6 cifre");	
		} 
		
		return new ProgrammaCashback(programma);
	}
	
	public float richiediRimborso(String idCittadino, String password, int programma)
	throws ProgrammaNonTrovato, IscrizioneNonTrovata,PasswordErrata,ProgrammaNonTerminato,MinAcquistiNonRaggiunto, IllegalArgumentException {
		ProgrammaCashback ProgCashback = ricercaProgramma(programma);
		return ProgCashback.creaRimborso(idCittadino,password);
	}
	
}
