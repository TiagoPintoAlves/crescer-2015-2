import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida() {
        Dwarf gimli = new Dwarf("gimli");
        assertEquals(110, gimli.getLife());
    }

    @Test
    public void dwarfRecebeFlechaEPerde10Vida() {
        // AAA
        // Arrange
        Dwarf gimli = new Dwarf("gimli");
        int vidaEsperada = 100;
        // Act
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getLife());
    }

    @Test
    public void dwarfRecebeFlecha11VezesEVidaÉ0() {
        Dwarf gimli = new Dwarf("gimli");
        int vidaEsperada = 0;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getLife());
    }

    @Test
    public void dwarfRecebeFlecha7VezesEVidaÉ40() {
        Dwarf gimli = new Dwarf("gimli");
        int vidaEsperada = 40;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getLife());
    }
    
    @Test
    public void dwarfRecebeFlechaAteMorrer(){
        Dwarf gimli = new Dwarf("gimli");
        
        for(int i=0; i<=11; i++){
            gimli.receberFlechada();
        }
        int vidaEsperada = 0;
        Status statusEsperado = gimli.getStatus();
        
        assertEquals(statusEsperado, gimli.getStatus());
    }
    
    @Test
    public void dwarfNesceEmAnoBissextoComVida80(){
       DataTerceiraEra dataNascimento = new DataTerceiraEra(21,5,2012);
       Dwarf gimli = new Dwarf("gimli", dataNascimento);
       
       int ehBissexto = dataNascimento.getAno();
       
       assertEquals(80, gimli.getLife());
       assertEquals(ehBissexto, dataNascimento.ehBissexto());
    }
    
    @Test
    public void dwarfNumeroSorteadoMenorQueZeroGanha2Exp(){
       DataTerceiraEra dataNascimento = new DataTerceiraEra(21,5,2012);
       Dwarf gimli = new Dwarf("gimli", dataNascimento);
       
       assertEquals(-3333, gimli.getNumeroSorte());
       assertEquals(true, dataNascimento.ehBissexto());
 
    }
    
    @Test
    public void dwarfSeixasNumeroSorteadoEntre0E100MantemVidaEExp(){
       DataTerceiraEra dataNascimento = new DataTerceiraEra(21,5,2015);
       Dwarf Seixas = new Dwarf("Seixas", dataNascimento);
       
       double valorInicial = Seixas.getNumeroSorte();
       
       assertEquals(valorInicial, Seixas.getNumeroSorte());
       assertEquals(false, dataNascimento.ehBissexto());
    }
    
    @Test
    public void dwarfMeirelesNumeroSorteadoEntre0E100(){
       DataTerceiraEra dataNascimento = new DataTerceiraEra(21,5,2015);
       Dwarf Meireles = new Dwarf("Meireles", dataNascimento);
       
       double valorInicial = Meireles.getNumeroSorte();
       
       assertEquals(valorInicial, Meireles.getNumeroSorte());
       assertEquals(false, dataNascimento.ehBissexto());
    }
}