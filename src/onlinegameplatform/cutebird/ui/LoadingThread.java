package onlinegameplatform.cutebird.ui;

public class LoadingThread extends Thread{

    public void run(){
        LoadingUI ui = new LoadingUI();
        ui.InitUI();
    }
}
