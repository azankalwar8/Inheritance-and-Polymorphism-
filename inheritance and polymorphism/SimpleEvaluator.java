import java.io.File;
import java.util.Scanner;

public class SimpleEvaluator {

    public static void main(String[] args) {
        String fileContent = "";
        String keyboardContent = "";

        // 🟢 TASK 1: Read input from a text file
        try {
            File file = new File("submission.txt");
            Scanner fileScanner = new java.util.Scanner(file);
            while (fileScanner.hasNextLine()) {
                fileContent += fileScanner.nextLine() + " ";
            }
            fileScanner.close();
            System.out.println("[✓] Loaded submission.txt successfully!");
        } catch (Exception e) {
            System.out.println("[!] submission.txt not found. (Using default test file text)");
            fileContent = "public class Test { public static void main(String[] args) { int x = 10; if (x > 5) System.out.println(x); } }";
        }

        // 🟢 TASK 2: Read input from the keyboard
        Scanner keyboard = new java.util.Scanner(System.in);
        System.out.print("\nEnter Student Name: ");
        String name = keyboard.nextLine();

        System.out.println("Enter code/text (type 'DONE' on a new line when finished):");
        while (true) {
            String line = keyboard.nextLine();
            if (line.equalsIgnoreCase("DONE")) {
                break;
            }
            keyboardContent += line + " ";
        }

        // Evaluate both submissions
        System.out.println("\n" + "=".repeat(40));
        System.out.println("RESULTS");
        System.out.println("=".repeat(40));

        int score1 = evaluateSubmission("File Submission", fileContent);
        int score2 = evaluateSubmission(name.isEmpty() ? "Keyboard User" : name, keyboardContent);

        // 🟢 TASK 6: Compare submissions and find the winner
        System.out.println("\n" + "=".repeat(40));
        System.out.println("WINNER");
        System.out.println("=".repeat(40));

        if (score1 > score2) {
            System.out.println("🏆 Top Performer: File Submission!");
        } else if (score2 > score1) {
            System.out.println("🏆 Top Performer: " + (name.isEmpty() ? "Keyboard User" : name) + "!");
        } else {
            System.out.println("🤝 It's a tie!");
        }

        keyboard.close();
    }

    // Evaluates a submission for Tasks 3, 4, and 5
    public static int evaluateSubmission(String title, String text) {
        // 🟢 TASK 3: Tokenize (split text into words)
        String[] words = text.toLowerCase().split("\\W+");

        int basicCount = 0;
        int advancedCount = 0;

        // Keywords list
        String basicTerms = "if else for while int float double string print println void return";
        String advancedTerms = "class object interface list map arraylist inheritance recursion algorithm lambda";

        // Identify and count relevant terms
        for (String word : words) {
            if (!word.isEmpty()) {
                if (basicTerms.contains(word)) {
                    basicCount++;
                } else if (advancedTerms.contains(word)) {
                    advancedCount++;
                }
            }
        }

        // 🟢 TASK 4: Assign score based on rules
        // Rule: Basic term = 1 pt, Advanced term = 2 pts
        int totalScore = (basicCount * 1) + (advancedCount * 2);

        // 🟢 TASK 5: Classify the submission
        String rating;
        if (totalScore >= 10) {
            rating = "Excellent";
        } else if (totalScore >= 4) {
            rating = "Good";
        } else {
            rating = "Basic";
        }

        // Print details
        System.out.println("\n--- " + title + " ---");
        System.out.println("Total Words Tokenized: " + words.length);
        System.out.println("Basic Terms Found:    " + basicCount + " (1 pt each)");
        System.out.println("Advanced Terms Found: " + advancedCount + " (2 pts each)");
        System.out.println("Total Score:          " + totalScore);
        System.out.println("Classification:       " + rating);

        return totalScore;
    }

}
