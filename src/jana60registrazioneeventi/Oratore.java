package jana60registrazioneeventi;

public class Oratore {
/*l’oratore, a sua volta, è caratterizzato da: 
 ●   nome 
 ●   cognome 
 ●   titolo */
	
	private String nome;
	private String cognome;
	private String titolo;
	
	
	public Oratore(String nome, String cognome, String titolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.titolo = titolo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	@Override
	public String toString() {
		return  nome + " " +   cognome;
	}
	
}

