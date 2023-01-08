package de.htw.berlin.impl;


import de.htw.berlin.domain.*;
import de.htw.berlin.domain.Color;
import de.htw.berlin.export.GameService;
import org.springframework.stereotype.Component;

import java.util.List;

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
        Card c1 = new Card();
        game.getDrawStack().cardList.remove(c1);
        game.getActivePlayer().getHand().add(c1);
        return game;
    }

    @Override
    public Game playCard(Game game, Card card, Player player) {
        if (player != game.getActivePlayer()){
            throw new IllegalArgumentException("It is not the turn of the given player");
        }

        Card lastCard = game.getPlayStack().cardList.get(game.getPlayStack().cardList.size() - 1);

        if(card.getValue() == Value.JACK && lastCard.getValue() == Value.JACK){
            throw new IllegalArgumentException("You can not put Jack on a Jack");
        }

        if(card.getValue() != lastCard.getValue() || card.getColor() != lastCard.getColor()){
            throw new IllegalArgumentException("The color/value of your card does not " +
                    "match with the last card on the Play-Stack");
        }

        player.getHand().remove(card);
        game.getPlayStack().putCardOnStack(card);

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
        game.setHasPlayerPlayed(true);
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
