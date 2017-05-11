/**
 * Created by princ on 10/05/2017.
 * SortedArray (from Maylis) --> Word Object --> Word Object ArrayList
 */
import java.util.ArrayList;
public class SortedTOWordObjectArrayList {
    private ArrayList<Word> wordArray = new ArrayList<>();
    private ArrayList<String> sorted = new ArrayList<>();

    public SortedTOWordObjectArrayList(ArrayList<String> sorted){
        this.sorted = sorted;
    }

    public ArrayList<Word> listed(){
        int l = sorted.size();
        int counter =0;
        while(l > 0){
            int current = 0;
            String targetWord = sorted.get(current); //gets the first word to compare
            current = 1; //sets it to look to the next position
            /*for(current; current < l - 1; l++){
                String gottenWord = sorted.get(current);
                if(gottenWord.compareTo(targetWord) == 0){

                }
            }*/
            boolean same = true; //when the words are the same, continue on
            while(same){
                String gottenWord = sorted.get(current);
                if(gottenWord.compareTo(targetWord) == 0){
                    counter++;
                }
                else{
                    same = false; //ends the while loop for this word
                    for(int i = counter; i > 0; i--){
                        sorted.remove(i - 1); //removes the checked words
                    }
                }
            }
            Word words = new Word(targetWord, counter);
            wordArray.add(words);
        }
        return wordArray;
    }
}
