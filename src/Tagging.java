/**
 * Created by princ on 10/05/2017.
 * Tagger class to determine parts of speech
 * ??? Why is this an entire class right now? With only one method? I'll figure it out later.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
public class Tagging {
    public Word[] conversion(HashMap h) {
        Set<String> w = h.keySet(); //creates a set from keys in HashMap h.
        Collection<Integer> v = h.values(); //creates a collection from values in HashMap h.
        Object[] v2 = v.toArray(); //creates an array w/ values from v.
        Object[] w2 = w.toArray(); //creates an array from set w.
        //int[] vals = new Array[s.size()]; creates an array w/ sizes
        //Set<String> partOfSpeechWord = new Set[paragraph.length()];
        HashMap<String, String> wordSpeech = new HashMap<>(); //creates a HashMap mapping word w/ pofS
        Collection<String> pofs = wordSpeech.values(); //Collection of values from PofS
        Object[] pofs2 = pofs.toArray(); //Array of values from PofS.
        for (Object element : w2) {
            if (w2 instanceof Integer[]) {
                int n = (int) h.get(element); //gets the key from HM h.
            }

            String part = h.pOfS(h); //gets the part of speech the element is from the pOfS method
            wordSpeech.put(n, part); //maps the word w/ its pOfS into wordSpeech HM

        }
        ArrayList<Word> nouns = new ArrayList<Word>();
        ArrayList<Word> prestenseVerb = new ArrayList<Word>();
        ArrayList<Word> properNoun = new ArrayList<Word>();
        ArrayList<Word> adj = new ArrayList<Word>();
        ArrayList<Word> pasttenVerb = new ArrayList<Word>();
        ArrayList<Word> other = new ArrayList<Word>();
        for (int i = 0; i < w2.length; i++) {
            String w3 = w2[i]; //gets the keys
            String pofs3 = pofs2[i]; //gets the values from PofS.
            int v3 = v2[i];
            if (pofs3.equals("NN") || pofs3.equals("NNS")) {
                Word x = new Word(w3, pofs3, v3);
                nouns.add(x);
            } else if (pofs3.equals("VB") || pofs3.equals("VBP") || pofs3.equals("VBZ")) {
                Word x = new Word(w3, pofs3, v3);
                prestenseVerb.add(x);
            } else if (pofs3.equals("NNP") || pofs3.equals("NNPS")) {
                Word x = new Word(w3, pofs3, v3);
                properNoun.add(x);
            } else if (pofs3.equals("JJ") || pofs3.equals("JJR")) {
                Word x = new Word(w3, pofs3, v3);
                adj.add(x);
            } else if (pofs3.equals("VBD") || pofs3 "VBN"){
                Word x = new Word(w3, pofs3, v3);
                pasttenVerb.add(x);
            }
        }
        Collection.sort(nouns, prestenseVerb, properNoun, adj, pasttenVerb);
        Word[] finals = {nouns[0], prestenseVerb[0], properNoun[0], adj[0], pasttenVerb[0]};
        return finals;
        //To find the type of article.
        /*for(int i = 0; i < paragraph.length(); i++){
            if()
        }*/


        /*int max = h.get(w[0]);
        int current = h.get(w[0]);
        for(String m : w){
            current = h.get(m);
            if(current > max){
                max = current;
            }
        }*/
// this is so messed up, i think its supposed to be a method not a class...
    }
}