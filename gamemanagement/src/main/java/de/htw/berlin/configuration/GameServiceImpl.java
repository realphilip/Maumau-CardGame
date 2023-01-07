package de.htw.berlin.configuration;


import de.htw.berlin.domain.*;
import de.htw.berlin.domain.Color;
import de.htw.berlin.export.GameService;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
import java.util.Random;

@Component
public class GameServiceImpl implements GameService {
    @Override
    public Game createGame(String uniqueGameName, List<Player> playerList, boolean specialRules) {
        Game g1 = new Game();
        g1.setUniqueGameName(uniqueGameName);
        g1.setPlayerList(playerList);
        g1.setSpecialRules(specialRules);
        return g1;
    }

    @Override
    public Game drawCard(Game game) {
        return null;
    }

    @Override
    public Game playCard(Game game, Card card, Player player) {
        if (player != game.getActivePlayer()){
            throw new IllegalArgumentException("It is not the turn of the given player");
        }

        Stack s1 = new Stack();
        s1.putCardOnStack(card);

        return game;
    }

    @Override
    public Stack shuffleStack(Stack stack) {
        stack.shuffleStack();
        return stack;
    }

    @Override
    public boolean checkWinner(Player player) {
        return player.isSaidMauMau();
    }

    @Override
    public Game wishColor(Game game, Color color) {
        game.setCurrentWishedColor(color);
        return game;
    }

    @Override
    public Game nextPlayer(Game game) {
        return game;
    }

    @Override
    public void setMauMau(Player player, boolean saidMau) {
      player.setSaidMauMau(saidMau);
    }

    @Override
    public Game sayMauMau(Game game) {
        game.getActivePlayer().setSaidMauMau(true);
        return game;
    }
}
