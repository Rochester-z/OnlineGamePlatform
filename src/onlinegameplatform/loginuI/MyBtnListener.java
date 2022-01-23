package onlinegameplatform.loginuI;


import onlinegameplatform.dao.dao.UserDao;
import onlinegameplatform.dao.impl.daoimp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyBtnListener implements ActionListener {
    JTextField nameInput1 ;
    JTextField nameInput2 ;

    LoginUi ui;  //将登录及界面传入监听器来隐藏登录界面
    public void setLoginui(LoginUi ui){
        this.ui = ui;
    }


    //jdk1.8包在rt压缩包里
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String btnstring = actionEvent.getActionCommand();
        String name = nameInput1.getText();
        String password = nameInput2.getText();
        UserDao dao = new daoimp();      //创建JDBC对象连接数据库
        if (btnstring.equals("登录")) {
            //单个进程死循环了
            //当账号正确,且密码正确时,进行下一步,打开对话框
            boolean flag = dao.login(name,password);  //记录下是否账号密码正确
            if(flag) {
                System.out.println("登录成功了");
                GamingRoom gamingRoom = new GamingRoom();  //当登录成功时,创建游戏大厅界面
                gamingRoom.InitUI();
                ui.setVisible(false);
            }
            else{
                System.out.println("密码错误");
            }



        }
        else if (btnstring.equals("退出")) {
            System.out.println("用户点击了" + btnstring);

        }
        else if(btnstring.equals("注册账号")){
//            Scanner in = new Scanner(System.in);  //获取,输入的内容
//            String username = in.nextLine();
//            System.out.println("username" + username);
//            String word = in.nextLine();




            dao.insert(name,password);

        }


    }
}
