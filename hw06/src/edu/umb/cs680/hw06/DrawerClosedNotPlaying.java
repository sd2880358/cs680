package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements PlayerState{
    private DrawerClosedNotPlaying(){};
    private static DrawerClosedNotPlaying instance = null;
    private DVDPlayer player = DVDPlayer.getInstance();
    public static DrawerClosedNotPlaying getInstance(){
        if (instance==null){
            instance = new DrawerClosedNotPlaying();
        }
        return instance;
    }

    @Override
    public void openCloseButtonPushed() {
        player.open();
        player.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        if (player.drawerCheck()){
            player.play();
            player.changeState(DrawerClosedPlaying.getInstance());
        }
        else{
            throw new RuntimeException("The Drawer is empty");
        }
    }

    @Override
    public void stopButtonPushed() {

    }




}