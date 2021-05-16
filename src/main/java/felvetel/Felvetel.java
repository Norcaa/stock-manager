package felvetel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import org.tinylog.Logger;

/**
 * Egy rendelés felvételének a lebonyolítása.
 * <p>
 * Az adott kellék levonás egyenlőre képletes, az osztály a levonandó értékeket
 * tárolja integer típusú változókban.
 * Modell.
 */
public class Felvetel {

    private static int viragos;
    private static int autos;
    private static int harry;
    private static int starwars;
    private static int spiral;
    private static int page;
    private static int kicsi;
    private static int nagy;
    private static int doboz;
    private static int csomagolo;
    private static int matrica;
    private static int koszono;
    private static int nevjegy;

    public Felvetel() {
    }

    /**
     * A rendelés információinak összegyüjtése.
     * <p>
     * A rendelés felvételekor kötelezően megadott mezők, mint a vevő neve,
     * a rendelés dátuma, illetve a termékek száma. A rendelés leadásához és
     * az adminisztráció szempontjából elengedhetetlen értékek. A vevő neve
     * és a dátum a nyomkövetést szolgálja, amivel követhető, hogy a raktárból
     * mikor lett levonva az adott dolog és kinek a rendelése volt.
     * @param vevo a nyomkövetést szolgálja, ezzel követhető, hogy kinek a
     *             rendeléséhez lett felhasználva
     * @param termekszam a csomagolás optimizáláshoz szükséges, a termékek
     *                   számának megfelelő nagyságú csomagolás választása
     * @param ev a rendelés leadásának az éve
     * @param honap a rendelés leadásának a hónapja
     * @param nap a rendelés leadásának a napja
     */
    public static void hozzaadas(String vevo, int termekszam, int ev, int honap, int nap) {
        String who = vevo;
        Logger.info("Vevő hozzáadva");

        Logger.info("Dátum hozzáadva");
        String stdatum = ev + "-" + honap + "-" + nap;
        LocalDate datum = LocalDate.parse(stdatum, DateTimeFormatter
                .ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));

        Felvetel.pack(termekszam);
    }

    /**
     * A rendelt termék és a raktárból való levonáshoz szükséges dolog beazonosítása.
     * <p>
     * A szükséges kellékek értékének csökkentése a megfelelő mennyiséggel.
     * @param termeknev rendelt termék neve, beazonosítás, hogy melyik kellék
     *                  levonása történik
     * @param num egy termékből több darab rendelése esetén annak megfelelően
     *            történik a levonandó érték meghatározása, legalább 1
     */
    public static void item (String termeknev, int num) {
        if (termeknev.equalsIgnoreCase("virágos")) {
            viragos = viragos + (num);
        } else if (termeknev.equalsIgnoreCase("autós")) {
            autos = autos + (num);
        } else if (termeknev.equalsIgnoreCase("harry potter")) {
            harry = harry + (num);
        } else if (termeknev.equalsIgnoreCase("star wars")) {
            starwars = starwars + (num);
        }
        Logger.info("Füzet hozzáadva");
    }

    /**
     * Csomagolás meghatározása.
     * <p>
     * Egy rendelt termék esetén elég a kisebb boríték választása.
     * Kettő termék esetén a doboz túl nagy, a kicsi boríték pedig túl kicsi,
     * így nagyobb borítékra van szükség. Három vagy annál több termék esetén
     * doboz választása.
     * A kiválasztás után a megfelelő kellék levonandó értékének, illetve a
     * csomagolásgoz szükséges többi kellék megadása. Csomagolópapír, amibe a
     * termék becsomagolásra kerül. A matrica, amivel a csomagolópapír lesz ragasztva.
     * A köszönő- és a névjegykártya a rendelés mellé kerül.
     *
     * Egy rendelés esetén csak egyszer fut le.
     * @param num a rendelt termékek száma, legalább 1
     */
    public static void pack (int num) {
        if (num == 1) {
            kicsi++;
            Logger.info("Kis boríték hozzáadva");
        } else if (num == 2) {
            nagy++;
            Logger.info("Nagy boríték hozzáadva");
        } else {
            doboz++;
            Logger.info("Doboz hozzáadva");
        }
        Logger.info("Csomagolópapír hozzáadva");
        csomagolo++;
        Logger.info("Matrica hozzáadva");
        matrica++;
        Logger.info("Köszönőkártya hozzáadva");
        koszono++;
        Logger.info("Névjegykártya hozzáadva");
        nevjegy++;
    }

    /**
     * A levonandó értékek összegyüjtése.
     * <p>
     * Minden kellék a listába kerül, melynek sorrendje megegyezik a
     * {@link raktar.RaktarRepository} osztályban szereplő elemek sorrendjével,
     * például a "virágos" az első, "autós" a második.
     * Az értéknek megfelelő mennyiség kerül levonása a raktárból.
     *
     * @return lista, a benne szereplő értékek 0, vagy attól nagyobb egész
     *      számok, levonandó értékek.
     */
    public static List<Integer> getAll(){
        List<Integer> stock = new ArrayList<Integer>(12);

        stock.add(viragos);
        stock.add(autos);
        stock.add(harry);
        stock.add(starwars);
        stock.add(spiral);
        stock.add(page);
        stock.add(kicsi);
        stock.add(nagy);
        stock.add(doboz);
        stock.add(csomagolo);
        stock.add(matrica);
        stock.add(koszono);
        stock.add(nevjegy);

        return stock;
    }
}
