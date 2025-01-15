import java.util.Scanner;

import static controller.Krankenhausmanagement.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            showMenu();  // Zeigt das Hauptmenü der Anwendung an
            int choice = scanner.nextInt();  // Benutzereingabe zur Auswahl einer Aktion
            scanner.nextLine();  // Neue Zeile konsumieren, um Fehler zu vermeiden
            switch (choice) {
                case 1: addMedikament(); break;
                case 2: displayMedikament(); break;
                case 3: editMedikament(); break;
                case 4: deleteMedikament(); break;
                case 5: addPatient(); break;
                case 6: displayPatients(); break;  // Alle Charaktere anzeigen
                case 7: editPatient(); break;  // Charakter bearbeiten
                case 8: deletePatient(); break;  // Charakter löschen
                case 9: filterPatientenByDiagnose(); break;  // Charaktere nach Herkunftsort filtern
                case 10: displayPatientenByMedikamentKrankheit(); break;  // Charaktere nach Produkt-Herkunftsregion filtern
                case 11: sortPatientMedikamenteByPreis(); break;  // Produkte eines Charakters nach Preis sortieren
                case 12: System.exit(0); break;  // Anwendung beenden
                default: System.out.println("Ungültige Auswahl."); break;  // Ungültige Eingabe
            }
        }
    }
}