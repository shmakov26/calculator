package ru.ac.uniyar.eshmakov;

public class Fraction {
    private Integer numerator;
    private Integer denominator;

    public Fraction(Integer numerator, Integer denominator) throws IllegalAccessException {
        if (denominator == 0) {
            throw new IllegalAccessException("Знаменатель должен быть не ноль");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(Integer numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction (String str) throws IllegalAccessException {
        if (str.contains("/")) {
            String[] parts = str.split("/");
            if (parts.length != 2) {
                throw new IllegalAccessException("Неправильный формат дроби");
            }
            this.numerator = Integer.parseInt(parts[0]);
            this.denominator = Integer.parseInt(parts[1]);
        } else {
            this.numerator = Integer.parseInt(str);
            this.denominator = 1;
        }
    }




}
