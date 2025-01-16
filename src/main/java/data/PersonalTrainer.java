package data;

import java.util.ArrayList;

public class PersonalTrainer extends Utente {
    private ArrayList<String> attestati;
    private boolean abilitato;

    // Costruttore
    public PersonalTrainer(String nome, String cognome, String email, String indirizzo, int eta, String recapitoTelefonico, String citta, int idP, ArrayList<String> attestati, boolean abilitato) {
        super(nome, cognome, email, indirizzo, eta, recapitoTelefonico, citta, idP);
        this.attestati = attestati;
        this.abilitato = abilitato;
    }

    public boolean isAbilitato() {
        return abilitato;
    }

    public void setAbilitato(boolean abilitato) {
        this.abilitato = abilitato;
    }

    public ArrayList<String> getAttestati() {
        return attestati;
    }

    public void setAttestati(ArrayList<String> attestati) {
        this.attestati = attestati;
    }
}