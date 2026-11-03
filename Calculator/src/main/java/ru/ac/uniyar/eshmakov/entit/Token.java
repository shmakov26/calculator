package ru.ac.uniyar.eshmakov.entit;

public class Token {
    public enum Type { NUMBER, OPERATOR, L_PAREN, R_PAREN }

    private final Type type;
    private final String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() { return type; }
    public String getValue() { return value; }

    @Override
    public String toString() { return value; }
}
