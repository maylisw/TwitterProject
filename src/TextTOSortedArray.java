import edu.stanford.nlp.util.StringUtils;

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
    }
    public String[] punctuationRemoval(String[] s){
        for(int i = 0; i < s.length; i++) { //Go through all words
            String temp = s[i]; //create variable housing string at index i
            if (temp.length() > 0) {
                String last = temp.substring(temp.length() - 1, temp.length()); //last char in the string at i
                if (!StringUtils.isAlphanumeric(last)) //if not alpha numeric
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
                if (!StringUtils.isAlphanumeric(first)) //if not alpha numeric
                {
                    String fin = temp.substring(1, temp.length());  //remove first digit
                    s[i] = fin; //set new edited string to index i
                }
            }
        }
        return s;
    }
}
