import java.util.Scanner;

public class Felvetel {

    public static void item(){
        System.out.println("TERMÉK MEGADÁSA...");

        System.out.print("Termék neve: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        System.out.print("Darabszáma: ");
        int n = input.nextInt();

        System.out.println("A megadott termék ára: ");

        System.out.println("SIKERES MEGADÁS!");
    }

    public static void delete(){
        System.out.println("TERMÉK TÖRLÉSE...");

        System.out.print("Termék neve: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        System.out.print("Darabszáma: ");
        int n = input.nextInt();

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
