package onlinegameplatform.gobang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;


/**棋盘操作下棋监听器（实现了鼠标按下下棋  鼠标拖动光标）
 * 属性：1.ChessX ChessY 当前的棋子坐标  2.g 绘制棋子组件
 *
 * 方法：setGraphic 向本类中传入画笔对象
 * 重写的方法 MouseListener, MouseMotionListener
 */

public class GobangListener implements MouseListener, MouseMotionListener, GoBangConfig, ActionListener  {
    int ChessX;
    int ChessY;
    Graphics g;   //定义画笔参数，可用
    GobangUI gobangjf;       //GobangUI继承了JFRAME,需要调用本类中gobangui方法,需要定义gobangui
    String text;  //按钮名称
    int[][] chessrecord = new int[ROW+1][COLUMN+1];    //定义棋盘记录数组记录棋子的位置，行+1个棋子
    int chesscolor;  //棋子颜色
    Chess[] chesssaving = new Chess[(ROW+1)*(COLUMN+1)];      //棋子保存数组保存棋子，用于悔棋功能
    int index = -1; //棋子当前下标， -1表示当前无棋子
    int chessstorage[][] = new int[ROW+1][COLUMN+1];      //棋盘存储数组，用于存档读档功能
    Chess[] chesssave = new Chess[(ROW+1)*(COLUMN+1)];      //棋子保存数组二号，用于存档读档功能

    String pattern;         //下棋模式

    boolean nextstep;   //是否下了一步棋

    static HashMap<String, Integer> hash = new HashMap<>();    //创建hashmap，记录连子情况和得分




    public int[][] getchessrecord(){
        return chessrecord;            //将棋盘记录返回到监听器对象
    }



    public void setgobangjf(GobangUI gobangjf){
        this.gobangjf = gobangjf;
    }


    public void setGraphic(Graphics g){
        this.g = g;
    }


    public void setpattern(String pattern){             //设置下棋模式
        this.pattern = pattern;

    }





    @Override
    public void mouseClicked(MouseEvent e) {

    }
    boolean flag = true;
    int countblack = 0;
    int countwhite = 0;
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(x<X||x>X+COLUMN*SIZE||y<Y||y>Y+ROW*SIZE){   //限制下棋范围
            return;
        }
        ChessX = x;
        ChessY = y;
        ChessX = (ChessX-X+SIZE/2)/SIZE;         //找出该坐标位于第几格，为X轴坐标
        ChessY = (ChessY-Y+SIZE/2)/SIZE;

        if(chessrecord[ChessX][ChessY] != 0)   //当前棋盘位置有棋子，无法下棋
            return;


        //判断为双人模式
        if(pattern.equals("双人模式")) {
            nextstep = true;  //下了一步棋,从30s开始计数
            gobangjf.setNextstep(nextstep); //将下棋状态传入下棋界面的run函数

//            //创建线程的两种方式,多线程实现倒计时
//            Thread thread = new Thread(gobangjf);  //gobangjf实现了runable
//            thread.start();

//        e.getClickCount();    获取鼠标点击次数
            if (flag == true) {            //设置boolean变量改变状态
                g.setColor(Color.BLACK);
                flag = false;
                countblack++;
                g.fillOval(ChessX * SIZE - SIZE / 2 + X, ChessY * SIZE - SIZE / 2 + Y, SIZE, SIZE);  //还原坐标
                chesscolor = 1;
                chessrecord[ChessX][ChessY] = chesscolor;   //棋盘棋子（X,Y）坐标缩小为格数

                //创建棋子对象，棋子对象坐标，个数，颜色，保存下来
                index++;           //-1++=0; 此时下标0中存棋子
                Chess chess = new Chess(index, chesscolor, ChessX, ChessY);
//            System.out.println("ChesX"+x1+"ChessY"+y1+"index"+index);
                chesssaving[index] = chess;  //将棋子对象存储到棋子保存数组中，index++

//            gobangjf.repaint();

                //判断输赢
                if (IsWin.IsWin(chessrecord, ChessX, ChessY))
                    JOptionPane.showMessageDialog(null, "执黑棋者获得胜利");

            } else {
                g.setColor(Color.white);
                flag = true;
                countwhite++;
                g.fillOval(ChessX * SIZE - SIZE / 2 + X, ChessY * SIZE - SIZE / 2 + Y, SIZE, SIZE);  //还原坐标
                chesscolor = 2;
                chessrecord[ChessX][ChessY] = chesscolor;         //X轴坐标为棋盘列数，Y轴坐标为棋盘行数

//            gobangjf.repaint();

                //创建棋子对象，棋子对象坐标，个数，颜色，保存下来
                index++;
                Chess chess = new Chess(index, chesscolor, ChessX, ChessY);
                chesssaving[index] = chess;

                //判断输赢
                if (IsWin.IsWin(chessrecord, ChessX, ChessY))
                    JOptionPane.showMessageDialog(null, "执白棋者获得胜利");

            }
        }

        if(pattern.equals("单人模式")) {

            //黑棋先手
            //判断为人机对战
            g.setColor(Color.black);             //白棋先下，一次下两颗
            countblack++;
            g.fillOval(ChessX * SIZE - SIZE / 2 + X, ChessY * SIZE - SIZE / 2 + Y, SIZE, SIZE);  //还原坐标
            chesscolor = 1;
            chessrecord[ChessX][ChessY] = chesscolor;   //棋盘棋子（X,Y）坐标缩小为格数

            //创建棋子对象，棋子对象坐标，个数，颜色，保存下来
            index++;           //-1++=0; 此时下标0中存棋子
            Chess chess1 = new Chess(index, chesscolor, ChessX, ChessY);
//            System.out.println("ChesX"+x1+"ChessY"+y1+"index"+index);
            chesssaving[index] = chess1;  //将棋子对象存储到棋子保存数组中，index++

//            gobangjf.repaint();

            //判断输赢
            if (IsWin.IsWin(chessrecord, ChessX, ChessY))
                JOptionPane.showMessageDialog(null, "执黑棋者获得胜利");


            nextstep = true;  //下了一步棋,从30s开始计数
            gobangjf.setNextstep(nextstep); //将下棋状态传入下棋界面的run函数
//            gobangjf.nextstep = nextstep;    //将监听器中的nextstep传入到run函数

//            //多线程倒计时
//            Thread thread = new Thread(gobangjf);
//            thread.start();


//            //多线程计时功能
//            //创建线程对象
//            ThreadTime thread = new ThreadTime();
//            //启动线程:每个线程对象只能启动一次
//            thread.start();


//            //代码延时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            g.setColor(Color.white);
            countwhite++;
            //遍历权重数组下棋
            int[][] chessweight = HashMapChess.intelligence(chessrecord);

            int maxweight = Integer.MIN_VALUE;
            int maxi = Integer.MIN_VALUE;
            int maxj = Integer.MIN_VALUE;
            for (int i = 0; i < ROW + 1; i++) {
                for (int j = 0; j < COLUMN + 1; j++) {
                    if (chessweight[i][j] > maxweight && chessrecord[i][j]==0) {   //此时该位置棋子为空
                        maxweight = chessweight[i][j];
                        maxi = i;                 //找到棋盘权值数组中最大权值的坐标
                        maxj = j;
                    }
                }
            }
            g.fillOval(maxi * SIZE - SIZE / 2 + X, maxj * SIZE - SIZE / 2 + Y, SIZE, SIZE);  //还原坐标
            chesscolor = 2;
            chessrecord[maxi][maxj] = chesscolor;         //X轴坐标为棋盘列数，Y轴坐标为棋盘行数


            nextstep = true;  //下了一步棋,从30s开始计数
            gobangjf.setNextstep(nextstep); //将下棋状态传入下棋界面的run函数



//            for(int i=0; i<chessrecord.length; i++){
//                for(int j=0; j<chessrecord[i].length; j++){
//                    System.out.print(chessrecord[i][j]+" ");
//                }
//                System.out.println();
//            }
//
//
//            for(int i=0; i<chessweight.length; i++){
//                for(int j=0; j<chessweight[i].length; j++){
//                    System.out.print(chessweight[i][j]+" ");
//                }
//
//            }



//            gobangjf.repaint();

            //创建棋子对象，棋子对象坐标，个数，颜色，保存下来
            index++;
            Chess chess2 = new Chess(index, chesscolor, maxi, maxj);
            chesssaving[index] = chess2;

            //判断输赢
            if (IsWin.IsWin(chessrecord, maxi, maxj))
                JOptionPane.showMessageDialog(null, "执白棋者获得胜利");
        }





//        Font font = new Font("黑体");          也可以设置颜色
//        Color color = new Color(255, 255, 255,255);   设置方框透明度
        JFrame JF =(JFrame) e.getSource();
        Color color = JF.getBackground();
        g.setColor(color);
        g.fillRect(750,50,80,50);
        g.setColor(Color.BLACK);
        g.drawString("黑棋："+countblack, 770, 60);
        g.drawString("白棋："+countwhite, 770, 80);







    }



    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text = e.getActionCommand();

        if(text.equals("悔棋")) {            //悔棋按钮必须传入窗体监听器
            //分两种单机模式和双人模式
            //chesssaving下标首先为0
            if(pattern.equals("双人模式")){
                if(index<0){           //下标小于0，返回
                    return;
                }
                //每次悔一步
                Chess curchess = chesssaving[index];  //取出最后一颗棋子对象，下标为index
                int curChessX = curchess.ChessX;
                int curChessY = curchess.ChessY;
                chessrecord[curChessX][curChessY] = 0;    //在棋盘记录数组中重绘棋子，当前位置棋子为空
//                chesssaving[index] =null;   //删除棋盘保存数组悔棋对象，  不可删除，否则，读取棋盘时无法恢复
                index--;   //新数组棋子个数减1
                gobangjf.repaint();
        }
        else {
                if (index < 1) {           //下标小于0，返回
                    return;
                }
                //每次悔两步
                Chess curchess1 = chesssaving[index];  //取出最后一颗棋子对象，下标为index
                Chess curchess2 = chesssaving[index - 1];  //取出最后一颗棋子对象，下标为index

                int curChessX1 = curchess1.ChessX;
                int curChessY1 = curchess1.ChessY;
                chessrecord[curChessX1][curChessY1] = 0;    //在棋盘记录数组中重绘棋子，当前位置棋子为空
//                chesssaving[index] =null;   //删除棋盘保存数组悔棋对象，  不可删除，否则，读取棋盘时无法恢复
                index--;   //新数组棋子个数减1

                int curChessX2 = curchess2.ChessX;
                int curChessY2 = curchess2.ChessY;
                chessrecord[curChessX2][curChessY2] = 0;    //在棋盘记录数组中重绘棋子，当前位置棋子为空
//                chesssaving[index] =null;   //删除棋盘保存数组悔棋对象，  不可删除，否则，读取棋盘时无法恢复
                index--;   //新数组棋子个数再1

                gobangjf.repaint();
            }
        }
        if(text.equals("认输")){
            JOptionPane.showMessageDialog(null, "游戏已结束");
        }
        if(text.equals("存档")) {  //将当前所有棋子保存下来，已经有两个数组，一个保存坐标数组，绘制棋子，一个保存棋子对象，有坐标
            int count = 0;   //记录当前棋谱的棋子个数
            for (int i = 0; i < chessrecord.length; i++) {   //数组不能直接复制，不然传地址
                for (int j = 0; j < chessrecord[i].length; j++) {
                    chessstorage[i][j] = chessrecord[i][j];
                    if(chessrecord[i][j] != 0){
                        count++;        //所有棋子的个数
                    }
                }
            }
            //存档不需要改变index,此时index = count-1
            for(int k=0; k<=count-1; k++){
                chesssave[k] = chesssaving[k];       //不可 chesssave指向chesssaving地址
            }
        }
        if(text.equals("读档")){
            int count = 0;
            for (int i = 0; i < chessstorage.length; i++) {   //数组不能直接复制，不然传地址
                for (int j = 0; j < chessstorage[i].length; j++) {
                    chessrecord[i][j] = chessstorage[i][j];
                    if(chessrecord[i][j] != 0){
                        count++;          //棋子保存数组中棋子的个数，此时要改变棋子保存数组的索引
                    }
                }
                for(int k=0; k<chesssaving.length; k++){
                    chesssaving[k] = chesssave[k];       //不可 chesssave指向chesssaving地址
                }
                //读档后要改变

            }
            index = count-1;  //当前棋子个数下标为棋子个数减一
            gobangjf.repaint();

        }

        if(text.equals("回放")){
            //在图片上重新画棋盘，不需要初始化数组

            //repaint函数在线程最后调用
            paint();
    }





        if(text.equals("重新开始")){
            for(int i=0; i<chessrecord.length; i++){
                for(int j=0; j<chessrecord[0].length; j++)
                    chessrecord[i][j] = 0;
            }
            //重新开始，棋子存储数组清空
            for(int i=0; i<=index; i++) {
                chesssaving[i] = null;
            }
            index = -1;
            flag = true;  //白棋先下
            //重新开始，


            gobangjf.repaint();
        }

        if(text.equals("返回主页面")){
            gobangjf.setVisible(false);
            LogGBUI ui = new LogGBUI();
            ui.initLogGBUI();

        }


    }



    private static final Image image1 = new ImageIcon("D:\\IDEA 2019\\test\\Image\\chessboard.jpg").getImage();  //Iamge接口
    private static final Image image2 = new ImageIcon("D:\\IDEA 2019\\test\\Image\\bg.jpeg").getImage();

    public void paint() {   //重绘传递画笔参数，可用
        //绘制图片
        g.drawImage(image2, 0, 0, 1000,1000,null);
        g.drawImage(image1, X, Y,COLUMN*SIZE, ROW*SIZE, null);
        g.setColor(Color.BLACK);
        for (int i = 0; i <= ROW; i++) {
            g.drawLine(X + SIZE * i, Y, X + SIZE * i, Y + ROW * SIZE);
        }

        //重绘按钮
        for (int i = 0; i <= COLUMN; i++) {     //重回功能里面写的函数，拖动窗体不会消失
            g.drawLine(X, Y + SIZE * i, X + COLUMN * SIZE, Y + SIZE * i);
        }
        for (int k = 0; k <= index; k++){
            int i = chesssaving[k].ChessX;
            int j = chesssaving[k].ChessY;
            if(chesssaving[k].chesscolor == 1) {
                g.setColor(Color.BLACK);
                g.fillOval(i * SIZE - SIZE / 2 + X, j * SIZE - SIZE / 2 + Y, SIZE, SIZE);
            } else if (chesssaving[k].chesscolor == 2) {
                g.setColor(Color.WHITE);
                g.fillOval(i * SIZE - SIZE / 2 + X, j * SIZE - SIZE / 2 + Y, SIZE, SIZE);
            }
            //代码延时
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            //录制回放结束后，刷新窗体，绘制的图片消失
        }

    }
}
