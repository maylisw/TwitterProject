/**
 * Created by princ on 10/05/2017.
 * SortedArray (from Maylis) --> Word Object --> Word Object ArrayList
 */
import java.util.ArrayList;
public class SortedTOWordObjectArrayList {
    private ArrayList<Word> wordArray = new ArrayList<>();
    private String[] sorted;

    public SortedTOWordObjectArrayList(String[] s){
        sorted = s;
    }

    public ArrayList<Word> listed(){
        int counter = 1;
        int current = 0;
        while(current < sorted.length){ //while have not reached the end
            String targetWord = sorted[current].toLowerCase(); //gets the first word to compare
            if(current == sorted.length - 1) { //cuts short if last word
                wordArray.add(new Word(targetWord, counter));
                break;
            }
            else {
                current = current + 1; //sets it to look at the next position
            }
            boolean same = true; //when the words are the same, continue on
            while(same){
                String gottenWord = sorted[current].toLowerCase();
                if(gottenWord.compareTo(targetWord) == 0){
                    counter++;
                    current ++;
                    System.out.println("Im Here");
                }
                else{
                    same = false; //ends the while loop for this word
                    System.out.println("im not the same"); //
                }
            }
            wordArray.add(new Word(targetWord, counter));
        }
        return wordArray;
    }
}
