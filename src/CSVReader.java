import java.io.*;
import java.util.*;

// CSV Formatierung: Vorname, Nachname, Aufgabennummer, Punkte

/**
 * Das Schreiben des Programms hat in etwa 20 Minuten in Anspruch genommen,
 * da ich etwas länger nichts in Java geschrieben habe.
 * <p>
 * Das Programm liest eine CSV Datei Zeilenweise ein und speichert jeweils den vollständigen Namen mit der Punktzahl
 * des Studenten in einer Treemap. Anschließend werden zeilenweise die Gesamtpunktzahlen aller Studenten in aufsteigend
 * alphabetischer Reihenfolge im Format "Name : Punktzahl" in der Konsole ausgegeben.
 * <p>
 * Das Programm wird also einfach in der Konsole ausgeführt: "java CSVReader(.java) 'Dateipfad/Datei.csv'"
 * Die Endung .java wird selbstverständlich benötigt, wenn die Java Datei zuvor nicht kompiliert wurde.
 */

public class CSVReader {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        String path = args[0];
        TreeMap<String, Integer> students = new TreeMap<String, Integer>();
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(COMMA_DELIMITER);
            String name = values[0] + " " + values[1];
            if (!students.containsKey(name)) students.put(name, Integer.parseInt(values[3]));
            else students.replace(name, students.get(name) + Integer.parseInt(values[3]));
        }

        for (String key : students.keySet()) {
            System.out.println(key + ": " + students.get(key));
        }
    }
}
