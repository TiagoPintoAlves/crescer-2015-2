public class Elfo {
    
    private String nome;
    private int flechas = 42;
    private int experiencia;
    

    /* Type initializer
     * Executa antes de cada construtor
    {
        flechas = 42;
    }
    */
    public Elfo(String nome, int flechas) {
           this.nome = nome;
           this.flechas = flechas;
        }
    
    
    public Elfo(String nome) {
        this(nome, 42);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        flechas--;
        experiencia++;
        dwarf.receberFlechada();
        //experiencia += 1;
        //experiencia = experiencia + 1;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    public String toString(){
        return(this.nome+" possui "+this.flechas+" flechas e "+this.experiencia+" níveis de experiência");
        
    }
    /*
    public void setFlechas(int flechas) {
        if (flechas > this.flechas)
            this.flechas = flechas;
    }
    */
}
