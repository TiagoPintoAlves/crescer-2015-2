import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest{
    @Test
    public void CriandoItemComDescricaoQuantidade(){
        Item novoItem = new Item("Poção de Vida", 1);
        assertEquals("Poção de Vida", novoItem.getDescricao());
        assertEquals(1, novoItem.getQuantidade());
    }
    
}