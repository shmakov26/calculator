package ru.ac.uniyar.eshmakov.factory;

import ru.ac.uniyar.eshmakov.entit.MultiplyOperation;
import ru.ac.uniyar.eshmakov.entit.Operation;

public class FactoryMultiplyOperation extends FactoryOperation {
    @Override
    public Operation createOperation() {
        return new MultiplyOperation();
    }
}
