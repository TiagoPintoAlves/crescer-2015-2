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

    public void receberFlechada(){
        if(getNumeroSorte() < 0){
            this.life = life;
            this.experiencia += 2;
            
        }else{
            if(getNumeroSorte() >= 0 && getNumeroSorte() <= 100){
                this.life = life;
                this.experiencia = experiencia;
            }
        }
        
        this.life -= 10;
        if(this.life <= 0){
            this.status = Status.MORTO;
            this.life = 0;
        }
    }

    public int getLife(){
        return this.life;
    }

    public Status getStatus(){
        if(this.life <= 0){
            return this.status = Status.MORTO;
        }
        return this.status;
    }

    public double getNumeroSorte(){
        double valorInicial = 101.0;

        if(this.dataNascimento.ehBissexto() == true && this.life >= 80 && this.life <= 90){
            return valorInicial *= (-33);
        }else{
            if(this.dataNascimento.ehBissexto() == false && this.nome == "Seixas" || this.nome == "Meireles"){
                int operadorMod = 100;
                return valorInicial = (valorInicial *= 33) / operadorMod;
            }
        }
        
        return valorInicial;
    }

    
}
