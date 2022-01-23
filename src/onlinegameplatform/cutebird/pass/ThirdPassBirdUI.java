package onlinegameplatform.cutebird.pass;

import onlinegameplatform.cutebird.ui.StageUI;

import javax.swing.*;

public class ThirdPassBirdUI extends Thread{
    //关卡选择界面
    StageUI stageUI;


//    public static void main(String[] args) {
//        ThirdPassBirdUI ui = new ThirdPassBirdUI();
//        ui.start();
//    }
    public void setStageUI(StageUI stageUI){  //将关卡选择页面传入游戏界面来隐藏关卡选择页面
        this.stageUI = stageUI;
    }

    public void run() {
        stageUI.setVisible(false);       //JAVA类之间传参数太麻烦了
        JFrame jf = new JFrame();
        jf.setSize(800, 800);
        jf.setTitle("萌萌的小鸟");
        jf.setDefaultCloseOperation(3);
        /*
          this.setDefaultCloseOperation(0);// DO_NOTHING_ON_CLOSE，不执行任何操作。
         (1)//HIDE_ON_CLOSE，只隐藏界面，setVisible(false)。
         (2)//DISPOSE_ON_CLOSE,隐藏并释放窗体，dispose()，当最后一个窗口被释放后，则程序也随之运行结束。
         (3)//EXIT_ON_CLOSE,直接关闭应用程序，System.exit(0)。一个main函数对应一整个程序。
         */

        //创建panel容器,在上面重绘(paint)画图解决闪烁问题
        ThirdPassBirdPanel panel = new ThirdPassBirdPanel();
        jf.add(panel);
        panel.jf = jf;  //将开始界面传入面板来操作开始界面
        panel.stageUI = stageUI;
        jf.addMouseMotionListener(panel);
        jf.addMouseListener(panel);
        jf.setLocationRelativeTo(null);  //设置窗体在屏幕中间

        jf.setVisible(true);

        try {
            panel.begin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

