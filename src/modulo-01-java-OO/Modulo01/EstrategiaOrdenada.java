import java.util.*;
public class EstrategiaOrdenada implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();

    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return this.ordemDoUltimoAtaque;
    }

    public void atacar(ArrayList<Elfo> ListaAtacantes, ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque.clear();

        ArrayList<Elfo> vivos = new ArrayList<>();
        for(Elfo elfo : ListaAtacantes){
            this.ordemDoUltimoAtaque.clear();
            if(elfo.getStatus() == Status.VIVO){
                if(elfo instanceof ElfoVerde){
                    vivos.add(0, elfo);
                }else{
                    vivos.add(elfo);
                }
            }
            
        }
        
        for(Elfo elfo : vivos){
            ordemDoUltimoAtaque.add(elfo);
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);
                this.ordemDoUltimoAtaque.add(elfo);
            }
        }
    }
}