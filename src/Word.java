/**
 * Created by princ on 10/05/2017.
 * Creates a Word object that implements a Comparable<Word>
 *     Need to create a comparable class
 */

public class Word implements Comparable<Word>
{
    private String word;
    //private String partOfSpeech;
    private int timesFound;
    public Word(String w, int i) /*Maylis, does this store an infinite amount of Word objs or
                                            is it just one and we have to recreate one for every set?*/
    {
        word = w;
        //partOfSpeech = a;
        timesFound = i;
    }
    public int compareTo(Word other){
        return other.timesFound - this.timesFound;
    }
    public String getWord()
    {
        return word;
    }
    /*public String getPartOfSpeech()
    {
        return partOfSpeech;
    }*/
    public int getTimesFound()
    {
        return timesFound;
    }
}
