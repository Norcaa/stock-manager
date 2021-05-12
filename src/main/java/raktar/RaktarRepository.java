package raktar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.List;


public class RaktarRepository {

    Raktar raktar = new Raktar();

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private static List<Raktar> stock;

    public RaktarRepository() {
        try {
            stock = mapper.readValue(RaktarRepository.class.getResource("stock.json"), new TypeReference<List<Raktar>>() {});
        } catch(IOException e) {
            throw new AssertionError("Failed to load resource stock.json", e);
        }
    }

    public static List<Raktar> getAll() {
        return stock;
    }

}
