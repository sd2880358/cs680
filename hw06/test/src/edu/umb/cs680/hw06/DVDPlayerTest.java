package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DVDPlayerTest {

    @Test
    void getInstance() {
        DVDPlayer instance1 = DVDPlayer.getInstance();
        DVDPlayer instance2 = DVDPlayer.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void changeState() {
        DVDPlayer player = DVDPlayer.getInstance();
        PlayerState expected = player.getState();
        PlayerState actual = DrawerClosedNotPlaying.getInstance();
        assertEquals(expected, actual);
    }

    @Test
    void openCloseButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.openCloseButtonPushed();
        PlayerState actual = player.getState();
        PlayerState expected = DrawerOpen.getInstance();
        assertEquals(actual, expected);
    }

    @Test
    void playButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.playButtonPushed();
        PlayerState actual = player.getState();
        PlayerState expected = DrawerClosedPlaying.getInstance();
        assertEquals(actual, expected);
    }
}