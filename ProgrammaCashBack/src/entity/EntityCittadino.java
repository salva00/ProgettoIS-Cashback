package entity;

import java.util.ArrayList;

import database.DBCittadino;

public class EntityCittadino {

	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String indirizzoMail;
	private ArrayList<EntityIscrizione> iscrizioni;
	
	public EntityCittadino() {
		iscrizioni = new ArrayList<EntityIscrizione>();
	}
	
	public EntityCittadino(String nome, String cognome, String codiceFiscale, String indirizzoMail,
		ArrayList<EntityIscrizione> iscrizioni) {
		
		iscrizioni = new ArrayList<EntityIscrizione>();
		
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzoMail = indirizzoMail;
		this.iscrizioni = iscrizioni;
	}
	
	public EntityCittadino(String codiceFiscale) {
	
		this.codiceFiscale = codiceFiscale;
		iscrizioni = new ArrayList<EntityIscrizione>();
		
		DBCittadino cittadino = new DBCittadino(codiceFiscale);
		
		this.nome=cittadino.getNome();
		this.cognome=cittadino.getCognome();
		this.indirizzoMail=cittadino.getIndirizzoMail();
		
		cittadino.caricaIscrizioniCittadinoDaDB();
		
		caricaIscrizioni(cittadino);
		
	}
	
	public EntityCittadino(DBCittadino cittadino) {
		
		iscrizioni = new ArrayList<EntityIscrizione>();
		
		this.codiceFiscale = cittadino.getCodiceFiscale();
		this.nome=cittadino.getNome();
		this.cognome=cittadino.getCognome();
		this.indirizzoMail=cittadino.getIndirizzoMail();
		
		cittadino.caricaIscrizioniCittadinoDaDB();
		
		caricaIscrizioni(cittadino);
	}
	
	public void caricaIscrizioni(DBCittadino cittadino) {
		
		for(int i =0; i<cittadino.getIscrizioni().size(); i++) {
			
		EntityIscrizione iscrizione = new EntityIscrizione(cittadino.getIscrizioni().get(i),this);
		cittadino.getIscrizioni().get(i).caricaAcquistiIscrizioneDaDB();
		cittadino.getIscrizioni().get(i).caricaCarteRegistrateIscrizioneDaDB();
		this.iscrizioni.add(iscrizione);
		
		}
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getIndirizzoMail() {
		return indirizzoMail;
	}
	public void setIndirizzoMail(String indirizzoMail) {
		this.indirizzoMail = indirizzoMail;
	}
	public ArrayList<EntityIscrizione> getIscrizioni() {
		return iscrizioni;
	}
	public void setIscrizioni(ArrayList<EntityIscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}

	@Override
	public String toString() {
		return "EntityCittadino [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale
				+ ", indirizzoMail=" + indirizzoMail + ", iscrizioni=" + iscrizioni + "]";
	}

	
	
	
}
