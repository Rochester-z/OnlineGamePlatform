package onlinegameplatform.cutebird.ui;

import onlinegameplatform.cutebird.listener.StageListener;
import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;

public class StageUI extends JFrame {
    public Image image = PictureUtil.getPictureBird("stage.png").getImage();;
    public LoadingUI ui;    //将加载页面传入选择关卡页面来实现隐藏

    //set传参数避免参数太多复杂看不清
    public void setLoadingUI(LoadingUI ui){
        this.ui = ui;
    }

    public void InitUI(){
        ui.setVisible(false);
        this.setTitle("萌萌的小鸟");
        this.setSize(800,800);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);

        this.setVisible(true);

        StageListener stagelistener = new StageListener();
        this.addMouseListener(stagelistener);      //给界面添加鼠标监听器
        stagelistener.setStageUI(this);  //将选择关卡界面传入监听器来隐藏选择关卡界面






    }



    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image,10,50,790,750,null);

    }

}
