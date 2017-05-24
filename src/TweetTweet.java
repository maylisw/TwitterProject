import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import javax.swing.*;
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
        //Maybe userInput
        //String realURL = "http://boilerpipe-web.appspot.com/extract?url=" + /*URL User Input*/ "&output=text";
        URLReader url = new URLReader("http://boilerpipe-web.appspot.com/extract?url=https://www.theodysseyonline.com/rape-culture-important-details-missed&output=text"); //sample text for now
        String HTMLCode = url.readerReturn("http://boilerpipe-web.appspot.com/extract?url=https://www.theodysseyonline.com/rape-culture-important-details-missed&output=text");
        HTMLtoPlainText html = new HTMLtoPlainText();
        String plainText = html.replace(HTMLCode); //URL reader works here
        TextTOSortedArray obj = new TextTOSortedArray(plainText);
        String[] tokenArray = obj.tokenize();
        String[] tokenArray2 = obj.punctuationRemoval(tokenArray);
        String[] tokenArray3 = obj.punctuationRemoval(tokenArray2);
        String[] tokenArray4 = obj.punctuationRemoval(tokenArray3);
        String[] betterTokenArray = obj.frontPunctuationRemoval(tokenArray4); //good but some things were not split at ? or.
        Arrays.sort(betterTokenArray);
        SortedTOWordObjectArrayList obj2 = new SortedTOWordObjectArrayList(betterTokenArray);
        ArrayList<Word> wordList = obj2.listed();
        PartOfSpeech p = new PartOfSpeech(wordList, plainText);
        POSArrayLists taggedLists = p.tagging();
        Chosen c = new Chosen(taggedLists);
        String [][] filled = c.fill(taggedLists);
        System.out.println("I love Maÿlis");
        for(String[] x: filled) {
            for(String s : x){
                System.out.println(s);
            }
        }
        double d = c.getTemplate();
        MadLibs madLibs = new MadLibs(d, filled);
        String tweet = madLibs.getTweet();
        System.out.print(tweet);
    }
}
