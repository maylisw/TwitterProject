import javax.swing.*;

/**
 * Created by princ on 24/05/2017.
 */
public class TweetImage {
    private String tweet = "";
    Icon picture;
    int position;

    public TweetImage(String tweet, Icon picture, int position){
        this.tweet = tweet;
        this.picture = picture;
        this.position = position;
    }

    public JLabel makeJLabel(){
        JLabel jLabel = new JLabel("tweet", picture, position);
        JFrame frame = new JFrame();
        jLabel.setIcon(picture);
        frame.setSize(picture.getIconWidth(), picture.getIconHeight());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
