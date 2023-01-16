package de.htw.berlin.controller;
import de.htw.berlin.view.InterfaceView;
import org.apache.logging.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainControllerImpl implements Main{
    private Scanner scanner = new Scanner(System.in);
    private InterfaceView viewer = new InterfaceView();
    Logger logger;

    /**
     * The method to run the game.
     */
    @Override
    public void run(
            EntityManagerFactory entityManagerFactory = Persistence
    ) {
        //incomplete
    }

    /**
     * This is the first input type - a number within a specified range (ex. 1-6)
     * Forces a redo
     *
     * @param inputRangeMin - bottom of the input range. 1-based counting
     * @param inputRangeMax - top of the numerical input range. 1-based counting
     * @return - the exact number put in
     */
    private int inputTypeNumber(int inputRangeMin, int inputRangeMax) {
        logger.debug("Reading numerical input.");
        String rawInput;
        boolean isBadInput;
        int input = 0;
        //checking for bad inputs, else loop again
        do {
            rawInput = scanner.next();
            try {
                isBadInput = false;
                input = Integer.parseInt(rawInput);
            } catch (java.lang.NumberFormatException e) {
                isBadInput = true;
                viewer.badNumberInputMessage();
                logger.debug("Invalid numerical input. Prompt to try again.");
                //attempt again - prints message
            }
        } while (isBadInput);
        return input;
    }

    /**
     * This is the second input type - a y (yes) or n (no) question represented by a boolean, in which true is y
     * Forces a redo
     * @return - true is y, n is false;
     */
    private boolean inPutTypeYN() {
        logger.debug("Reading y/n input.");
        boolean isYes = false;
        //using the BadInput approach from the method above - repeats until valid input is received.
        boolean isBadInput = true;

        while (isBadInput) {
            String rawInput = scanner.next();
            rawInput = rawInput.toUpperCase();
            if (rawInput.equals("Y")) {
                isYes = true;
                isBadInput = false;
            } else if (rawInput.equals("N")) {
                isYes = false;
                isBadInput = false;
            } else {
                viewer.badYNInputMessage();
            }
        }
        return isYes;
    }


}
