package ru.ac.uniyar.eshmakov.factory;

import ru.ac.uniyar.eshmakov.entit.Operation;
import ru.ac.uniyar.eshmakov.entit.SubtractOperation;

public class FactorySubtractOperation extends FactoryOperation{
    @Override
    public Operation createOperation() {
        return new SubtractOperation();
    }
}
