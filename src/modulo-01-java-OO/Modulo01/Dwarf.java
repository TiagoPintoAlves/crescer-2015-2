public class Dwarf{
    private String nome;
    private int life;
    private int experiencia;
    private Status status;
    private DataTerceiraEra dataNascimento;

    public Dwarf(String nome){
        this.nome = nome;
        this.life = 110;
        this.status = Status.VIVO;
        this.dataNascimento = new DataTerceiraEra(1, 1, 1);
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this(nome);
        this.dataNascimento = dataNascimento;
    }

    public int getLife(){
        return this.life;
    }

    public void receberFlechada(){
        this.life -= 10;
        if(this.life <= 0){
            this.status = Status.MORTO;
            this.life = 0;
        }
    }

    public Status getStatus(){
        if(this.life <= 0){
            return this.status = Status.MORTO;
        }
        return this.status;
    }
}
