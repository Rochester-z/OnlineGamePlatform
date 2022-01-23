package onlinegameplatform.cutebird.listener;

import onlinegameplatform.cutebird.pass.*;
import onlinegameplatform.cutebird.ui.StageUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StageListener implements MouseListener {
    //关卡选择页面
    StageUI ui;

    public void setStageUI(StageUI ui){
        this.ui = ui;
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if( x > 100 && x < 160 && y > 160 && y < 230){
            FirstPassBirdUI thread = new FirstPassBirdUI();           //(当前线程)函数里又是死循环,创个新线程
            thread.setStageUI(ui);
            thread.start();
        }
        if( x > 180 && x < 240 && y > 160 && y < 230){
            SecondPassBirdUI thread = new SecondPassBirdUI();
            thread.setStageUI(ui);
            thread.start();
        }

        if( x > 260 && x < 320 && y > 160 && y < 230){
            ThirdPassBirdUI thread = new ThirdPassBirdUI();
            thread.setStageUI(ui);
            thread.start();
        }

        if( x > 340 && x < 400 && y > 160 && y < 230){
            FourthPassBirdUI thread = new FourthPassBirdUI();
            thread.setStageUI(ui);
            thread.start();
        }

        if( x > 420 && x < 480 && y > 160 && y < 230){
            FifthPassBirdUI thread = new FifthPassBirdUI();
            thread.setStageUI(ui);
            thread.start();
        }


        System.out.println("鼠标点击x的坐标:"+x+"y的坐标"+y);


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
}
