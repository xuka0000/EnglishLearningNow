public class imageLogic extends Thread{
    Grame gf ;
    //那一张图片
    int RandowPicture;
    //是否需要更改图片
    boolean isChange = true;
    //当前加载图片数量
    int loginNum = 0;
    public static image imageNow = imagedata.imageDta[0];
    public imageLogic(Grame gf){
        this.gf = gf;
    }

    @Override
    public void run() {
        //用来决定图片元素每次只加+1
        boolean flag = true;
        //记录当前数目
        int key = -1 ;
        while(true){

            //确定那一张图片
            if(isChange){
                RandowPicture = (int)Math.random()*imagedata.imageDta.length/1;
                loginNum = -1;
                isChange = false;
            }
            if(KeyListener.doubleShot>2 && KeyListener.doubleShot %3 == 0 && flag == true){
                key = KeyListener.doubleShot;
                if((loginNum+1)<imageNow.image.length){
                    loginNum++;flag = false;
                }else{
                    isChange = true;
                }
            }
            if(key != KeyListener.doubleShot){
                flag = true;
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
