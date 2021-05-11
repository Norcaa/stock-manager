package felvetel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import felvetel.Termek;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TermekRepository {

    private static final ObjectMapper mapper = new ObjectMapper();
    // ObjectMapper mapper = new ObjectMapper();

    private List<Termek> products;

    public TermekRepository() {
        try {
            products = mapper.readValue("products.json", new TypeReference<List<Termek>>() {});
        } catch(IOException e) {
            throw new AssertionError("Failed to load resource products.json", e);
        }
    }

    public List<Termek> getAll() {
        return products;
    }

}
