import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest{
  @Test
    public void elfoNasceComFlechasDefault(){
        Elfo Hadad = new Elfo("Hadad");
        assertEquals(42, Hadad.getFlechas());
    }
   
  @Test
    public void elfoNasceComONomeInformado(){
        Elfo elfinho = new Elfo("Elfinho");
       assertEquals("Elfinho", elfinho.getNome());
  }
     
  @Test
    
    public void elfoAtiraFlechasGanhaEXP() {
        Elfo Hadad = new Elfo("Hadad");
        Dwarf dwarf = new Dwarf();
        int flechasIniciais = Hadad.getFlechas();
        Hadad.atirarFlecha(dwarf);
        assertTrue(flechasIniciais > Hadad.getFlechas());
   }
    
}