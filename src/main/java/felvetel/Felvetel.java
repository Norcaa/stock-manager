package felvetel;

import raktar.Raktar;

import java.util.Scanner;

public class Felvetel {

    public static void felvetel(){
        System.out.println("RENDELÉS FELVÉTELE");

        // vevő:
        System.out.print("Vevő neve: ");
        Scanner input = new Scanner(System.in);
        String who = input.nextLine();

        // termék:
        System.out.print("Hány terméket rendelt? ");
        int num = input.nextInt();

        for (int i = 0; i < num; i++) {
            item();
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
        String shipping = "házhozszállítás";
        System.out.print("A szállítási mód: ");
        System.out.println(shipping);
        // fizetés:
        String payment = "utánvét";
        System.out.print("A fizetési mód: ");
        System.out.println(payment);

        System.out.println("SIKERES FELVÉTEL!");
    }

    public static void item(){
        System.out.println("TERMÉK MEGADÁSA...");

        Termek termek = new Termek();
        Raktar raktar = new Raktar();

        System.out.print("Termék neve: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        System.out.print("Darabszáma: ");
        int n = input.nextInt();

        // termék kiválasztása
        if (name == termek.pro_name){
            // termékhez szükséges
            if ( termek.pro_cover == raktar.st_name){
                raktar.st_available =- n;
            }
            raktar.st_available =- termek.pro_pages;
            if ( termek.pro_backcover == raktar.st_name){
                raktar.st_available =- n;
            }
            if ( termek.pro_bindig == raktar.st_name){
                raktar.st_available =- n;
            }
        }

        System.out.println("A megadott termék ára: ");

        System.out.println("SIKERES MEGADÁS!");
    }

    public static void delete(){
        System.out.println("TERMÉK TÖRLÉSE...");

        Termek termek = new Termek();
        Raktar raktar = new Raktar();

        System.out.print("Termék neve: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        System.out.print("Darabszáma: ");
        int n = input.nextInt();

        // termék kiválasztása
        if (name == termek.pro_name){
            // termékhez szükséges
            if ( termek.pro_cover == raktar.st_name){
                raktar.st_available = n;
            }
            raktar.st_available =- termek.pro_pages;
            if ( termek.pro_backcover == raktar.st_name){
                raktar.st_available = n;
            }
            if ( termek.pro_bindig == raktar.st_name){
                raktar.st_available = n;
            }
        }

        System.out.println("TERMÉK TÖRÖLVE!");
    }

    public static void pack(int num){
        if (num == 1){
            System.out.println("Kis boríték hozzáadva!");
        } else if (num == 2){
            System.out.println("Nagy boríték hozzáadva!");
        } else {
            System.out.println("Doboz hozzáadva!");
        }
        System.out.println("Csomagolópapír hozzáadva!");
        System.out.println("Matrica hozzáadva!");
        System.out.println("Köszönőkártya hozzáadva!");
        System.out.println("Névjegykártya hozzáadva!");
    }

    public static void exit(){
        System.out.println("Felvétel megszakítva!");
    }
}
