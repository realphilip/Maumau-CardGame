package de.htw.berlin.ai.impl;

import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Player;
import de.htw.berlin.ai.export.AIService;
import org.apache.logging.log4j.Logger;

import java.util.Random;


public class AIServiceImpl implements AIService {
    Logger logger;
    Random randomizer;

    @Override
    public String createAI(int index) {
        logger.debug("A new player is born!");
        return "Opponent" + index;
    }

    @Override
    public String chatMessage(String name) {
        int probablity = randomizer.nextInt(100);
        if (probablity <= 40){
            return "";
        } else if (probablity >= 50 && probablity <= 60) {
            return name + ": I'm feeling lucky today!";
        } else if (probablity >= 60 && probablity <= 70) {
            return name + ": I will win this game! I have the strongest cards.";
        } else if (probablity >= 70 && probablity <= 80) {
            return name + ": I must have gotten the worst cards in the deck.";
        } else if (probablity >= 80 && probablity <= 90) {
            return name + ": You're not going to expect this move!";
        } else {
            return name + ": I am the best MauMau player I know!";
        }
    }

    @Override
    public Color whatColorToWish() {
        logger.debug("The AI is choosing what color to wish!");
        // inspired by : https://stackoverflow.com/questions/1972392/pick-a-random-value-from-an-enum
        final int VALUESLENGTH = Color.values().length;
        int colorIndex = randomizer.nextInt(VALUESLENGTH);
        Color wishedColor = null;
        if (colorIndex == 0){
            wishedColor = Color.CLUB;
        }
        else if (colorIndex == 1){
            wishedColor = Color.HEART;
        }
        else if (colorIndex == 2){
            wishedColor = Color.SPADE;
        }
        else if (colorIndex == 3){
            wishedColor = Color.DIAMOND;
        }
        return wishedColor;
    }

    @Override
    public boolean saysMauMauOrForgetsTo(Player player) {
        logger.debug("Checking the AI's mau status.");
        if (player.getHand().cardList.size() == 1) {
            int probability = randomizer.nextInt(100);
            if (probability <= 80){
                return true;
            } else{
                logger.debug("AI forgot to say MauMau! (20% chance)");
                return false;
            }
        }
        return false;
    }
}
