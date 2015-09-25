import java.util.*;

public class EstrategiaGeneralElfo implements EstrategiaDeAtaque{
    private ArrayList<Elfo> getOrdemDoUltimoAtaque = new ArrayList<>();
    private ArrayList<Elfo> ListaAtaques = new ArrayList<>();
    private int cont = 0;
    public void atacar(ArrayList<Elfo> ListaAtacantes, ArrayList<Dwarf> dwarves){
        getOrdemDoUltimoAtaque.clear();
        
        for(Elfo elfo : ListaAtaques){
            cont++;
            getOrdemDoUltimoAtaque.add(elfo);
            for(Dwarf dwarf : dwarves){
                
                elfo.atirarFlecha(dwarf);
                
                if(elfo instanceof ElfoNoturno && elfo.getStatus() == Status.VIVO ){
                    continue;
                }
            }
        }
    }

    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return this.getOrdemDoUltimoAtaque;
    }

    //     public double intencaoAtaque(ArrayList<Elfo> ListaAtacantes, ArrayList<Dwarf> dwarves){
    //         for(Elfo elfo : ListaAtaques){
    //             for(Dwarf dwarf : dwarves){
    //                 elfo.atirarFlecha(dwarf);
    // 
    //                 if(elfo instanceof ElfoNoturno && elfo.getVida() == 0){
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    
    
}
