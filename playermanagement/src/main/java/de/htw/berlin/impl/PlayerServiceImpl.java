package de.htw.berlin.impl;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Player;
import de.htw.berlin.export.PlayerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Component
public class PlayerServiceImpl implements PlayerService {
    @Override
    public Player newPlayer(String name) {
        Player p1 = new Player();
        p1.setName(name);
        return p1;
    }

    @Override
    public Player addCardtoHand(Card card, Player player) {
        Stack<Card> hand = player.getHand();
        hand.add(card);
        player.setHand(hand);
        return player;
    }

    @Override
    public Player removeCardfromHand(Card card, Player player) {
        Stack<Card> hand = player.getHand();
        hand.remove(card);
        player.setHand(hand);
        return player;
    }
}
