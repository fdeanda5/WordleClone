import java.util.Scanner;

public class WordleGame {

    private static final int MAX_ATTEMPTS = 6;
    private final String secretWord;

    public WordleGame() {
        this.secretWord = WordList.getRandomWord();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== WORDLE CLONE ===");
        System.out.println("Guess the 5-letter word!");
        System.out.println("G = correct spot, Y = wrong spot, _ = not in word");
        System.out.println();

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Attempt " + attempt + "/" + MAX_ATTEMPTS + ": ");
            String guess = scanner.nextLine().toUpperCase();

            if (!isValidGuess(guess)) {
                System.out.println("❌ Invalid guess. Enter a 5-letter word.");
                attempt--;
                continue;
            }

            String feedback = getFeedback(guess);
            System.out.println(feedback);

            if (guess.equals(secretWord)) {
                System.out.println("🎉 Congratulations! You guessed the word!");
                return;
            }
        }

        System.out.println("❌ Game Over! The word was: " + secretWord);
    }

    private boolean isValidGuess(String guess) {
        return guess.length() == 5 && guess.matches("[A-Z]+");
    }

    private String getFeedback(String guess) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == secretWord.charAt(i)) {
                result.append("G ");
            } else if (secretWord.indexOf(guess.charAt(i)) >= 0) {
                result.append("Y ");
            } else {
                result.append("_ ");
            }
        }
        return result.toString();
    }
}
