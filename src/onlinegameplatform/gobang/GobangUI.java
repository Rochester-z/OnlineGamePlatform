package onlinegameplatform.gobang;

import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.awt.*;


/**五子棋的界面 继承了JFrame 重写了paint        先写中文梳理框架
 *
 *属性 1.bgimg 2.gl 棋盘监听器
 *
 *方法 重写的paint方法 绘制棋盘，绘制背景图
 */



public class GobangUI extends JFrame implements GoBangConfig,Runnable {
    private static final Image image1 =  PictureUtil.getPictureGobang("chessboard.jpg").getImage();   //Iamge接口
    private static final Image image2 =  PictureUtil.getPictureGobang("bg.jpeg").getImage();

    GobangListener gl = new GobangListener();   //定义为全局变量，在本类中都可以调用


//    public static void main(String[] args){  //在别的类调用
////      new GobangUI().InitUI();     创建一个对象只调用一个函数
//
//
//    }



    public GobangUI(){

    }



    public void InitUI() {
//        BjPanel pl = new BjPanel();          //创建图片面板对象
//        Container containerPane = this.getContentPane();  //获取窗体第三层容器
//        containerPane.add(pl);  //窗体第三层容器添加面板对象；
//        pl.setOpaque(true);     //面板设置为透明


        this.setTitle("zq五子棋");          //继承父类方法，皆用this调用函数
        this.setSize(1100, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);



        JPanel jp_1 = new JPanel();
        JPanel jp_2 = new JPanel();
        Dimension dim = new Dimension(125, 100);
        jp_2.setPreferredSize(dim);
        jp_1.setBackground(Color.white);     //面板设置颜色
        jp_2.setBackground(Color.cyan);
        this.add(jp_2, BorderLayout.EAST); //窗体设置边界布局方式
        this.add(jp_1, BorderLayout.CENTER); //窗体设置边界布局方式

        JButton btn1 = new JButton("悔棋");
        JButton btn2 = new JButton("认输");
        JButton btn3 = new JButton("存档");
        JButton btn4 = new JButton("读档");
        JButton btn5 = new JButton("回放");
        JButton btn6 = new JButton("重新开始");
        JButton btn7 = new JButton("返回主页面");
        btn1.setBackground(Color.cyan);
        btn2.setBackground(Color.cyan);
        btn3.setBackground(Color.cyan);
        btn4.setBackground(Color.cyan);
        btn5.setBackground(Color.cyan);
        btn6.setBackground(Color.cyan);
        btn7.setBackground(Color.cyan);
        Dimension btndim = new Dimension(125, 35);
        btn1.setPreferredSize(btndim);
        btn2.setPreferredSize(btndim);
        btn3.setPreferredSize(btndim);
        btn4.setPreferredSize(btndim);
        btn5.setPreferredSize(btndim);
        btn6.setPreferredSize(btndim);
        btn7.setPreferredSize(btndim);
        btn1.addActionListener(gl);
        btn2.addActionListener(gl);
        btn3.addActionListener(gl);
//      GobangListener gobangListener4 = new GobangListener();  //同一个界面添加同一个监听器，公用功能
        btn4.addActionListener(gl);
        btn5.addActionListener(gl);
        btn6.addActionListener(gl);
        btn7.addActionListener(gl);
        gl.setgobangjf(this);     //传入窗体对象，非界面对象

//        System.out.println(gl.pattern);

        jp_2.add(btn1);
        jp_2.add(btn2);
        jp_2.add(btn3);
        jp_2.add(btn4);
        jp_2.add(btn5);
        jp_2.add(btn6);
        jp_2.add(btn7);

        this.setVisible(true);


        Graphics g = this.getGraphics();         //添加监听器的步骤
        gl.setGraphic(g);
        this.addMouseListener(gl);
        this.addMouseMotionListener(gl);

    }



    public void paint(Graphics g) {   //重绘传递画笔参数，可用
        super.paint(g);  //注意 必须先调用父类绘制窗体
        //绘制图片
        g.drawImage(image2, 0, 0, 1100,1000,null);
        g.drawImage(image1, X, Y,COLUMN*SIZE, ROW*SIZE, null);
        this.setIconImage(new ImageIcon("Image//login.png").getImage());         //给窗体加图标
        for(int i=0; i<=ROW; i++){
            g.drawLine(X+SIZE*i, Y, X+SIZE*i, Y+ROW*SIZE);
        }

        //重绘按钮
        for(int i=0; i<=COLUMN; i++){     //重回功能里面写的函数，拖动窗体不会消失
            g.drawLine(X, Y+SIZE*i, X+COLUMN*SIZE, Y+SIZE*i);
        }


        int[][] chessrecord = gl.getchessrecord();  //重绘棋子
//        System.out.println(chessrecord.toString());      非list接口定义的数组，无tostring功能
        for(int i=0; i<chessrecord.length; i++){      //棋盘记录数组行为X轴Y轴 行数，列为列数
            for(int j=0; j<chessrecord[i].length; j++){
                //X轴Y轴行列数转换为数组坐标，转置
//                System.out.print(chessrecord[j][i]+ " ");  //println每输出一次换一次行,打开UI即调用重绘函数
                if(chessrecord[i][j]==1){
                    g.setColor(Color.BLACK);
                    g.fillOval(i*SIZE-SIZE/2+X, j*SIZE-SIZE/2+Y, SIZE, SIZE);  //依据当前棋盘记录中的行列值重绘
                }
                else if(chessrecord[i][j]==2){
                    g.setColor(Color.WHITE);
                    g.fillOval(i*SIZE-SIZE/2+X, j*SIZE-SIZE/2+Y, SIZE, SIZE);
                }
            }
//            System.out.println();           //sout+Enter打印语句快捷键, println为换行语句
        }
        System.out.println("gobangif.nextstep"+nextstep);
    }

    boolean nextstep;   //是否下了一步棋
    public void setNextstep(boolean nextstep){
        this.nextstep = nextstep;

    }

    @Override
    public void run() {  //线程的执行体
        Graphics g = this.getGraphics();
        g.setColor(Color.BLACK);
        for(int i=30; i>=0; i--) {
            try {
                Thread.sleep(1000);      //延时函数
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //        Font font = new Font("黑体");          也可以设置颜色
//        Color color = new Color(255, 255, 255,255);   设置方框透明度
            Color color = this.getBackground();
            g.setColor(color);
            g.fillRect(860, 50, 70, 40);
            g.setColor(Color.BLACK);

            if(nextstep == true){         //如果下了一步棋,从新开始计数
                i=30;
                nextstep = false;        //改变flag标志
            }

            System.out.println("i的值"+i);
            System.out.println("nextstep的值"+nextstep);
            g.drawString("倒计时:" + i + "s", 870, 75);
        }
        JOptionPane.showMessageDialog(null,"时间超时,自动认输!");

    }
}
