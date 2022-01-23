package onlinegameplatform.cutebird.ui;

import onlinegameplatform.cutebird.listener.ScoreListener;
import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;

public class ScoreUI extends JFrame{
    public JFrame jf;
    public StageUI stageUI;    //将关卡选择界面传入得分界面来操作
    public int stage;       //关卡数

    public void setstage(int stage){this.stage = stage;}
    public void setBirdUI(JFrame jf){
        this.jf = jf;
    }

    //当通关时打开得分界面
    Image image = PictureUtil.getPictureBird("score.png").getImage();
    LoadingUI ui;    //将加载页面传入选择关卡页面来实现隐藏

    public void setLoadingUI(LoadingUI ui){
        this.ui = ui;
    }
//    public static void main(String[] args) {
//        ScoreUI ui = new ScoreUI();
//        ui.InitUI();
//    }
    public void InitUI(){
        jf.setVisible(false);
//        ui.setVisible(false);
        this.setTitle("萌萌的小鸟");
        this.setSize(800,800);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);


        this.setVisible(true);

        ScoreListener listener = new ScoreListener();
        this.addMouseListener(listener);      //给界面添加鼠标监听器
        this.addMouseMotionListener(listener);
        listener.setStageUI(stageUI);  //将选择关卡界面传入监听器来隐藏选择关卡界面
        listener.setScoreUI(this);
        listener.setstage(stage);

        listener.g = this.getGraphics();  //将画笔传给监听器

    }



    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image,10,50,790,750,null);

    }
}
