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
        ArrayList<String> temp = new ArrayList<>();
        int l = words.length;
        for(int i = 0; i < l; i++){
            String w = words[i];
            String w2 = w.toUpperCase();
            char c = w2.charAt(0);
            for(char alphabet = 'A'; alphabet <= 'Z';alphabet++) {
                if (c == alphabet) {
                    temp.add(w);
                }
                    //System.out.print(w);
                /*
                    for(char alphabet = 'A'; alphabet <= 'Z';alphabet++) {
                    System.out.println(alphabet);
                    }
                    "[a-zA-Z]+"
                }*/
            }
        }
        int size = temp.size();
        String[] onlyWords = new String[size];
        for(int i = 0; i < size; i++){
            onlyWords[i] = temp.get(i);
            //System.out.print(i + " " + onlyWords[i]);
        }
        return onlyWords;
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
