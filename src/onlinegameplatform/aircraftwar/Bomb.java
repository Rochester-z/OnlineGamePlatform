package onlinegameplatform.aircraftwar;

import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;

public class Bomb {

    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon bombimg =  PictureUtil.getPictureAirwar("bomb.png");
    private int count;//删除的次数

    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = bombimg.getIconWidth();
        this.height = bombimg.getIconHeight();
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


    public ImageIcon getBombimg() {
        return bombimg;
    }


    public void setBombimg(ImageIcon bombimg) {
        this.bombimg = bombimg;
    }


    public void drawImage(Graphics g) {
        g.drawImage(bombimg.getImage(), x, y, null);
    }


    public void move() {
        count++;
    }
}
