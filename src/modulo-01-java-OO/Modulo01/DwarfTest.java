import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test 
    public void dwarfNasceCom110DeVida(){
        Dwarf dwarf = new Dwarf();
        assertEquals(110, dwarf.getVida());
    }
}


