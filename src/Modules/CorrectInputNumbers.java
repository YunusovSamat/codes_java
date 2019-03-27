package Modules;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CorrectInputNumbers {
    public static int cinInt(int to, int till) {
        Scanner input = new Scanner(System.in);

        String str;
        int i = 0;

        while (true) {
            /*str = input.nextLine();

            if (str.matches("[-]?[0-9]")) {
                i = Integer.parseInt(str);

                if ((i >= to) && (i <= till)) return i;
                else {
                    System.out.print("Число должно быть в диапазоне от " + to +
                            " до " + till + ".\nВведите корректное число: ");
                }
            } else {
                System.out.print("Некорректное число " + "(допустимые символы:" +
                        " 0-9; \'-\').\nВведите корректное число: ");
            }*/

            try {
                i = input.nextInt();

                if ((i >= to) && (i <= till)) return i;
                else {
                    System.out.print("Число должно быть в диапазоне от " + to +
                            " до " + till + ".\nВведите корректное число: ");
                    continue;
                }
            }
            catch (InputMismatchException exc) {
                System.out.print("Некорректное число " + "(допустимые символы:" +
                        " 0-9; \'-\').\nВведите корректное число: ");
                str = input.next();
            }
        }


    }


    public static double cinDouble(double to, double till) {
        Scanner input = new Scanner(System.in);

        double d;

        while (true) {
            d = 0;
            try {
                d = input.nextDouble();

                if ((d >= to) && (d <= till)) return d;
                else {
                    System.out.print("Число должно быть в диапазоне от " + to +
                            " до " + till + ".\nВведите корректное число: ");
                    continue;
                }
            }
            catch (InputMismatchException exc) {
                System.out.print("Некорректное число " + "(допустимые символы:" +
                        " 0-9; \',\'; \'-\' ).\nВведите корректное число: ");
                input.next();
            }
        }
    }


    public static double cinDoubleNotZero(double to, double till) {
        Scanner input = new Scanner(System.in);

        double d;

        while (true) {
            d = 0;
            try {
                d = input.nextDouble();

                if ((d >= to) && (d <= till) && (d != 0)) return d;
                else {
                    System.out.print("Число должно быть в диапазоне от " + to +
                            " до " + till + "  и не равно 0.\nВведите корректное число: ");
                    continue;
                }
            }
            catch (InputMismatchException exc) {
                System.out.print("Некорректное число " + "(допустимые символы:" +
                        " 0-9; \',\'; \'-\' ).\nВведите корректное число: ");
                input.next();
            }
        }
    }
}
