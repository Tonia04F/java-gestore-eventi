package jana60registrazioneeventi;

import java.time.LocalDate;

public class Conferenza extends Evento{
/*Creare una classe Conferenza che estende Evento, che ha anche gli attributi 
 ●   argomento 
 ●   oratore 
 l’oratore, a sua volta, è caratterizzato da: 
 ●   nome 
 ●   cognome 
 ●   titolo 
 Modificare il metodo main in modo che al momento della creazione dell’evento venga 
 richiesto se è una conferenza, e in tal caso valorizzare tutti i parametri. 
 Quando si stampano i dettagli della Conferenza, oltre a data e titolo, devono apparire anche 
 le informazioni sull’oratore e sull’argomento*/
	
	private String argomento;
	private Oratore oratore;
	
	
	public Conferenza(String titolo, LocalDate dataEvento, int postiTotali, String argomento, Oratore oratore)
			throws IllegalArgumentException, NumberFormatException {
		super(titolo, dataEvento, postiTotali);
		this.argomento = argomento;
		this.oratore = oratore;
		
		if(argomento == null) {
			throw new IllegalArgumentException("L'argomento non può essere nullo.");
		}
	}


	public String getArgomento() {
		return argomento;
	}


	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}


	public Oratore getOratore() {
		return oratore;
	}


	public void setOratore(Oratore oratore) {
		this.oratore = oratore;
	}


	@Override
	public String toString() {
		return super.toString() + "argomento: " + argomento + " l'oratore sarà: " + oratore.toString();
	
	}
	
	
}
