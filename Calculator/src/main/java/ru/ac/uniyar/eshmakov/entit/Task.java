package ru.ac.uniyar.eshmakov.entit;

import ru.ac.uniyar.eshmakov.Fraction;

public class Task {
    private Fraction num1;
    private Fraction num2;
    private String operand;

    public Task() {
    }

    public Task (Fraction num1, Fraction num2, String operand) {
        this.num1 = num1;
        this.num2 = num2;
        this.operand = operand;
    }

    public Fraction getNum1() {
        return num1;
    }

    public Fraction getNum2() {
        return num2;
    }

    public String getOperand() {
        return operand;
    }

    public static Task parser(String[] example) {
        return new Task(Fraction.parseFraction(example[0]), Fraction.parseFraction(example[2]), example[1]);
    }

    @Override
    public String toString() {
        return num1.toString() + " " + operand + " " + num2.toString();
    }
}
