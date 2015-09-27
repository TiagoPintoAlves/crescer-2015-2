import java.util.*;

public class EstrategiaGeneralElfo implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public void atacar(ArrayList<Elfo> ListaAtacantes, ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque.clear();
        
        for(Elfo elfo : ListaAtacantes){
            ordemDoUltimoAtaque.add(elfo);
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);
            }
        }
    }

    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return this.ordemDoUltimoAtaque;
    }
    
}
