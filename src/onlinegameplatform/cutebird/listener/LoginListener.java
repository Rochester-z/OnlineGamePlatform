package onlinegameplatform.cutebird.listener;

import onlinegameplatform.cutebird.ui.LoadingThread;
import onlinegameplatform.cutebird.ui.LoginUI;
import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class LoginListener implements MouseListener, MouseMotionListener {  //一个界面一个监听器，防止出错
    //开始游戏界面的监听器
    public LoginUI ui;

    public Graphics g;
    public Image image = PictureUtil.getPictureBird("login2.png").getImage();
    public Image image2 = PictureUtil.getPictureBird("login.png").getImage();

    public void setLoginUI(LoginUI ui) {
        this.ui = ui;
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
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x > 310 && x < 500 && y > 650 && y < 720) {

            LoadingThread thread = new LoadingThread();   //(当前线程里有Thread.sleep,创个新线程)
            thread.start();
            ui.setVisible(false);   //隐藏上一个界面、
            System.out.println("ui.music");
        }


        System.out.println("鼠标点击x的坐标:" + x + "y的坐标" + y);

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    boolean buttonflag = false;       //判断按钮是否被点击

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
       //如果鼠标移动到按钮上，按钮变色，移动出去，按钮还原颜色，不会继续刷新了
        if (x > 310 && x < 500 && y > 650 && y < 720) {
            buttonflag = true;
            g.drawImage(image, 0, 0, 800, 800, null);
        }

        if (buttonflag = true) {
            if (x < 310 || x > 500 || y < 650 || y > 720) {
                g.drawImage(image2,0,0,800,800,null);
                buttonflag = false;  //鼠标移除按钮
            }
        }
    }
}


