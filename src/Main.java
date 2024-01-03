import Controller.Calculator;

import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

public class Main {


    public static void main(String[] args){
        Logger logger = Logger.getLogger(Main.class.getName());
        try {
            FileHandler fh = new FileHandler("MyLog.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за политики безопасности.",
                    e);
        } catch (IOException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за ошибки ввода-вывода.",
                    e);
        }

        Calculator calculator = new Calculator();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите оператор: ");
        var operator = in.nextLine();
        System.out.println("Введите число 1: ");
        float number1 = in.nextFloat();
        System.out.println("Введите число 2: ");
        float number2 = in.nextFloat();
        in.close();

        double answer = calculator.calculate(operator, number1, number2);

        String text = String.valueOf(number1)+operator+String.valueOf(number2) +"="+ String.valueOf(answer);

        logger.log(Level.INFO, text);


        System.out.println("Результат: " + answer);
    }
}
