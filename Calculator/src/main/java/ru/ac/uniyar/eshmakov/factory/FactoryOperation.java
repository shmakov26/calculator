package ru.ac.uniyar.eshmakov.factory;

import ru.ac.uniyar.eshmakov.Fraction;
import ru.ac.uniyar.eshmakov.entit.Operation;

public abstract class FactoryOperation {

    public Fraction decision(Fraction num1, Fraction num2) {
        Operation operation = createOperation();
        return operation.solution(num1, num2);
    }

    public abstract Operation createOperation();
}
