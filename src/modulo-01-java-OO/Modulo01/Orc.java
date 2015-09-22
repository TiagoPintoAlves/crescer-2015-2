/**
 * Escreva a descrição da classe orc aqui.
 * 
 * @author Tiago Alves 
 * @version 22/09/2015
 */
public class Orc{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    public int VIDA;
    protected Status status;
    protected Inventario inventario = new Inventario();

    /**
     * Construtor para objetos da classe orc
     */
    public Orc(){
        VIDA = (int)(100 / 10 * 2.5);
    }

    public void gerarVida(int vidaAleatoria) {
        VIDA = vidaAleatoria;
    }
	
	public void receberFlechadaElfo(Elfo elfo) {
		this.gerarVida(this.VIDA - 8);
	}
	
	public void receberFlechadaDwarf(Dwarf dwarf) {
		if(inventario.adicionarItem(inventario.getInventario())) {
			gerarVida(this.VIDA - 5);
		}
		gerarVida(this.VIDA - 10);
	}
    
    public void adicionarNovoItem(Item i) {
        
        if(i.getDescricao() == "Escudo Uruk-Hai") {
            this.EscudoUrukHai = i;
        }
        else if(i.getDescricao().indexOf("Flecha") >= 0) {
			
			if(i.getDescricao() == "Flecha1")
				this.Flecha1 = i;
			if(i.getDescricao() == "Flecha2")
				this.Flecha2 = i;
			if(i.getDescricao() == "Flecha3")
				this.Flecha3 = i;
			else
				this.Arco = new Item(1, "Arco  Uruk-Hai");
				this.Flecha1 = new Item(1, "Flecha");
        }
        else {
            this.Arco = i;
        }
        
    }
    
    public void AtacarAnao(Dwarf anao) {
    
        anao.vida -= 10;
        
        for (Item item : this.novosItens) {
            
			ArrayList<int> numeroDeFlechas = new ArrayList<int>();
			numeroDeFlechas.add(1);
			numeroDeFlechas.add(2);
			numeroDeFlechas.add(3);
			
			for(int i = 0; i <= 3  ;i++) {
				
				if(item.getDescricao() == "Flecha" + i) {
					this.novosItens.remove(item);
				}
			}
        }
    }
    
}