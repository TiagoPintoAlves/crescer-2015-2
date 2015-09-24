import java.util.*;

public class ExercitoElfo{
    Map<String, Elfo> exercitoElfo;
    Map<Status, ArrayList<Elfo>> statusElfo;

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

    public void agruparPorStatus(){
        Status statusVivo = Status.VIVO;
        Status statusMorto = Status.MORTO;

        statusElfo = new HashMap<>();
        for(String nome : exercitoElfo.keySet()){
            Elfo elfo = exercitoElfo.get(nome);

            if(elfo.getStatus() == Status.VIVO){

                if(statusElfo.get(statusVivo) == null){
                    statusElfo.put(statusVivo, new ArrayList<Elfo>());
                }
                statusElfo.get(statusVivo).add(elfo);

            }else{

                if(statusElfo.get(statusMorto) == null){
                    statusElfo.put(statusMorto, new ArrayList<Elfo>());
                }
                statusElfo.get(statusMorto).add(elfo);
            }
        }
    }

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> elfos = new ArrayList<>();
        if(status == Status.VIVO){
            for(Map.Entry<Status, ArrayList<Elfo>> ListaElfos : statusElfo.entrySet()){
                Status key = ListaElfos.getKey();
                if(key == Status.VIVO){
                    elfos = ListaElfos.getValue();
                }
            }
        }else if(status == Status.MORTO){
            for(Map.Entry<Status, ArrayList<Elfo>> ListaElfos : statusElfo.entrySet()){
                Status key = ListaElfos.getKey();
                if(key == Status.MORTO){
                    elfos = ListaElfos.getValue();
                }
            }

        }
        return elfos;
    }

}
