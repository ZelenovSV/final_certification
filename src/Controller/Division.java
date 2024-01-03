package Controller;

public class Division implements Operation {
    @Override
    public double execute(double number1, double number2) {
        if (number2 == 0){throw new IllegalArgumentException("Делить на ноль нельзя!!!");}
        return number1 / number2;
    }
}
