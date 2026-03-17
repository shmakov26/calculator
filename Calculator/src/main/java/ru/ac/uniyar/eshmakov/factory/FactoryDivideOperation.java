package ru.ac.uniyar.eshmakov.factory;

import ru.ac.uniyar.eshmakov.entit.DivideOperation;
import ru.ac.uniyar.eshmakov.entit.Operation;

public class FactoryDivideOperation extends FactoryOperation {
    @Override
    public Operation createOperation() {
        return new DivideOperation();
    }
}
