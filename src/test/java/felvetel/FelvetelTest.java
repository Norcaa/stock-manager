package felvetel;

import org.junit.jupiter.api.Test;
import raktar.RaktarRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelvetelTest {

    @Test
    public void testGetAll() {
        assertEquals(13,Felvetel.getAll().size());
    }

    @Test
    public void testItem1() {
        String termeknev = "autós";
        int num = 2;
        Felvetel.item(termeknev, num);
        assertEquals(2,Felvetel.getAll().get(1));
    }

    @Test
    public void testItem2() {
        String termeknev = "Harry Potter";
        int num = 4;
        Felvetel.item(termeknev, num);
        assertEquals(4,Felvetel.getAll().get(2));
    }

    @Test
    public void testPack1() {
        int num = 1;
        Felvetel.pack(num);
        assertEquals(1,Felvetel.getAll().get(6));
        assertEquals(0,Felvetel.getAll().get(7));
        assertEquals(0,Felvetel.getAll().get(8));
        assertEquals(1,Felvetel.getAll().get(9));
        assertEquals(1,Felvetel.getAll().get(10));
        assertEquals(1,Felvetel.getAll().get(11));
        assertEquals(1,Felvetel.getAll().get(12));
    }

    @Test
    public void testSetNull() {
        Felvetel.setNull();
        for (int i = 0; i < Felvetel.getAll().size(); i++){
            assertEquals(0,Felvetel.getAll().get(i));
        }
    }
}