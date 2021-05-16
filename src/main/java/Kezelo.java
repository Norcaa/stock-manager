
import javafx.application.Application;
import main.MyApplication;

/**
 * Main osztály, a program indulásáért felelős.
 */
public class Kezelo {

    /**
     * Meghívásakor elindítja a JavaFX alkalmazást.
     * <p>
     * Meghívja a {@link MyApplication} osztályt.
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(MyApplication.class, args);
    }
}
