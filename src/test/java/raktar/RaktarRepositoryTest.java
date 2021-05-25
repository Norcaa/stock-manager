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


}
