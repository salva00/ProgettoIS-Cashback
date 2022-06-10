package entity;

import java.util.ArrayList;

import database.DBIscrizione;
import exceptions.IscrizioneNonTrovata;

public class Iscrizione {
	private String idCittadino;
	private String password;
	private String iban;
	private float rimborsoRicevuto;
	private ArrayList<Acquisto> acquistiRegistrati;
	private ArrayList<CartaDiCredito> carteRegistrate;
	private Cittadino cittadino;
	private ProgrammaCashback programma;
	
	public Iscrizione() {
		acquistiRegistrati = new ArrayList<Acquisto>();
		carteRegistrate=new ArrayList<CartaDiCredito>();
	}
	
	public Iscrizione(String idCittadino, String password, String iban, float rimborsoRicevuto,
			ArrayList<Acquisto> acquistiRegistrati, ArrayList<CartaDiCredito> carteRegistrate,
			Cittadino cittadino, ProgrammaCashback programma) {
		this.idCittadino = idCittadino;
		this.password = password;
		this.iban = iban;
		this.rimborsoRicevuto = rimborsoRicevuto;
		this.acquistiRegistrati = acquistiRegistrati;
		this.carteRegistrate = carteRegistrate;
		this.cittadino = cittadino;
		this.programma = programma;
	}
	
	public Iscrizione(String idCittadino)throws IscrizioneNonTrovata {
		this.idCittadino=idCittadino;
		acquistiRegistrati = new ArrayList<Acquisto>();
		carteRegistrate=new ArrayList<CartaDiCredito>();
		
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
	
	public Iscrizione(DBIscrizione iscrizione) {
		
		this.idCittadino=iscrizione.getIdCittadino();
		acquistiRegistrati = new ArrayList<Acquisto>();
		carteRegistrate=new ArrayList<CartaDiCredito>();

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
	
	public Iscrizione(DBIscrizione iscrizione, Cittadino cittadino) {
		
		this.idCittadino=iscrizione.getIdCittadino();
		acquistiRegistrati = new ArrayList<Acquisto>();
		carteRegistrate=new ArrayList<CartaDiCredito>();

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
	
	public Iscrizione(DBIscrizione iscrizione, ProgrammaCashback programma) {
		
		this.idCittadino=iscrizione.getIdCittadino();
		acquistiRegistrati = new ArrayList<Acquisto>();
		carteRegistrate=new ArrayList<CartaDiCredito>();

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
			Acquisto acquisto = new Acquisto(iscrizione.getAcquistiRegistrati().get(i));
			this.acquistiRegistrati.add(acquisto);
		}
		
	}
	
	public void caricaCarte(DBIscrizione iscrizione) {

		for(int i=0; i<iscrizione.getCarteRegistrate().size(); i++) {
			CartaDiCredito carta = new CartaDiCredito(iscrizione.getCarteRegistrate().get(i));
			this.carteRegistrate.add(carta);
		}
	}
	
	public void caricaProgramma(DBIscrizione iscrizione) {
		
		ProgrammaCashback programma = new ProgrammaCashback(iscrizione.getProgramma());
		this.setProgramma(programma);
	}
	
	public void caricaCittadino(DBIscrizione iscrizione) {
		
		Cittadino cittadino = new Cittadino(iscrizione.getCittadino());
		this.setCittadino(cittadino);
	}
	
	public void aggiungiAcquisto() {}
	
	public float calcolaImporto() {
		return 0;
	}	
	
	
	public String getIdCittadino() {
		return idCittadino;
	}
	public void setIdCittadino(String idCittadino) {
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
	public void salvaRimborso(float rimborsoRicevuto){
		setRimborsoRicevuto(rimborsoRicevuto);
		try {
		DBIscrizione dbEntry=new DBIscrizione(idCittadino);
	
		dbEntry.setRimborsoRicevuto(rimborsoRicevuto);
		dbEntry.aggiornaRimborsoInDB();
		}catch(IscrizioneNonTrovata e ) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<Acquisto> getAcquistiRegistrati() {
		return acquistiRegistrati;
	}
	public void setAcquistiRegistrati(ArrayList<Acquisto> acquistiRegistrati) {
		this.acquistiRegistrati = acquistiRegistrati;
	}
	public ArrayList<CartaDiCredito> getCarteRegistrate() {
		return carteRegistrate;
	}
	public void setCarteRegistrate(ArrayList<CartaDiCredito> carteRegistrate) {
		this.carteRegistrate = carteRegistrate;
	}
	public Cittadino getCittadino() {
		return cittadino;
	}
	public void setCittadino(Cittadino cittadino) {
		this.cittadino = cittadino;
	}
	public ProgrammaCashback getProgramma() {
		return programma;
	}
	public void setProgramma(ProgrammaCashback programma) {
		this.programma = programma;
	}

	@Override
	public String toString() {
		return "Iscrizione [idCittadino=" + idCittadino + ", password=" + password + ", iban=" + iban
				+ ", rimborsoRicevuto=" + rimborsoRicevuto + ", acquistiRegistrati=" + acquistiRegistrati
				+ ", carteRegistrate=" + carteRegistrate + ", cittadino=" + cittadino + ", programma=" + programma
				+ "]";
	}
	
	
	
	
}
