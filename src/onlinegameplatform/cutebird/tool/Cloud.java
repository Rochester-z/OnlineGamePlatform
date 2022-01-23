package onlinegameplatform.cutebird.tool;

import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;

//小球类
public class Cloud {
    //云朵图片
    Image image = PictureUtil.getPictureBird("cloud.png").getImage();
    //云朵类中云朵的属性
    public int x, y;      //初始云朵位置           //JAVA src包下的对类进行分类，UI包，Listener包，工具包，关卡包
    int vx = 2, vy = 6;   //初始云朵x,y方向速度
    int size = 100;  //云朵图片大小


    public Cloud(int x, int y){
        this.x = x;
        this.y = y;
    }

   //云朵类中云朵的方法,动作
    //画小球
    public void darwcloud(Graphics g){
        g.drawImage(image,x,y,size,size,null);
//            g.fillOval(x,y,size,size);
//            move();   //改变创建的当前小球对象的全局的坐标
    }

    //云朵移动
    public void move(){
//        if(x > 800 - 1.1*size || x <=0){   //先判断坐标符不符合要求再移动
//            vx = -vx;
//            System.out.println("vx的值"+vx);
//        }
//        if(y > 650 - 1.1*size || y < 150){
//            vy = -vy;
//        }
        x = x + vx;  //移动后的创建的当前小球的全局坐标即为下次画小球的坐标
//        y = y +vy;


    }



}
