package onlinegameplatform.aircraftwar;

import javax.swing.*;

public class GameMain extends Thread{

    //窗口的宽度和高度
    static int width = 600;
    static int height = 800;

    public static void main(String[] args) {
        GameMain gameMain = new GameMain();
        gameMain.start();
    }

    public void run(){


            //创建一个窗口的大小
            JFrame frame = new JFrame();

            //设置标题
            frame.setTitle("飞机大战");

            //设置窗口的大小
            frame.setSize(width, height);


            //关闭窗口关闭后JVM终止运行
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            //设置窗口居中
            frame.setLocationRelativeTo(null);


            //创建JPanel容器
            GamePanel panel = new GamePanel();

            //把JPanel添加到窗口中
            frame.add(panel);

            //添加鼠标监听器
            frame.addMouseMotionListener(panel);


            //设置可见
            frame.setVisible(true);

            //初始化容器
            panel.init();
        }
}
