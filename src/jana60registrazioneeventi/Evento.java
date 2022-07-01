package jana60registrazioneeventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.zip.DataFormatException;

public class Evento {
/*La consegna è di creare una classe Evento che abbia le seguenti proprietà:
● titolo
● data
● numero di posti totali (cioè la capienza della location)
● numero di posti prenotati
Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore, tranne posti prenotati che va inizializzato a 0.
Inserire il controllo che la data non sia già passata e che il numero di posti totali sia un numero positivo. In caso contrario sollevare opportune eccezioni.
Aggiungere metodi getter e setter in modo che:
● titolo sia in lettura e in scrittura
● data sia in lettura e scrittura
● numero di posti totali sia solo in lettura
● numero di posti prenotati sia solo in lettura
Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
1. prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha più posti disponibili deve sollevare un’eccezione.
2. disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni deve sollevare un’eccezione.
3. l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo
Aggiungere eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.

*/
	 private String titolo;
	 private LocalDate dataEvento;
	 private int postiTotali;
	 private int postiPrenotati = 0;
	 private LocalDate data;
	 private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	 
	 //costruttore
	public Evento(String titolo, LocalDate dataEvento, int postiTotali ) throws IllegalArgumentException,NumberFormatException {
		super();
		
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.postiTotali = postiTotali;
		this.data = data;
		//inizializzo a 0 perchè ad ogni evento sono aggiunte un tot di persone
		this.postiPrenotati = 0;
		
		validaData();
		prenota();
		disdici();
		validaCapienza();
		postiRimasti();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	
	
	private void validaData() {
		if(dataEvento.isBefore(dataEvento.now())) {
			throw  new IllegalArgumentException("la data inserita non può essere un giorno già passato");
		}
	}
	
	int posti;
	 
	 public int prenota() {
		//valido posti, controllo che ci siano posti disponibili
			if(postiTotali < postiPrenotati) {
				throw new IllegalArgumentException("non ci sono più posti disponibili.");
			}
			return postiPrenotati += 1;
	 }
			
	public int disdici() {
		
			if(postiPrenotati <= 0) {
				throw new NumberFormatException("non ci sono prenotazioni per questo evento");
			}
			return postiPrenotati -= 1;
		
	 }
	public void validaCapienza() {
		
		if(postiTotali > 5 ) {
			throw new NumberFormatException("non ci sono posti disponibili");

		}
		
	}
	public int postiRimasti() {
		return postiTotali - postiPrenotati;
	}

	@Override
	public String toString() {
		return "Evento: " + titolo + " si svolgerà in data: " + dataEvento;
	}
	
	 
	
	
	
	
}
