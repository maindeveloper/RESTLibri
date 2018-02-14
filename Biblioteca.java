package ifts.libri;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

// QUESTA CLASSE SERVE PER IMPLEMENTARE I SERVIZI REST
// QUINDI   "POST"  "PUT"  "GET"  "DELETE"

@Path("/biblioteca")
@Produces(MediaType.APPLICATION_JSON)
public class Biblioteca {

    private final String descrizioneIniziale;
    private final List<Libro> biblioteca;

    public Biblioteca(String descrizioneIniziale){
        this.descrizioneIniziale=descrizioneIniziale;
        this.biblioteca = new ArrayList<Libro>();
    }

    public int ricercaLibro(String isbn){
        for(int i=0; i<biblioteca.size(); i++){
            if(biblioteca.get(i).getIsbn().equals(isbn)){
                return i;
            }
        }
        return -1;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postLibro(Libro l){
        int indice=ricercaLibro(l.getIsbn());

        if(indice == -1){
            biblioteca.add(l);
        }
    }

    @GET
    @Path("/{isbn}")
    public Libro getLibro(@PathParam("isbn") String isbn){
        int indice=ricercaLibro(isbn);

        if(indice != -1){
            return biblioteca.get(indice);
        }else{
            return null;
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{isbn}")
    public void putLibro(@PathParam("isbn") String isbn,
                         Libro l){

        int indice=ricercaLibro(isbn);
        l=new Libro(l.getIsbn(),l.getTitolo(),l.getAutori(),l.getEditore(),descrizioneIniziale);
        if(indice != -1){
            biblioteca.remove(indice);
            biblioteca.add(l);
        }

    }

    @DELETE
    @Path("/{isbn}")
    public void deleteLibro(@PathParam("isbn") String isbn){
        int indice=ricercaLibro(isbn);

        if(indice != -1){
            biblioteca.remove(indice);
        }
    }

}
