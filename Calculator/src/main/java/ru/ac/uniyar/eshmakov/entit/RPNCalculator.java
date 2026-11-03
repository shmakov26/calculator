package ru.ac.uniyar.eshmakov.entit;

import ru.ac.uniyar.eshmakov.Fraction;
import ru.ac.uniyar.eshmakov.factory.*;

import java.util.*;

public class RPNCalculator {

    public static Fraction evaluate(List<Token> rpn) {
        Deque<Fraction> stack = new ArrayDeque<>();

        for (Token t : rpn) {
            if (t.getType() == Token.Type.NUMBER) {
                stack.push(Fraction.parseFraction(t.getValue()));
            } else if (t.getType() == Token.Type.OPERATOR) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Недостаточно операндов для " + t.getValue());
                }
                Fraction b = stack.pop();
                Fraction a = stack.pop();
                FactoryOperation factory = factoryFor(t.getValue());
                stack.push(factory.decision(a, b));
            } else {
                throw new IllegalArgumentException("Некорректный токен в ОПН: " + t);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Некорректное выражение");
        }
        return stack.pop();
    }

    public static FactoryOperation factoryFor(String op) {
        return switch (op) {
            case "+" -> new FactoryAddOperation();
            case "-" -> new FactorySubtractOperation();
            case "*" -> new FactoryMultiplyOperation();
            case "/" -> new FactoryDivideOperation();
            default -> throw new IllegalArgumentException("Неизвестная операция: " + op);
        };
    }

    public static Fraction calculate (String example) {
        try {
            System.out.println("Пример: " + example);
            List<Token> tokens = Tokenizer.tokenize(example);
            List<Token> rpn = Converter.toRPN(tokens);
            System.out.println("ОПН: " + rpn);
            Fraction resalt = RPNCalculator.evaluate(rpn);
            System.out.println("Ответ: " + resalt);
            System.out.println();
            return resalt;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}