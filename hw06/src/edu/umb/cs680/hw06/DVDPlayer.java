package edu.umb.cs680.hw06;

public class DVDPlayer{
    private DVDPlayer() {};
    private static PlayerState state;
    private static DVDPlayer instance = null;
    public static DVDPlayer getInstance(){
        if (instance==null){
            instance = new DVDPlayer();
            state = DrawerClosedNotPlaying.getInstance();
        }
        return instance;
    }

    public PlayerState getState(){
        return state;
    }

    public void changeState(PlayerState state){
        this.state = state;
    }



    public void openCloseButtonPushed(){
        state.openCloseButtonPushed();
    }

    public void playButtonPushed(){
        state.playButtonPushed();
    }

    public void stopButtonPushed(){
        state.stopButtonPushed();
    }

    public void open(){};
    public void close(){};
    public void play(){};
    public void stop(){};
    public boolean disk = true;
    public boolean drawerCheck(){
        if (disk){
            return true;
        }
        else{
            return false;
        }
    };
}