import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest{
    @Test
    public void adicionarItemNoInventario(){
        Item item = new Item("poção", 1);
        ArrayList<Item> inventarioPocao = new ArrayList<>();
        inventarioPocao.add(item);
        assertEquals(item, inventarioPocao.get(0));
    }

    @Test
    public void criandoInventarioDeItensEImprindoDescricoes(){
        //Arrange
        ArrayList<Item> inventario = new ArrayList<>();
        Item pocoes = new Item("Poções", 4);
        Item facas = new Item("Facas", 3);
        Item espada = new Item("Espada", 1);
        //Act
        inventario.add(pocoes);
        inventario.add(facas);
        inventario.add(espada);
        //Assert
        assertEquals("Poções,Facas,Espada", inventario.get(0).getDescricao()+","+inventario.get(1).getDescricao()+","+inventario.get(2).getDescricao());
    }

    @Test
    public void criandoInventarioImprindoItemComMaiorQuantidade(){
        ArrayList<Item> inventario = new ArrayList<>();
        Item pocoes = new Item("Poções", 4);
        Item facas = new Item("Facas", 3);
        Item espada = new Item("Espada", 1);

        inventario.add(pocoes);
        inventario.add(facas);
        inventario.add(espada);

        assertEquals(pocoes, inventario.get(0));
    }

    @Test
    public void InventarioOrdemAscendente(){
        Inventario mochilaOrg = new Inventario();
        mochilaOrg.adicionarItem(new Item("Poções", 4));
        mochilaOrg.adicionarItem(new Item("Facas", 3));
        mochilaOrg.adicionarItem(new Item("Espada", 1));
        mochilaOrg.ordenarItens();
        
        assertEquals(1, mochilaOrg.getInventario().get(0).getQuantidade());
        assertEquals(3, mochilaOrg.getInventario().get(1).getQuantidade());
        assertEquals(4, mochilaOrg.getInventario().get(2).getQuantidade());
    }

}
