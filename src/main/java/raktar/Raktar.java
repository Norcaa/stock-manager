package raktar;

import java.util.Map;

@lombok.Data
public class Raktar {

    public String name;
    public int available;
    public String unit;
    public String size;
    public Map<String, String> lastuse;
}
