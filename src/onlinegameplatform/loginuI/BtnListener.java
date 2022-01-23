package onlinegameplatform.loginuI;


import onlinegameplatform.aircraftwar.GameMain;
import onlinegameplatform.cutebird.ui.LoginUI;
import onlinegameplatform.gobang.LogGBUI;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BtnListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(x>235 && x<320 && y<410 && y>375){
            System.out.println("开始五子棋");
            LogGBUI ui = new LogGBUI();
            ui.initLogGBUI();
        }
        if(x>190 && x<260 && y<730 && y>700){
//           LoginBirdUI ui = new LoginBirdUI();
//           ui.InitUI();  //函数中无死循环,不用创建新线程
            LoginUI loginUI = new LoginUI();
            loginUI.InitUI();
            System.out.println("开始萌萌的小鸟");

        }
        if(x>170 && x<255 && y<930 && y>880){
//            GameMain war = new GameMain();
//            war.InitUI();
            GameMain war = new GameMain();
            war.start();          //线程调用run方法和调用普通方法一样,主函数里有死循环直接结束,线程里有死循环一直运行
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
