import java.util.Random;

public class WordList {

    private static final String[] WORDS = {
            "APPLE", "GRAPE", "PLANT", "CHAIR", "BRAIN",
            "HOUSE", "TABLE", "MOUSE", "TRAIN", "PHONE"
    };

    public static String getRandomWord() {
        Random rand = new Random();
        return WORDS[rand.nextInt(WORDS.length)];
    }
}
