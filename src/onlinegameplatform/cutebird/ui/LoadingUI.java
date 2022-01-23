package onlinegameplatform.cutebird.ui;

import onlinegameplatform.cutebird.listener.ScoreListener;
import onlinegameplatform.util.PictureUtil;


import javax.swing.*;
import java.awt.*;

public class LoadingUI extends JFrame{
    //加载界面
    Image[] images = new Image[12];          //创建了图片数组
    Image image; //图片数组中当前画的图片


    public void InitUI() {
        this.setTitle("萌萌的小鸟");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);


        ScoreListener listener = new ScoreListener();
        this.addMouseListener(listener);      //给界面添加鼠标监听器

//        listener.setBirdUI(this);

        this.setVisible(true);
        //初始化图片数组
        for (int i = 0; i < 12; i++) {
            images[i] = PictureUtil.getPictureBird(i+".png").getImage();
        }


        for (int i = 0; i < 12; i++) {
            image = images[i];
            System.out.println(image);
            repaint();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        StageUI ui = new StageUI();
        ui.setLoadingUI(this);
        ui.InitUI();


    }


    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image,0,0,800,800,null);
    }



    }
