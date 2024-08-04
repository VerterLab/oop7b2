package start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import start.impl.ComplexCalc;
import start.util.Operators;

public class View {

    public void run() {
        List<Double> complex_1 = new ArrayList<>();
        List<Double> complex_2 = new ArrayList<>();
        System.out.println("< Complex numbers calculator >");
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter real number_1: ");
        double real1 = scan.nextDouble();
        System.out.println("Enter image number_1: ");
        double imag1 = scan.nextDouble();
        complex_1.add(real1);
        complex_1.add(imag1);

        System.out.println("Enter real number_2: ");
        double real2 = scan.nextDouble();
        System.out.println("Enter image number_2: ");
        double imag2 = scan.nextDouble();
        complex_2.add(real2);
        complex_2.add(imag2);

        String operator = getOperator();
        while (operator == null) {
            System.out.println("Entered invalid math operator. " + "Enter the math operation (*, +, /, -) : ");
            operator = getOperator();
        }
        ComplexCalc cmplCalc = new ComplexCalc(complex_1, complex_2);
        switch (operator) {
            case "+":
                cmplCalc.sum();
                break;
            case "-":
                cmplCalc.subtraction();
                break;
            case "*":
                cmplCalc.multiply();
                break;
            case "/":
                cmplCalc.divide();
                break;
            default:
                break;
        }
        System.out.println("(" + real1 + " + " + imag1 + "i" + ") " + operator + " (" + real2 + " + " + imag2 + "i"
                + ")");
        System.out.println(cmplCalc.result());
        cmplCalc.clear();
    }

    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the math operation (*, +, /, -) : ");
        String operator = in.nextLine();

        System.out.println(operator);
        while (true) {

            if (Arrays.stream(Operators.values()).anyMatch(e -> e.getOperator().equals(operator))) {
                return operator;
            } else {
                return null;
            }
        }

    }

}

