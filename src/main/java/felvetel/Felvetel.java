package felvetel;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import raktar.Raktar;

import java.util.Scanner;

public class Felvetel {

    public static void felvetel(String vevo, int termekszam, int ev, int honap, int nap){

        // vevő:
        String who = vevo;
        // csomagolás:
        Felvetel.pack(termekszam);
        // dátum:
        int year = ev;
        int month = honap;
        int day = nap;
    }

    public static void item(String termek1, String termek2, String termek3, String termek4){


    }
    /*
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
    */
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

}
