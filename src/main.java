import java.awt.event.MouseMotionListener;

public class main {
    public static void main(String Array[]){
        Grame gf = new Grame();
        //键盘监听器
        KeyListener keylistener = new KeyListener(gf);
        gf.addKeyListener(keylistener);
        //鼠标监听器
        MouseListener mouseListener = new MouseListener((gf));
        gf.addMouseListener(mouseListener);
        gf.addMouseMotionListener(mouseListener);
    }
}
