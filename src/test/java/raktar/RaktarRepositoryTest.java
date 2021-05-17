package raktar;

import felvetel.Felvetel;
import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import raktar.Raktar;
import raktar.RaktarRepository;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * {@link RaktarRepository} osztály tesztje.
 */
public class RaktarRepositoryTest {

    /**
     * {@link RaktarRepository} osztály és annak a <code>getAll()</code>
     * metódusának a tesztje.
     */
    @Test
    public void testRaktarRepository() {
        new RaktarRepository();
        assertEquals(13, RaktarRepository.getAll().size());
    }

    /**
     * {@link RaktarRepository} osztály <code>update()</code> metódusának a tesztje.
     * <p>
     * A teszt során több példarendelés leadása történik.
     * A rendelés során leadott dátumot és a termékek darabszámát adjuk át, a
     * {@link Felvetel} osztály <code>item()</code> és <code>hozzaadas()</code>
     * metódusának.
     * A <code>getAll()</code> metódus segítségével lekérdezzük az értéket,
     * amelyeknek különböznie kell a rendelés előtti értékektől.
     */
    @Test
    public void testUpdate() throws IOException {
        new RaktarRepository();
        List<Raktar> older = RaktarRepository.getAll();
        Felvetel.item("Virágos", 3);
        Felvetel.item("Autós", 2);
        Felvetel.item("Harry Potter", 4);
        Felvetel.item("Star Wars", 5);
        Felvetel.hozzaadas("Példa Péter", 1, 2021, 5, 14);
        Felvetel.hozzaadas("Példa Péter", 2, 2021, 5, 8);
        Felvetel.hozzaadas("Példa Péter", 3, 2021, 4, 16);

        RaktarRepository.update();

        List<Raktar> newer = RaktarRepository.getAll();
        for (int i = 0; i < older.size(); i++) {
            assertNotEquals(newer.get(i), older.get(i));
        }
    }
}
