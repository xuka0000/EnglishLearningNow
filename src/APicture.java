import javax.swing.*;
import java.awt.*;

public class APicture {
    private String PicturePath;

    public APicture(String picturePath) {
        PicturePath = picturePath;
    }

    public Image getPicturePath() {
        Image img=new ImageIcon(this.PicturePath).getImage();
        return img;
    }

    public void setPicturePath(String picturePath) {
        PicturePath = picturePath;
    }
}
