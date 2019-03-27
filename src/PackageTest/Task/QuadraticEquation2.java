package PackageTest.Task;

import java.util.Scanner;
import static java.lang.Math.*;

public class QuadraticEquation2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c, D, x1, x2;
        System.out.print("Введите a: ");
        a = input.nextDouble();
        System.out.print("Введите b: ");
        b = input.nextDouble();
        System.out.print("Введите c: ");
        c = input.nextDouble();

        D = pow(b, 2) - 4 * a * c;
        if (D > 0) {
            x1 = (-b + pow(D, 0.5))/(2 * a);
            x2 = (-b - pow(D, 0.5))/(2 * a);
            System.out.println("Корни: " + x1 + " и " + x2);
        } else if (D == 0) {
            x1 = (-b)/(2 * a);
            System.out.println("Корень: " + x1);
        }else if (D < 0) {
            System.out.println("Корней нет");
        }
    }
}
