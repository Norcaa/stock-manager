package raktar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.List;

/**
 * Osztály a kellékek információinak megszerzésére.
 */
public class RaktarRepository {

    private final Raktar raktar = new Raktar();

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    private static List<Raktar> stock;

    /**
     * Információ szerzése a forrásfájlból.
     * <p>
     * A stock.json állomány beolvasása a {@link Raktar} osztály értékeinek megfelelően.
     * A beolvasás értékét a stock listában tároljuk.
     * Ha az argumentum <code>null</code>, akkor információt kapunk a sikertelen betöltésről.
     */
    public RaktarRepository() {
        try{
            stock = MAPPER.readValue(RaktarRepository.class.getResource("stock.json"), new TypeReference<List<Raktar>>() {});
        } catch (IOException e) {
            throw new AssertionError("Nem sikerült a stock.json betöltése", e);
        }
    }

    /**
     * Az információk listájának elérése.
     * @return a lista, amelyben a kellékek információit tároljuk.
     */
    public static List<Raktar> getAll() {
        return stock;
    }

}
