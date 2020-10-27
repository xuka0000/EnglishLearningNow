

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Grame extends JFrame {
    //词库组
    public logic logic;
    //图片
    public imageLogic imageLogic;
    //音乐组
    AudioPlayer StartSound;

    //白纸
    APicture white = new APicture("Image\\index.jpg");

    public Grame() {
        // 制作界面~~~~~~~~~~~~~~~~~~~~~~~~~~
        String title = "记单词咯";
        JFrame jf = new JFrame(title);
        Container container = jf.getContentPane();
        jf.setSize(600, 400);
        jf.setLayout(new BorderLayout());
        // 初始化窗口
        this.setSize(1400, 1120);
        this.setTitle("记单词啦");
        this.setResizable(false);
        // 居中展示窗口
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        //制作选择题库界面
        JTextField jt1 = new JTextField();
        JTextArea jt2 = new JTextArea();
        JScrollPane jsp = new JScrollPane(jt2);//new一个滚条
        String title2 = "选择题库中ing";
        JFrame jf2 = new JFrame(title2);
        jf2.setSize(600, 400);
        jf2.setLayout(new BorderLayout());
        jf2.add(BorderLayout.NORTH, jt1);
        jt1.setBackground(new Color(211, 137, 235));
        jf2.add(BorderLayout.CENTER, jt2);
        jt2.setBackground(new Color(144, 137, 235));
        jt1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jt2.setFont(new Font("", Font.BOLD, 20));
                jt2.setCaretColor(Color.cyan);
                int nowWordData = -1;
                for (int i = 0; i < date.totalWordDate.length; i++) {
                    if (date.totalWordDate[i].name.equals(jt1.getText())) {
                        nowWordData = i;
                    }
                }
                if (nowWordData == -1) {
                    jt2.setText("我靠！我这里没有你说的这什么鬼东西！"
                            + "我只有 2015 -2016");

                } else {
                    logic.WordDate = date.totalWordDate[nowWordData].word;
                    logic.isNewData = false;
                }
            }

        });
        //聊天框

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        if (logic.isNewData == true) {
                            jf2.setVisible(true);
                        } else {
                            jf2.setVisible(false);
                        }
                    } catch (NullPointerException ID) {
                    }

                }
            }
        }.start();

        //开启单词组
        logic = new logic(this);
        logic.start();
        //开始图片组
        imageLogic = new imageLogic((this));
        imageLogic.start();
        // 开启音乐播放器
        new Thread() {
            @Override
            public void run() {
                setName("音乐线程");
                while (true) {
                    try {
                        while (true) {
                            StartSound = new AudioPlayer("Sound\\Ares.MP3");//这里插入你BGM 最好是相对路径
                            StartSound.run();
                        }
                    } catch (Exception e) {
                        //不打印异常
                    }
                }

            }
        }.start();

        // 开启一个线程负责界面的窗体重绘线程
        new Thread() {
            public void run() {

                while (true) {
                    // 绘制窗体
                    repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        //不打印了
                    }
                }
            }
        }.start();
    }

    // 利用双缓冲画背景图片和冒险家
    @Override
    public void paint(Graphics g) {
        // 绘画板
        BufferedImage bi = (BufferedImage) this.createImage(this.getSize().width, this.getSize().height);
        // 画笔
        Graphics big = bi.getGraphics();

        try {
            imageDrawing(big);
            big.drawString("" + (logic.WordDate.length - logic.fightNum), 50, 130);
            big.drawString("" + MouseListener.nowMouseX, 50, 160);
            big.drawString("" + MouseListener.nowMouseY, 80, 160);
            if (logic.isNewData == false) {
                learning(big);
            }
        } catch (NullPointerException ID) {
        }


        // 绘画上色
        g.drawImage(bi, 0, 0, null);
    }

    public void learning(Graphics big) {
        try {
            big.setFont(new Font("", Font.BOLD, 50));
            big.setColor(new Color(137, 195, 235));
            big.drawString("[ " + logic.WordDate[logic.Random].partOfSpeech + " ]", 30, 90);
            big.setFont(new Font("", Font.BOLD, 80));
            big.setColor(new Color(216, 193, 235));
            big.drawString(logic.WordDate[logic.Random].spell, 245, 205);
            big.setFont(new Font("", Font.BOLD, 80));
            big.setColor(new Color(190, 137, 235));
            big.drawString(logic.WordDate[logic.Random].spell, 240, 200);


            big.setFont(new Font("", Font.BOLD, 55));
            big.setColor(new Color(167, 239, 214));
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    big.setColor(new Color(226, 185, 247));
                }
                if (i == 1) {
                    big.setColor(new Color(170, 210, 238));
                }
                if (i == 2) {
                    big.setColor(new Color(167, 196, 239));
                }
                if (i == 3) {
                    big.setColor(new Color(194, 167, 239));
                }
                if (logic.choice[i].isRight == true && logic.isAnswer == true) {
                    //错
                    big.setColor(new Color(244, 42, 131));
                }
                if (logic.congratulation == true) {
                    //对
                    big.setColor(new Color(3, 252, 243));
                }
                if (logic.choice[i].isRight == false) {
                    if (i == 0) {
                        big.setColor(new Color(226, 185, 247));
                    }
                    if (i == 1) {
                        big.setColor(new Color(170, 210, 238));
                    }
                    if (i == 2) {
                        big.setColor(new Color(167, 196, 239));
                    }
                    if (i == 3) {
                        big.setColor(new Color(194, 167, 239));
                    }
                }
                big.drawString(i + 1 + ". " + logic.choice[i].word.mean, 180, 300 + (i + 1 * 1) * 75);

            }

        } catch (NullPointerException ID) {

        }
    }

    public void imageDrawing(Graphics big) {
        for(int i = 0 ; i< this.imageLogic.loginNum; i++){
            big.drawImage(this.imageLogic.imageNow.image[i].getPicturePath(),0,0,1024,807,null);
        }
    }
}
/*if(logic.choice[i].isRight ==true &&logic.isAnswer ==true){
        big.setColor( new Color(248,91,136));
        }
        if( logic.congratulation ==true ){
        big.setColor(new Color(194,167,239));
        }
        if(logic.choice[i].isRight ==false){
        big.setColor(new Color(167,196,239));

        }*/