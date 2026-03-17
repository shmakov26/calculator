package ru.ac.uniyar.eshmakov.entit;

import ru.ac.uniyar.eshmakov.Fraction;

public class SubtractOperation implements Operation {

    @Override
    public Fraction solution(Fraction num1, Fraction num2) {
        return num1.subtract(num2);
    }
}
