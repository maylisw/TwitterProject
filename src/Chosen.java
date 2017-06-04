import java.util.ArrayList;

/**
 * Created by mayliswhetsel on 5/14/17.
 */
public class Chosen {
    private String[][] keyWords = new String[12][1]; //currently largest # to fill per tweet is 3; later make separate
    ArrayList[] s = new ArrayList[12]; //create an instance variable --> check if array is null or empty in isFilled.
    private double d;
    private boolean yesNo;

    public Chosen( boolean y){
        d = Math.random();
        yesNo = y;
        if(yesNo == false){
            System.out.println(d);
            if(d >= 0 && d < 0.2){
                keyWords[1] = new String[1];
                keyWords[4] = new String[1];
                System.out.println("0 &.2");
            }
            else if(d >= 0.2 && d < 0.4){
                keyWords[8] = new String[1];
                keyWords[5] = new String[1];
                keyWords[0] = new String[1];
                System.out.println(".2 &.4");
            }
            else if(d >= 0.4 && d < 0.6){
                keyWords[5] = new String[1];
                keyWords[6] = new String[1];
                keyWords[1] = new String[1];
                System.out.println(".4 &.6");
            }
            else if(d >= 0.6 && d < 0.8){
                keyWords[6] = new String[1];
                keyWords[10] = new String[1];
                System.out.println(".6 &.8");
            }
            else{
                keyWords[10] = new String[1];
                System.out.println(".8 & 1");
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
        ArrayList<ArrayList<Word>> temp = new ArrayList<>();
        for(int i = 0; i < 12; i++){
            temp.add(s[i]);
        }
        for(int row = 0; row < 12; row++){
            cols = keyWords[row].length;
            ArrayList<Word> ws = s[row];
            for(int col = 0; col < cols; col++){
                 if(temp.get(row).isEmpty() != true) {
                     Word w = ws.get(col);
                     //System.out.println(w.getWord() + " " + col + " " + cols); can uncomment later
                     keyWords[row][col] = w.getWord();
                 }
                 else{
                     keyWords[row][col] = "TESTER";
                 }
            }
        }
        return keyWords;
    }

    public double getTemplate(){
        return d;
    }

    /*public boolean isFilled(){
        ArrayList<ArrayList<Word>> aL = new ArrayList<>();
        int i = 0;
        while(i < 12){
            aL.add(this.);
        }
    }*/

}
