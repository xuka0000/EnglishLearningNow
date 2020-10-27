import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements java.awt.event.MouseListener , MouseMotionListener {

    public Grame gf ;

    public  static int mouseX , mouseY;
    public static int nowMouseX , nowMouseY;
    public MouseListener(Grame gf){
        this.gf = gf;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        int code = Getchioce(mouseX,mouseY);

        switch (code) {
            case 1:isWrong();needCongratulation(0);break;
            case 2:isWrong();needCongratulation(1);break;
            case 3:isWrong();needCongratulation(2);break;
            case 4:isWrong();needCongratulation(3);break;

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
          nowMouseX = e.getX();
          nowMouseY = e.getY();
    }

    public int Getchioce(int x,int y){
        if(x>185 && x<650){
            if(y>335 && y<370){
                return 1;
            }
            if(y>410 && y<450){
                return 2;
            }
            if(y>485 && y<525){
                return 3;
            }
            if(y>560 && y<600){
                return 4;
            }
        }
        return -1;
    }

    /**************************************************************************************/
    //选择正确和选择后一些变量改变
    public void needCongratulation(int num){

        gf.logic.isAnswer = true;
        if(gf.logic.choice[num].isRight == true) {
            gf.logic.visited[gf.logic.Random] = true;
            gf.logic.congratulation = true;
            KeyListener.doubleShot++;
            gf.logic.fightNum++;
            System.err.println("可以不错！（当前连击数："+KeyListener.doubleShot+" )");
        }else{
            if(KeyListener.wrongtip){
                System.err.println("这都错！复读吧！小笨蛋"); KeyListener.doubleShot =0;
            }
            KeyListener.wrongtip = !KeyListener.wrongtip;
        }
        if(gf.logic.congratulation == true){
            gf.logic.change = true;
        }

    }

    //选择错误后
    public  void isWrong(){
        if(gf.logic.isAnswer == true && gf.logic.congratulation ==false){

            for(int i = 0 ; i<4 ; i++){
                gf.logic.choice[i].isRight =false;
            }
            gf.logic.change = true;
        }
    }

}
