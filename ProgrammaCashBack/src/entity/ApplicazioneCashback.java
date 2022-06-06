package entity;

import java.util.ArrayList;

public class ApplicazioneCashback {
	
	//façade e singleton
	
	private static ApplicazioneCashback instance=null;
	
	private ArrayList<Iscrizione> iscrizioni;
	private ArrayList<Cittadino> cittadini;
	
	private ApplicazioneCashback() {
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
	public void richiediRimborso() {}
	public void registraAcquisti() {}
	private void ricercaProgramma() {}
	
	
}
