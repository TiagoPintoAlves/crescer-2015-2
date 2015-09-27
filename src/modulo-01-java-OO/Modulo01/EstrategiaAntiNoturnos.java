import java.util.*;
public class EstrategiaAntiNoturnos implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();

    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return this.ordemDoUltimoAtaque;
    }
    
    public void atacar(ArrayList<Elfo> ListaAtacantes, ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque.clear();

        ArrayList<Elfo> vivos = new ArrayList<>();
        for(Elfo elfo : ListaAtacantes){
            if(elfo.getStatus() == Status.VIVO){
                vivos.add(elfo);
            }
        }

        int intencoesAtaque = vivos.size() * dwarves.size();
        int limiteElfosNoturnos = (int)(intencoesAtaque * 0.3);
        int qtdElfosNoturnosQueJáAtacaram = 0;
        
        for( Elfo elfosVivos : vivos){
            boolean Noturnos = elfosVivos instanceof ElfoNoturno;
            if(Noturnos){
               if(qtdElfosNoturnosQueJáAtacaram >= limiteElfosNoturnos){
                    continue;
                }
               qtdElfosNoturnosQueJáAtacaram++;
            }
            
            ordemDoUltimoAtaque.add(elfosVivos);
            for(Dwarf dwarf : dwarves){
                elfosVivos.atirarFlecha(dwarf);
            }
        }
    }
    
    
}
