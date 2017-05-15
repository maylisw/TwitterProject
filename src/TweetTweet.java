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
        String plainText = "TEXT GOES HERE ZED TEXT ZED";
        TextTOSortedArray obj = new TextTOSortedArray(plainText);
        String[] tokenArray = obj.tokenize();
        String[] betterTokenArray = obj.sort(tokenArray);
        Arrays.sort(betterTokenArray);
        SortedTOWordObjectArrayList obj2 = new SortedTOWordObjectArrayList(betterTokenArray);
        ArrayList<Word> wordList = obj2.listed();
        PartOfSpeech p = new PartOfSpeech(wordList, plainText);
       // POSArrayLists pos = p.tagging();  //not needed anymore I don't think
        POSArrayLists taggedLists = p.tagging();
        /*Choosen c = new Choosen(taggedLists);
        String tweet = choosen.createText();*/


    }
}
