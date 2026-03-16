package ru.ac.uniyar.eshmakov;

import java.math.BigInteger;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
    }

    private Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }
    
    private Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель должен быть не ноль");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private Fraction(Double decimal) {
        // Преобразуем double в дробь
        String decimalString = decimal.toString();

        String[] parts = decimalString.split("\\.");
        String integerPart = parts[0];
        String fractionalPart = parts[1];

        // Убираем ведущие нули из дробной части
        while (fractionalPart.endsWith("0") && fractionalPart.length() > 1) {
            fractionalPart = fractionalPart.substring(0, fractionalPart.length() - 1);
        }

        int integerNum = Integer.parseInt(integerPart);
        int fractionalNum = Integer.parseInt(fractionalPart);
        double fractionalDenom = Math.pow(10, fractionalPart.length());

        this.numerator = (int) (integerNum * fractionalDenom + fractionalNum);
        this.denominator = (int) fractionalDenom;

        simplify();
    }

    private Fraction (String str) {
        String[] parts = str.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Неправильный формат дроби");
        }
        try {
            if (Integer.parseInt(parts[1]) == 0) {
                throw new IllegalArgumentException("Знаменатель должен быть не ноль");
            }
            this.numerator = Integer.parseInt(parts[0]);
            this.denominator = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Переданы не числовые значения");
        }
        simplify();
    }

    public static Fraction parseFraction(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустая строка не может быть преобразована в дробь");
        }

        input = input.trim();

        // Проверяем, содержит ли строка "/"
        if (input.contains("/")) {
            return new Fraction(input);
        }

        // Если это десятичное число
        if (input.contains(".")) {
            return new Fraction(Double.parseDouble(input));
        }

        // Если это целое число
        return new Fraction(Integer.parseInt(input));
    }

    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;

        // Убираем знак из знаменателя
        if (denominator < 0) {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
    }

    private int gcd(int a, int b) {
        int q;

        while (true) {
            if (a > b) {
                q = a % b;
                if (q == 0) return b;
                else a = q;
            } else if (a < b) {
                q = b % a;
                if (q == 0) return a;
                else b = q;
            } else {
                return a;
            }
        }
    }

    /**
     * Сложение дробей
     * @param other второе слагаемое
     * @return результат вычислений
     */
    public Fraction add(Fraction other) {
        int numerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int denominator = this.denominator * other.denominator;
        return new Fraction(numerator, denominator);
    }

    /**
     * Вычитание дробей
     * @param other вычитаемое
     * @return результат вычислений
     */
    public Fraction subtract(Fraction other) {
        int numerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        int denominator = this.denominator * other.denominator;
        return new Fraction(numerator, denominator);
    }

    /**
     * Умножение дробей
     * @param other второй множитель
     * @return результат вычислений
     */
    public Fraction multiply(Fraction other) {
        int numerator = this.numerator * other.numerator;
        int denominator = this.denominator * other.denominator;
        return new Fraction(numerator, denominator);
    }

    /**
     * Деление дробей
     * @param other делитель
     * @return результат вычислений
     */
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        int numerator = this.numerator * other.denominator;
        int denominator = this.denominator * other.numerator;
        return new Fraction(numerator, denominator);
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        } else {
            return numerator + "/" + denominator;
        }
    }

}
