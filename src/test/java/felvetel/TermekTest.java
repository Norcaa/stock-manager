package felvetel;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TermekTest {

    private static List<String> products = new ArrayList<String>(4);

    @Test
    public void testGetAll(){
        new Termek();
        products.add("Autós füzet");
        products.add("Virágos füzet");
        products.add("Harry Potter füzet");
        products.add("Star Wars füzet");
        assertEquals(products,Termek.getAll());
    }
}
