package ifts.libri;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// QUESTA CLASSE RAPPRESENTA LA RISORSA OVVERO IL LIBRO

public class Libro {

    private String isbn;
    private String titolo;
    private List<String> autori;
    private String editore;
    private String descrizione;

    public Libro(){

    }

    public Libro(String isbn, String titolo, List<String> autori, String editore, String descrizione) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.editore = editore;
        this.descrizione = descrizione;
        this.autori = autori;
    }

    @JsonProperty
    public String getIsbn() {
        return isbn;
    }

    @JsonProperty
    public String getTitolo() {
        return titolo;
    }

    @JsonProperty
    public List<String> getAutori() {
        return autori;
    }

    @JsonProperty
    public String getEditore() {
        return editore;
    }

    @JsonProperty
    public String getDescrizione() {
        return descrizione;
    }




}
