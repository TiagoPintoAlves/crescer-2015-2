import java.util.*;
public class Personagem {
    protected String nome;
    protected Status status;
<<<<<<< HEAD
    protected int vida;
    protected int experiencia;
=======
    protected int experiencia;
    protected double vida;
>>>>>>> 91040aa0dba51792e602e20302333545a7270d20
    protected final Inventario inventario;

    public Personagem() {
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public String getNome() {
        return this.nome;
    }

    public Status getStatus() {
        return this.status;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public double getVida() {
        return this.vida;
    }

    public void adicionarItem(Item item) {
        inventario.adicionarItem(item);
    }

    public void perderItem(Item item) {
        inventario.perderItem(item);
    }

    public void receberAtaqueDoOrc(Orc orc){
        int dano = orc.getDanoDeAtaque();
        this.vida -= dano;
    }
    
}