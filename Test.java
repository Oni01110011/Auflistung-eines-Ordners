import java.io.File;

public class Test {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Bitte geben Sie einen gültigen Pfad an.");
            return;
        }

        File root = new File(args[0]);
        if (!root.exists()) {
            System.out.println("Der angegebene Pfad existiert nicht.");
            return;
        }

        FileLister.listFile(root, 0);
    }
}
