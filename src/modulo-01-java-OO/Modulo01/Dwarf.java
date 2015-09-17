public class Dwarf{
    private String nome;
    private int life;
    private Status dwarfStatus = Status.VIVO;
    
    public Dwarf(String nome){
       this.nome = nome;
       this.life = 110;
    }
    
    public int getLife(){
        return this.life;
    }
    
    public void receberFlechada(){
         this.life -= 10;
    }
    
    public Status getStatus(){
        if(this.dwarfStatus == dwarfStatus.MORTO){
            return dwarfStatus.MORTO;
        }
        return this.dwarfStatus;
    }
}
