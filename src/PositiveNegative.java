/**
 * Created by princ on 24/05/2017.
 */
public class PositiveNegative {
    private String url = "";
    private String news = "";
    private boolean yesNo = false; //false = negative for Trump; true = positive for Trump

    public PositiveNegative(String url){
        //locate first www and cut off from that to the &output=text to isolate URL (until userInput works
        if(url.contains("tigernewspaper")){
            url = "www." + url;
        }
        int firstWWW = url.indexOf("www");
        int firstBoilerPipe = url.indexOf("&output=text");
        url = url.substring(firstWWW, firstBoilerPipe);
        int firstDot = url.indexOf(".");
        //System.out.print(firstDot);
        url = url.substring(firstDot + 1);
        //System.out.print(url);
        int secondDot = url.indexOf(".");
        //System.out.print(secondDot);
        news = url.substring(firstDot - 3, secondDot); // out of bounds error
        //System.out.println(news);
        if(news.equals("breitbart")|| news.equals("foxnews")){
            yesNo = true;
        }
        else if(news.equals("latimes") || news.equals("cnn") || news.equals("huffingtonpost") || news.equals("tigernewspaper") || news.equals("dailycal")){
            yesNo = false;
        }
        else if(news.equals("npr") || news.equals("bbc") || news.equals("nytimes") || news.equals("wsj")){
            int m = (int) Math.random()*10;
            if(m % 2 == 0){
                yesNo = true;
            }
            else{
                yesNo = false;
            }
        }
        else{
            int m = (int) Math.random()*10;
            if(m % 2 == 0){
                yesNo = true;
            }
            else {
                yesNo = false;
            }
        } //we've got to think of a better strategy for +/-
    }
    public boolean whichTemplate(){

        return yesNo;
    }

    public String whichNews(){
        return news;
    }
}
