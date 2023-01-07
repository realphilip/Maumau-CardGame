package de.htw.berlin.configuration;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Player;
import de.htw.berlin.domain.Stack;
import de.htw.berlin.export.PlayerService;
import org.springframework.stereotype.Component;

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
        player.getHand().add(card);
        return player;
    }

    @Override
    public Player removeCardfromHand(Card card, Player player) {
        player.getHand().remove(card);
        return player;
    }
}
