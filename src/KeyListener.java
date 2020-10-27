import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    public Grame gf;
    public static int doubleShot = 0;
    public static boolean  wrongtip = true;
    public KeyListener(Grame gf){this.gf = gf;}


    /**
     * 按键触发一次
     * 仅对字母键位有效
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e){
        int code = e.getKeyCode();

    }

    /**
     * 键盘点击每一个键时
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        //测试ASCLL码
	//	System.out.println(code);
        switch (code) {
            case 97:isWrong();needCongratulation(0);break;
            case 98:isWrong();needCongratulation(1);break;
            case 99:isWrong();needCongratulation(2);break;
            case 100:isWrong();needCongratulation(3);break;

        }
    }

    /**
     * 当抬起键盘摸一个键时
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();


    }

    /**************************************************************************************/
    //选择正确和选择后一些变量改变
    public void needCongratulation(int num){

            gf.logic.isAnswer = true;
            if(gf.logic.choice[num].isRight == true) {
                gf.logic.visited[gf.logic.Random] = true;
                gf.logic.congratulation = true;
                doubleShot++;
                gf.logic.fightNum++;
                System.err.println("可以不错！（当前连击数："+doubleShot+" )");
            }else{
               if(wrongtip){
                   System.err.println("这都错！复读吧！小笨蛋"); doubleShot =0;
               }
                wrongtip = !wrongtip;
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


    public  void sleepTest(int sleep) {//时间延迟装置
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
