package raktar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import controller.FelvetelController;
import felvetel.Felvetel;
import org.json.JSONException;
import org.json.JSONObject;
import org.tinylog.Logger;

import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
     * Adatbázis frissítése.
     * <p>
     * A beolvasásra kerülő fájlnévvel megyező nével kerül elmentésre, így a
     * program következő indulásakor az új adatbázisból olvas be.
     * Az új fájl mentése előtt a megfelelő mezők új értékét kiszámoljuk.
     * @throws JSONException ha bármilyen hiba történik az állománnyal
     * @throws IOException ha bármilyen I/O hiba történik
     */
    public static void update() throws JSONException, IOException {
        new RaktarRepository();
        List<Integer> nums = Felvetel.getAll();
        List<Raktar> newjson = getAll();

        for (int i = 0; i < 13; i++){
            newjson.get(i).setAvailable(newjson.get(i).getAvailable() - nums.get(i));
        }

        MAPPER.writeValue(new File("src/main/resources/raktar/stock.json"), newjson);
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
