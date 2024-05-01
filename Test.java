import java.io.File;
import java.util.Scanner;

/**
 * Testklasse für FileLister
 * @author Benhard Aichinger-Ganas
 * @version 2024-05-01
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Bitte geben Sie den Pfad an oder 'exit' zum Beenden: ");
            String inputPath = scanner.nextLine();

            if ("exit".equalsIgnoreCase(inputPath)) {
                System.out.println("Programm wird beendet.");
                break;
            }

            File root = new File(inputPath);
            if (!root.exists()) {
                System.out.println("Der angegebene Pfad existiert nicht. Bitte versuchen Sie es erneut.");
            } else {
                FileLister.listFile(root, 0);
            }
        }
        scanner.close();
    }
}
