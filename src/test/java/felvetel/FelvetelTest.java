package felvetel;

import org.junit.jupiter.api.Test;
import raktar.RaktarRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * {@link Felvetel} osztály metódusainak tesztje.
 */
public class FelvetelTest {

    /**
     * {@link Felvetel} osztály <code>getAll()</code> metódus végrehajtásának tesztje.
     */
    @Test
    public void testGetAll() {
        assertEquals(13,Felvetel.getAll().size());
    }

    /**
     * {@link Felvetel} osztály <code>setNull()</code> metódus végrehajtásának tesztje.
     */
    @Test
    public void testSetNull() {
        Felvetel.setNull();
        for (int i = 0; i < Felvetel.getAll().size(); i++){
            assertEquals(0,Felvetel.getAll().get(i));
        }
    }

    /**
     * {@link Felvetel} osztály <code>item()</code> metódusának tesztje.
     * <p>
     * A teszt során egy példarendelés leadása történik.
     * A rendelés során leadott termék nevét és darabszámát adjuk át, az
     * <code>item()</code> metódusnak. A <code>getAll()</code> metódus
     * segítségével lekérdezzük a megfelelő értéket.
     */
    @Test
    public void testItem1() {
        Felvetel.setNull();
        Felvetel.item("autós", 2);
        assertEquals(2,Felvetel.getAll().get(1));
    }

    /**
     * {@link Felvetel} osztály <code>item()</code> metódusának tesztje.
     * <p>
     * A teszt során egy példarendelés leadása történik.
     * A rendelés során leadott termék nevét és darabszámát adjuk át, az
     * <code>item()</code> metódusnak. A <code>getAll()</code> metódus
     * segítségével lekérdezzük a megfelelő értéket.
     */
    @Test
    public void testItem2() {
        Felvetel.setNull();
        String termeknev = "Harry Potter";
        int num = 4;
        Felvetel.item(termeknev, num);
        assertEquals(4,Felvetel.getAll().get(2));
    }

    /**
     * {@link Felvetel} osztály <code>pack()</code> metódusának tesztje
     * <p>
     * A teszt során egy példarendelés leadása történik.
     * A rendelés során leadott termékek darabszámát adjuk át, a
     * <code>pack()</code> metódusnak. A <code>getAll()</code> metódus
     * segítségével lekérdezzük a megfelelő értéket.
     */
    @Test
    public void testGetPack() {
        assertEquals(Packaging.KISBORITEK,Felvetel.getPack(1));
        assertEquals(Packaging.NAGYBORITEK,Felvetel.getPack(2));
        assertEquals(Packaging.DOBOZ,Felvetel.getPack(3));
        assertEquals(Packaging.DOBOZ,Felvetel.getPack(5));
    }
}