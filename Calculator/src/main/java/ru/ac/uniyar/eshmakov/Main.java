package ru.ac.uniyar.eshmakov;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] example = sc.nextLine().split(" ");
        List<Integer> parsExample = parser(example);
        if (parsExample.isEmpty()) {
            System.out.println("Переданно не целое число");
        }
        try {
            solution(parsExample, example[1]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Integer> parser(String[] example) {
        List<Integer> result = new ArrayList<>();
        try {
            result.add(Integer.parseInt(example[0]));
            result.add(Integer.parseInt(example[2]));
            return result;
        } catch (NumberFormatException e) {
            return new ArrayList<>();
        }
    }

    private static void solution(List<Integer> parsExample, String operand) throws Exception {
        switch (operand) {
            case "+":
                System.out.println(parsExample.get(0) + parsExample.get(1));
                break;
            case "-":
                System.out.println(parsExample.get(0) - parsExample.get(1));
                break;
            case "*":
                System.out.println(parsExample.get(0) * parsExample.get(1));
                break;
            case "/":
                if (parsExample.get(1) == 0) {
                    throw new Exception("Делить на ноль нельзя");
                }
                System.out.println(parsExample.get(0) / parsExample.get(1));
                break;
            default:
                System.out.println("Неизвестная операция");
        }
    }
}