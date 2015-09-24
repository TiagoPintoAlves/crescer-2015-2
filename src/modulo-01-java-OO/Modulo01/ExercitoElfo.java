import java.util.*;

public class ExercitoElfo{
    HashMap<String, Elfo> exercitoElfo;

    public ExercitoElfo(){
        exercitoElfo = new HashMap<>();
    }

    public void alistarElfoVerde(ElfoVerde elfoVerde ){
        exercitoElfo.put(elfoVerde.getNome(), elfoVerde);
    }

    public void alistarElfoNoturno(ElfoNoturno elfoNoturno ){
        exercitoElfo.put(elfoNoturno.getNome(), elfoNoturno);
    }

    public Elfo buscarElfoPorNome(String nome){
        if(exercitoElfo.containsKey(nome)){
            return exercitoElfo.get(nome);
        }
        return null;
    }
    
    
}
