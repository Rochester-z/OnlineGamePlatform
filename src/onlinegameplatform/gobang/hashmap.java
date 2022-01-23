package onlinegameplatform.gobang;

import java.util.HashMap;


public class hashmap {
    HashMap<String, Integer> hash = new HashMap<>();    //创建hashmap对象，记录连子情况和得分

    public hashmap(){
        //        两端通畅为活连;
//      hash = hashmap;              //将hashmap地址赋给hash
        hash.put("010", 10);    //黑棋活一连 10分  这个位置10分 黑棋下或者白棋下都好
        hash.put("0110", 50);   //活二连 50分
        hash.put("01110", 500); //活三连 500分
        hash.put("011110", 2000);  //活四连 2000分
        hash.put("020", 10);   //白棋活一连 10分
        hash.put("0220", 50);  //白棋活二连 50分
        hash.put("02220", 500); //白棋活三连 500分
        hash.put("022220", 2000);  //白棋活四连 2000分
        // 一端通畅为死连
        //黑棋死一连5分
        hash.put("01", 5);
        hash.put("012", 5);
        //黑棋死二连25分
        hash.put("011", 25);
        hash.put("0112", 25);
        //黑棋死三连250分
        hash.put("0111", 250);
        hash.put("01112", 250);
        //黑棋死四连1000分
        hash.put("01111", 1000);
        hash.put("011112", 1000);

        //白棋死一连5分
        hash.put("02", 5);
        hash.put("021", 5);
        //白棋死二连25分
        hash.put("022", 25);
        hash.put("0221", 25);
        //白棋死三连250分
        hash.put("0222", 250);
        hash.put("02221", 250);
        //白棋死四连1000分
        hash.put("02222", 1000);
        hash.put("022221", 1000);
//      System.out.println("hash.get(0222)"+hash.get("0222"));
    }
}
