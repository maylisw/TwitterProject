import java.util.ArrayList;

/**
 * Created by mayliswhetsel on 5/14/17.
 */
public class Chosen {
    private String[][] keyWords = new String[16][3]; //currently largest # to fill per tweet is 3; later make separate
    ArrayList[] s = new ArrayList[16]; //create an instance variable --> check if array is null or empty in isFilled.
    private double d;
    private boolean yesNo;

    public Chosen( boolean y){
        //d = Math.random();
        yesNo = y;
        if(yesNo == false){
            //System.out.println(d);
            d = Math.random();
            if(d >= 0 && d < 1.0/9){
                keyWords[1] = new String[3];
                keyWords[4] = new String[3];
            }
            else if(d >= 1.0/9 && d < 2.0/9){
                keyWords[8] = new String[3];
                keyWords[5] = new String[3];
                keyWords[0] = new String[3];
            }
            else if(d >= 2.0/9 && d < 1.0/3){
                keyWords[5] = new String[3];
                keyWords[6] = new String[3];
                keyWords[1] = new String[3];
            }
            else if(d >= 1.0/3 && d < 4.0/9){
                keyWords[6] = new String[3];
                keyWords[10] = new String[3];
            }
            else if(d >= 4.0/9 && d < 5.0/9){
                //tweet #7
                keyWords[9] = new String[3];
                keyWords[6] = new String[3];
                keyWords[7] = new String[3];
            }
            else if(d >= 5.0/9 && d < 2.0/3){
                //tweet #8
                keyWords[6] = new String[3]; //2
                keyWords[13] = new String[3];
                keyWords[14] = new String[3];
                keyWords[15] = new String[3];
                keyWords[9] = new String[3];
            }
            else if(d >= 2.0/3 && d < 7.0/9){
                //tweet #9
                keyWords[7] = new String[3];
                keyWords[0] = new String[3]; //2
                keyWords[12] = new String[3];
                keyWords[3] = new String[3];
            }
            else if(d >= 7.0/9 && d < 8.0/9){
                //tweet #10
                keyWords[14] = new String[3];
                keyWords[7] = new String[3]; //3
                keyWords[1] = new String[3]; //3
                keyWords[2] = new String[3];
                keyWords[7] = new String[3];
            }
            else{
                keyWords[10] = new String[3];
                //System.out.println(".8 & 1");
            }
        }
        else {
            keyWords[6] = new String[3];
            keyWords[7] = new String[3];
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
        ArrayList<Word> MD = p.getModalVerb();
        ArrayList<Word> PRP$ = p.getPossessivePronoun();
        ArrayList<Word> UH = p.getInterjection();
        ArrayList<Word> RB = p.getAdverb();
        ArrayList[] s = {NN, NNS, VB, VBP, VBZ, NNP, NNPS, JJ, JJR, JJS, VBD, VBN, MD, PRP$, UH, RB}; //can create array of AL<Anything>
        ArrayList<ArrayList<Word>> temp = new ArrayList<>();
        for(int i = 0; i < 16; i++){
            temp.add(s[i]);
        }
        for(int row = 0; row < 16; row++){
            //cols = keyWords[row].length - 1;
            ArrayList<Word> ws = s[row];
            System.out.println(ws.size());
            cols = ws.size();
            if(cols < 2){
                for(int col = 0; col < cols - 1; col++){
                    Word wTest = ws.get(col);
                    if(wTest != null){//temp.get(row).isEmpty() != true) {
                        System.out.println(col + " " + cols);
                        Word w = ws.get(col);
                        System.out.println(w.getWord() + " " + col + " " + cols);
                        keyWords[row][col] = w.getWord();
                    }
                    else{
                        keyWords[row][col] = "LIES! YOUR FIRED!!!";
                    }
                }
            }
            else{
                for(int col = 0; col < 2; col++){
                    Word wTest = ws.get(col);
                    if(wTest != null) {
                        System.out.println(col + " " + cols);
                        Word w = ws.get(col);
                        System.out.println(w.getWord() + " " + col + " " + cols);
                        keyWords[row][col] = w.getWord();
                    }
                    else{
                        keyWords[row][col] = "LIES! YOUR FIRED!!!";
                    }
                }
            }
        }
        return keyWords;
    }

    public double getTemplate(){
        return d;
    }

}
