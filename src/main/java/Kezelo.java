import felvetel.Felvetel;
import javafx.application.Application;
import main.MyApplication;
import raktar.Raktar;

import java.io.IOException;
import java.util.Scanner;

public class Kezelo {

    /*
    public static void main(String[] args) throws IOException {
        System.out.print("Mit szeretnél csinálni? ");
        // input
        Scanner input = new Scanner(System.in);
        String what = input.nextLine();

        // megadás
        int i = 0;
        while (i == 0) {
            if (what.toLowerCase().equals("felvétel")) { // .toLowerCase() == .lower()
                Felvetel.felvetel();
                i = 1;
            } else if (what.toLowerCase().equals("készlet")) {
                final var raktar = new Raktar();

                i = 1;
            } else {
                System.out.print("-1");
                i = 1;
            }
        }
    }
    */

    public static void main(String[] args) {
        Application.launch(MyApplication.class, args);
    }
}
