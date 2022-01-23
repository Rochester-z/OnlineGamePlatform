package onlinegameplatform.gobang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btnListener implements ActionListener {
    String text;
    JFrame startjf;   //开始窗体
    JPanel jPanel;
    JButton btn1;  //传入两个按钮
    JButton btn2;
    LogGBUI ui;       //启动界面对象


    public void setloggbui(LogGBUI ui){
        this.ui = ui;
    }

    public void setJpanel(JPanel jpanel_0){
        this.jPanel = jpanel_0;
    }

    public void setstartjf(JFrame startjf){
        this.startjf = startjf;
    }

    public void setJButton(JButton btn1, JButton btn2){
        this.btn1 = btn1;
        this.btn2 = btn2;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        text = e.getActionCommand();
        if(text.equals("单人模式")){
//            startjf.setVisible(false);     //第一个开始窗体为空
//            jPanel.setVisible(false);
//            btn1.setVisible(false);
//            btn2.setVisible(false);
//            ui.showJPnel(startjf);      //启动界面对象>窗体>面板

//            jp.setVisible(false);   //传过来的第一个面板为空
//            ui.showJPnel();             //调用登录界面对象的showJpanel函数添加第二个面板

            startjf.setVisible(false);
            GobangUI ui = new GobangUI();
            ui.InitUI();

            ui.gl.setpattern("单人模式");
            //创建线程的两种方式,多线程实现倒计时
            Thread thread = new Thread(ui);  //ui实现了runable
            thread.start();

            //            ui.pattern = "单人模式";         //创建的这个对象的pattern改变了，类中pattern没改变
        }
        if(text.equals("双人模式")){
            startjf.setVisible(false);
            GobangUI ui = new GobangUI();
            ui.InitUI();
            ui.gl.setpattern("双人模式");

            //创建线程的两种方式,多线程实现倒计时
            Thread thread = new Thread(ui);  //ui实现了runable
            thread.start();

        }
        if(text.equals("返回")){
            startjf.setVisible(false);        //startjf在第二个窗体已经改变了
            LogGBUI ui = new LogGBUI();
            ui.initLogGBUI();

        }
        if(text.equals("中")){
        }


    }
}
