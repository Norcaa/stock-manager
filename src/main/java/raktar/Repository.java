package raktar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Repository {

    private static final ObjectMapper mapper = new ObjectMapper();
    // ObjectMapper mapper = new ObjectMapper();

    private static List<Raktar> stock;

    public static List<Raktar> StockRepository() {
        try {
            List<Raktar> stock = Arrays.asList(mapper.readValue("stock.json", new TypeReference<Raktar>() {}));
            System.out.println("HAHAHAHA");

            var name = mapper.writeValueAsString(Math.PI);
            var available = mapper.writeValueAsString(1);
            var unit = mapper.writeValueAsString(false);
            var size = mapper.writeValueAsString(null);
            var lastuse = mapper.writeValueAsString(new int[] {1, 2, 3, 4, 5});System.out.println(mapper.writeValueAsString(new int[]{1, 2, 3,4, 5}));

            System.out.println(name);
            System.out.println(available);
            System.out.println(unit);
            System.out.println(size);
            System.out.println(lastuse);

            var result1 = mapper.readValue(name, Double.class);
            System.out.println(result1);
            var result4 = mapper.readValue(available, Integer.class);
            System.out.println(result4);

            return stock;
            //List<Raktar.Raktar> stock = readValue("stock.json", new TypeReference<List<Raktar.Raktar>>() {});
        } catch(IOException e) {
            throw new AssertionError("Failed to load resource stock.json", e);
        }
    }
    /*
    private void load(InputStream what) throws IOException {
        stock = mapper.readValue(what, new TypeReference<List<Raktar.Raktar>>() {});
    }
    */
    public List<Raktar> getAll() {
        return stock;
    }

}
