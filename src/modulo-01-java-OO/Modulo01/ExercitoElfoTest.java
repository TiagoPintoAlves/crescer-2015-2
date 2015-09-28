import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoElfoTest{
    @Test
    public void exercitoElfoAlistarEhBuscarElfosVerdes(){
        ExercitoElfo exercitoElfo = new ExercitoElfo();
        ElfoVerde green1 = new ElfoVerde("green1");
        ElfoVerde green2 = new ElfoVerde("green2");
        ElfoVerde green3 = new ElfoVerde("green3");
        exercitoElfo.alistar(green1);
        exercitoElfo.alistar(green2);
        exercitoElfo.alistar(green3);
        assertEquals(green1, exercitoElfo.buscarElfoPorNome("green1"));
        assertEquals(green2, exercitoElfo.buscarElfoPorNome("green2"));
        assertEquals(green3, exercitoElfo.buscarElfoPorNome("green3"));
    }
    
    @Test
    public void exercitoElfoAlistarEhBuscarElfosNoturnos(){
        ExercitoElfo exercitoElfo = new ExercitoElfo();
        ElfoNoturno dark1 = new ElfoNoturno("dark1");
        ElfoNoturno dark2 = new ElfoNoturno("dark2");
        ElfoNoturno dark3 = new ElfoNoturno("dark3");
        exercitoElfo.alistar(dark1);
        exercitoElfo.alistar(dark2);
        exercitoElfo.alistar(dark3);
        assertEquals(dark1, exercitoElfo.buscarElfoPorNome("dark1"));
        assertEquals(dark2, exercitoElfo.buscarElfoPorNome("dark2"));
        assertEquals(dark3, exercitoElfo.buscarElfoPorNome("dark3"));
    }
    
    @Test
    public void exercitoElfoBuscaElfoPorNome(){
        ExercitoElfo exercitoElfo = new ExercitoElfo();
        ElfoVerde green1 = new ElfoVerde("green1");
        ElfoVerde green2 = new ElfoVerde("green2");
        ElfoVerde green3 = new ElfoVerde("green3");
        ElfoNoturno dark1 = new ElfoNoturno("dark1");
        ElfoNoturno dark2 = new ElfoNoturno("dark2");
        ElfoNoturno dark3 = new ElfoNoturno("dark3");
        exercitoElfo.alistar(dark1);
        exercitoElfo.alistar(dark2);
        exercitoElfo.alistar(dark3);
        exercitoElfo.alistar(green1);
        exercitoElfo.alistar(green2);
        exercitoElfo.alistar(green3);
        
    }
    
    @Test
    public void exercitoUsaEstrategia
    
    
    
    
    
    
    
    
    
    
    
}
