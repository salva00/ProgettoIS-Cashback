package entity;

import java.util.Date;

import database.DBAcquisto;

public class EntityAcquisto {

	private int idAcquisto;
	private Date data;
	private float importo;
	private EntityCartaDiCredito carta;
	
	public EntityAcquisto(int idAcquisto, Date data, float importo, EntityCartaDiCredito carta) {
		this.idAcquisto = idAcquisto;
		this.data = data;
		this.importo = importo;
		this.carta = carta;
	}
	
	public EntityAcquisto(int idAcquisto) {
		
		this.idAcquisto = idAcquisto;
		
		DBAcquisto acquisto = new DBAcquisto(idAcquisto);
		this.data = acquisto.getData();
		this.importo=acquisto.getImporto();
		
		acquisto.caricaCartaAcquistoDaDB();
		caricaCarta(acquisto);
	}
	
	public EntityAcquisto(DBAcquisto acquisto) {
		
		this.idAcquisto=acquisto.getIdAcquisto();
		this.data = acquisto.getData();
		this.importo=acquisto.getImporto();
		acquisto.caricaCartaAcquistoDaDB();
		caricaCarta(acquisto);
		
	}
	
	public void caricaCarta(DBAcquisto acquisto) {
		
		EntityCartaDiCredito carta = new EntityCartaDiCredito(acquisto.getCarta());
		this.setCarta(carta);
		
	}
	
	
	public int getIdAcquisto() {
		return idAcquisto;
	}
	public void setIdAcquisto(int idAcquisto) {
		this.idAcquisto = idAcquisto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public float getImporto() {
		return importo;
	}
	public void setImporto(float importo) {
		this.importo = importo;
	}
	public EntityCartaDiCredito getCarta() {
		return carta;
	}
	public void setCarta(EntityCartaDiCredito carta) {
		this.carta = carta;
	}

	@Override
	public String toString() {
		return "EntityAcquisto [idAcquisto=" + idAcquisto + ", data=" + data + ", importo=" + importo + ", carta="
				+ carta + "]";
	}
	




}
