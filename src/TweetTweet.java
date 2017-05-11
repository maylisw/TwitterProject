import java.util.Arrays;

/**
 * Created by mayliswhetsel on 5/8/17.
 * Main class: 2D Array --> Tweet --> Image --> Twitter
 */
public class TweetTweet {
    public static void main(String[] args) {
        // Create URL object
        // URL.getText - > plain text
        String plainText = "TEXT GOES HERE";
        TextTOSortedArray obj = new TextTOSortedArray(plainText);
        String[] tokenArray = obj.tokenize();
        String[] betterTokenArray = obj.sort(tokenArray);
        Arrays.sort(betterTokenArray);
        for(String s: betterTokenArray)
        {
            System.out.println(s);
        }

    }
}
