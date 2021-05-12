package felvetel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.util.List;


public class TermekRepository {

    Termek termek = new Termek();

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private static List<Termek> products;

    public TermekRepository() {
        try {
            System.out.println("HAHAH");
            products = mapper.readValue(TermekRepository.class.getResource("products.json"), new TypeReference<List<Termek>>() {});
        } catch(IOException e) {
            throw new AssertionError("Failed to load resource products.json", e);
        }
    }

    public static String getAll() {
        return "alma";
    }

}
