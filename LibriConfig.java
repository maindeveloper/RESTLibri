package ifts.libri;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;


public class LibriConfig extends Configuration {

    private String descrizioneIniziale;

    @JsonProperty
    public String getDescrizioneIniziale() {
        return descrizioneIniziale;
    }

    @JsonProperty
    public void setDescrizioneIniziale(String descrizioneIniziale) {
        this.descrizioneIniziale = descrizioneIniziale;
    }


}
