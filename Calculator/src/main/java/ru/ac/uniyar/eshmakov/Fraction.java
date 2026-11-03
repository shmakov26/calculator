package ru.ac.uniyar.eshmakov;

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

    /**
     * Функция, которая парсит строку в дробь
     * @param input строка с дробью
     * @return объект дроби
     */
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

        if (denominator < 0) {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int q = b;
            b = a % b;
            a = q;
        }

        return a;
    }

    /**
     * Сложение дробей
     * @param other второе слагаемое
     * @return результат вычислений
     */
    public Fraction add(Fraction other) {
        int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Вычитание дробей
     * @param other вычитаемое
     * @return результат вычислений
     */
    public Fraction subtract(Fraction other) {
        int newNumerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Умножение дробей
     * @param other второй множитель
     * @return результат вычислений
     */
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
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
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
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
