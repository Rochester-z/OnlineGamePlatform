package onlinegameplatform.cutebird.pass;

import onlinegameplatform.cutebird.tool.BirdBullet;
import onlinegameplatform.cutebird.tool.Cloud;
import onlinegameplatform.cutebird.tool.CloudProduction;
import onlinegameplatform.cutebird.tool.CuteBird;
import onlinegameplatform.cutebird.ui.ScoreUI;
import onlinegameplatform.cutebird.ui.StageUI;
import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class FifthPassBirdPanel extends JPanel implements MouseMotionListener, MouseListener {
    JFrame jf;   //将开始界面传入面板,来操作开始界面

    StageUI stageUI;


    //背景
    Image image = PictureUtil.getPictureBird("bg.jpg").getImage();
    //发射架
    Image image1 = PictureUtil.getPictureBird("shoot.png").getImage();
    //墙体
    Image image2 = PictureUtil.getPictureBird("wall5.png").getImage();
    //小猪
    Image image3 = PictureUtil.getPictureBird("bird2.png").getImage();

    //单个小鸟
    Image image4 = PictureUtil.getPictureBird("bird3.png").getImage();

    //爱心图片
    Image image5 = PictureUtil.getPictureBird("love.png").getImage();



    List<Cloud> ListCloud = new ArrayList<Cloud>();       //创建对象数组列表用来保存云朵对象
    //绳子的长度,发射鸟的位置

    //发射台的坐标
    int launchpady = 500;
    //弹弓上两条绳子x坐标不变
    int string1x = 95;
    int string2x = 115;
    //两条绳子y坐标不变，随发射台变化而变化
    int string1y = launchpady + 30;  //发射台y坐标+30
    int string2y = launchpady + 25;  //发射台y坐标+25



    int shootx;
    int shooty;
    int beginx;  //小鸟子弹初始的坐标
    int beginy;

    boolean flag1 = false;  //是否发射小鸟
    boolean flag2 = false;  //发射的小鸟是否飞行


    //创建小鸟子弹数组
    List<BirdBullet> ListBirdBullet = new ArrayList<>();
    //创建萌萌的小鸟对象数组列表来保存萌萌的小鸟
    List<CuteBird> ListCuteBird = new ArrayList<>();


    public void BirdPanel(){

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        //当拖动鼠标时,改变绳子和小鸟的位置,并画出子弹的轨迹
        int x = e.getX();
        int y = e.getY();
        //120 480
//        95,449);
//        g2.drawLine(shootx,shooty,122,449);

        //绳子发射坐标必须在发射范围内，绳子长度为160
        //绳子发射坐标和圆心的长度必须小于半径
        if (Math.sqrt(Math.pow(x - (string1x + string2x) / 2, 2) + Math.pow(y - (string1y + string2y) / 2, 2)) < 160) {
            flag1 = true;   //绘制绳子
            flag2 = false;  //当拖动鼠标时,未释放鼠标
            shootx = x;      //如果鼠标拖动的位置在发射位置内,赋值给发射位置
            shooty = y;
        }

        //当绳子发射坐标在发射范围内，之后又拉绳子，绳子超过发射范围时，只绘制发射范围内的绳子
        if (flag1) {
            //再次判断绳子发射坐标是否在发射范围内
            if (Math.sqrt(Math.pow(x - (string1x + string2x) / 2, 2) + Math.pow(y - (string1y + string2y) / 2, 2)) > 160){

                //绳长和发射位置的比例，
                double proportion = 160 / Math.sqrt(Math.pow(x - (string1x + string2x) / 2, 2) + Math.pow(y - (string1y + string2y) / 2, 2));
                //新发射位置为圆心坐标x为+比例*x长度，y为+比例*y长度
                shootx = string1x + (int)(proportion * (x - string1x));
                shooty =string1y + (int) (proportion * (y - string2y));
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }







    //重写paint方法,在里面画图
    public void paint(Graphics g){
        super.paint(g);
        //绘制背景图片
        g.drawImage(image, 0, 0, 800, 800, null);


        //画云朵
        for (int i = 0; i < ListCloud.size(); i++) {   //每刷新一次画n个云朵,判断此时云朵位置是否会碰撞
            //取出所有云朵对象,取出坐标判断是否相等,相等改变速度
            ListCloud.get(i);
            Cloud cloud = ListCloud.get(i);    //创建对象在循环里,对象创建了n次,用对象引用赋值本质还是一个
            cloud.move();
            if (cloud.x > 750) {
                ListCloud.remove(cloud);
            }
            //改变了创建的当前云朵对象的x,y,画出云朵
            cloud.darwcloud(g);
        }
        //绘制墙体
        g.drawImage(image2,350, 450, 400,350, null);




        //绘制小鸟发射台
        g.drawImage(image1, 0, launchpady, 150, 120, null);

        //判断是否发射
        if(flag1){
//            System.out.println("shootx的值"+shootx+"shooty的值"+shooty);

            //画粗线,弹弓上的绳子
            Graphics2D g2 = (Graphics2D)g;  //g是Graphics对象
            g2.setStroke(new BasicStroke(8));
            g2.drawLine(shootx,shooty,string1x,string1y);
            g2.drawLine(shootx,shooty,string2x,string2y);
//            g.drawImage(image1, 0, 420, 150, 120, null);

            //绘制绳子上的小鸟
            if(flag2 != true) {   //当鼠标未释放时可以画绳子上的小鸟子弹,当鼠标释放时//消去初始的小鸟,画飞行的小鸟子弹
                g.drawImage(image4, shootx - 25, shooty - 50, 70, 70, null);
            }
        }




        //绘制小鸟子弹
        //每隔10ms移动一次小鸟子弹数组中的子弹,重绘一次
        if(flag2) {            //当释放鼠标时,每隔10ms,小鸟子弹移动一次位置,并画出来
            for (int i = 0; i < ListBirdBullet.size(); i++) {
                BirdBullet bullet = ListBirdBullet.get(i);
                bullet.drawbullet(g); //绘制小鸟,绘制一次,改变小鸟的位置,再次绘制
                bullet.move();
                //绘制碰撞效果,捕捉此时小鸟子弹的坐标,如果和某只萌萌的小鸟坐标碰撞,则消除改只萌萌的小鸟，画出爱心
                for (int j = 0; j < ListCuteBird.size(); j++) {
                    CuteBird cuteBird = ListCuteBird.get(j);
                    if (iscollision(bullet, cuteBird)) {
                        int x = cuteBird.getx();
                        int y = cuteBird.gety();
                        g.drawImage(image5, x, y, 70, 70, null);
                        ListCuteBird.remove(j);
                    }
                }

            }
        }

        //绘制萌萌的小鸟
        for(int i = 0; i < ListCuteBird.size(); i++){
            CuteBird cuteBird = ListCuteBird.get(i);
            cuteBird.move();
            cuteBird.drawbird(g);
        }


        //当所有的萌萌的小鸟和愤怒的小鸟都碰撞后判断游戏是否结束了
            if(ListCuteBird.size() == 0) {
                ScoreUI ui = new ScoreUI();
                ui.setBirdUI(jf);
                ui.stageUI = stageUI;
                ui.setstage(6);
                ui.InitUI();
            }





    }



    //游戏开始函数
    public void begin() throws InterruptedException {

        //当启动界面开始游戏时生产云朵
        CloudProduction Cloudproduction = new CloudProduction(ListCloud);
        Cloudproduction.start();

        //当弹弓释放时创建一个小鸟子弹

        CuteBird cuteBird1 = new CuteBird();
        cuteBird1.setx(370);
        cuteBird1.sety(400);
        ListCuteBird.add(cuteBird1);
        CuteBird cuteBird2 = new CuteBird();
        cuteBird2.setx(510);
        cuteBird2.sety(495);
        ListCuteBird.add(cuteBird2);
        CuteBird cuteBird3 = new CuteBird();
        cuteBird3.setx(640);
        cuteBird3.sety(590);
        ListCuteBird.add(cuteBird3);








        while (true) {  //死循环,一直执行,全局变量改变可以收到
            Thread.sleep(10);

            //在paint函数中移动子弹
            //每隔10ms移动一次小鸟子弹,重绘一次
//            if(flag2) {            //当释放鼠标时,每隔10ms,小鸟子弹移动一次位置,并画出来
//                bullet.move();
//            }


            repaint();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("点击的x坐标"+x+"点击的y坐标"+y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //当鼠标释放时,发射小球
        int x = e.getX();
        int y = e.getY();
        if(flag1) {      //当先在发射范围内拖动鼠标时有绳子时才能释放鼠标发射小鸟
            flag2 = true;   //如果鼠标释放的位置在发射位置内,发射的小鸟开始飞行
            //绘制小鸟子弹,当鼠标拖动结束时,全局变量shootx,shooty已经改变,鼠标释放时接受到了改变的shootx,shooty
            beginx = shootx - 25;  //小鸟子弹初始的坐标
            beginy = shooty - 50;
            BirdBullet bullet = new BirdBullet();
            bullet.setx(beginx);  //设置小鸟子弹的初始坐标
            bullet.sety(beginy);
            ListBirdBullet.add(bullet);
            //根据小鸟子弹的初始坐标设置小鸟子弹的速度大小方向
            System.out.println("beginx" + beginx);
            System.out.println("beginY" + beginy);


            //弹弓自然，速度设为连续，用函数设置速度了;
            if (beginx < string1x) {
                bullet.setvx((string1x - beginx) * 1 / 4);
            } else if (beginx > string1x) {
                bullet.setvx((string1x - beginx) * 1 / 4);
            }


            if (beginy < string1y) {
                bullet.setvy((string1y - beginy) * 1 / 3);
            } else if (beginy > string1y) {
                bullet.setvy((string1y - beginy) * 1 / 3);
            }


            //为了能画出小鸟运动为曲线的效果,vx可以不变,初始vy最大,慢慢变小,变为负数
//            bullet.setvx(15);
//            bullet.setvy(-20);
//        }

            flag1 = false;      //当释放鼠标时，绳子弹回消失
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //判断愤怒的小鸟和所有萌萌的小鸟是否碰撞的函数
    public boolean iscollision(BirdBullet birdBullet, CuteBird cuteBird) {
            //如果两只小鸟之间距离小于它们之间半径和,则消除该只萌萌的小鸟，画爱心图片
            if (Math.sqrt(Math.pow(birdBullet.getx() - cuteBird.getx(), 2) + Math.pow(birdBullet.gety() - cuteBird.gety(), 2)) < 30) {
                return true;
            }
            return false;
        }

}
