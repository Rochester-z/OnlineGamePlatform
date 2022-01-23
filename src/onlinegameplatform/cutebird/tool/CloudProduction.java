package onlinegameplatform.cutebird.tool;

import java.util.ArrayList;
import java.util.List;

public class CloudProduction extends Thread {
    //生产的线程
    //生产云朵
    List<Cloud> ListCloud = new ArrayList<>();


    public CloudProduction(List<Cloud> ListCloud){
        this.ListCloud = ListCloud;
    }


    public void run(){
        while (true) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //生产云朵
            //当按钮被按下时创建云朵对象,云朵初始位置和颜色,速度,大小随机
//            int x = (int) (Math.random() * 700);
            int x = 10;
            int y = (int) (Math.random() * 250 + 1);
//            int xspeed = (int) (Math.random() * 2 + 1);  //random数范围[0,1),
            int xspeed = 1;
            int yspeed = (int) (-(Math.random() * 10 + 1));

            //云朵大小随机
            int size = (int) (Math.random() * 60 + 60);

            Cloud cloud = new Cloud(x, y);  //此时x,y值不变
            //设置小球x轴,y轴的速度
            cloud.vx = xspeed;
            cloud.vy = yspeed;
            cloud.size = size;
            ListCloud.add(cloud);      //将云朵对象保存到数组列表中
            //将ListCloud数组列表传给监听器


        }
    }
}
