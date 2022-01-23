package onlinegameplatform.loginuI;
/**- 创建一个自己的类
        - 定义这个具备的属性（尺寸 标题...）和方法(组成窗体结构  初始化窗体的方法 )
        - 初始化方法
        - 1、创建一个窗体对象
        - 2、设置这个窗体对象的属性值 
        - 3、设置窗体对象的相关功能 （关闭选项，可视化 布局规则）
        - 4、创建小组件对象 （按钮 输入框 ...）
        - 5、设置小组件对象的属性和功能
        - 6、将小组件对象加载到窗体对象上
        - 创建主函数 实力化这个类的对象 调用初始化界面的*/

import javax.swing.*;
import java.awt.*;

public class LoginUi extends JFrame{
    public static void main(String[] args){
        //  - 创建主函数 实力化这个类的对象 调用初始化界面的方法*/
        LoginUi loginui = new LoginUi();
        loginui.initUI();
    }

    //初始化窗体的方法
    public void initUI(){
        //qq整合美颜相机
        //1.调用javax.swing界面开发工具包中的JFrame窗体类创建一个Jf窗体对象
        //2.设置窗体的标题，尺寸大小
        this.setTitle("8566 Online Game");
        this.setSize(700,500);
        this.setLocationRelativeTo(null);  //null设置为中心位置
        //3.设置窗体的功能，如关闭，可视化，布局
        //关闭选项
        //EXIT_ON_CLOSE为JFrame类的属性值
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//EXIT_ON_CLOSE为JFrame类的属性值

        Bjpanel bj = new Bjpanel();
        Container container = this.getContentPane();   //获取窗体第三层容器
        container.add(bj);    //给窗体第三层容器添加重写的面板对象
        bj.setOpaque(true);

        
        
        //给窗体添加了重写的面板后窗体不可设置为流式布局,面板可以设置,面板上不可以再添加面板了
        //流式布局管理器对象，用Flowlayout流式布局管理器类创建对象，jf.setlayout函数参数为对象；面板默认流式，非窗体

        bj.setLayout(null);

        //4.创建小组件对象，为什么不需要调用包路径
        JButton btn1 = new JButton();//按钮类创建按钮对象
        JButton btn2 = new JButton();
        JButton btn3 = new JButton();
        JButton btn4 = new JButton();
        JTextField nameInput1 = new JTextField();//文字类创建输入框对象
        JPasswordField nameInput2 = new JPasswordField();  //密码输入框
        // 复选框
        JCheckBox nameInput3 = new JCheckBox();
        JCheckBox nameInput4 = new JCheckBox();
        JLabel namejla1 = new JLabel();//标签类创建名字+对象，添加文字
        namejla1.setText("账号：");
        JLabel namejla2 = new JLabel();
        namejla2.setText("密码：");






        //设置小组件的属性和功能
        btn1.setText("自动登录");
        btn2.setText("登录");
        btn3.setText("记住密码");
        btn4.setText("注册账号");


        //namejla.setSize()代码不适用于小组件对象


        //给按钮设置背景颜色
        btn1.setBackground(Color.cyan);
        btn2.setBackground(Color.cyan);
        btn3.setBackground(Color.cyan);
        btn4.setBackground(Color.cyan);




        // 6、将小组件对象加载到窗体对象上
        bj.add(namejla1);
        bj.add(namejla2);
        bj.add(nameInput1);
        bj.add(nameInput2);
        bj.add(nameInput3);
        bj.add(nameInput4);
        bj.add(btn1);
        bj.add(btn2);
        bj.add(btn3);
        bj.add(btn4);


        //空布局自定义组件的位置
        //账号
        namejla1.setBounds(200,230,50,35);
        //账号框
        nameInput1.setBounds(250,230,240,35);
        //密码
        namejla2.setBounds(200,280,50,35);
        //密码框
        nameInput2.setBounds(250,280,240,35);
        //复选框
        nameInput3.setBounds(228,340,18,15);
        //自动登录
        btn1.setBounds(250,330,100,35);
        //复选框
        nameInput4.setBounds(379,340,18,15);
        //记住密码
        btn3.setBounds(400,330,100,35);
        //注册账号
        btn4.setBounds(510,330,100,35);
        //登录
        btn2.setBounds(250,380,180,40);






        this.setVisible(true);

        MyBtnListener my = new MyBtnListener();
        btn2.addActionListener(my);
        btn4.addActionListener(my);
        nameInput1.addActionListener(my);
        nameInput2.addActionListener(my);
        my.nameInput1 = nameInput1;
        my.nameInput2 = nameInput2;

        my.setLoginui(this);   //将登录游戏界面传入监听器来隐藏登录界面



    }

    public void paint(Graphics g){
        super.paint(g);

    }

}
