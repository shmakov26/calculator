package ru.ac.uniyar.eshmakov.entit;

import java.util.*;

public class Converter {

    private static int precedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> throw new IllegalArgumentException("Неизвестный оператор: " + op);
        };
    }

    public static List<Token> toRPN(List<Token> tokens) {
        List<Token> output = new ArrayList<>();
        Deque<Token> stack = new ArrayDeque<>();

        for (Token t : tokens) {
            switch (t.getType()) {
                case NUMBER:
                    output.add(t);
                    break;
                case OPERATOR:
                    while (!stack.isEmpty()
                            && stack.peek().getType() == Token.Type.OPERATOR
                            && precedence(stack.peek().getValue()) >= precedence(t.getValue()))
                    {
                        output.add(stack.pop());
                    }
                    stack.push(t);
                    break;
                case L_PAREN:
                    stack.push(t);
                    break;
                case R_PAREN:
                    while (!stack.isEmpty() && stack.peek().getType() != Token.Type.L_PAREN) {
                        output.add(stack.pop());
                    }
                    if (stack.isEmpty()) {
                        throw new IllegalArgumentException("Несбалансированные скобки");
                    }
                    stack.pop(); // убираем '('
                    break;
            }
        }
        while (!stack.isEmpty()) {
            Token t = stack.pop();
            if (t.getType() == Token.Type.L_PAREN) {
                throw new IllegalArgumentException("Несбалансированные скобки");
            }
            output.add(t);
        }
        return output;
    }
}
