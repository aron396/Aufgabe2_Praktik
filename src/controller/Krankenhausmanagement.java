package controller;

import model.Medikament;
import model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Krankenhausmanagement {

    private static List<Medikament> medikamentList = new ArrayList<>();
    private static List<Patient> patients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static void showMenu() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Medikamente hinzufügen");
        System.out.println("2. Alle Medikamente anzeigen");
        System.out.println("3. Medikamente bearbeiten");
        System.out.println("4. Medikamente löschen");
        System.out.println("5. Patiente hinzufügen");
        System.out.println("6. Alle Patiente anzeigen");
        System.out.println("7. Patiente bearbeiten");
        System.out.println("8. Patiente löschen");
        System.out.println("9. Patiente nach Diagnose filtern");
        System.out.println("10. Patiente nach Medikament-Krankheit filtern");
        System.out.println("11. Medikamente eines Patientes nach Preis sortieren");
        System.out.println("12. Beenden");
    }

    private static void addMedikament() {
        System.out.print("Medikamentname: ");
        String name = scanner.nextLine();
        System.out.print("Preis: ");
        double preis = scanner.nextDouble();
        scanner.nextLine();  // consume newline
        System.out.print("Krankheit: ");
        String krankheit = scanner.nextLine();

        medikamentList.add(new Medikament(name, preis, krankheit));
        System.out.println("Produkt hinzugefügt.");
    }


    private static void displayMedikament() {
        System.out.println("Alle Medikamente:");
        for (Medikament medikament : medikamentList) {
            System.out.println(medikament);
        }
    }

    private static void editMedikament() {
        System.out.print("Medikamentname zum Bearbeiten: ");
        String name = scanner.nextLine();
        Medikament medikament = findMedikamentByName(name);
        if (medikament != null) {
            System.out.print("Neuer Preis: ");
            medikament = new Medikament(medikament.getName(), scanner.nextDouble(), medikament.getKrankheit());
            scanner.nextLine();  // consume newline
            System.out.println("Medikament bearbeitet.");
        } else {
            System.out.println("Produkt nicht gefunden.");
        }
    }

    private static Medikament findMedikamentByName(String name) {
        for (Medikament medikament : medikamentList) {
            if (medikament.getName().equalsIgnoreCase(name)) {
                return medikament;
            }
        }
        return null;
    }


}
