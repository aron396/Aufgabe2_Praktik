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
                case 6: displayPatients(); break;
                case 7: editPatient(); break;
                case 8: deletePatient(); break;
                case 9: filterPatientenByDiagnose(); break;
                case 10: displayPatientenByMedikamentKrankheit(); break;
                case 11: sortPatientMedikamenteByPreis(); break;
                case 12: System.exit(0); break;
                default: System.out.println("Ungültige Auswahl."); break;
            }
        }
    }
}