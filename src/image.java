import javax.swing.*;
import java.awt.*;

/*
 一张图片的
 */
public class image {
    APicture[] image;

    public image(APicture[] image) {
        this.image = image;
    }

    public APicture[] getImage() {
        return image;
    }

    public void setImage(APicture[] image) {
        this.image = image;
    }
}
