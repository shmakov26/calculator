package ru.ac.uniyar.eshmakov;

import ru.ac.uniyar.eshmakov.entit.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String example;
        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);
            example = sc.nextLine();
            sc.close();
        } else {
            example = String.join(" ", args);
        }

        try {
            RPNCalculator.calculate(example);
        } catch (RuntimeException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}