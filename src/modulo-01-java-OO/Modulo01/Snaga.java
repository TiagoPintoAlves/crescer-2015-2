public class Snaga extends Orc{

    public Snaga(){
        Item arco = new Item(1, "Arco");
        Item flechas = new Item(5, "Flecha");
        super.adicionarItem(arco);
        super.adicionarItem(flechas);
        super.vida = 70;
    }

}
