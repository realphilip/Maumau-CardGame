package de.htw.berlin.domain;
import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Game;
import de.htw.berlin.domain.Player;
import de.htw.berlin.domain.Stack;
import de.htw.berlin.domain.Value;
import de.htw.berlin.export.GameService;
import de.htw.berlin.impl.GameServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImplTest {

    private GameService gameService;
    private Game game;
    private Player player1;
    private Player player2;
    private Stack drawStack;

    @Before
    public void setUp() {
        gameService = new GameServiceImpl();
        List<String> playerList = new ArrayList<>();
        playerList.add("Player1");
        playerList.add("Player2");
        game = gameService.createGame("game1", playerList, false);
        player1 = game.getPlayerList().get(0);
        player2 = game.getPlayerList().get(1);
        drawStack = game.getDrawStack();
    }

    @Test
    public void testCreateGame() {
        Assert.assertEquals("game1", game.getUniqueGameName());
        Assert.assertEquals(2, game.getPlayerList().size());
    }

    @Test
    public void testDrawCard() {
        game = gameService.drawCard(game);
        Assert.assertEquals(1, player1.getHand().size());
        Assert.assertEquals(51, drawStack.cardList.size());
    }

    @Test
    public void testPlayCard() {
        Card card = new Card(Value.ACE, Color.HEART);
        game = gameService.drawCard(game);
        game = gameService.playCard(game, card, player1);
        Assert.assertEquals(0, player1.getHand().size());
        Assert.assertEquals(51, drawStack.cardList.size());
        Assert.assertEquals(1, game.getPlayStack().cardList.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayCardNotTurn() {
        Card card = new Card(Value.ACE, Color.HEART);
        game = gameService.drawCard(game);
        game = gameService.playCard(game, card, player2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayCardWrongColorValue() {
        Card card = new Card(Value.ACE, Color.HEART);
        game = gameService.drawCard(game);
        game.getPlayStack().cardList.add(new Card(Value.TWO, Color.CLUB));
        game = gameService.playCard(game, card, player1);
    }
}

