package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrawerClosedNotPlayingTest {

    @Test
    public void getInstance() {
        DrawerClosedNotPlaying instance1 = DrawerClosedNotPlaying.getInstance();
        DrawerClosedNotPlaying instance2 = DrawerClosedNotPlaying.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void openCloseButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedNotPlaying.getInstance());
        player.openCloseButtonPushed();
        PlayerState actual =  player.getState();
        PlayerState expected = DrawerOpen.getInstance();
        assertSame(actual, expected);
    }

    @Test
    public void playButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedNotPlaying.getInstance());
        player.playButtonPushed();
        PlayerState actual =  player.getState();
        PlayerState expected = DrawerClosedPlaying.getInstance();
        assertSame(actual, expected);
    }

    @Test
    public void stopButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedNotPlaying.getInstance());
        player.stopButtonPushed();
        PlayerState actual =  player.getState();
        PlayerState expected = DrawerClosedNotPlaying.getInstance();
        assertSame(actual, expected);
    }
}