package ru.ac.uniyar.eshmakov;

import ru.ac.uniyar.eshmakov.entit.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);
            String[] example = sc.nextLine().split(" ");
            sc.close();
            task = Task.parser(example);
        } else {
            task = Task.parser(args);
        }
        solution(task);
    }

    private static void solution(Task task) {
        Fraction num1 = task.getNum1();
        Fraction num2 = task.getNum2();
        switch (task.getOperand()) {
            case "+":
                System.out.println(num1.add(num2));
                break;
            case "-":
                System.out.println(num1.subtract(num2));
                break;
            case "*":
                System.out.println(num1.multiply(num2));
                break;
            case "/":
                System.out.println(num1.divide(num2));
                break;
            default:
                System.out.println("Неизвестная операция");
        }
    }
}