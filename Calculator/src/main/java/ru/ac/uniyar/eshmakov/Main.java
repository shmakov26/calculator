package ru.ac.uniyar.eshmakov;

import ru.ac.uniyar.eshmakov.entit.Task;
import ru.ac.uniyar.eshmakov.factory.*;

import java.util.Scanner;

public class Main {
    private static FactoryOperation factoryOperation;

    public static void main(String[] args) {
        Task task;
        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);
            String[] example = sc.nextLine().split(" ");
            sc.close();
            task = Task.parser(example);
        } else {
            task = Task.parser(args);
        }
        determineOperation(task.getOperand());
        System.out.println(factoryOperation.decision(task.getNum1(), task.getNum2()));
    }

    private static void determineOperation(String operand) {
        switch (operand) {
            case "+":
                factoryOperation = new FactoryAddOperation();
                break;
            case "-":
                factoryOperation = new FactorySubtractOperation();
                break;
            case "*":
                factoryOperation = new FactoryMultiplyOperation();
                break;
            case "/":
                factoryOperation = new FactoryDivideOperation();
                break;
            default:
                System.out.println("Неизвестная операция");
        }
    }
}