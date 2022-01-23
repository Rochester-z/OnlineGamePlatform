package onlinegameplatform.gobang;

public class HashMapChess implements GoBangConfig{
    static int[][] chessweight = new int[ROW+1][COLUMN+1];
    static hashmap Hashmap = new hashmap();

    //测试数据
//    static int[][] test = {{0, 0, 1, 2, 0},
//                           {1, 2, 2, 1, 0},
//                           {2, 1, 0, 0 ,1},
//                           {1, 2, 0, 0, 1},
//                           {2, 2, 1, 0, 0}};


    public static int[][] intelligence(int[][] chessrecord) {  //主函数中变量为静态变量
        //从棋盘记录数组左上角开始遍历找到权值最大的位置下棋
        for (int i = 0; i < chessrecord.length; i++) {
            for (int j = 0; j < chessrecord[i].length; j++) {
//                System.out.print(chessrecord[i][j]+" ");
                int weight = 0;
                if (chessrecord[i][j] == 0) {   //表示当前位置无棋子，可以统计,从当前位置往右统计
                    int chessnum = chessrecord[i][j];  //记录当前棋子

                    //向右遍历找棋子
                    if (j < chessrecord[i].length - 1 && chessnum != chessrecord[i][j + 1]) {   //确保当前空位置右边有棋子，缺陷
                        int chess0 = chessrecord[i][j + 1];   //记录当前空位置右边棋子
                        String codeStr = "0";
                        for (int k = j + 1; k < chessrecord[i].length; k++) {
                            if (chessrecord[i][k] == chess0) {
                                codeStr = codeStr + chessrecord[i][k];  //字符串能直接为 字符串+数字
                            }
                            else {
                                codeStr = codeStr + chessrecord[i][k];
                                break;
                            }
                        }

//                        System.out.println(i+" "+j+"codeStr右"+codeStr);
                        if(Hashmap.hash.containsKey(codeStr)) {
                            weight += Hashmap.hash.get(codeStr);
                        }
                    }

                    //向左遍历找棋子
                    if (j > 0 && chessnum != chessrecord[i][j - 1]) {   //确保当前空位置左边有棋子，缺陷
                        int chess0 = chessrecord[i][j - 1];   //记录当前空位置左边棋子
                        String codeStr = "0";
                        for (int k = j - 1; k >= 0; k--) {
                            if (chessrecord[i][k] == chess0) {
                                codeStr = codeStr + chessrecord[i][k];  //字符串能直接为 字符串+数字
                            } else {
                                codeStr = codeStr + chessrecord[i][k];   //codeStr添加遍历到的不等于左边的棋子，为0或2
                                break;
                            }
                        }
//                        System.out.println(i+" "+j+"codeStr左"+codeStr);
                        if (Hashmap.hash.containsKey(codeStr)) {
                            weight += Hashmap.hash.get(codeStr);
                        }
                    }


                    //向上遍历找棋子
                    if (i > 0 && chessnum != chessrecord[i - 1][j]) {   //确保当前空位置上边有棋子，缺陷
                        int chess0 = chessrecord[i - 1][j];   //记录当前空位置上边棋子
                        String codeStr = "0";
                        for (int k = i - 1; k >= 0; k--) {
                            if (chessrecord[k][j] == chess0) {
                                codeStr = codeStr + chessrecord[k][j];  //字符串能直接为 字符串+数字
                            } else {
                                codeStr = codeStr + chessrecord[k][j];
                                break;
                            }
                        }
//                        System.out.println(i+" "+j+"codeStr上"+codeStr);
                        if (Hashmap.hash.containsKey(codeStr)) {
                            weight += Hashmap.hash.get(codeStr);
                        }

                    }


                    //向下遍历找棋子
                    if (i < chessrecord.length - 1 && chessnum != chessrecord[i + 1][j]) {   //确保当前空位置上边有棋子，缺陷
                        int chess0 = chessrecord[i + 1][j];   //记录当前空位置上边棋子
                        String codeStr = "0";
                        for (int k = i + 1; k < chessrecord.length; k++) {
                            if (chessrecord[k][j] == chess0) {
                                codeStr = codeStr + chessrecord[k][j];  //字符串能直接为 字符串+数字
                            } else {
                                codeStr = codeStr + chessrecord[k][j];
                                break;
                            }
                        }
//                        System.out.println(i+" "+j+"codeStr下"+codeStr);
                        if (Hashmap.hash.containsKey(codeStr)) {
                            weight += Hashmap.hash.get(codeStr);
                        }
                    }
                    //向左上遍历找棋子
                    if (i > 0 && j >0 && chessnum != chessrecord[i - 1][j-1]) {  //确保当前空位置左上有棋子，缺陷
                        int chess0 = chessrecord[i - 1][j-1];      //记录当前空位置左上边棋子
                        String codeStr = "0";
                        for (int m = i - 1, n = j-1; m >= 0 && n >=0; m--, n--) {      //for循环定义两个参数
                            if (chessrecord[m][n] == chess0) {
                                codeStr = codeStr + chessrecord[m][n];  //字符串能直接为 字符串+数字
                            } else {
                                codeStr = codeStr + chessrecord[m][n];
                                break;
                            }
                        }
//                        System.out.println(i+" "+j+"codeStr上"+codeStr);
                        if (Hashmap.hash.containsKey(codeStr)) {
                            weight += Hashmap.hash.get(codeStr);
                        }
                    }
                    //向右上遍历棋子
                    if (i > 0 && j < chessrecord[i].length - 1 && chessnum != chessrecord[i - 1][j + 1]) {  //确保当前空位置左上有棋子，缺陷
                        int chess0 = chessrecord[i - 1][j+1];      //记录当前空位置左上边棋子
                        String codeStr = "0";
                        for (int m = i - 1, n = j + 1; m >= 0 && n < chessrecord[i].length; m--, n++) {      //for循环定义两个参数
                            if (chessrecord[m][n] == chess0) {
                                codeStr = codeStr + chessrecord[m][n];  //字符串能直接为 字符串+数字
                            } else {
                                codeStr = codeStr + chessrecord[m][n];
                                break;
                            }
                        }
//                        System.out.println(i+" "+j+"codeStr上"+codeStr);
                        if (Hashmap.hash.containsKey(codeStr)) {
                            weight += Hashmap.hash.get(codeStr);
                        }
                    }

                    //向左下遍历棋子
                    if (i < chessrecord.length - 1 && j > 0 && chessnum != chessrecord[i + 1][j-1]) {  //确保当前空位置左上有棋子，缺陷
                        int chess0 = chessrecord[i + 1][j-1];      //记录当前空位置左上边棋子
                        String codeStr = "0";
                        for (int m = i + 1, n = j-1; m <chessrecord.length && n >=0; m++, n--) {      //for循环定义两个参数
                            if (chessrecord[m][n] == chess0) {
                                codeStr = codeStr + chessrecord[m][n];  //字符串能直接为 字符串+数字
                            } else {
                                codeStr = codeStr + chessrecord[m][n];
                                break;
                            }
                        }
//                        System.out.println(i+" "+j+"codeStr上"+codeStr);
                        if (Hashmap.hash.containsKey(codeStr)) {
                            weight += Hashmap.hash.get(codeStr);
                        }
                    }

                    //向右下遍历棋子
                    if (i < chessrecord.length-1 && j <chessrecord[i].length-1 && chessnum != chessrecord[i + 1][j + 1]) {  //确保当前空位置左上有棋子，缺陷
                        int chess0 = chessrecord[i + 1][j+1];      //记录当前空位置右下边棋子
                        String codeStr = "0";
                        for (int m = i + 1, n = j + 1; m < chessrecord.length && n < chessrecord[i].length; m++, n++) {      //for循环定义两个参数
                            if (chessrecord[m][n] == chess0) {
                                codeStr = codeStr + chessrecord[m][n];  //字符串能直接为 字符串+数字
                            } else {
                                codeStr = codeStr + chessrecord[m][n];
                                break;
                            }
                        }
//                        System.out.println(i+" "+j+"codeStr上"+codeStr);
                        if (Hashmap.hash.containsKey(codeStr)) {
                            weight += Hashmap.hash.get(codeStr);
                        }
                    }

                }
                chessweight[i][j] = weight;
//                System.out.print("weight"+weight+"");   //+空格
            }
//            System.out.println();
        }
        return chessweight;
    }
}








