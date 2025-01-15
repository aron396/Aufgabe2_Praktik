package controller;

import model.Medikament;
import model.Patient;

import java.util.*;

public class Krankenhausmanagement {

    public
 static List<Medikament> medikamentList = new ArrayList<>();
    public
 static List<Patient> patientList = new ArrayList<>();
    public
 static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
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

    public static void addMedikament() {
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


    public static void displayMedikament() {
        System.out.println("Alle Medikamente:");
        for (Medikament medikament : medikamentList) {
            System.out.println(medikament.getName());
            System.out.println(medikament.getKrankheit());
            System.out.println(medikament.getPreis());
        }
    }

    public static void editMedikament() {
        System.out.print("Medikamentname zum Bearbeiten: ");
        String name = scanner.nextLine();
        Medikament medikament = findMedikamentByName(name);
        if (medikament != null) {
            System.out.print("Neuer Preis: ");
            double preis = scanner.nextDouble();
            medikament = new Medikament(medikament.getName(), preis, medikament.getKrankheit());
            scanner.nextLine();  // consume newline
            System.out.println("Medikament bearbeitet.");
        } else {
            System.out.println("Produkt nicht gefunden.");
        }
    }

    public static Medikament findMedikamentByName(String name) {
        for (Medikament medikament : medikamentList) {
            if (medikament.getName().equalsIgnoreCase(name)) {
                return medikament;
            }
        }
        return null;
    }

    public static void deleteMedikament() {
        System.out.print("Medikamentname zum Löschen: ");
        String name = scanner.nextLine();
        Medikament medikament = findMedikamentByName(name);
        if (medikament != null) {
            medikamentList.remove(medikament);
            System.out.println("Medikament gelöscht.");
        } else {
            System.out.println("Medikament nicht gefunden.");
        }
    }

    public static void addPatient() {
        System.out.print("Patient-ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Charaktername: ");
        String name = scanner.nextLine();
        System.out.print("Alter: ");
        int alter = scanner.nextInt();
        System.out.print("Diagnose: ");
        String diagnose = scanner.nextLine();

        patientList.add(new Patient(id, name, alter, diagnose, new ArrayList<>()));
        System.out.println("Charakter hinzugefügt.");
    }

    public static void displayPatients() {
        System.out.println("Alle Charaktere:");
        for (Patient Patient : patientList) {
            System.out.println(Patient);
        }
    }

    public static void editPatient() {
        System.out.print("Patient-ID zum Bearbeiten: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        Patient patient = findPatientById(id);
        if (patient != null) {
            System.out.print("Neuer Name: ");
            String name = scanner.nextLine();
            patient = new Patient(patient.getId(), name, patient.getAlter(), patient.getDiagnose(), patient.getMedikamente());
            System.out.println("Patient bearbeitet.");
        } else {
            System.out.println("Patient nicht gefunden.");
        }
    }

    public static void deletePatient() {
        System.out.print("Patient-ID zum Löschen: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        Patient patient = findPatientById(id);
        if (patient != null) {
            patientList.remove(patient);
            System.out.println("Patient gelöscht.");
        } else {
            System.out.println("Patient nicht gefunden.");
        }
    }

    public static Patient findPatientById(int id) {
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public static void filterPatientenByDiagnose() {
        System.out.print("Diagnose zum Filtern: ");
        String diagnose = scanner.nextLine();
        System.out.println("Patienten aus " + diagnose + ":");
        for (Patient patient : patientList) {
            if (patient.getDiagnose().equalsIgnoreCase(diagnose)) {
                System.out.println(patient);
            }
        }
    }

    public static void displayPatientenByMedikamentKrankheit() {
        System.out.print("Krankheit des Medikamentes: ");
        String krankheit = scanner.nextLine();
        System.out.println("Patienten, die Medikamente fur " + krankheit + " gekauft haben:");
        for (Patient patient : patientList) {
            for (Medikament medikament : patient.getMedikamente()) {
                if (medikament.getKrankheit().equalsIgnoreCase(krankheit)) {
                    System.out.println(patient);
                    break;
                }
            }
        }
    }

    public static void sortPatientMedikamenteByPreis() {
        System.out.print("Patient-ID für Medikamente sortieren: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        Patient patient = findPatientById(id);
        if (patient != null) {
            System.out.print("Sortieren aufsteigend (1) oder absteigend (2): ");
            int sortOrder = scanner.nextInt();
            scanner.nextLine();  // consume newline

            List<Medikament> medikaments = patient.getMedikamente();
            medikaments.sort(Comparator.comparingDouble(Medikament::getPreis));
            if (sortOrder == 2) {
                Collections.reverse(medikaments);
            }

            System.out.println("Medikamente des Patienten sortiert:");
            for (Medikament medikament : medikaments) {
                System.out.println(medikament);
            }
        } else {
            System.out.println("Charakter nicht gefunden.");
        }
    }





}
