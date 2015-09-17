import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest{
    @Test
    public void elfoRecebeNomeEFlechas() {
        Elfo Hadad = new Elfo("Hadad", 15);
        assertEquals(Elfo());
    }
    
    public void elfoRecebeNomeENaoRecebeFlechas() {
        Elfo  = new Elfo("", );
        assertEquals(Elfo);
    }
    
    public void elfoAtiraFlechas() {
        assertEquals(Elfo);
    }
    
}