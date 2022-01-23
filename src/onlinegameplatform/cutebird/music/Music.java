package onlinegameplatform.cutebird.music;


import onlinegameplatform.util.PictureUtil;

import javax.swing.*;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Music extends Thread{

//音频文件getClassLoader()获取不了
//AudioClip christmas = loadSound(PictureUtil.class.getClassLoader().getResource("onlinegameplatform/resource/music/Easy-Breeze.wav"));

    public AudioClip christmas = loadSound(this.getClass().getResource("/onlinegameplatform/resource/music/Easy-Breeze.wav"));

    public AudioClip loadSound(URL filename) {
        URL url = null;
        url = filename;
        return JApplet.newAudioClip(url);       //小程序的新音频剪辑，返回一个音频
    }

    public void run() {
            christmas.play();
    }
}


