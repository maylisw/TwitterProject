import java.util.ArrayList;

/**
 * Created by princ on 10/05/2017.
 * Tagger class to determine parts of speech
 * ??? Why is this an entire class right now? With only one method? I'll figure it out later.
 */
public class POSArrayLists{
    private ArrayList<Word> singularNoun;
    private ArrayList<Word> pluralNoun;
    private ArrayList<Word> infiniteVerb;
    private ArrayList<Word> nonThirdPersonSingularPresentVerb;
    private ArrayList<Word> thirdPersonSingularVerb;
    private ArrayList<Word> properNounSingular;
    private ArrayList<Word> properNounPlural;
    private ArrayList<Word> adjective;
    private ArrayList<Word> comparativeAdjectives;
    private ArrayList<Word> superlativeAdjectives;
    private ArrayList<Word> pastTenseVerb;
    private ArrayList<Word> pastParticipleVerb;
    private ArrayList<Word> modalVerb;
    private ArrayList<Word> possessivePronoun;
    private ArrayList<Word> interjection;
    private ArrayList<Word> adverb;
    public POSArrayLists(ArrayList<Word> w1, ArrayList<Word> w2, ArrayList<Word> w3, ArrayList<Word> w4, ArrayList<Word> w5, ArrayList<Word> w6, ArrayList<Word> w7, ArrayList<Word> w8, ArrayList<Word> w9, ArrayList<Word> w10, ArrayList<Word> w11, ArrayList<Word> w12, ArrayList<Word> w13, ArrayList<Word> w14, ArrayList<Word> w15, ArrayList<Word> w16){
        singularNoun = w1;
        pluralNoun = w2;
        infiniteVerb = w3;
        nonThirdPersonSingularPresentVerb = w4;
        thirdPersonSingularVerb = w5;
        properNounSingular = w6;
        properNounPlural = w7;
        adjective = w8;
        comparativeAdjectives = w9;
        superlativeAdjectives = w10;
        pastTenseVerb = w11;
        pastParticipleVerb = w12;
        modalVerb = w13;
        possessivePronoun = w14;
        interjection = w15;
        adverb = w16;
    }

    public ArrayList<Word> getSingularNoun() {
        return singularNoun;
    }

    public ArrayList<Word> getPluralNoun() {
        return pluralNoun;
    }

    public ArrayList<Word> getInfiniteVerb() {
        return infiniteVerb;
    }

    public ArrayList<Word> getNonThirdPersonSingularPresentVerb() {
        return nonThirdPersonSingularPresentVerb;
    }

    public ArrayList<Word> getThirdPersonSingularVerb() {
        return thirdPersonSingularVerb;
    }

    public ArrayList<Word> getProperNounSingular() {
        return properNounSingular;
    }

    public ArrayList<Word> getProperNounPlural() {
        return properNounPlural;
    }

    public ArrayList<Word> getAdjective() { return adjective; }

    public ArrayList<Word> getComparativeAdjectives() {
        return comparativeAdjectives;
    }

    public ArrayList<Word> getSuperlativeAdjectives() {
        return superlativeAdjectives;
    }

    public ArrayList<Word> getPastTenseVerb() {
        return pastTenseVerb;
    }

    public ArrayList<Word> getPastParticipleVerb() {
        return pastParticipleVerb;
    }

    public ArrayList<Word> getModalVerb() { return modalVerb; }

    public ArrayList<Word> getPossessivePronoun() {
        return possessivePronoun;
    }

    public ArrayList<Word> getInterjection() {
        return interjection;
    }

    public ArrayList<Word> getAdverb() {
        return adverb;
    }
}