package de.htw.berlin.impl;


import de.htw.berlin.domain.*;
import de.htw.berlin.domain.Color;
import de.htw.berlin.export.CardService;
import de.htw.berlin.export.GameService;
import de.htw.berlin.export.PlayerService;
import de.htw.berlin.export.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameServiceImpl implements GameService {
    //Note Ü3: how to instantiate with spring?
    private PlayerService playerService;
    private CardService cardService;
    private RulesService rulesService;
    Logger logger;
    @Override
    public Game createGame(String uniqueGameName, List<String> playerList, boolean specialRules) {
        Game game = new Game();
        logger.debug("creating a new game");
        game.setSpecialRules(specialRules);
        List<Player> actualPlayers = new ArrayList<>();
        Stack playStack = new Stack();
        for (String playerValue : playerList){
            Player player = playerService.newPlayer(playerValue);
            actualPlayers.add(player);
        }
        game.setPlayerList(actualPlayers);
        game.setActivePlayer(game.getPlayerList().get(0));
        game.setDrawStack(cardService.shuffleStack(cardService.createStack(), false));
        game.setDrawStack(playStack);
        //DONE TILL HERE
        //g1.setUniqueGameName(uniqueGameName);
        game.setSpecialRules(specialRules);
        return game;
        //System.out.println(" hello");
    }

    @Override
    public Game drawCard(Game game) {
        //Card c1 = new Card();
/*        game.getDrawStack().cardList.remove(c1);
        game.getActivePlayer().getHand().add(c1);*/
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

/*        player.getHand().remove(card);
        game.getPlayStack()*/

        return game;
    }

    @Override
    public Game shuffleStack(Game game) {
       /* stack.shuffleStack();*/
        return game;
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

    @Override
    public boolean isSayMauMauNecessary(Player player) {
        logger.debug("checking if saying Mau is necessary for a palyer");
        if (player.getHand().size() == 1) return true;
        else return false;
    }

    @Override
    public RulesService chooseRules(boolean specialRules) {
        return null;
    }

    @Override
    public Stack giveAroundCards(Stack drawStack, List<Player> playerList, int amountOfCardsToGiveAround) {
        logger.debug("Giving cards to all of the players");
        for (int i = 0; i < amountOfCardsToGiveAround; i++) {
            for (int n = 0; n < playerList.size(); n++) {
                Card card = drawStack.getCardList().get(drawStack.cardList.size() - 1);
                playerService.addCardtoHand(card, playerList.get(n));
                drawStack.cardList.remove(card);
            }
        }
        return drawStack;
        // in case of passing cards to a single player, use the method giveCardsToOne which uses giveAroundCards as a submethod.
    }

    @Override
    public Stack giveCardsToOne(Stack drawStack, Player player, int amountOfCardsToGiveAround) {
        logger.debug("Giving cards to one of the players.");
        //this is simply another way to use the giveAroundCards method.
        List<Player> fakeListForSubmethod = new ArrayList<>();
        fakeListForSubmethod.add(player);
        giveAroundCards(drawStack, fakeListForSubmethod, amountOfCardsToGiveAround);
        return drawStack;
    }

    @Override
    public Stack removeCardFromAStack(Stack stack, Card card) {
        logger.debug("Removing a card from a stack.");
        stack.cardList.remove(card);
        return stack;
    }

    @Override
    public int cardsPerPlayer(Stack completeStack, List<Player> players) {
        logger.debug("Using calculation to determine the number of cards per player. Generally, a player will have 6 cards. In case of large number of players drawstack caps at 6, which can lead to fewer cards. ");
        //this calculation serves the purpose that there are always at least 6 cards in the playstack! in case there are lots of players, theyll have to play with fewer cards.
        int calculation = (int) Math.floor((completeStack.cardList.size() - 6) / players.size());
        //die Idee dazu stammt auf Anfrage von: https://stackoverflow.com/questions/34705178/rounding-double-to-int-always-to-the-smaller und auf Tipp von Kommiltonen (Krisjanis Spridis)
        if (calculation > 6) {
            calculation = 6;
        }
        return calculation;
    }

    @Override
    public Stack putDownCard(Stack playStack, Player player, Card card) {
        logger.debug("Taking the card from the player and transferring it to the playStack.");
        playerService.removeCardfromHand(card, player);
        playStack.cardList.add(card);
        return playStack;
    }


}
