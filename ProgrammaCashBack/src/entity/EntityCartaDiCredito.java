package entity;

import database.DBCartaDiCredito;

public class EntityCartaDiCredito {

	private int numero;
	private String scadenza;
	
	public EntityCartaDiCredito(int numero, String scadenza) {
		this.numero = numero;
		this.scadenza = scadenza;
	}
	
	public EntityCartaDiCredito(int numero) {
		
		this.numero = numero;
		
		DBCartaDiCredito carta = new DBCartaDiCredito(numero);
		this.scadenza=carta.getScadenza();
	
	}
	
	public EntityCartaDiCredito(DBCartaDiCredito carta) {
		
		this.numero=carta.getNumero();
		this.scadenza=carta.getScadenza();
		
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

	@Override
	public String toString() {
		return "EntityCartaDiCredito [numero=" + numero + ", scadenza=" + scadenza + "]";
	}

	
}
