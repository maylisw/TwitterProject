import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import javax.xml.bind.SchemaOutputResolver;
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
        MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");//model file from their model
        ArrayList<ArrayList<HasWord>> sentences = (ArrayList) MaxentTagger.tokenizeText(new BufferedReader(new StringReader(paragraph)));
        for (ArrayList<HasWord> sentence : sentences) {
            ArrayList<TaggedWord> tagWords = (ArrayList<TaggedWord>) tagger.tagSentence(sentence);
            int w = words.size();
            int w2 = w;
            int current = w - w2;
            //int current = 0;
            int total = 0;
            while(w > 0 /*|| need to cut off the loop before it reaches the end*/){
                int temp = current;
                int temp2 = w;
                for (TaggedWord targeted : tagWords){
                    String targetedWord = targeted.value();
                    String tag = targeted.tag();
                    //System.out.print(current + " " + w);
                    //System.out.println(words.get(current).getWord() + " " + targetedWord.toLowerCase()); can uncomment later
                    if(words.get(current).getWord().toLowerCase().equals(targetedWord.toLowerCase())){
                        switch(tag)
                        {
                            case "NN":
                                NN.add(words.get(current));
                                //current ++;
                                w--;
                                w2++;
                                total ++;
                                break;
                            case "NNS":
                                NNS.add(words.get(current));
                                //current ++;
                                w--;
                                w2++;
                                total ++;
                                break;
                            case "VB":
                                VB.add(words.get(current));
                                //current ++;
                                w--;
                                w2++;
                                total ++;
                                break;
                            case "VBP":
                                VBP.add(words.get(current));
                                //current ++;
                                w--;
                                total ++;
                                break;
                            case "VBZ":
                                VBZ.add(words.get(current));
                                //current ++;
                                w--;
                                w2++;
                                total ++;
                                break;
                            case "NNP":
                                NNP.add(words.get(current));
                                current ++;
                                w--;
                                total ++;
                                break;
                            case "NNPS":
                                NNPS.add(words.get(current));
                                //current ++;
                                w--;
                                w2++;
                                total ++;
                                break;
                            case "JJ":
                                JJ.add(words.get(current));
                                //current ++;
                                w--;
                                w2++;
                                total ++;
                                break;
                            case "JJR":
                                JJR.add(words.get(current));
                                //current ++;
                                w--;
                                w2++;
                                total ++;
                                break;
                            case "JJS":
                                JJS.add(words.get(current));
                                //current ++;
                                w--;
                                w2++;
                                total ++;
                                break;
                            case "VBD":
                                VBD.add(words.get(current));
                                //current ++;
                                w--;
                                w2++;
                                total ++;
                                break;
                            case "VBN":
                                VBN.add(words.get(current));
                                //current ++;
                                w--;
                                w2++;
                                total ++;
                                break;
                            default:
                                //current ++;
                                w2++;
                                break;
                        }
                        //System.out.println(current);
                    }
                }
                if(temp == current && current < words.size()-1)
                {
                    current ++;
                }
                if(temp2 == w && w > 0)
                {
                    w--;
                }
            }
            /*System.out.println(total);
            System.out.println(current);
            System.out.println(w);
            System.out.println(words.size());
            can uncomment later*/
        }
        //System.out.print("done"); can uncomment later
        POSArrayLists p = new POSArrayLists(NN, NNS, VB, VBP, VBZ, NNP, NNPS, JJ, JJR, JJS, VBD, VBN);
        return p;
    }
}