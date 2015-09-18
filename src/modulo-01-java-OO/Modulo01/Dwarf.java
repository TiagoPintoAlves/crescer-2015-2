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
        if(this.life <= 0){
            this.status = Status.MORTO;
        }
    }
    
    public Status getStatus(){
        if(this.life <= 0){
            return this.status = Status.MORTO;
        }
        return this.status;
    }
}
