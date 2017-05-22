/**
 * Created by princ on 18/05/2017.
 */
public class HTMLtoPlainText {
    private String plainText = "";

    public HTMLtoPlainText(){
        //doesn't have to declare anything
    }

    public String replace(String HTMLCode){
        plainText =HTMLCode.replaceAll("\\<.*?\\>", "");
        return plainText;
    }
}
