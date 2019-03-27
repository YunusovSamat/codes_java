package PackageTest.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestXO {

    // Игровое поле
    public static char[][] field =
            {   { '+', '+', '+' },
                    { '+', '+', '+' },
                    { '+', '+', '+' } };

    // Ход компьютера (random-бот)
    public static void CompMove() {
        int x = (int) (Math.random() * 3), y = (int) (Math.random() * 3);
        while (field[x][y] == '0' || field[x][y] == 'X') {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        }
        field[x][y] = '0';
    }

    // Ход человека
    public static void HumanMove() throws IOException {
        int x = -1, y = -1;
        System.out.println("Enter y (1..3):");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        x = Integer.parseInt(br.readLine())-1;
        System.out.println("Enter x (1..3):");
        y = Integer.parseInt(br.readLine())-1;
        while (field[x][y] == '0' || field[x][y] == 'X' || x < 0 || x > 2
                || y < 0 || y > 2) {
            System.out.println("Enter y:");
            x = Integer.parseInt(br.readLine())-1;
            System.out.println("Enter x:");
            y = Integer.parseInt(br.readLine())-1;
        }
        field[x][y] = 'X';
    }

    // Вывод игрового поля на экран
    public static void PrintField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    // Проерка состояния игры и есть ли победители
    // возвращает символ победителя или символ пробела если пока никто не
    // выиграл
    public static char CheckGame() {
        char winner = ' ';
        // Проверка по горизонтали
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2]
                    && field[i][0] != '+') {
                winner = field[i][0];
                break;
            }
        }

        // Проверка по вертикали если победитель пока не найден
        if (winner == ' ') {
            for (int i = 0; i < 3; i++) {
                if (field[0][i] == field[1][i] && field[1][i] == field[2][i]
                        && field[0][i] != '+') {
                    winner = field[0][i];
                    break;
                }
            }
        }

        // Проверка главной диагонали если победитель пока не найден
        if (winner == ' ') {
            if (field[0][0] == field[1][1] && field[1][1] == field[2][2]
                    && field[0][0] != '+') {
                winner = field[0][0];
            }
        }

        // Проверка побочной диагонали если победитель пока не найден
        if (winner == ' ') {
            if (field[0][2] == field[1][1] && field[1][1] == field[2][0]
                    && field[0][2] != '+') {
                winner = field[0][0];
            }
        }
        // Возвращаем победителя или проебл, если такового пока нет
        return winner;
    }

    // Проверяем, остались ли еще ходы
    public static boolean CanMove() {
        boolean p = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == '+') {
                    p = true;
                    break;
                }
            }
            if (p = true) {
                break;
            }
        }
        return p;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Game Started!!!");
        PrintField();
        while (CheckGame() == ' ' && CanMove()) {
            HumanMove();
            CompMove();
            PrintField();
        }
        if (CheckGame() == 'X') {
            System.out.println("YOU WIN!");
        }
        if (CheckGame() == '0') {
            System.out.println("YOU LOSE!");
        }
        if (CheckGame() == ' ' && !CanMove()) {
            System.out.println("STANDOFF!");
        }
    }

}