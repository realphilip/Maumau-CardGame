package de.htw.berlin.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Card {
    private Value value;
    private Color color;     //these are actually the 4 suits (types)

    public Card(Value value, Color color) {
        this.value = value;
        this.color = color;
    }

    public Card() {
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

