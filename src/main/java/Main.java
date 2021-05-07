import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.print("Mit szeretnél csinálni? ");
        // input
        Scanner input = new Scanner(System.in);
        String what = input.nextLine();

        // megadás
        int i = 0;
        while (i == 0) {
            if (what.toLowerCase().equals("felvétel")) { // .toLowerCase() == .lower()
                felvetel();
                i = 1;
            } else if (what.toLowerCase().equals("készlet")) {
                new Raktar();
                i = 1;
            } else {
                System.out.print("-1");
                i = 1;
            }
        }
    }

    public static void felvetel(){
        // példányosítás:
        new Felvetel();
        System.out.println("RENDELÉS FELVÉTELE");

        // vevő:
        System.out.print("Vevő neve: ");
        Scanner input = new Scanner(System.in);
        String who = input.nextLine();

        // termék:
        System.out.print("Hány terméket rendelt? ");
        int num = input.nextInt();

        for (int i = 0; i < num; i++) {
            Felvetel.item();
        }

        // csomagolás:
        Felvetel.pack(num);

        // dátum:
        System.out.println("DÁTUM HOZZÁADÁSA");
        // év
        System.out.print("Év: ");
        int year = input.nextInt();
        // hónap
        System.out.print("Hónap: ");
        int month = input.nextInt();
        // nap
        System.out.print("Nap: ");
        int day = input.nextInt();

        // szállítás:
        System.out.print("A szállítási mód: ");
        Scanner info = new Scanner(System.in);
        String shipping_info = input.nextLine();

        if (shipping_info.toLowerCase().equals("felvétel")) {
        } else if (shipping_info.toLowerCase().equals("készlet")) {
        } else {
        }

        // fizetés:
        System.out.print("A fizetési mód: ");
        String payment = input.nextLine();

        System.out.println("SIKERES FELVÉTEL!");
    }
}
