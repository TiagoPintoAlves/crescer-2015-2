import java.util.*;

public class ExercitoElfo {
    HashMap<String, Elfo> exercitoElfo;
    HashMap<Status, ArrayList<Elfo>> statusElfo = new HashMap<>();
    private EstrategiaDeAtaque estrategia = new EstrategiaGeneralElfo();

    public ExercitoElfo(){
        exercitoElfo = new HashMap<>();
    }

    public void alistar(Elfo elfo ){
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;

        if(podeAlistar){
            this.exercitoElfo.put(elfo.getNome(), elfo);
        }
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

    public void atacar(ArrayList<Elfo> ListaAtacantes, ArrayList<Dwarf> dwarves){
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        
    }
}