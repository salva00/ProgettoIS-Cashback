package entity;

import database.DBCartaDiCredito;

public class CartaDiCredito {

	private int numero;
	private String scadenza;
	
	public CartaDiCredito(int numero, String scadenza) {
		this.numero = numero;
		this.scadenza = scadenza;
	}
	
	public CartaDiCredito(int numero) {
		
		this.numero = numero;
		
		DBCartaDiCredito carta = new DBCartaDiCredito(numero);
		this.scadenza=carta.getScadenza();
	
	}
	
	public CartaDiCredito(DBCartaDiCredito carta) {
		
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
		return "CartaDiCredito [numero=" + numero + ", scadenza=" + scadenza + "]";
	}

	
}
