package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCartaDiCredito {

	private int numero;
	private String scadenza;
	
	public DBCartaDiCredito() {}
	
	public DBCartaDiCredito(int numero) {
		this.numero= numero;
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		
		String query = "SELECT * FROM carteDiCredito WHERE numero='"+this.numero+"';";
		System.out.println(query); //DEGUB
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) { //se ho un risultato
				
				//mi vado a prendere i dati, accedendo tramite il nome dell'attributo-colonna
				this.setScadenza(rs.getString("scadenza"));
			}
		
		} catch (ClassNotFoundException | SQLException e) {
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
	
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getScadenza() {
		return scadenza;
	}
	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}
	
	
	
	
}
