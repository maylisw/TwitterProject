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
           PartOfSpeech p = new PartOfSpeech(w);
           String partOfSpeech = p.tagging();
           switch(partOfSpeech){
               case "NN":
               {
                   NN.add(w);
                   break;
               }
               case "NNS":
               {
                   NNS.add(w);
                   break;
               }
               case "VB":
               {
                   VB.add(w);
                   break;
               }
               case "VBP":
               {
                   VBP.add(w);
                   break;
               }
               case "VBZ":
               {
                   VBZ.add(w);
                   break;
               }
               case "NNP":
               {
                   NNP.add(w);
                   break;
               }
               case "NNPS":
               {
                   NNPS.add(w);
                   break;
               }
               case "JJ":
               {
                   JJ.add(w);
                   break;
               }
               case "JJR":
               {
                   JJR.add(w);
                   break;
               }
               case "JJS":
               {
                   JJS.add(w);
                   break;
               }
               case "VBD":
               {
                   VBD.add(w);
                   break;
               }
               case "VBN":
               {
                   VBN.add(w);
                   break;
               }
               default:
               {
                   break;
               }
           }

       }
    }
}
