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
    private String word = "";


    public PartOfSpeech(Word wordObj){
        String word = wordObj.getWord();
        this.word = word;
    }

    public String tagging(){
        MaxentTagger tagger = new MaxentTagger("english-left3words-distsim.tagger");//model fie from their models
        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader(word)));
        for (List<HasWord> sentence : sentences) {
            List<TaggedWord> tSentence = tagger.tagSentence(sentence);

            /*for(TaggedWord t: tSentence )
            {
                h.put((String) t, (string) t.tag()); //ugh
            }*/

        }
    }
}