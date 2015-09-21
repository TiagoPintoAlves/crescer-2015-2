import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest{
    @Test
    public void irishDwarfTem3EFicaCom1009(){
        DataTerceiraEra data = new DataTerceiraEra(1,1,2000);
        IrishDwarf dwarf = new IrishDwarf("ose", data);
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        Item item = new Item("batata", 3);
        dwarf.getInventario().adicionarItem(item);
        dwarf.tentarSorte();
        assertEquals(6003, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

}
