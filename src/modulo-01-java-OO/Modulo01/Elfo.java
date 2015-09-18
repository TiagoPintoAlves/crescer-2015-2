public class Elfo {
    private String nome;
    private int flechas;
    private int experiencia;
    private Status status = Status.VIVO;
    
    /* Type initializer
     * Executa antes de cada construtor
    {
        flechas = 42;
    }
    */

    public Elfo(String nome, int flechas) {
           this.nome = nome;
           this.flechas = flechas;
           this.status = Status.VIVO;
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
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public String toString() {

        boolean flechaNoSingular = Math.abs(this.flechas) == 1;
        boolean nivelNoSingular = Math.abs(this.experiencia) == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência.",
            this.nome,
            this.flechas,
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            nivelNoSingular ? "nível" : "níveis");
    }
    
    /*
    public void setFlechas(int flechas) {
        if (flechas > this.flechas)
            this.flechas = flechas;
    }
    */
}
