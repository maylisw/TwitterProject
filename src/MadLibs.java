import java.util.ArrayList;

/**
 * Created by mayliswhetsel on 5/16/17.
 */
public class MadLibs {
    private String tweet;
    private String outlet;
    /*private int numberOfSingularNouns; 0
    private int numberOfPluralNouns; 1
    private int numberOfInfiniteVerbs; 2
    private int numberOfNonThirdPersonSingularPresentVerbs; 3
    private int numberOfThirdPersonSingularVerbs; 4
    private int numberOfProperNounSingulars; 5
    private int numberOfProperNounPlurals; 6
    private int numberOfAdjectives;7
    private int numberOfComparativeAdjectives; 8
    private int numberOfSuperlativeAdjectives; 9
    private int numberOfPastTenseVerbs; 10
    private int numberOfPastParticipleVerbs; 11
    private int numberOfModalVerbs; 12
    private int numberOfPossessivePronouns; 13
    private int numberOfInterjections; 14
    private int numberOfAdverbs; 15*/

    public MadLibs(double n, String[][] words, String outlet)
    {
        int k = (int)(n * 9 + 1);
        System.out.println(k);
        if(k >= 1 && k < 10){
            switch(k)
            {
                case 1: //negative
                    tweet = "The real problem is that " + words[1][0] + " " + words[3][0] + " " + words[0][0] + "! Very un-American!";
                    break;
                case 2: //negative
                    tweet = "Despite the efforts of " + words[8][0] + " " + words[5][0].substring(0,1).toUpperCase() + words[5][0].substring(1, words[5][0].length()) + " to stop us, " + words[0][0] + " is moving quickly!";
                    break;
                case 3: //negative
                    String w = words[5][0];
                    int l = w.length();
                    tweet = w.substring(0, 1).toUpperCase() + w.substring(1, l) + " just stated that " + words[6][0].substring(0,1).toUpperCase() + words[6][0].substring(1, words[6][0].length()) + " " + words[1][0] + ". Very untrue!";
                    break;
                case 4: //ONLY for CNN!!! negative
                    tweet = "Reports that " + words[6][0].substring(0,1).toUpperCase() + words[6][0].substring(1, words[6][0].length()) + " " + words[10][0] + " by " + outlet + " are completely untrue - FAKE NEWS!";
                    break;
                case 5: //negative
                    tweet = "Nobody should be allowed to be " + words[10][0] + "! Wrong wrong wrong!";
                    break;
                case 6:
                    tweet = "The liberals have been trying to smear my campaign - " + words[9][0].toUpperCase() + " " + words[8][0] + " are being " + words[7][0] + "!" ;
                    break;
                case 7:
                    tweet = "The " + words[6][0].substring(0,1).toUpperCase() + words[6][0].substring(1, words[6][0].length()) + " are " + words[13][0] + " - " + words[14][0] + "! " + words[15][0].substring(0, 1).toUpperCase() + words[15][0].substring(1, words[15][0].length()) + " the " + words[9][0] + " " + words[6][1] + " out there!";
                    break;
                case 8:
                    tweet = "To the " + words[7][0] + " " + words[0][0] + " out there, a " + words[0][1] + " " + words[12][0] + " " + words[3][0] + " today - NOT TRUE! Absolute lies!";
                    break;
                case 9:
                    tweet = words[14][0] + "! We need to be " + words[7][0].toUpperCase() + ", " + words[7][1].toUpperCase() + ", and " + words[7][2].toUpperCase() + ". We need the " + words[1][0] + " " + words[2][0] + " our " + words[1][1] + " now! No " + words[8][0] + " " + words[1][2] + "!";
                    break;
            }

        }
        else {
            tweet = "Finally a news outlet that is reporting the truth, " + words[6][0] + " are " + words[7][0] + ". " + "Very true!";
            //positive
        }

    }

    public String getTweet() {
        return tweet;
    }
}