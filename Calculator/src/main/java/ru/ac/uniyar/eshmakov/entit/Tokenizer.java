package ru.ac.uniyar.eshmakov.entit;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public static List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        int i = 0;
        int n = input.length();
        boolean expectOperand = true; // в начале ожидаем число или '('

        while (i < n) {
            char c = input.charAt(i);

            if (Character.isWhitespace(c)) { i++; continue; }

            if (c == '(') {
                tokens.add(new Token(Token.Type.L_PAREN, "("));
                expectOperand = true;
                i++;
                continue;
            }
            if (c == ')') {
                tokens.add(new Token(Token.Type.R_PAREN, ")"));
                expectOperand = false;
                i++;
                continue;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                // '/' может быть частью дроби, если мы ожидаем операнд — это не наш случай,
                // дробь начинается с цифры или унарного минуса
                if (expectOperand && (c == '-' || c == '+')) {
                    // унарный знак — считываем число вместе со знаком
                    int start = i;
                    i++;
                    // пропускаем возможные пробелы? нет — знак должен прилипать к числу
                    int numStart = i;
                    i = readNumber(input, i);
                    if (i == numStart) {
                        throw new IllegalArgumentException("Ожидалось число после унарного знака");
                    }
                    String value = input.substring(start, i).replaceAll("\\s+", "");
                    tokens.add(new Token(Token.Type.NUMBER, value));
                    expectOperand = false;
                    continue;
                }
                if (expectOperand) {
                    throw new IllegalArgumentException("Неожиданный оператор: " + c);
                }
                tokens.add(new Token(Token.Type.OPERATOR, String.valueOf(c)));
                expectOperand = true;
                i++;
                continue;
            }

            // иначе — число (целое, десятичное или дробь)
            if (Character.isDigit(c) || c == '.') {
                if (!expectOperand) {
                    throw new IllegalArgumentException("Ожидался оператор, получено число");
                }
                int start = i;
                i = readNumber(input, i);
                tokens.add(new Token(Token.Type.NUMBER, input.substring(start, i)));
                expectOperand = false;
                continue;
            }

            throw new IllegalArgumentException("Недопустимый символ: " + c);
        }
        return tokens;
    }

    private static int readNumber(String s, int i) {
        int n = s.length();
        while (i < n && Character.isDigit(s.charAt(i))) i++;
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) i++;
        }
        if (i < n && s.charAt(i) == '/') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) i++;
        }
        return i;
    }
}