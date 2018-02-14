package ifts.libri;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class AppBiblioteca extends Application<LibriConfig> {

    public static void main(String[] args) throws Exception{
        new AppBiblioteca().run(args);
    }

    public void run(LibriConfig libriConfig, Environment environment){
        final Biblioteca risorsaBiblioteca = new Biblioteca(libriConfig.getDescrizioneIniziale());
        environment.jersey().register(risorsaBiblioteca);
    }
}
