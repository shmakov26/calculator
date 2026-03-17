package ru.ac.uniyar.eshmakov.factory;

import ru.ac.uniyar.eshmakov.entit.AddOperation;
import ru.ac.uniyar.eshmakov.entit.Operation;

public class FactoryAddOperation extends FactoryOperation {

    @Override
    public Operation createOperation() {
        return new AddOperation();
    }
}
