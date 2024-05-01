import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Die Klasse FileLister dient dazu, eine hierarchische Liste aller Dateien und
 * Ordner in einem gegebenen Verzeichnis zu erstellen. Dabei werden sowohl die
 * Eigenschaften der Dateien als auch die Struktur der Ordner ausgegeben.
 * @author Bernhard Aichinger-Ganas
 * @version 2024-05-01
 */
public class FileLister {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Rekursive Methode zur Auflistung von Dateien und Ordnern eines übergebenen
     * File-Objekts. Die Ausgabe erfolgt formatiert entsprechend der Hierarchieebene.
     * @param file  Das zu listende File-Objekt.
     * @param level Die aktuelle Tiefe in der Verzeichnishierarchie, die die Einrückung bestimmt.
     */
    public static void listFile(File file, int level) {
        if (file.isDirectory()) {
            System.out.println(indent(level) + "+" + file.getName());
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    listFile(subFile, level + 1);
                }
            }
        } else {
            System.out.println(indent(level) + file.getName() + " - " +
                    DATE_FORMAT.format(file.lastModified()) + " - " +
                    file.length() + " Byte");
        }
    }

    /**
     * Hilfsmethode zur Erzeugung einer Einrückung, die der Hierarchieebene entspricht.
     * @param level Die Tiefe der Hierarchie, basierend auf der die Einrückung berechnet wird.
     * @return Eine Zeichenkette, die aus Leerzeichen besteht und der Hierarchieebene entspricht.
     */
    private static String indent(int level) {
        return " ".repeat(level * 2);
    }
}
