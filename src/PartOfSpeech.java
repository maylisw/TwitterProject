import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by princ on 10/05/2017.
 * Tags the word with the part of speech
 */
public class PartOfSpeech {
    //instance variables to be determined later
    //private String word = "";
    private ArrayList<Word> words = new ArrayList<>();
    private String paragraph = "";
    private POSArrayLists sorted;


    public PartOfSpeech(ArrayList<Word> words, String paragraph){
        this.words = words;
        this.paragraph = paragraph;
    }

    public String tagging(){
        MaxentTagger tagger = new MaxentTagger("english-left3words-distsim.tagger");//model fie from their models
        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader(paragraph)));
        for (List<HasWord> sentence : sentences) {
            List<TaggedWord> tagWords = tagger.tagSentence(sentence);
            int t = tagWords.size();
            int w = words.size();
            //int current = 0;
            while(w > 0){
                String word = TaggedWord.word(); //how?
                for (HasWord targeted : sentence){
                    String targetedWord = targeted.word();
                    String tag = targeted.toString();
                    if()
                }
            }
            //returnWord = tagWords.get(0).toString();
            /*for(TaggedWord t: tSentence )
            {
                h.put((String) t, (string) t.tag()); //ugh
            }*/

        }
        return returnWord;
    }
}