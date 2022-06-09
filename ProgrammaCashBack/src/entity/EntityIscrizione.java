package entity;

import java.util.ArrayList;

import database.DBIscrizione;

public class EntityIscrizione {
	private int idCittadino;
	private String password;
	private String iban;
	private float rimborsoRicevuto;
	private ArrayList<EntityAcquisto> acquistiRegistrati;
	private ArrayList<EntityCartaDiCredito> carteRegistrate;
	private EntityCittadino cittadino;
	private EntityProgramma programma;
	
	public EntityIscrizione() {
		acquistiRegistrati = new ArrayList<EntityAcquisto>();
		carteRegistrate=new ArrayList<EntityCartaDiCredito>();
	}
	
	public EntityIscrizione(int idCittadino, String password, String iban, float rimborsoRicevuto,
			ArrayList<EntityAcquisto> acquistiRegistrati, ArrayList<EntityCartaDiCredito> carteRegistrate,
			EntityCittadino cittadino, EntityProgramma programma) {
		this.idCittadino = idCittadino;
		this.password = password;
		this.iban = iban;
		this.rimborsoRicevuto = rimborsoRicevuto;
		this.acquistiRegistrati = acquistiRegistrati;
		this.carteRegistrate = carteRegistrate;
		this.cittadino = cittadino;
		this.programma = programma;
	}
	
	public EntityIscrizione(int idCittadino) {
		this.idCittadino=idCittadino;
		acquistiRegistrati = new ArrayList<EntityAcquisto>();
		carteRegistrate=new ArrayList<EntityCartaDiCredito>();
		
		DBIscrizione iscrizione=new DBIscrizione(idCittadino);
	
		this.iban=iscrizione.getIban();
		this.password=iscrizione.getPassword();
		this.rimborsoRicevuto=iscrizione.getRimborsoRicevuto();
		
		iscrizione.caricaAcquistiIscrizioneDaDB();
		caricaAcquisti(iscrizione);
		iscrizione.caricaCarteRegistrateIscrizioneDaDB();
		caricaCarte(iscrizione);
		iscrizione.caricaProgrammaIscrizioneDaDB();
		caricaProgramma(iscrizione);
		iscrizione.caricaCittadinoIscrizioneDaDB();
		caricaCittadino(iscrizione);
		
	}
	
	public EntityIscrizione(DBIscrizione iscrizione) {
		
		this.idCittadino=iscrizione.getIdCittadino();
		acquistiRegistrati = new ArrayList<EntityAcquisto>();
		carteRegistrate=new ArrayList<EntityCartaDiCredito>();

		this.iban=iscrizione.getIban();
		this.password=iscrizione.getPassword();
		this.rimborsoRicevuto=iscrizione.getRimborsoRicevuto();
		
		iscrizione.caricaAcquistiIscrizioneDaDB();
		caricaAcquisti(iscrizione);
		iscrizione.caricaCarteRegistrateIscrizioneDaDB();
		caricaCarte(iscrizione);
		iscrizione.caricaProgrammaIscrizioneDaDB();
		caricaProgramma(iscrizione);
		iscrizione.caricaCittadinoIscrizioneDaDB();
		caricaCittadino(iscrizione);
	}
	
	public EntityIscrizione(DBIscrizione iscrizione, EntityCittadino cittadino) {
		
		this.idCittadino=iscrizione.getIdCittadino();
		acquistiRegistrati = new ArrayList<EntityAcquisto>();
		carteRegistrate=new ArrayList<EntityCartaDiCredito>();

		this.iban=iscrizione.getIban();
		this.password=iscrizione.getPassword();
		this.rimborsoRicevuto=iscrizione.getRimborsoRicevuto();
		
		this.cittadino=cittadino;
		
		iscrizione.caricaAcquistiIscrizioneDaDB();
		caricaAcquisti(iscrizione);
		iscrizione.caricaCarteRegistrateIscrizioneDaDB();
		caricaCarte(iscrizione);
		iscrizione.caricaProgrammaIscrizioneDaDB();
		caricaProgramma(iscrizione);
	}
	
	public EntityIscrizione(DBIscrizione iscrizione, EntityProgramma programma) {
		
		this.idCittadino=iscrizione.getIdCittadino();
		acquistiRegistrati = new ArrayList<EntityAcquisto>();
		carteRegistrate=new ArrayList<EntityCartaDiCredito>();

		this.iban=iscrizione.getIban();
		this.password=iscrizione.getPassword();
		this.rimborsoRicevuto=iscrizione.getRimborsoRicevuto();
		
		this.programma=programma;
		
		iscrizione.caricaAcquistiIscrizioneDaDB();
		caricaAcquisti(iscrizione);
		iscrizione.caricaCarteRegistrateIscrizioneDaDB();
		caricaCarte(iscrizione);
		iscrizione.caricaCittadinoIscrizioneDaDB();
		caricaCittadino(iscrizione);
	}
	
	
	public void caricaAcquisti(DBIscrizione iscrizione) {
		
		for(int i=0; i<iscrizione.getAcquistiRegistrati().size(); i++) {
			EntityAcquisto acquisto = new EntityAcquisto(iscrizione.getAcquistiRegistrati().get(i));
			this.acquistiRegistrati.add(acquisto);
		}
		
	}
	
	public void caricaCarte(DBIscrizione iscrizione) {

		for(int i=0; i<iscrizione.getCarteRegistrate().size(); i++) {
			EntityCartaDiCredito carta = new EntityCartaDiCredito(iscrizione.getCarteRegistrate().get(i));
			this.carteRegistrate.add(carta);
		}
	}
	
	public void caricaProgramma(DBIscrizione iscrizione) {
		
		EntityProgramma programma = new EntityProgramma(iscrizione.getProgramma());
		this.setProgramma(programma);
	}
	
	public void caricaCittadino(DBIscrizione iscrizione) {
		
		EntityCittadino cittadino = new EntityCittadino(iscrizione.getCittadino());
		this.setCittadino(cittadino);
	}
	
	public int getIdCittadino() {
		return idCittadino;
	}
	public void setIdCittadino(int idCittadino) {
		this.idCittadino = idCittadino;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public float getRimborsoRicevuto() {
		return rimborsoRicevuto;
	}
	public void setRimborsoRicevuto(float rimborsoRicevuto) {
		this.rimborsoRicevuto = rimborsoRicevuto;
	}
	public ArrayList<EntityAcquisto> getAcquistiRegistrati() {
		return acquistiRegistrati;
	}
	public void setAcquistiRegistrati(ArrayList<EntityAcquisto> acquistiRegistrati) {
		this.acquistiRegistrati = acquistiRegistrati;
	}
	public ArrayList<EntityCartaDiCredito> getCarteRegistrate() {
		return carteRegistrate;
	}
	public void setCarteRegistrate(ArrayList<EntityCartaDiCredito> carteRegistrate) {
		this.carteRegistrate = carteRegistrate;
	}
	public EntityCittadino getCittadino() {
		return cittadino;
	}
	public void setCittadino(EntityCittadino cittadino) {
		this.cittadino = cittadino;
	}
	public EntityProgramma getProgramma() {
		return programma;
	}
	public void setProgramma(EntityProgramma programma) {
		this.programma = programma;
	}

	@Override
	public String toString() {
		return "EntityIscrizione [idCittadino=" + idCittadino + ", password=" + password + ", iban=" + iban
				+ ", rimborsoRicevuto=" + rimborsoRicevuto + ", acquistiRegistrati=" + acquistiRegistrati
				+ ", carteRegistrate=" + carteRegistrate + ", cittadino=" + cittadino + ", programma=" + programma
				+ "]";
	}
	
	
	
	
}
