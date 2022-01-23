package onlinegameplatform.gobang;


import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;

public class LogGBUI {
//    private ImageIcon image =  PictureUtil.getPictureGobang("chess1.jpg"); //给窗体加图标
    //非Image类，不加.getimage函数

    public static void main(String[] args){      //快捷键psvm   遇左括号Tab
        LogGBUI ui = new LogGBUI();
        ui.initLogGBUI();

    }

    public void initLogGBUI() {
        JFrame startjf = new JFrame();       //调用方法不能在类中直接写,不加title "趣味五子棋"
        //给窗体添加图片面板
        BjPanel pl = new BjPanel();          //创建图片面板对象
        Container container = startjf.getContentPane(); //获取窗体第三层容器
        container.add(pl);  //窗体第三层容器添加面板对象；
//        JPanel jp = (JPanel)startjf.getContentPane();
//        startjf.add(jp);
          pl.setOpaque(true);





        startjf.setSize(300, 650);
        startjf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    //关闭选项

//        JLabel label = new JLabel(onlinegameplatform.onlinegameplatform.resource.image);
//        startjf.add(label);
        startjf.setLocationRelativeTo(null);  //null为中心位置
//        startjf.setLocation(480,50);            //设置窗体的位置
       startjf.setIconImage(PictureUtil.getPictureGobang("login.png").getImage());


        //第一个界面中的面板
//        JPanel jp_1 = new JPanel();  //设置面板布局，尺寸，背景色
//        Dimension dim1 = new Dimension(250, 120);
//        jp_1.setPreferredSize(dim1);
//        jp_1.setBackground(Color.cyan);  //天蓝
//        startjf.add(jp_1, BorderLayout.SOUTH);
        JButton btn1 = new JButton();
        JButton btn2 = new JButton();
        JPanel jp_0 = new JPanel();
        JLabel label = new JLabel();        //空标签
        Dimension dimjp_0 = new Dimension(300, 410);
        label.setPreferredSize(dimjp_0);
        pl.add(label);
//        btn1.setBounds(100,100,225,500);
//        btn1.setBounds(500,800,115,500);
        btn1.setText("单人模式");
        btn2.setText("双人模式");
        Dimension dimbtn1 = new Dimension(150, 40);
        btn1.setPreferredSize(dimbtn1);
        btn2.setPreferredSize(dimbtn1);
        pl.add(btn1);  //面板默认流式布局
        pl.add(btn2);
        //给按钮添加监听器
        btnListener btnListener = new btnListener();  //给按钮添加监听器
        btnListener.setstartjf(startjf);  //给btn1按钮的监听器添加窗体和面板对象; 注意
        btnListener.setJButton(btn1, btn2);
        btnListener.setJpanel(jp_0);
        btnListener.setloggbui(this);      //传这个类创建的对象，界面对象

        btn1.addActionListener(btnListener);
        btn2.addActionListener(btnListener);    //位置相同的面板，显示第二个面板
        startjf.remove(btn1);
        startjf.repaint();
        startjf.setVisible(true);

//        btnlistener.setGobangUI();


        }
    //第二个界面中的面板
    public void showJPnel(JFrame startjf) {

//        startjf.remove(btn1);
        BjPanel pl = new BjPanel();          //创建图片面板对象
        Container container = startjf.getContentPane(); //获取窗体第三层容器
        container.add(pl);  //窗体第三层容器添加面板对象；
        pl.setOpaque(true);

        JButton btn3 = new JButton();
        JButton btn4 = new JButton();
        JButton btn5 = new JButton();
        JButton btn6 = new JButton();
        btn3.setText("低");
        btn4.setText("中");
        btn5.setText("难");
        btn6.setText("返回");
        Dimension dimbtn2 = new Dimension(115, 20);
        btn3.setPreferredSize(dimbtn2);
        btn4.setPreferredSize(dimbtn2);
        btn5.setPreferredSize(dimbtn2);
        btn6.setPreferredSize(dimbtn2);
        JPanel jp_0 = new JPanel();
        JLabel label = new JLabel();        //空标签
        Dimension dimjp_0 = new Dimension(250, 500);
        label.setPreferredSize(dimjp_0);
        pl.add(label);
        pl.add(btn3);  //窗体，面板默认流式布局
        pl.add(btn4);
        pl.add(btn5);
        pl.add(btn6);
        //给按钮添加监听器

        btnListener btnListener3 = new btnListener();  //给按钮添加监听器，同一界面添加同一监听器，公用属性，可写多个监听器，但监听器对象尽可能少
        btn3.addActionListener(btnListener3);
        btnListener btnListener4 = new btnListener();
        btnListener4.setstartjf(startjf);  //btn3的监听器也要传窗体对象
        btn4.addActionListener(btnListener4);
        btnListener btnListener5 = new btnListener();
        btn5.addActionListener(btnListener5);
        btnListener btnListener6 = new btnListener();
        btnListener6.setstartjf(startjf);
        btn6.addActionListener(btnListener6);

    }

    }


