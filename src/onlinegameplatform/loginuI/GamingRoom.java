package onlinegameplatform.loginuI;

import javax.swing.*;
import java.awt.*;

public class GamingRoom extends JFrame {
    Image image = new ImageIcon("onlinegameplatform/resource/image/roombg.PNG").getImage();


    public void InitUI(){
        this.setTitle("游戏大厅");
        this.setSize(1800,1400);
        this.setDefaultCloseOperation(3);

        this.setVisible(true);

        BtnListener listener = new BtnListener();
        this.addMouseListener(listener);      //给界面添加鼠标监听器


    }



    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image,0,40,1800,1400,null);



    }


}
