

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
    public void elfoNoturnoAtiraFlechaEmDwarf(){
        ElfoNoturno dark = new ElfoNoturno("Dark", 5);
        Dwarf alvo = new Dwarf();
        dark.atirarFlecha(alvo);
        assertEquals(3, dark.getExperiencia());
        assertEquals(4, dark.getFlechas());
        assertEquals(95, dark.getVida());
    }
    
    @Test
    public void elfoNoturnoAtiraFlechaEmOrc(){
        ElfoNoturno dark = new ElfoNoturno("Dark", 5);
        Orc alvo = new Orc();
        dark.atirarFlecha(alvo);
        assertEquals(3, dark.getExperiencia());
        assertEquals(4, dark.getFlechas());
        assertEquals(95, dark.getVida());
    }
    
    @Test
    public void elfoNoturnoAtiraFlechaEmOrcSnaga(){
        ElfoNoturno dark = new ElfoNoturno("Dark", 5);
        Orc alvo = new Snaga();
        dark.atirarFlecha(alvo);
        assertEquals(3, dark.getExperiencia());
        assertEquals(4, dark.getFlechas());
        assertEquals(95, dark.getVida());
        assertEquals(60, alvo.getVida());
    }
    
    @Test
    public void elfoNoturnoAtiraFlechaEmOrcUrukHai(){
        ElfoNoturno dark = new ElfoNoturno("Dark", 5);
        Orc alvo = new UrukHai();
        dark.atirarFlecha(alvo);
        assertEquals(3, dark.getExperiencia());
        assertEquals(4, dark.getFlechas());
        assertEquals(95, dark.getVida());
        assertEquals(144, alvo.getVida());
    }
    
    
    
    
}
