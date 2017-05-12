import java.util.ArrayList;

/**
 * Created by mayliswhetsel on 5/12/17.
 */
public class Tagger {
    private ArrayList<Word> tagME;
    public Tagger(ArrayList<Word> w){
        tagME = w;
    }
    public POSArrayLists listTag(){
       for(Word w: tagME){
           PartOfSpeech p = new PartOfSpeech(w);
       }
    }
}
