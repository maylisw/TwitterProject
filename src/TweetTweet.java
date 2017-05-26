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
        //String realURL = "http://boilerpipe-web.appspot.com/extract?url=" + /*URL User Input*/ "&output=text";
        String boilerPipeURL = "http://boilerpipe-web.appspot.com/extract?url=https://www.theodysseyonline.com/rape-culture-important-details-missed&output=text";
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

        PositiveNegative posNeg = new PositiveNegative(boilerPipeURL);
        boolean goodBad = posNeg.whichTemplate();

        POSArrayLists taggedLists = p.tagging();
        Chosen c = new Chosen(taggedLists, goodBad);
        String [][] filled = c.fill(taggedLists);
        double d = c.getTemplate();
        //MadLibs madLibs = new MadLibs(d, filled);
        //String tweet = madLibs.getTweet();
        String[][] s = {{"hi", "me", "what even"}, {"boom", "boo", "hello"}, {"When", "the", "home"}, {"And", "window", "close"}, {"their", "shutters", "One"}, {"by", "one", "oil"}, {"lamps", "are", "blown"}, {"out", "Until", "dark"}, {"envelopes", "single", "flame"}, {"Pulsing", "softly", "hearth"}, {"wandering", "soul", "glimmers"}, {"base", "stairs", "nighttime"}};
        MadLibs madLibs = new MadLibs(0.4, s); //tester MadLibs object
        String tweet = madLibs.getTweet(); //why are only 1 and 6 working? --> k < 0 = 1; k > 0 = 6
        System.out.print(tweet);
        Icon image = new ImageIcon("TrumpTweetPage.png");
        int w = image.getIconWidth();
        int h = image.getIconHeight();
        JLabel imageTweet = new JLabel(tweet, image, JLabel.CENTER);
        imageTweet.setIcon(image);
        System.out.print(imageTweet); //printing out info at JLabel imageTweet
    }
}
