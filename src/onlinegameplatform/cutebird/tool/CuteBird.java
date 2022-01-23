package onlinegameplatform.cutebird.tool;

import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;

public class CuteBird {
        //萌萌的小鸟类
        private int x;  //小鸟子弹的位置,
        private int y;
        private int vx;   //萌萌的小鸟初始速度为0
        private int vy;
        private int size = 60;  //萌萌的小鸟的大小

        public void setvx(int vx){
            this.vx = vx;
        }

        public void setvy(int vy){
            this.vy = vy;
        }

        //小鸟子弹图片
        Image image = PictureUtil.getPictureBird("bird2.png").getImage();  //从根目录开始找

        public CuteBird(){
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

        public void drawbird(Graphics g){
//        System.out.println("画萌萌的小鸟");
            g.drawImage(image,x,y,size,size,null);
        }

        public void move(){
            x = x + vx;
            y = y + vy;
        }
    }

