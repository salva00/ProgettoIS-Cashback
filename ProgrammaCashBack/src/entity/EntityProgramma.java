package entity;

import java.util.ArrayList;
import java.util.Date;

import database.DBProgramma;

public class EntityProgramma {
	
	private int idProgramma;
	private Date dataInizio;
	private Date dataFine;
	private int minAcquisti;
	private float maxTetto; //se è un float, modificarlo nel CD
	private float percRimborso;
	private ArrayList<EntityIscrizione> iscrizioni;

	public EntityProgramma() {
		iscrizioni = new ArrayList<EntityIscrizione>();
	}

	public EntityProgramma(int idProgramma, Date dataInizio, Date dataFine, int minAcquisti, float maxTetto,
			int percRimborso, ArrayList<EntityIscrizione> iscrizioni) {

		iscrizioni = new ArrayList<EntityIscrizione>();

		this.idProgramma = idProgramma;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.minAcquisti = minAcquisti;
		this.maxTetto = maxTetto;
		this.percRimborso = percRimborso;
		this.iscrizioni = iscrizioni;
	}
	
	public EntityProgramma(int idProgramma) {
		iscrizioni = new ArrayList<EntityIscrizione>();

		this.idProgramma=idProgramma;
		
		DBProgramma programma = new DBProgramma(idProgramma);
		this.dataInizio=programma.getDataInizio();
		this.dataFine=programma.getDataFine();
		this.minAcquisti=programma.getMinAcquisti();
		this.maxTetto=programma.getMaxTetto();
		this.percRimborso=programma.getPercRimborso();
		
		programma.caricaIscrizioniProgrammaDaDB();
		caricaIscrizioni(programma);
	}

	public EntityProgramma(DBProgramma programma ) {
		iscrizioni = new ArrayList<EntityIscrizione>();

		this.idProgramma=programma.getIdProgramma();
		this.dataInizio=programma.getDataInizio();
		this.dataFine=programma.getDataFine();
		this.minAcquisti=programma.getMinAcquisti();
		this.maxTetto=programma.getMaxTetto();
		this.percRimborso=programma.getPercRimborso();
		
		programma.caricaIscrizioniProgrammaDaDB();
		caricaIscrizioni(programma);
	}
	
	public void caricaIscrizioni(DBProgramma programma) {
		
		for(int i =0; i<programma.getIscrizioni().size(); i++) {
			
			EntityIscrizione iscrizione = new EntityIscrizione(programma.getIscrizioni().get(i),this);
			programma.getIscrizioni().get(i).caricaAcquistiIscrizioneDaDB();
			programma.getIscrizioni().get(i).caricaCarteRegistrateIscrizioneDaDB();
			this.iscrizioni.add(iscrizione);
			
			}
	}
	
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

	public ArrayList<EntityIscrizione> getIscrizioni() {
		return iscrizioni;
	}

	public void setIscrizioni(ArrayList<EntityIscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}

	@Override
	public String toString() {
		return "EntityProgramma [idProgramma=" + idProgramma + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine
				+ ", minAcquisti=" + minAcquisti + ", maxTetto=" + maxTetto + ", percRimborso=" + percRimborso * 100
				+ "%, iscrizioni=" + iscrizioni + "]";
	}

	
}
