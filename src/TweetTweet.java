import javax.swing.*;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Function;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.extractors.DefaultExtractor;
import java.net.URL;

/**
 * Created by mayliswhetsel on 5/8/17.
 * Main class: 2D Array --> Tweet --> Image --> Twitter
 */
public class TweetTweet {
    public static void main(String[] args) throws TwitterException, MalformedURLException, BoilerpipeProcessingException {
        UserInput userInput = new UserInput();
        System.out.print("What article do you want to make Trump react to? --> ");
        String link = userInput.getString();
        String realURL = "http://boilerpipe-web.appspot.com/extract?url=" + link + "&output=text";
        //System.out.println(realURL);
        //String boilerPipeURL = "http://boilerpipe-web.appspot.com/extract?url=https://www.theodysseyonline.com/rape-culture-important-details-missed&output=text";

        /*URLReader url = new URLReader(realURL); //sample text for now
        String boilerPipe = url.readerReturn(realURL);*/
        URL url2 = new URL(link);
        String text = ArticleExtractor.INSTANCE.getText(url2);
        //System.out.println(text);

        //HTMLtoPlainText html = new HTMLtoPlainText();
        //String plainText = html.replace(HTMLCode);

        TextTOSortedArray obj = new TextTOSortedArray(text);
        String[] tokenArray = obj.tokenize();

        String[] tokenArray2 = obj.punctuationRemoval(tokenArray);
        String[] tokenArray3 = obj.punctuationRemoval(tokenArray2);
        String[] tokenArray4 = obj.punctuationRemoval(tokenArray3);
        String[] betterTokenArray = obj.frontPunctuationRemoval(tokenArray4);
        Arrays.sort(betterTokenArray);

        SortedTOWordObjectArrayList obj2 = new SortedTOWordObjectArrayList(betterTokenArray);
        ArrayList<Word> wordList = obj2.listed();
        PartOfSpeech p = new PartOfSpeech(wordList, text);

        PositiveNegative posNeg = new PositiveNegative(realURL);
        boolean goodBad = posNeg.whichTemplate();
        String s = posNeg.whichNews();
        //System.out.println(goodBad)

        POSArrayLists taggedLists = p.tagging();

        Chosen c = new Chosen(goodBad);
        String [][] filled = c.fill(taggedLists);

        double d = c.getTemplate();
        System.out.println(d);
        MadLibs madLibs = new MadLibs(d, filled, s); //d = 0.04 URL = http://www.cnn.com/2017/06/01/politics/hillary-clinton-2016/index.html
        String tweet = madLibs.getTweet() + "\n link: "+link;
        System.out.println(tweet);

        //TextTOSortedArray tester = new TextTOSortedArray(plainText);
        //String[] s = tester.tokenize();
        /*String[][] s = {{"hi", "me", "what even"}, {"boom", "boo", "hello"}, {"When", "the", "home"}, {"And", "window", "close"}, {"their", "shutters", "One"}, {"by", "one", "oil"}, {"lamps", "are", "blown"}, {"out", "Until", "dark"}, {"envelopes", "single", "flame"}, {"Pulsing", "softly", "hearth"}, {"wandering", "soul", "glimmers"}, {"base", "stairs", "nighttime"}};
        MadLibs madLibs = new MadLibs(0.6, s); //tester MadLibs object
        String tweet = madLibs.getTweet(); //why are only 1 and 6 working? --> k < 0 = 1; k > 0 = 6*/


        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(TwitterKeys.OAUTH_CON_KEY)
                .setOAuthConsumerSecret(TwitterKeys.OAUTH_CON_SECRET)
                .setOAuthAccessToken(TwitterKeys.OAUTH_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitterKeys.OAUTH_ACCESS_TOKEN_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

    }
}
