package onlinegameplatform.gobang;

public class Chess {
    int index;
    int chesscolor;
    int ChessX;
    int ChessY;

    /**
     * 棋子对象
     * @param index     棋子数目
     * @param chesscolor 棋子颜色
     * @param ChessX     棋子当前X坐标
     * @param ChessY     棋子当前Y坐标
     */
    public Chess(int index, int chesscolor, int ChessX, int ChessY){
        this.index = index;
        this.chesscolor = chesscolor;
        this.ChessX = ChessX;
        this.ChessY = ChessY;

    }



}
