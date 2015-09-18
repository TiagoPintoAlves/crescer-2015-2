public class Dwarf{
    private String nome;
    private int life;
    private Status status;
    
    public Dwarf(String nome){
       this.nome = nome;
       this.life = 110;
       this.status = Status.VIVO;
    }
    
    public int getLife(){
        return this.life;
    }
    
    public void receberFlechada(){
         this.life -= 10;
    }
    
    public Status getStatus(){
        if(this.status == status.MORTO){
            return status.MORTO;
        }
        return this.status;
    }
}
