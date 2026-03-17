package ru.ac.uniyar.eshmakov.entit;

import ru.ac.uniyar.eshmakov.Fraction;

public class AddOperation implements Operation {

    @Override
    public Fraction solution(Fraction num1, Fraction num2) {
        return num1.add(num2);
    }
}
