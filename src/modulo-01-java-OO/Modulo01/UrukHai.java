public class UrukHai extends Orc{

    public UrukHai(){
        Item escudoUrukHai = new Item(1, "Escudo Uruk-Hai");
        Item espada = new Item(1, "Espada");
        super.adicionarItem(escudoUrukHai);
        super.adicionarItem(espada);
        super.vida = 150;
    }

}
