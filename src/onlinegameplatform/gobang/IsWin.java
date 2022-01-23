package onlinegameplatform.gobang;

public class IsWin extends GobangListener{


    //判断输赢，此时坐标已经存入棋子记录数组
    //判断此时棋子上下左右斜上斜下，此时X,Y每按下一次按钮改变一次，函数调用一次，但是数组是总体的数组

    public static boolean IsWin(int[][] chessrecord, int ChessX, int ChessY){   //静态函数可以用类名直接调用
        if(checkrow(chessrecord, ChessX, ChessY)>=5|| checkcolumn(chessrecord, ChessX, ChessY)>=5|| checkedgeleft(chessrecord, ChessX, ChessY)>=5||checkedgeright(chessrecord, ChessX, ChessY)>=5)
            return true;
        else
            return false;
    }


    public static int checkrow (int[][] chessrecord, int x, int y) {          //传入当前棋子坐标
        int count = 1;          //局部变量，不然一直加
        for (int i = x+1; i < ROW + 1; i++) {  //判断纵轴棋子下侧是否赢
            if (chessrecord[i][y] == chessrecord[x][y]) {
                count++;
            } else {
                break;         //无连续5个棋子，结束循环
            }
        }

        for (int i = x-1; i >= 0; i--) {  //判断纵轴棋子上侧是否赢
            if (chessrecord[i][y] == chessrecord[x][y]) {
                count++;
            } else {            //无5个连续的棋子，结束循环
                break;
            }
        }
        return count;
//            System.out.println("row"+count);       //多输出坐标判断个数
    }

    public static int checkcolumn(int[][] chessrecord, int x, int y){
        int count = 1;
        for(int j=y+1; j<COLUMN+1; j++) {  //判断横轴棋子右侧是否赢
            if (chessrecord[x][j] == chessrecord[x][y]) {
                count++;
            } else {
                break;
            }
        }

        for(int j=y-1; j>=0; j--) {  //判断横轴棋子左侧是否赢
            if (chessrecord[x][j] == chessrecord[x][y]) {
                count++;
            }
            else {
                break;
            }
        }
//         System.out.println("column"+count);         //多输出坐标判断个数
        return count;
    }

    public static int checkedgeleft(int[][] chessrecord, int x, int y){  //判断棋子左斜轴是否有连续5个棋子
        int count = 1;
        int i = x;
        int j = y;
        while (i<ROW && j<COLUMN) {
            if (chessrecord[i][j] == chessrecord[i+1][j+1]){
                count++;
                i++;
                j++;
            }
            else {
                break;
            }
        }
        i = x;
        j = y; //重置x,y坐标，判断下
        while(i>0 && j>0){
            if(chessrecord[i][j] == chessrecord[i-1][j-1]){
                count++;
                i--;
                j--;
            }
            else {
                break;
            }

        }
//            System.out.println("count"+count);         //输出连续棋子的个数
        return count;
    }


    public static int checkedgeright(int[][] chessrecord, int x, int y){  //判断棋子右斜轴是否有连续5个棋子
        int count = 1;
        int i = x;
        int j = y;
        while (i>0 && j<COLUMN) {
            if (chessrecord[i][j] == chessrecord[i-1][j+1]){
                count++;
                i--;
                j++;
            }
            else {
                break;
            }

        }
        i = x;
        j = y;
        while(i<ROW && j>0){
            if(chessrecord[i][j] == chessrecord[i+1][j-1]){
                count++;
                i++;
                j--;
            }
            else {
                break;
            }

        }
//        System.out.println("右"+count);     //输出右斜轴个数
//        if (count >= 5) {
//            if (chessrecord[x][y] == 1) {
//                JOptionPane.showMessageDialog(null, "执黑棋者获得胜利");
//            } else if (chessrecord[x][y] == 2) {
//                JOptionPane.showMessageDialog(null, "执白棋者获得胜利");
//            }
        return count;
    }
}
