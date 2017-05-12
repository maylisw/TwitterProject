/**
 * Created by princ on 10/05/2017.
 * Tagger class to determine parts of speech
 * ??? Why is this an entire class right now? With only one method? I'll figure it out later.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
//import java.util.Set;
public class Tagger {
    private ArrayList<Word> wordList = new ArrayList<>();

    public Tagger(ArrayList<Word> wordList){
        this.wordList = wordList;
    }
    public HashMap<String, String> pOfS()
    {
        HashMap<String, String> h = new HashMap<>();
        MaxentTagger tagger = new MaxentTagger("english-left3words-distsim.tagger");//model fie from their models
        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader(paragraph)));
        for (List<HasWord> sentence : sentences) {
            List<TaggedWord> tSentence = tagger.tagSentence(sentence);
            for(TaggedWord t: tSentence )
            {
                 h.put((String) t, (string) t.tag());
            }
        }
        return h; //h
    }

}