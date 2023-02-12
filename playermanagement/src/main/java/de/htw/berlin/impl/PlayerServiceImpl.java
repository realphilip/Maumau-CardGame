package de.htw.berlin.impl;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Player;
import de.htw.berlin.domain.Stack;
import de.htw.berlin.export.PlayerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        Stack hand = player.getHand();
        hand.cardList.add(card);
        player.setHand(hand);
        return player;
    }

    @Override
    public Player removeCardfromHand(Card card, Player player) {
        Stack hand = player.getHand();
        hand.cardList.remove(card);
        player.setHand(hand);
        return player;
    }
}
