

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest{
    @Test
    public void elfoNoturnoAtiraFlechaEmAnao(){
        ElfoNoturno dark = new ElfoNoturno("Dark", 5);
        Dwarf alvo = new Dwarf();
        dark.atirarFlecha(alvo);
        assertEquals(3, dark.getExperiencia());
        assertEquals(4, dark.getFlechas());
        assertEquals(95, dark.getVida());
    }
}
