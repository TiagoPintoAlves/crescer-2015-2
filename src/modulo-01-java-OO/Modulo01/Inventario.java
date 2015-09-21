import java.util.ArrayList;
public class Inventario{
    ArrayList<Item> inventario = new ArrayList<>();

    public void adicionarItem(Item item) {
        this.inventario.add(item);
    }

    public void perderItem(Item item){
        this.inventario.remove(item);
    }

    public ArrayList<Item> getInventario(){
        return this.inventario;
    }

    public String getDescricoesItens(){
        int cont = 1;
        String retorno = "";
        for(Item item: inventario){
            retorno += String.format("%s%s", item.getDescricao(), (this.inventario.size() == cont) ? "" : ",");
            cont++;
        }
        return retorno;
    }

    public Item getItemComMaiorQuantidade(){
        Item maiorQuantia = new Item("", 1);
        int maiorQuantidade = 0;
        for(Item item : inventario){
            if (item.getQuantidade() > maiorQuantia.getQuantidade()){
                maiorQuantia = new Item(item.getDescricao(), item.getQuantidade()); 
            }
        }
        return maiorQuantia;
    }

    public void ordenarItens(){
        Item prox;
        
        for(int i = 0; i < inventario.size();i++){
            for(int j = 0; j < inventario.size() - 1; j++){
                if(inventario.get(j).getQuantidade() > inventario.get(j + 1).getQuantidade()){
                    prox = inventario.get(j);
                    inventario.set(j, inventario.get(j + 1));
                    inventario.set(j + 1, prox);
                }
            }
        }
    }
    
}
