package edu.umb.cs680.hw06;

public class DrawerOpen implements PlayerState{
    private DrawerOpen(){};
    private static DrawerOpen instance = null;
    private DVDPlayer player = DVDPlayer.getInstance();
    public static DrawerOpen getInstance(){
        if (instance==null){
            instance = new DrawerOpen();
        }
        return instance;
    }

    @Override
    public void openCloseButtonPushed() {
        player.close();
        player.changeState(DrawerClosedNotPlaying.getInstance());
    }

    @Override
    public void playButtonPushed() {
        player.close();
        player.play();
        player.changeState(DrawerClosedNotPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {

    }
}