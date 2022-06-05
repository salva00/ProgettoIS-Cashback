package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBIscrizione {
	
	private int idCittadino;
	private String password;
	private String iban;
	private float rimborsoRicevuto;
	private ArrayList<DBAcquisto> acquistiRegistrati;
	private ArrayList<DBCartaDiCredito> carteRegistrate;
	private DBCittadino cittadino;
	private DBProgramma programma;
	
	public DBIscrizione() {
		acquistiRegistrati = new ArrayList<DBAcquisto>();
		carteRegistrate = new ArrayList<DBCartaDiCredito>();
	}
	
	public DBIscrizione(int idCittadino) {
		
		this.idCittadino = idCittadino;
		this.acquistiRegistrati= new ArrayList<DBAcquisto>(); 
		this.carteRegistrate = new ArrayList<DBCartaDiCredito>();
		caricaDaDB(); //accedo solo alla tabella programmi
	}

	
	public void caricaDaDB() {
		
		String query = "SELECT * FROM iscrizione WHERE idCittadino='"+this.idCittadino+"';";
		System.out.println(query); //DEGUB
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) { //se ho un risultato
				
				//mi vado a prendere i dati, accedendo tramite il nome dell'attributo-colonna
				this.setIdCittadino(rs.getInt("IdCittadino"));
				this.setRimborsoRicevuto(rs.getFloat("RimborsoRicevuto"));
				this.setIban(rs.getString("Iban"));
				this.setPassword(rs.getString("Password"));
				//altre cose??BOH
				
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void caricaAcquistiIscrizioneDaDB() {
		
		String query = new String("select * from acquisti where iscrizione = '"+this.idCittadino+";" );
		System.out.println(query); //stampo query per controllo in fase di DEBUG, poi posso commentare
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {	//while perch� mi aspetto pi� risultati			
							
				//NB: non dimenticare di istanziare l'oggetto Corso
				//altrimenti non potremmo salvare i suoi dati				
				DBAcquisto acquisto = new DBAcquisto();
				acquisto.setIdAcquisto(rs.getInt("idAcquisto"));
				acquisto.setImporto(rs.getFloat("Importo"));
	
				
				acquisto.caricaCartaAcquistoDaDB();
				
				this.acquistiRegistrati.add(acquisto);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	public void caricaCarteRegistrateIscrizioneDaDB() {

			//COME FACCIO LA QUERY????????
		
		String query = new String("??");
		System.out.println(query); //stampo query per controllo in fase di DEBUG, poi posso commentare
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {				
				DBCartaDiCredito carta = new DBCartaDiCredito();
				carta.setNumero(rs.getInt("Numero"));
				carta.setScadenza(rs.getString("Scadenza"));
				
				this.carteRegistrate.add(carta);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void caricaProgrammaIscrizioneDaDB() {
		
		String query = new String("??" );
		System.out.println(query); //stampo query per controllo in fase di DEBUG, poi posso commentare
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()){
				
				DBProgramma programma = new DBProgramma();
				programma.setDataInizio(rs.getDate("Inizio"));
				programma.setDataFine(rs.getDate("Fine"));
				programma.setMinAcquisti(rs.getInt("AcquistiMinimi"));
				programma.setMaxTetto(rs.getFloat("TettoMassimo"));
				programma.setPercRimborso(rs.getFloat("PercentualeRimborso"));
				
				this.setProgramma(programma);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

	public void caricaCittadinoIscrizioneDaDB() {
		
		String query = new String("??" );
		System.out.println(query); //stampo query per controllo in fase di DEBUG, poi posso commentare
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()){
				
				DBCittadino cittadino = new DBCittadino();
				cittadino.setNome(rs.getString("Nome"));
				cittadino.setCognome(rs.getString("cognome"));
				cittadino.setIndirizzoMail(rs.getString("IndirizzoMail"));
			
				this.setCittadino(cittadino);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public int SalvaInDB() {
		
		int ret = 0;
		
		String query ="??"; 
		System.out.println(query);
		try {
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1; //per segnalare l'errore di scrittura
		}
		
		return ret;
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
	public ArrayList<DBAcquisto> getAcquistiRegistrati() {
		return acquistiRegistrati;
	}
	public void setAcquistiRegistrati(ArrayList<DBAcquisto> acquistiRegistrati) {
		this.acquistiRegistrati = acquistiRegistrati;
	}
	public ArrayList<DBCartaDiCredito> getCarteRegistrate() {
		return carteRegistrate;
	}
	public void setCarteRegistrate(ArrayList<DBCartaDiCredito> carteRegistrate) {
		this.carteRegistrate = carteRegistrate;
	}
	public DBCittadino getCittadino() {
		return cittadino;
	}
	public void setCittadino(DBCittadino cittadino) {
		this.cittadino = cittadino;
	}
	public DBProgramma getProgramma() {
		return programma;
	}
	public void setProgramma(DBProgramma programma) {
		this.programma = programma;
	}

}
