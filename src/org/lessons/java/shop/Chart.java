package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Chart {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int dimension;
        String category;
        boolean isEnded = false;
        boolean isPremium = false;

        System.out.println("Benvenuto nel tuo shop di fiducia.");

        System.out.println("****");

        System.out.print("Quanti prodotti intendi aquistare: ");
        dimension = Integer.parseInt(scan.nextLine());

        Product[] products = new Product[dimension];

        for (int i = 0; i < products.length && !isEnded; i++) {
            System.out.println("Che tipologia di prodotto intendi acquistare?");
            System.out.print("Digita: s - per smartphone; t - per televisori; c - per cuffie; e - per uscire -> ");
            category = scan.nextLine();

            switch (category) {
                case "s":
                    //caso smartphone
                    String nomeSmartphone;
                    String descrizioneSmartphone;
                    BigDecimal prezzoSmartphone;
                    BigDecimal ivaSmartphone;
                    int imei;
                    int memoria;
                    System.out.print("Nome prodotto: ");
                    nomeSmartphone = scan.nextLine();
                    System.out.print("Descrizione prodotto: ");
                    descrizioneSmartphone = scan.nextLine();
                    System.out.print("Prezzo: ");
                    prezzoSmartphone = BigDecimal.valueOf(Double.parseDouble(scan.nextLine()));
                    System.out.print("IVA: ");
                    ivaSmartphone = BigDecimal.valueOf(Double.parseDouble(scan.nextLine()));
                    System.out.print("Imei: ");
                    imei = Integer.parseInt(scan.nextLine());
                    System.out.print("Memoria: ");
                    memoria = Integer.parseInt(scan.nextLine());
                    products[i] = new Smartphone(nomeSmartphone, descrizioneSmartphone, prezzoSmartphone, ivaSmartphone, imei, memoria);
                    break;
                case "t":
                    //caso televisori
                    String nomeTv;
                    String descrizioneTv;
                    BigDecimal prezzoTv;
                    BigDecimal ivaTv;
                    int pollici;
                    boolean isSmart;
                    System.out.print("Nome prodotto: ");
                    nomeTv = scan.nextLine();
                    System.out.print("Descrizione prodotto: ");
                    descrizioneTv = scan.nextLine();
                    System.out.print("Prezzo: ");
                    prezzoTv = BigDecimal.valueOf(Double.parseDouble(scan.nextLine()));
                    System.out.print("IVA: ");
                    ivaTv = BigDecimal.valueOf(Double.parseDouble(scan.nextLine()));
                    System.out.print("Numero pollici: ");
                    pollici = Integer.parseInt(scan.nextLine());
                    System.out.print("è smart (s o n): ");
                    isSmart = scan.nextLine().equalsIgnoreCase("s");
                    products[i] = new Television(nomeTv, descrizioneTv, prezzoTv, ivaTv, pollici, isSmart);
                    break;
                case "c":
                    String nomeCuffia;
                    String descrizioneCuffia;
                    BigDecimal prezzoCuffia;
                    BigDecimal ivaCuffia;
                    String color;
                    boolean isWireless;
                    System.out.print("Nome prodotto: ");
                    nomeCuffia = scan.nextLine();
                    System.out.print("Descrizione prodotto: ");
                    descrizioneCuffia = scan.nextLine();
                    System.out.print("Prezzo: ");
                    prezzoCuffia = BigDecimal.valueOf(Double.parseDouble(scan.nextLine()));
                    System.out.print("IVA: ");
                    ivaCuffia = BigDecimal.valueOf(Double.parseDouble(scan.nextLine()));
                    System.out.print("Colore: ");
                    color = scan.nextLine();
                    System.out.print("è senza fili (s o n): ");
                    isWireless = scan.nextLine().equalsIgnoreCase("s");
                    products[i] = new Headphone(nomeCuffia, descrizioneCuffia, prezzoCuffia, ivaCuffia, color, isWireless);
                    //caso cuffie
                    break;
                case "e":
                    //caso uscita
                    isEnded = true;
                    System.out.println("Arrivederci");
                    break;
                default:
                    //caso nullo
                    System.out.println("Scelta nulla.");
                    break;
            }
        }

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].toString());
            System.out.println(products[i].getClass().getSimpleName());
        }

        System.out.print("Possiedi una carta fedeltà? (s - per si, n - per no) -> ");
        String response = scan.nextLine();

        BigDecimal amount = BigDecimal.valueOf(0.0);

        if (response.equals("s")){
            for (int i = 0; i < products.length; i++) {
                amount = amount.add(products[i].discountedPrice());
            }
            System.out.println("Il tuo prezzo totale, scontato, è: " + amount);
        } else if (response.equals("n")) {
            for (int i = 0; i < products.length; i++) {
                amount = amount.add(products[i].priceWithVat());
            }
            System.out.println("Il tuo prezzo totale è: " + amount);
        }



        scan.close();

    }
}
