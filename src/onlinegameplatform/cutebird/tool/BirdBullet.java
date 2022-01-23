package onlinegameplatform.cutebird.tool;

import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;

public class BirdBullet {
    //只需要创建一个小鸟子弹对象,但是每隔10秒画一次,改变vx,vy
    //小鸟子弹类
    //私有属性只有本类对象能调用
    private int x;  //小鸟子弹的位置,
    private int y;
    private int vx=5;  //要实现小鸟子弹曲线,vx,vy必须变化
    private int vy=-10;
    private int size = 70;  //小鸟子弹的大小

    public void setvx(int vx){
        this.vx = vx;
    }

    public void setvy(int vy){
        this.vy = vy;
    }

    //小鸟子弹图片
    Image image = PictureUtil.getPictureBird("bird3.png").getImage(); //从根目录开始找

    public BirdBullet(){
    }
    public void setx(int x){
        this.x = x;
    }
    public void sety(int y){
        this.y = y;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }

    public void drawbullet(Graphics g){
//        System.out.println("画小鸟");
        g.drawImage(image,x,y,size,size,null);
    }

    public void move(){
        x = x + vx;
        y = y + vy;

        vy = vy + 1;
    }
}
