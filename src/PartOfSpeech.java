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
        ArrayList<Word> NN = new ArrayList<>();
        ArrayList<Word> NNS = new ArrayList<>();
        ArrayList<Word> VB = new ArrayList<>();
        ArrayList<Word> VBP = new ArrayList<>();
        ArrayList<Word> VBZ = new ArrayList<>();
        ArrayList<Word> NNP = new ArrayList<>();
        ArrayList<Word> NNPS = new ArrayList<>();
        ArrayList<Word> JJ = new ArrayList<>();
        ArrayList<Word> JJR = new ArrayList<>();
        ArrayList<Word> JJS = new ArrayList<>();
        ArrayList<Word> VBD = new ArrayList<>();
        ArrayList<Word> VBN = new ArrayList<>();
        MaxentTagger tagger = new MaxentTagger("english-left3words-distsim.tagger");//model fie from their models
        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader(paragraph)));
        for (List<HasWord> sentence : sentences) {
            List<TaggedWord> tagWords = tagger.tagSentence(sentence);
            //int t = tagWords.size();
            int w = words.size();
            int current = 0;
            while(w > 0){
                String word = TaggedWord.word(); //how?
                for (HasWord targeted : sentence){
                    String targetedWord = targeted.word();
                    String tag = targeted.toString();
                    if(words.get(current).equals(targetedWord)){
                        if(tag.equals("NN")){
                            NN.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("NNS")){
                            NNS.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("VB")){
                            VB.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("VBP")){
                            VBP.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("VBZ")){
                            VBZ.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("NNP")){
                            NNP.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("NNPS")){
                            NNPS.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("JJ")){
                            JJ.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("JJR")){
                            JJR.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("JJS")){
                            JJS.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("VBD")){
                            VBD.add(tagWords.get(0));
                            current++;
                        }
                        else if(tag.equals("VBN")){
                            VBN.add(tagWords.get(0));
                            current++;
                        }
                    }
                }
            }
            //returnWord = tagWords.get(0).toString();
            /*for(TaggedWord t: tSentence )
            {
                h.put((String) t, (string) t.tag()); //ugh
            }*/

        }
        ArrayList<Word>[] POSArrayLists = ArrayList<Word>[NN, NNS, VB, VBP, VBZ, NNP, NNPS, JJ, JJR, JJS, VBD, VBN];
        return POSArrayLists;
    }
}