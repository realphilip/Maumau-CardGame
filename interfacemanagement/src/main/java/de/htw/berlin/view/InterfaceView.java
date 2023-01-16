package de.htw.berlin.view;

import java.sql.SQLOutput;

public class InterfaceView {

    //prints a placeholder for definition purposes.
    public void printLogo() {
        System.out.println();
        System.out.println("-------------------------MAUMAU############MAUMAU--------------------------");
        System.out.println();
    }

    //upon invalid inputs, prompts user to put in either yes or no.
    public void invalidInputYesNo() {
        System.out.println("Youve inputted an invalid answer. Choose either yes or no.");
    }

    //shows the rules of the game to new players.
    public void listRules() {
        System.out.println("Thank you for choosing to play this game.\n" +
                "Choose from either normal or special rules:" +
                "NORMAL RULES\n" +
                "Cards can only be played if either the color or the value matches the deck\n" +
                "if its a players turn but that player doesnt have a card, he draws, and the direction is always clockwise\n" +
                "if a player wants to place his last 2 cards, he has to input MAU, otherwise draw 2 cards\n");
        System.out.println("\n" +
                "THE SPECIAL RULES \n" +
                "Players who play Jack get to wish a color " +
                "and a Nine changes the direction of the game.\n" +
                "A seven means the next player has to draw two cards\n" +
                "and an Eight skips the next person.\n"
        );
    }
}

