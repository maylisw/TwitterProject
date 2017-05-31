import edu.stanford.nlp.util.StringUtils;

import java.util.ArrayList;

/**
 * Created by mayliswhetsel on 5/10/17.
 * Plain text-> tokenize strings
 * Tokenize Strings to sorted array
 */
public class TextTOSortedArray {
    private String paragraph;
    public TextTOSortedArray(String text) {
        paragraph = text;
    }

    /**
     * Tokenizes all the words in the paragraph
     * @return array of String words.
     */
    public String[] tokenize() {
        String[] words = paragraph.split(" ");
        return words;
        /*String[] words = paragraph.split(" ");
        ArrayList<String> temp = new ArrayList<>();
        int l = words.length;
        for(int i = 0; i < l; i++){
            String w = words[i];
            if(w.matches("[a-zA-Z]+")){
                temp.add(w);
            }
        }
        int size = temp.size();
        String[] onlyWords = new String[size];
        for(String s : temp){
            int x = 0;
            onlyWords[x] = s;
            x++;
        }
        return onlyWords;*/
    }
    public String[] punctuationRemoval(String[] s){
        for(int i = 0; i < s.length; i++) { //Go through all words
            String temp = s[i]; //create variable housing string at index i
            if (temp.length() > 0) {
                String last = temp.substring(temp.length() - 1, temp.length()); //last char in the string at i
                if (!StringUtils.isAlphanumeric(last) || last.equals("")) //if not alpha numeric
                {
                    String fin = temp.substring(0, temp.length() - 1);  //remove last digits
                    s[i] = fin; //set new edited string to index i
                }
            }
        }
        return s;
    }

    public String[] frontPunctuationRemoval(String[] s){
        for(int i = 0; i < s.length; i++) { //Go through all words
            String temp = s[i]; //create variable housing string at index i
            if (temp.length() > 0) {
                String first = temp.substring(0, 1); //first char in the string at i
                if (!StringUtils.isAlphanumeric(first) || first.equals(".")) //if not alpha numeric
                {
                    String fin = temp.substring(1, temp.length());  //remove first digit
                    s[i] = fin; //set new edited string to index i
                }
            }
        }
        return s;
    }
}
