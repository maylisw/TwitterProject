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
    public String[] tokenize() {
        String[] words = paragraph.split(" ");
        return words;
    }
    //loop through check is alpha numeric on all last digits nex emthodgoes there
}
