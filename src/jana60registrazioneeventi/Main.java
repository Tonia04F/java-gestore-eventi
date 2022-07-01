package jana60registrazioneeventi;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*1. Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.
			2. Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, 
			implementando opportuni controlli e gestendo eventuali eccezioni.
			3. Stampare a video il numero di posti prenotati e quelli disponibili
			4. Chiedere all’utente se e quanti posti vuole disdire
			5. Provare ad effettuare le disdette, implementando opportuni controlli e gestendo
			eventuali eccezioni
			6. Stampare a video il numero di posti prenotati e quelli disponibili*/ 

		Scanner sc = new Scanner(System.in);
		boolean datiValidi = false;
		Evento evento = null;
		
		
			
			do {
				
				try {
					//titolo
					System.out.println("Dai un nome all'evento: ");
					String titolo = sc.nextLine();
					
					//data
					System.out.println("inserisci giorno dell'evento: ");
					int giorno = Integer.parseInt(sc.nextLine());
					System.out.println("inserisci mese: ");
					int mese = Integer.parseInt(sc.nextLine());
					System.out.println("inserisci anno: ");
					int anno = Integer.parseInt(sc.nextLine());
					
					//limite posti
					System.out.println("stabilisci i posti totali: ");
					int postiTotali = Integer.parseInt(sc.nextLine());
					
					//creo evento
					LocalDate data = LocalDate.of(anno, mese, giorno);
					evento = new Evento(titolo, data, postiTotali);
					datiValidi= true;
			
			
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	}while (!datiValidi);
			
			do {
				try {
					int scelta = 0;
					int postiPrenotati = 0;
					int postiDisdetti = 0;
					//chiedo all utente se vuole aggiungere invitati
					System.out.println("vuoi aggiungere prenotazioni? 1 per aggiungere 2 per uscire: ");
					scelta = Integer.parseInt(sc.nextLine());
					if (scelta == 1) {
						System.out.println("quante persone voi prenotare? ");
						postiPrenotati = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < postiPrenotati; i++) {
							evento.prenota();

						}
						System.out.println("hai prenotato " + evento.getPostiPrenotati() + " invitati" + "sono rimasti "
								+ evento.postiRimasti() + "posti diponibili");

					} else if (scelta == 2) {
						System.out.println("non ci sono ancora prenotazioni per il tuo evento");
					}
					
					
					//chiedo all utente se vuole disdire qualche prenotazione
					System.out.println("vuoi disdire qualche prenotazione? 1 per disdire, 2 per uscire: ");
					scelta = Integer.parseInt(sc.nextLine());
					if (scelta == 1) {
						System.out.println("quante prenotazioni vuoi disdire? ");
						postiDisdetti = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < postiDisdetti; i++) {
							evento.disdici();

						}
						System.out.println("sono rimasti " + evento.postiRimasti() + "posti disponibili");
						System.out.println("L'evento " + evento.getTitolo() + " ha già " + evento.getPostiPrenotati() + " posti prenotati " + " ne sono rimasti: " + evento.postiRimasti() + " anora disponibili");
					}
				} catch (NumberFormatException e) {
					System.out.println("i dati inseriti non sono validi " + e.getMessage());
					
				} 
			} while (!datiValidi);
			
			
	sc.close();	
	}
}

		
		
		
			

	