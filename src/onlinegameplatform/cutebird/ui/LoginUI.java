package onlinegameplatform.cutebird.ui;

import onlinegameplatform.cutebird.listener.LoginListener;
import onlinegameplatform.cutebird.music.Music;
import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    //线程对象最好设为全局
    public Music music = new Music();
    //开始界面
    public Image image = PictureUtil.getPictureBird("login.png").getImage();

    public static void main(String[] args) {
        LoginUI ui = new LoginUI();
        ui.InitUI();


    }
    public void InitUI(){
        //函数里的变量为局部变量，函数执行完，变量自动销毁了。不是全局变量，不能为类的对象所有
        music.start();
        this.setTitle("萌萌的小鸟");
        this.setSize(800,800);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);

        this.setVisible(true); //隐藏，没关闭

        LoginListener loginListener = new LoginListener();
        this.addMouseListener(loginListener);      //给界面添加鼠标监听器
        this.addMouseMotionListener(loginListener);
        loginListener.setLoginUI(this);
        Graphics g = this.getGraphics();
        loginListener.g = g;



    }



    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image,0,0,800,800,null);
    }


}
