package Modules;

public class QuickSort {
    public static void qs(int[] mas, int left, int right) {
        int i, j, x, y;

        i = left;
        j = right;
        x = mas[(left+right) / 2];

        do {
            while ((mas[i] < x) && (i < right)) i++;
            while ((x < mas[j]) && (j > left)) j--;

            if (i <= j) {
                y = mas[i];
                mas[i] = mas[j];
                mas[j] = y;
                i++; j--;
            }
        } while (i <= j);

        if (left < j) qs(mas, left, j);
        if (i < right) qs(mas, i, right);
    }
}
