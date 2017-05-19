import java.util.Arrays;
import java.util.ArrayList;

/**
 * Created by mayliswhetsel on 5/8/17.
 * Main class: 2D Array --> Tweet --> Image --> Twitter
 */
public class TweetTweet {
    public static void main(String[] args) {
        // Create URL object
        // URL.getText - > plain text
        URLReader url = new URLReader("https://www.theodysseyonline.com/rape-culture-important-details-missed"); //sample text for now
        String HTMLCode = url.readerReturn("https://www.theodysseyonline.com/rape-culture-important-details-missed");
        HTMLtoPlainText html = new HTMLtoPlainText();
        String plainText = html.replace(HTMLCode);
        TextTOSortedArray obj = new TextTOSortedArray(plainText);
        String[] tokenArray = obj.tokenize();
        String[] betterTokenArray = obj.sort(tokenArray);
        Arrays.sort(betterTokenArray);
        SortedTOWordObjectArrayList obj2 = new SortedTOWordObjectArrayList(betterTokenArray);
        ArrayList<Word> wordList = obj2.listed();
        PartOfSpeech p = new PartOfSpeech(wordList, plainText);
        POSArrayLists taggedLists = p.tagging();
        Chosen c = new Chosen(taggedLists);
        String [][] filled = c.fill(taggedLists);
        double d = c.getTemplate();
        MadLibs madLibs = new MadLibs(d, filled);
        String tweet = madLibs.getTweet();
        System.out.print(tweet);
    }
}
