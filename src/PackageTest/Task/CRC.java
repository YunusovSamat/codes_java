package PackageTest.Task;

import java.util.Arrays;
import static java.lang.Math.*;

public class CRC {
    private static final int k = 100;                                           // длина сообщения
    private static final int n = 65;                                            // длина полинома
    private static final int w = n - 1;                                         // позиция самого старшего бита
    private static final byte[] origPolinom = {64, 62, 57, 55, 54, 53, 52, 47,  //необработанный полином
                                               46, 45, 40, 39, 38, 37, 35, 33,
                                               32, 31, 29, 27, 24, 23, 22, 21,
                                               19, 17, 13, 12, 10, 9, 7, 4, 1,
                                                0};
//    private static final byte[] origPolinom = {4, 1, 0};


    public static void main(String[] args) {
        System.out.print("------------------------------------------------");
        System.out.print("------ Вычисление CRC ------");
        System.out.println("------------------------------------------------");

        byte[] origMess = generationOrigMess();                                 // исходное сообщение
//        byte[] origMess = {1, 1, 0, 1, 0, 1, 1, 0, 1, 1};
        System.out.println("Исходное сгенерированное сообщение:");
        outputArray(origMess);                                                  // вывод исходного сообщения

        byte[] polynomial = generationPolynomial();                             // полином
        System.out.println("Образующий полином:");
        outputArray(polynomial);                                                // вывод полинома

        byte[] messZeros = Arrays.copyOf(origMess, k + w);           // сообщение дополненное W нулями
        System.out.println("Сообщение, дополненое " + w + " битами:");
        outputArray(messZeros);                                                 // вывод сообщения с нулями

        byte[] CRC = modulo(messZeros, polynomial);                             // контрольная сумма
        System.out.println("Контрольная сумма:");
        outputArray(CRC);                                                       // вывод контрольной суммы

        System.out.print("------------------------------------------------");
        System.out.print("--------- Проверка ---------");
        System.out.println("------------------------------------------------");

        byte[] totalMess = Arrays.copyOf(origMess, messZeros.length);           // конечное сообщение
        System.arraycopy(CRC, 0, totalMess, origMess.length, CRC.length);// копирование CRC в totalMess на origMess.length позицию
        System.out.println("Конечное сообщение:");
        outputArray(totalMess);                                                 // вывод конечного сообщения

        byte[] residueArr = modulo(totalMess, polynomial);                      // массив остатка от деления

        int residue = 0;                                                        // останок от деления
        int i = residueArr.length;
        for (byte x: residueArr) {                                              // перевод из массива в число
            residue += x * i;
            i--;
        }

        System.out.println("Остаток от конечного сообщения:\n" + residue);

        if (residue == 0) {
            System.out.println("Функционал, реализующий вычисление CRC работает корректно.");
        } else System.out.println("Функционал, реализующий вычисление CRC работает не корректно.");
    }


    public static byte[] generationOrigMess() {                                 // метод генерации исходного сообщения
        byte[] array = new byte[k];

        for (int i = 0; i < k; i++) {                                           // присвоить каждому элементу случайное число
            array[i] = (byte)round(random());
        }
        return array;
    }


    public static void outputArray(byte[] array) {                              // метод вывода массива
        int count = 0;
        for (byte x: array) {
            if (count % 100 == 0 && (count != 0)) {                             // переносить на новую строку
                System.out.println();
            } else if (count % 4 == 0 && (count != 0)) {                        // ставить точки для читабельности
                System.out.print(".");
            }

            System.out.print(x);
            count++;
        }
        System.out.println();
    }


    public static byte[] generationPolynomial() {                               // метод генерации полинома
        byte[] array = new byte[n];

        for (byte x: origPolinom) {
            array[n-1-x] = 1;
        }
        return array;
    }


    public static byte[] xorArray(byte[] x, byte[] y) {                         // метод исключающее ИЛИ массивов
        byte[] z = new byte[x.length];
        for (int i = 0; i < z.length; i++) {
            z[i] = (byte)(x[i] ^ y[i]);
        }
        return z;
    }


    public static byte[] leftShift(byte[] array) {                              // метод сдвига массива на один бит влево
        array = Arrays.copyOfRange(array, 1, array.length + 1);
        return array;
    }


    public static byte[] modulo(byte[] x, byte[] y) {                           // метод вычисления остатка от деления
        byte[] register = new byte[w];                                          // регистр
        byte[] p = Arrays.copyOfRange(y, 1, y.length);                    // полином без старшего бита
        byte primary;                                                           // старший бит регистра

        for (byte a: x) {
            primary = register[0];                                              // запоминаем старший бит регистра
            register = leftShift(register);                                     // сдвигаем регистр на один бит влево
            register[register.length-1] = a;                                    // присваиваем регистру младшего бита 1 бит сообщения

            if (primary == 1) {                                                 // если старший бит регистра 1
                register = xorArray(register, p);                               // то произвести операцию XOR
            }
        }

        return register;
    }
}
