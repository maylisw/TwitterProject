import java.util.ArrayList;

/**
 * Created by mayliswhetsel on 5/14/17.
 */
public class Chosen {
    private String[][] keyWords = new String[12][1]; //currently largest # to fill per tweet is 3; later make separate
    private double d;
    private boolean yesNo;

    public Chosen(POSArrayLists p, boolean yesNo){
        //d = Math.random();
        this.yesNo = yesNo;
        if(yesNo = false){
            d = Math.random();
            if(d >= 0 && d < 0.2){
                keyWords[1] = new String[1];
                keyWords[4] = new String[1];
            }
            else if(d >= 0.2 && d < 0.4){
                keyWords[8] = new String[1];
                keyWords[5] = new String[1];
                keyWords[0] = new String[1];
            }
            else if(d >= 0.4 && d < 0.6){
                keyWords[5] = new String[1];
                keyWords[6] = new String[1];
                keyWords[1] = new String[1];
            }
            else if(d >= 0.6 && d < 0.8){
                keyWords[6] = new String[1];
                keyWords[10] = new String[1];
            }
            else{
                keyWords[10] = new String[1];
            }
        }
        else {
            keyWords[6] = new String[1];
            keyWords[7] = new String[1];
            d = 5.0;
        }
    }

    /**
     * Inserts the proper number of String words gotten by getWord() on Word objects
     */
    public String[][] fill(POSArrayLists p){
        int cols;
        ArrayList<Word> NN = p.getSingularNoun();
        ArrayList<Word> NNS = p.getPluralNoun();
        ArrayList<Word> VB = p.getInfiniteVerb();
        ArrayList<Word> VBP = p.getNonThirdPersonSingularPresentVerb();
        ArrayList<Word> VBZ = p.getThirdPersonSingularVerb();
        ArrayList<Word> NNP = p.getProperNounSingular();
        ArrayList<Word> NNPS = p.getProperNounPlural();
        ArrayList<Word> JJ = p.getAdjective();
        ArrayList<Word> JJR = p.getComparativeAdjectives();
        ArrayList<Word> JJS = p.getSuperlativeAdjectives();
        ArrayList<Word> VBD = p.getPastTenseVerb();
        ArrayList<Word> VBN = p.getPastParticipleVerb();
        ArrayList[] s = {NN, NNS, VB, VBP, VBZ, NNP, NNPS, JJ, JJR, JJS, VBD, VBN}; //can create array of AL<Anything>
        for(int row = 0; row < 12; row++){
            cols = keyWords[row].length;
            ArrayList<Word> ws = s[row];
            for(int col = 0; col < cols; col++){
                Word w = ws.get(col);
                keyWords[row][col] = w.getWord();
            }
        }
        return keyWords;
    }

    public double getTemplate(){
        return d;
    }

}
