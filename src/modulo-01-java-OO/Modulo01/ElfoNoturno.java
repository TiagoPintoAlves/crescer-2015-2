<<<<<<< HEAD
public class ElfoNoturno extends Elfo{

    public ElfoNoturno(String nome, int flechas) {
        super(nome, flechas);
    }

    public ElfoNoturno(String nome) {
        super(nome, 42);
    }

    public ElfoNoturno(){
        super();
    }

    public void atirarFlecha(Object obj) {
        super.atirarFlecha(obj);
        super.experiencia += 2;
        this.vida -= (5 * this.vida)/100;

        if(this.vida < 1){
            this.vida = 0;
            this.status = Status.MORTO;
        }
    }

=======
public class ElfoNoturno extends Elfo
{   
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    /**
     * Atira a flecha em um orc, ganhando o triplo de experiência e perdendo 5% da vida atual.
     * 
     * @param Orc orc que receberá a flechada.
     */
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia += 2;
        double qtdVidaAPerder = this.vida * 0.05;
        //double qtdVidaAPerder = this.vida * 5/100;
        this.vida -= qtdVidaAPerder;
        this.status = (int)this.vida == 0 ? 
            Status.MORTO : this.status;
    }   
    
    @Override
    public String toString() {
        return "Elfo Noturno: " + super.toString();
    }
>>>>>>> 91040aa0dba51792e602e20302333545a7270d20
}