package PackageTest.Task;

import static Modules.CorrectInputNumbers.*;

import java.util.Scanner;

import static java.lang.Math.*;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a, b, c, D, x1, x2;

        System.out.print("Введите a: ");
        a = cinDoubleNotZero(-1000, 1000);

        System.out.print("Введите b: ");
        b = cinDouble(-1000, 1000);

        System.out.print("Введите c: ");
        c = cinDouble(-1000, 1000);

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
