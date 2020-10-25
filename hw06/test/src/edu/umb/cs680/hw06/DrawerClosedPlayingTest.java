package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DrawerClosedPlayingTest {

    @Test
    void getInstance() {
        DrawerClosedPlaying instance1 = DrawerClosedPlaying.getInstance();
        DrawerClosedPlaying instance2 = DrawerClosedPlaying.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void openCloseButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedPlaying.getInstance());
        player.openCloseButtonPushed();
        PlayerState actual =  player.getState();
        PlayerState expected = DrawerOpen.getInstance();
        assertSame(actual, expected);
    }

    @Test
    void playButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedPlaying.getInstance());
        player.playButtonPushed();
        PlayerState actual =  player.getState();
        PlayerState expected = DrawerClosedPlaying.getInstance();
        assertSame(actual, expected);
    }

    @Test
    void stopButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedPlaying.getInstance());
        player.stopButtonPushed();
        PlayerState actual =  player.getState();
        PlayerState expected = DrawerClosedNotPlaying.getInstance();
        assertSame(actual, expected);
    }
}