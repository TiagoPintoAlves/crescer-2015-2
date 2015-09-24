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

}