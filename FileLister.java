import java.io.File;
import java.text.SimpleDateFormat;

public class FileLister {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

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

    private static String indent(int level) {
        return " ".repeat(level * 2);
    }
}

