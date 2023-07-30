import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class taskTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("Enter '1' to input text manually or '2' to provide a file: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            System.out.println("Enter the text: ");
            text = scanner.nextLine();
        } else if (option == 2) {
            System.out.println("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                text = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                return;
            }
        } else {
            System.out.println("Invalid option.");
            return;
        }

        int wordCount = countWords(text);
        System.out.println("Total word count: " + wordCount);
    }
    private static String readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
            stringBuilder.append("\n");
        }
        scanner.close();
        return stringBuilder.toString();
    }
    private static int countWords(String text) {
        String[] words = text.split("[\\p{Punct}\\s]+");
        return words.length;
    }
}