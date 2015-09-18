import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void DataTerceiraEraObterDiaMesAno(){
        DataTerceiraEra date = new DataTerceiraEra(21,5,2000);
        assertEquals(21, date.getDia());
        assertEquals(5, date.getMes());
        assertEquals(2000, date.getAno());
    }
    
    @Test
    public void DataTerceiraEraAnoBissextoTrue(){
        DataTerceiraEra date = new DataTerceiraEra(21,5,2012);
        
        assertEquals(true, date.ehBissexto());
    }
    
    
    @Test
    public void DataTerceiraEraAnoBissextoFalse(){
        DataTerceiraEra date = new DataTerceiraEra(21,5,2015);
        assertEquals(false, date.ehBissexto());
    }
}
