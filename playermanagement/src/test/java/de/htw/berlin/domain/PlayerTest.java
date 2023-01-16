package de.htw.berlin.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void testConstructor() {
        Player actualPlayer = new Player();
        Stack stack = new Stack();
        actualPlayer.setHand(stack);
        actualPlayer.setName("Name");
        actualPlayer.setSaidMauMau(true);
        assertSame(stack, actualPlayer.getHand());
        assertEquals("Name", actualPlayer.getName());
        assertTrue(actualPlayer.isSaidMauMau());
    }
}

