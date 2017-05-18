import java.util.ArrayList;

/**
 * Created by mayliswhetsel on 5/16/17.
 */
public class MadLibs {
    private String tweet;
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
    private int numberOfPastParticipleVerbs; 11*/

    public MadLibs(double n, String[][] words)
    {
        int k = (int) n*6 +1;
        switch(k)
        {
            case 1:
                tweet = "The real problem is that " + words[1][0] + " " + words[4][0] + "! Very un-American!";
                break;
            case 2:
                tweet = "Despite the efforts of " + words[8][0] + " " + words[5][0] + " to stop us, " + words[0][0] + " is moving quickly!";
                break;
            case 3:
                tweet = words[5][0] + " just stated that (noun) (past tense verb). Very untrue!";
                break;
            case 4:
                tweet = "Reports that " + words[6][0] + words[10][0] + "by CNN are completely untrue - FAKE NEWS!";
                break;
            case 5:
                tweet = "Nobody should be allowed to " + words[10][0] + "! Wrong wrong wrong!";
                break;
            case 6:
                tweet = "Finally a news outlet that is reporting the truth, " + words[6][0] + "is " + words[7][0] + "Very true!";
                break;
        }

    }

    public String getTweet() {
        return tweet;
    }
}