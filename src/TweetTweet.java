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
        String plainText = html.replace(HTMLCode);
        TextTOSortedArray obj = new TextTOSortedArray(plainText);
        String[] tokenArray = obj.tokenize();
        String[] tokenArray2 = obj.punctuationRemoval(tokenArray);
        String[] tokenArray3 = obj.punctuationRemoval(tokenArray2);
        String[] tokenArray4 = obj.punctuationRemoval(tokenArray3);
        String[] betterTokenArray = obj.frontPunctuationRemoval(tokenArray4);
        Arrays.sort(betterTokenArray);
        SortedTOWordObjectArrayList obj2 = new SortedTOWordObjectArrayList(betterTokenArray);
        ArrayList<Word> wordList = obj2.listed();
        PartOfSpeech p = new PartOfSpeech(wordList, plainText);
        //works to here
        POSArrayLists taggedLists = p.tagging();
        //works below here
        Chosen c = new Chosen(taggedLists);
        String [][] filled = c.fill(taggedLists);
        /*for(String[] x: filled) {
            for(String s : x){
                System.out.println(s);
            }
        }*/
        double d = c.getTemplate();
        //MadLibs madLibs = new MadLibs(d, filled);
        //String tweet = madLibs.getTweet();
        String[][] s = {{"hi", "me", "what even"}, {"boom", "boo", "hello"}, {"When", "the", "home"}, {"And", "window", "close"}, {"their", "shutters", "One"}, {"by", "one", "oil"}, {"lamps", "are", "blown"}, {"out", "Until", "dark"}, {"envelopes", "single", "flame"}, {"Pulsing", "softly", "hearth"}, {"wandering", "soul", "glimmers"}, {"base", "stairs", "nighttime"}};
        MadLibs madLibs = new MadLibs(0.2,s); //tester MadLibs object. Everything else commented out (except your print) is the real main class.
        String tweet = madLibs.getTweet();
        Icon image = new ImageIcon("TrumpTweetPage.png");
        JLabel imageTweet = new JLabel(tweet, image, JLabel.CENTER);
        System.out.print(imageTweet); //printing out info at JLabel imageTweet
    }
}
