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
    private NormalRulesServiceImpl normalRulesService;
    private SpecialRulesServiceImpl specialRulesService;
    Logger logger;
    @Override
    public Game createGame(String uniqueGameName, List<String> playerList, boolean specialRules) {
        Game game = new Game();
        logger.debug("creating a new game");
        Stack playStack = new Stack();
        List<Player> actualPlayers = new ArrayList<>();
        game.setSpecialRules(specialRules);
        for (String playerValue : playerList){
            Player player = playerService.newPlayer(playerValue);
            if (playerValue.contains("Computer")){
                player.setAiOrNot(true);
            }
            actualPlayers.add(player);
            logger.debug("Added player.");
        }
        game.setPlayerList(actualPlayers);
        game.setActivePlayer(game.getPlayerList().get(0));
        game.setDrawStack(cardService.shuffleStack(cardService.createStack(), false));
        game.setDrawStack(giveAroundCards(game.getDrawStack(), game.getPlayerList(), cardsPerPlayer(game.getDrawStack(), game.getPlayerList())));
        //taking the last card of the draw stack and using it to start the playstack and be the first card of the game.
        playStack.cardList.add(game.getDrawStack().cardList.get(game.getDrawStack().cardList.size() - 1));
        game.setPlayStack(playStack);
        game.setDrawStack(removeCardFromAStack(game.getDrawStack(), game.getDrawStack().cardList.get(game.getDrawStack().cardList.size() -1)));
        return game;
    }

    @Override
    public Game drawCard(Game game) {
<<<<<<< HEAD
        Card c1 = new Card(Value.ACE, Color.HEART);
        game.getDrawStack().cardList.remove(c1);
        game.getActivePlayer().getHand().add(c1);
=======
        logger.debug("Simply drawing a single card from the Draw Stack.");
        Card card = game.getDrawStack().cardList.get(game.getDrawStack().cardList.size() - 1); //the last card fo the drawStack
        playerService.addCardtoHand(card, game.getActivePlayer());
        game.setDrawStack(removeCardFromAStack(game.getDrawStack(), card));
>>>>>>> 13cb96ad3582c6858f5bdbbf97507c24a6b64ff0
        return game;
    }

    @Override
    public Game playCard(Game game, Card card, Player player) {
        logger.debug("Playing a card!");
        if(rulesService.canPlaceCard(game.getPlayStack().cardList.get((game.getPlayStack().cardList.size())- 1), card, game.getCurrentWishedColor())) {
            game.setPlayStack(putDownCard(game.getPlayStack(), player, card));
            game.setNumberOfCardsToDraw(rulesService.mustDrawTwoCards(card, game.getNumberOfCardsToDraw()));
            if (rulesService.mustDirectionChange(card)){
                //hoffe ich bin mit den directions nicht durcheinander gekommen. muss getestet werden.
                logger.debug("The direction is being changed.");
                game.setDirectionReversed(!game.isDirectionReversed());
            }
            game.setHasPlayerPlayed(true);
            if(rulesService.canWishColor(card)){
                logger.debug("A color is being wished.");
                game.setColorWishOutstanding(true);
            }
            //checking if a player's gotta be skipped according to the card placed
            game.setCurrentPlayerSkipped(rulesService.isTurnSkipped(card));
            return game;
        }
<<<<<<< HEAD

        Card lastCard = game.getPlayStack().cardList.get(game.getPlayStack().cardList.size() - 1);

        if(card.getValue() == Value.JACK && lastCard.getValue() == Value.JACK){
            throw new IllegalArgumentException("You can not put Jack on a Jack");
        }

        if(card.getValue() != lastCard.getValue() || card.getColor() != lastCard.getColor()){
            throw new IllegalArgumentException("The color/value of your card does not " +
                    "match with the last card on the Play-Stack");
        }

        player.getHand().remove(card);
        //game.getPlayStack().putCardOnStack(card);

=======
>>>>>>> 13cb96ad3582c6858f5bdbbf97507c24a6b64ff0
        return game;
    }

    @Override
<<<<<<< HEAD
    public Stack shuffleStack(Stack stack) {
        //stack.shuffleStack();
        return stack;
=======
    public Game shuffleStack(Game game) {
        logger.debug("Checking if the drawStack is nearly empty.");
        Stack drawStack = game.getDrawStack();
        Stack newPlayStack = new Stack();
        if (drawStack.cardList.size() < 4) {
            logger.debug("Filling the drawStack with the play Stack. Shuffling. Keeping Top and Bottom Cards.");
            Card topCardStackToFill = drawStack.cardList.get(0);
            drawStack = game.getPlayStack();
            //adding the last card of the old playStack to the new (empty) playStack
            newPlayStack.cardList.add(drawStack.getCardList().get(drawStack.cardList.size() - 1));
            drawStack.cardList.remove(drawStack.cardList.size() - 1);
            drawStack.cardList.add(topCardStackToFill);
            game.setDrawStack(cardService.shuffleStack(drawStack, false));
            game.setPlayStack(newPlayStack);
        }
        return game;
>>>>>>> 13cb96ad3582c6858f5bdbbf97507c24a6b64ff0
    }

    @Override
    public boolean checkWinner(Player player) {
        //FALSE IF PLAYER WINS!
        logger.debug("Checking if a player has won the game yet.");
        if (player.getHand().cardList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Game wishColor(Game game, Color color) {
        logger.debug("A wished color is being set.");
        game.setCurrentWishedColor(color);
        game.setColorWishOutstanding(false);
        return game;
    }

    @Override
    public Game nextPlayer(Game game) {
        //this method modifies the game's ActivePlayer
        logger.debug("Calculating the next player's turn");
        int skipFactor = 1;
        game.setHasPlayerPlayed(false);
        //if with special rules a player is skipped, the game moves two forward or back depending on direction
        if(game.isCurrentPlayerSkipped()){
            skipFactor = skipFactor * 2;
        }
        int nextPlayer = 0;
        // if the direction is reversed, the game goes in the other direction, but the skipfactor is retained.
        if(game.isDirectionReversed()){
            nextPlayer = game.getPlayerList().indexOf(game.getActivePlayer()) + (skipFactor);
        } else if (!game.isDirectionReversed())  {
            nextPlayer = game.getPlayerList().indexOf(game.getActivePlayer()) - (skipFactor);
        }
        if (nextPlayer >= game.getPlayerList().size()){
            game.setActivePlayer(game.getPlayerList().get(nextPlayer - game.getPlayerList().size()));
        } else {
            if (nextPlayer < 0){
                //in these cases the round simply starts again.
                game.setActivePlayer(game.getPlayerList().get(nextPlayer - game.getPlayerList().size()));
            } else {
                game.setActivePlayer(game.getPlayerList().get(nextPlayer));
            }
        }
        return game;
    }

    @Override
    public void setMauMau(Player player, boolean saidMau) {
        logger.debug("Setting new maumau status");
      player.setSaidMauMau(saidMau);
    }

    @Override
    public Game sayMauMau(Game game) {
        logger.debug("Checking active player's MauMau status.");
        if(isSayMauMauNecessary(game.getActivePlayer())){
            game=shuffleStack(game);
            if(!game.getActivePlayer().isSaidMauMau()){
                //if the active player had to say maumau but didnt, he/she draws two cards.
                giveCardsToOne(game.getDrawStack(), game.getActivePlayer(), 2);
            }
        }
        return game;
    }

    @Override
    public boolean isSayMauMauNecessary(Player player) {
        logger.debug("checking if saying Mau is necessary for a player");
        if (player.getHand().cardList. size() == 1) return true;
        else return false;
    }

    @Override
    public RulesService chooseRules(boolean specialRules) {
        if (!(specialRules = true)) {
            return rulesService = normalRulesService;
        } else {
            return rulesService = specialRulesService;
        }
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
