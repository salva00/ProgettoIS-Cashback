package entity;

import java.util.ArrayList;
import java.util.Date;

import database.DBProgrammaCashback;

public class ProgrammaCashback {
	
	private int idProgramma;
	private Date dataInizio;
	private Date dataFine;
	private int minAcquisti;
	private float maxTetto; //se è un float, modificarlo nel CD
	private float percRimborso;
	private ArrayList<Iscrizione> iscrizioni;

	public ProgrammaCashback() {
		iscrizioni = new ArrayList<Iscrizione>();
	}

	public ProgrammaCashback(int idProgramma, Date dataInizio, Date dataFine, int minAcquisti, float maxTetto,
			int percRimborso, ArrayList<Iscrizione> iscrizioni) {

		iscrizioni = new ArrayList<Iscrizione>();

		this.idProgramma = idProgramma;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.minAcquisti = minAcquisti;
		this.maxTetto = maxTetto;
		this.percRimborso = percRimborso;
		this.iscrizioni = iscrizioni;
	}
	
	public ProgrammaCashback(int idProgramma) {
		iscrizioni = new ArrayList<Iscrizione>();

		this.idProgramma=idProgramma;
		
		DBProgrammaCashback programma = new DBProgrammaCashback(idProgramma);
		this.dataInizio=programma.getDataInizio();
		this.dataFine=programma.getDataFine();
		this.minAcquisti=programma.getMinAcquisti();
		this.maxTetto=programma.getMaxTetto();
		this.percRimborso=programma.getPercRimborso();
		
		//programma.caricaIscrizioniProgrammaDaDB();
		//caricaIscrizioni(programma);
	}

	public ProgrammaCashback(DBProgrammaCashback programma ) {
		iscrizioni = new ArrayList<Iscrizione>();

		this.idProgramma=programma.getIdProgramma();
		this.dataInizio=programma.getDataInizio();
		this.dataFine=programma.getDataFine();
		this.minAcquisti=programma.getMinAcquisti();
		this.maxTetto=programma.getMaxTetto();
		this.percRimborso=programma.getPercRimborso();
		
		//programma.caricaIscrizioniProgrammaDaDB();
		//caricaIscrizioni(programma);
	}
	
	public void caricaIscrizioni(DBProgrammaCashback programma) {
		
		for(int i =0; i<programma.getIscrizioni().size(); i++) {
			
			Iscrizione iscrizione = new Iscrizione(programma.getIscrizioni().get(i),this);
			programma.getIscrizioni().get(i).caricaAcquistiIscrizioneDaDB();
			programma.getIscrizioni().get(i).caricaCarteRegistrateIscrizioneDaDB();
			this.iscrizioni.add(iscrizione);
			
			}
	}
	
	public void creaIscrizione() {}
	
	public void creaRimborso() {}
	
	private void verificaDati() {}
	
	private void assegnaRimborso() {}
	
	
	
	public int getIdProgramma() {
		return idProgramma;
	}

	public void setIdProgramma(int idProgramma) {
		this.idProgramma = idProgramma;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public int getMinAcquisti() {
		return minAcquisti;
	}

	public void setMinAcquisti(int minAcquisti) {
		this.minAcquisti = minAcquisti;
	}

	public float getMaxTetto() {
		return maxTetto;
	}

	public void setMaxTetto(float maxTetto) {
		this.maxTetto = maxTetto;
	}

	public float getPercRimborso() {
		return percRimborso;
	}

	public void setPercRimborso(float percRimborso) {
		this.percRimborso = percRimborso;
	}

	public ArrayList<Iscrizione> getIscrizioni() {
		return iscrizioni;
	}

	public void setIscrizioni(ArrayList<Iscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}

	@Override
	public String toString() {
		return "ProgrammaCashback [idProgramma=" + idProgramma + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine
				+ ", minAcquisti=" + minAcquisti + ", maxTetto=" + maxTetto + ", percRimborso=" + percRimborso * 100
				+ "%, iscrizioni=" + iscrizioni + "]";
	}

	
}
