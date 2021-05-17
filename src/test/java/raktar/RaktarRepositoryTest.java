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

public class RaktarRepositoryTest {

    @Test
    public void testRaktarRepository() {
        new RaktarRepository();
        assertEquals(13, RaktarRepository.getAll().size());
    }

    @Test
    public void testUpdate() throws IOException {
        new RaktarRepository();
        List<Raktar> older = RaktarRepository.getAll();
        Felvetel.item("Virágos", 3);
        Felvetel.item("Autós", 2);
        Felvetel.item("Harry Potter", 4);
        Felvetel.item("Star Wars", 5);
        Felvetel.pack(1);
        Felvetel.pack(2);
        Felvetel.pack(3);

        RaktarRepository.update();

        List<Raktar> newer = RaktarRepository.getAll();
        for (int i = 0; i < older.size(); i++) {
            assertNotEquals(newer.get(i), older.get(i));
        }
    }
}
