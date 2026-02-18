package ru.ac.uniyar.eshmakov;

public class Task {
    private Fraction num1;
    private Fraction num2;
    private String operand;

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
}
