package raktar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import felvetel.Felvetel;
import org.tinylog.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Osztály a kellékek információinak megszerzésére és frissítése.
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
     * Adatbázis megnyitása.
     * <p>
     * A felhasználó által kiválasztott fájl kerül megnyitásra a
     * fájlrendszerből.
     *
     * @throws IOException ha bármilyen I/O hiba történik
     * @return a lista, amelyben a kellékek információit tároljuk.
     */
    public List<Raktar> open(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        stock = MAPPER.readValue(reader, new TypeReference<List<Raktar>>() {});

        Logger.info("Kellék adatbázis betöltése");
        return stock;
    }

    /** Adatbázis mentése.
     * <p>
     * A felhasználó által kiválasztott helyre kerül mentésre a fájl.
     * Az új fájl mentése előtt a megfelelő mezők új értékét kiszámoljuk.
     *
     * @param filePath ahová a mentés történik
     * @throws IOException ha bármilyen I/O hiba történik
     */
    public void saveAs(String filePath) throws IOException {
        List<Integer> nums = Felvetel.getAll();
        List<Raktar> newjson = getAll();
        Map<String, String> date = new HashMap<String, String>();

        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i) != 0) {
                newjson.get(i).setAvailable(newjson.get(i).getAvailable() - nums.get(i));
                date.put("year", Felvetel.getDate().get(0));
                date.put("month", Felvetel.getDate().get(1));
                date.put("day", Felvetel.getDate().get(2));
                newjson.get(i).setLastuse(date);
            }
        }

        MAPPER.writeValue(new File(filePath), newjson);
        Logger.info("Kellék adatbázis frissítve");
    }

    /**
     * Az információk listájának elérése.
     * @return a lista, amelyben a kellékek információit tároljuk.
     */
    public static List<Raktar> getAll() {
        return stock;
    }

}
