package raktar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import felvetel.Felvetel;
import org.json.JSONException;
import org.json.JSONObject;

import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public static void update() throws JSONException, IOException {
        new RaktarRepository();
        List<Integer> nums = Felvetel.getAll();
        List<Raktar> newjson = getAll();

        for (int i = 0; i < 13; i++){
            newjson.get(i).setAvailable(newjson.get(i).getAvailable() - nums.get(i));
        }

        MAPPER.writeValue(new File("src/main/resources/raktar/stock.json"), newjson);
        System.out.println("SUCCESS");
    }

    /**
     * Az információk listájának elérése.
     * @return a lista, amelyben a kellékek információit tároljuk.
     */
    public static List<Raktar> getAll() {
        return stock;
    }

}
