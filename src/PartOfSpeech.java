import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by princ on 10/05/2017.
 * Tags the word with the part of speech
 */
public class PartOfSpeech {
    //instance variables to be determined later
    //private String word = "";
    private ArrayList<Word> words = new ArrayList<>();
    private String paragraph = "";


    public PartOfSpeech(ArrayList<Word> words, String paragraph){
        this.words = words;
        this.paragraph = paragraph;
    }

    public POSArrayLists tagging(){
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
        MaxentTagger tagger = new MaxentTagger("left3words-wsj-0-18.tagger");//model fie from their models
        ArrayList<ArrayList<HasWord>> sentences = (ArrayList) MaxentTagger.tokenizeText(new BufferedReader(new StringReader(paragraph)));
        for (ArrayList<HasWord> sentence : sentences) {
            ArrayList<TaggedWord> tagWords = (ArrayList<TaggedWord>) tagger.tagSentence(sentence);
            int w = words.size();
            int current = 0;
            while(w > 0){
                for (TaggedWord targeted : tagWords){
                    String targetedWord = targeted.value();
                    String tag = targeted.tag();
                    if(words.get(current).equals(targetedWord)){
                        if(tag.equals("NN")){
                            NN.add(words.get(current));
                            current ++;
                            w--;
                        }
                        else if(tag.equals("NNS")){
                            NNS.add(words.get(current));
                            current ++;
                            w--;
                        }
                        else if(tag.equals("VB")){
                            VB.add(words.get(current));
                            current ++;
                            w--;
                        }
                        else if(tag.equals("VBP")){
                            VBP.add(words.get(current));
                            current ++;
                            w--;
                        }
                        else if(tag.equals("VBZ")){
                            VBZ.add(words.get(current));
                            current ++;
                            w--;
                        }
                        else if(tag.equals("NNP")){
                            NNP.add(words.get(current));
                            current ++;
                            w--;
                        }
                        else if(tag.equals("NNPS")){
                            NNPS.add(words.get(current));
                            current ++;
                            w--;
                        }
                        else if(tag.equals("JJ")){
                            JJ.add(words.get(current));
                            current ++;
                            w--;
                        }
                        else if(tag.equals("JJR")){
                            JJR.add(words.get(current));
                            current ++;
                            w--;
                        }
                        else if(tag.equals("JJS")){
                            JJS.add(words.get(current));
                            current ++;
                            w--;
                        }
                        else if(tag.equals("VBD")){
                            VBD.add(words.get(current));
                            current++;
                            w--;
                        }
                        else if(tag.equals("VBN")){
                            VBN.add(words.get(current));
                            current ++;
                            w--;
                        }
                    }
                }
            }

        }
        POSArrayLists p = new POSArrayLists(NN, NNS, VB, VBP, VBZ, NNP, NNPS, JJ, JJR, JJS, VBD, VBN);
        return p;
    }
}