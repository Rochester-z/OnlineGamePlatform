package onlinegameplatform.cutebird.listener;

import onlinegameplatform.cutebird.pass.FifthPassBirdUI;
import onlinegameplatform.cutebird.pass.SecondPassBirdUI;
import onlinegameplatform.cutebird.pass.ThirdPassBirdUI;
import onlinegameplatform.cutebird.ui.ScoreUI;
import onlinegameplatform.cutebird.ui.StageUI;
import onlinegameplatform.cutebird.pass.FourthPassBirdUI;
import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ScoreListener implements MouseListener, MouseMotionListener {
    //关卡跳转界面
    ScoreUI scoreUI;
    //关卡选择界面
    StageUI stageUI;

    public Graphics g;
    public Image image = PictureUtil.getPictureBird("score.png").getImage();  //原始背景
    public Image image1 = PictureUtil.getPictureBird("score1.png").getImage();  //按钮1被点亮
    public Image image2 = PictureUtil.getPictureBird("score2.png").getImage();  //按钮2被点亮

    public int stage;       //关卡数


    public void setStageUI(StageUI stageUI) {
        this.stageUI = stageUI;
    }

    public void setScoreUI(ScoreUI scoreUI) {
        this.scoreUI = scoreUI;
    }

    public void setstage(int stage) {
        this.stage = stage;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x < 340 && x > 260 && y > 665 && y < 760) {
            stageUI.setVisible(true);  //重新打开关卡选择界面
            scoreUI.setVisible(false);  //隐藏关卡跳转界面
        }
        if (x < 460 && x > 380 && y > 665 && y < 760) {
            System.out.println("重新开始本关");
        }

        if (x < 600 && x > 505 && y > 665 && y < 760) {
            if (stage == 2) {
                scoreUI.setVisible(false);  //隐藏关卡跳转界面
                SecondPassBirdUI thread = new SecondPassBirdUI();
                thread.setStageUI(stageUI);
                thread.start();
            }
            if (stage == 3) {
                scoreUI.setVisible(false);   //隐藏关卡跳转界面
                ThirdPassBirdUI thread = new ThirdPassBirdUI();
                System.out.println("stageUI" + stageUI);
                thread.setStageUI(stageUI);
                thread.start();
            }
            if (stage == 4) {
                scoreUI.setVisible(false);   //隐藏关卡跳转界面
                FourthPassBirdUI thread = new FourthPassBirdUI();
                System.out.println("stageUI" + stageUI);
                thread.setStageUI(stageUI);
                thread.start();
            }
            if(stage == 5){
                scoreUI.setVisible(false);   //隐藏关卡跳转界面
                FifthPassBirdUI thread = new FifthPassBirdUI();
                System.out.println("stageUI" + stageUI);
                thread.setStageUI(stageUI);
                thread.start();
            }
            System.out.println("进入下一关");
        }
        System.out.println("x的坐标" + x + "y的坐标" + y);

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

    boolean buttonflag1 = false;     //鼠标不在按钮1上
    boolean buttonflag2 = false;     //鼠标不在按钮2上

    @Override
    public void mouseMoved(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();


        //如果鼠标移动到按钮上，按钮变色，移动出去，按钮还原颜色

        if (x < 340 && x > 260 && y > 665 && y < 760) {
            buttonflag1 = true;  //鼠标移入按钮1
            g.drawImage(image1, 10, 50, 790, 750, null);
            System.out.println("按钮1被按下");
        }


        if (buttonflag1 == true) {
            if (x < 260 || x > 340 || y < 665 || y > 760) {
                System.out.println("移出按钮1");
                g.drawImage(image, 10, 50, 790, 750, null);
                buttonflag1 = false;  //移出按钮1
            }

        }

//        if(buttonflag1 == false)

        if (x < 600 && x > 505 && y > 665 && y < 760) {
            buttonflag2 = true;
            System.out.println("按钮2被按下");
            g.drawImage(image2, 10, 50, 790, 750, null);
        }
        if (buttonflag2 == true) {
            if (x < 505 || x > 600 || y < 665 || y > 760) {
                System.out.println("移出按钮2");
                g.drawImage(image, 10, 50, 790, 750, null);
                buttonflag2 = false;  //移出按钮2
            }


        }
    }
}
