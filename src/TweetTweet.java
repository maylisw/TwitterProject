import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * Created by mayliswhetsel on 5/8/17.
 * Main class: 2D Array --> Tweet --> Image --> Twitter
 */
public class TweetTweet {
    public static void main(String[] args) throws TwitterException {
        UserInput userInput = new UserInput();
        System.out.print("What article do you want to make Trump react to? --> ");
        String link = userInput.getString();
        String realURL = "http://boilerpipe-web.appspot.com/extract?url=" + link + "&output=text";
        System.out.println(realURL);
        //String boilerPipeURL = "http://boilerpipe-web.appspot.com/extract?url=https://www.theodysseyonline.com/rape-culture-important-details-missed&output=text";

        URLReader url = new URLReader(realURL); //sample text for now
        String boilerPipe = url.readerReturn(realURL);

        //HTMLtoPlainText html = new HTMLtoPlainText();
        //String plainText = html.replace(HTMLCode);

        TextTOSortedArray obj = new TextTOSortedArray(boilerPipe);
        String[] tokenArray = obj.tokenize();

        String[] tokenArray2 = obj.punctuationRemoval(tokenArray);
        String[] tokenArray3 = obj.punctuationRemoval(tokenArray2);
        String[] tokenArray4 = obj.punctuationRemoval(tokenArray3);
        String[] betterTokenArray = obj.frontPunctuationRemoval(tokenArray4);
        Arrays.sort(betterTokenArray);

        SortedTOWordObjectArrayList obj2 = new SortedTOWordObjectArrayList(betterTokenArray);
        ArrayList<Word> wordList = obj2.listed();
        PartOfSpeech p = new PartOfSpeech(wordList, boilerPipe);

        PositiveNegative posNeg = new PositiveNegative(realURL);
        boolean goodBad = posNeg.whichTemplate();
        String s = posNeg.whichNews();
        //System.out.println(goodBad);

        POSArrayLists taggedLists = p.tagging();

        Chosen c = new Chosen(goodBad);
        String [][] filled = c.fill(taggedLists);

        double d = c.getTemplate();
        System.out.println(d);
        MadLibs madLibs = new MadLibs(d, filled, s);
        String tweet = madLibs.getTweet();
        System.out.println(tweet);

        //TextTOSortedArray tester = new TextTOSortedArray(plainText);
        //String[] s = tester.tokenize();
        /*String[][] s = {{"hi", "me", "what even"}, {"boom", "boo", "hello"}, {"When", "the", "home"}, {"And", "window", "close"}, {"their", "shutters", "One"}, {"by", "one", "oil"}, {"lamps", "are", "blown"}, {"out", "Until", "dark"}, {"envelopes", "single", "flame"}, {"Pulsing", "softly", "hearth"}, {"wandering", "soul", "glimmers"}, {"base", "stairs", "nighttime"}};
        MadLibs madLibs = new MadLibs(0.6, s); //tester MadLibs object
        String tweet = madLibs.getTweet(); //why are only 1 and 6 working? --> k < 0 = 1; k > 0 = 6*/

        /*
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("Kcv2jop3cdiHPFAM1Gik8hirB")
                .setOAuthConsumerSecret("dz2EVFTJWPvBnZwszoOI4AHifOk5izx9ZMWsiV61LRAUt5qhql")
                .setOAuthAccessToken("870735718355574784-QtJCCRPArbSuzZPDpaS5ilaBQ8ZXkY4")
                .setOAuthAccessTokenSecret("eremAiNxiuAvmFQhIshTXoT47g4VcWt6xx1qvQCdKH5Io");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
        */
    }
}
