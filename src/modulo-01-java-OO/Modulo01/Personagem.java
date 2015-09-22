public class Personagem{
    protected String nome;
    protected int experiencia, vida;
    protected Status status;
    private Inventario inventario = new Inventario();

    public void adicionarItem(Item item){
        inventario.adicionarItem(item);
    }

    public Inventario getInventario(){
        return this.inventario;
    }

    public int getVida(){
        return this.vida;
    }

    public int getExperiencia(){
        return this.experiencia;
    }

    public Status getStatus(){
        return this.status;
    }

    public String getNome() {
        return this.nome;
    }
    
    public void receberAtaqueDoOrc(Orc orc){
        int dano = orc.getDanoDeAtaque();
        this.vida -= dano;
    }
    
}
