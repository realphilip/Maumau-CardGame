package de.htw.berlin.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void testConstructor() {
        Game actualGame = new Game();
        Player player = new Player();
        Stack stack3 = new Stack();
        //player.setHand(stack3);
        player.setName("Name");
        player.setSaidMauMau(true);
        actualGame.setActivePlayer(player);
        actualGame.setCurrentPlayerSkipped(true);
        actualGame.setDirectionReversed(true);
        Stack stack = new Stack();
        actualGame.setDrawStack(stack);
        actualGame.setHasPlayerPlayed(true);
        actualGame.setNumberOfCardsToDraw(10);
        Stack stack1 = new Stack();
        actualGame.setPlayStack(stack1);
        ArrayList<Player> playerList = new ArrayList<>();
        actualGame.setPlayerList(playerList);
        actualGame.setSpecialRules(true);
        actualGame.setUniqueGameName("Unique Game Name");
        actualGame.setWinner("Winner");
        assertSame(player, actualGame.getActivePlayer());
        assertNull(actualGame.getCurrentWishedColor());
        assertSame(stack, actualGame.getDrawStack());
        assertEquals(10, actualGame.getNumberOfCardsToDraw());
        assertSame(stack1, actualGame.getPlayStack());
        assertSame(playerList, actualGame.getPlayerList());
        assertEquals("Unique Game Name", actualGame.getUniqueGameName());
        assertEquals("Winner", actualGame.getWinner());
        assertTrue(actualGame.isCurrentPlayerSkipped());
        assertTrue(actualGame.isDirectionReversed());
        assertTrue(actualGame.isHasPlayerPlayed());
        assertTrue(actualGame.isSpecialRules());
    }
}

