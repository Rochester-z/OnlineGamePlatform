package onlinegameplatform.aircraftwar;

import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
 * 敌人对象
 *
 * */
public class Enemy {

    private int width;//敌人图片的宽度
    private int height;//敌人图片的高度

    //敌人的坐标
    private int x;
    private int y;


    private ImageIcon enemyImageIcon =  PictureUtil.getPictureAirwar("icon.png");

    public Enemy() {
        this.width = enemyImageIcon.getIconWidth();
        this.height = enemyImageIcon.getIconHeight();

        //设置敌机的位置
        Random random = new Random();
        random.nextInt(10);

        this.x = random.nextInt(GameMain.width - (width/2));
        this.y = -random.nextInt(GameMain.height - (height/2));

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move() {
        this.y += 1; //速度

    }

    public void drawImage(Graphics g){
        g.drawImage(enemyImageIcon.getImage(), x, y, null);
    }
}
