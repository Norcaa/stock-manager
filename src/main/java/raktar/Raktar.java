package raktar;

import java.util.Map;

// CHECKSTYLE:OFF
/**
 * A kellékek információ mezőit tartalmazó osztály.
 * <p>
 * Minden kellék rendelkezik névvel, mennyiséggel, egységgel, mérettel és az utolsó használat dátumával.
 */
@lombok.Data
public class Raktar {

    public String name;
    public int available;
    public String unit;
    public String size;
    public Map<String, String> lastuse;
}
