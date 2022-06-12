package tests;

import exceptions.*;
import javax.swing.JOptionPane;

import boundary.BCittadino;

import exceptions.IscrizioneNonTrovata;
import exceptions.MinAcquistiNonRaggiunto;
import exceptions.PasswordErrata;
import exceptions.ProgrammaNonTerminato;
import exceptions.ProgrammaNonTrovato;

public class TesterThread extends Thread {

	private int index;
	private String idCittadino;
	private String password;
	private int idProgramma;
	


	public TesterThread(int index, String idCittadino, String password, int idProgramma) {
		super();
		this.index = index;
		this.idCittadino = idCittadino;
		this.password = password;
		this.idProgramma = idProgramma;
	}




	public void start() {
	
		try {
			
			BCittadino cittadino = new BCittadino();
			cittadino.richiediRimborso(idProgramma, idCittadino, password);
			System.out.println("Test ["+ index +"] PASSED.");
			
			
		}catch(ProgrammaNonTrovato | MinAcquistiNonRaggiunto | PasswordErrata | 
				IscrizioneNonTrovata| ProgrammaNonTerminato | IllegalArgumentException  e1){
			System.out.println("Test ["+ index +"] FAILED. Errore: "+ e1.toString());
		}
	}
	
}
