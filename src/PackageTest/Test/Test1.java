package PackageTest.Test;

import Modules.QuickSort;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int arr[] = {5, 8, 6, 3, 4, 2, 1, 7, 9};
        QuickSort.qs(arr, 0, 8);

        System.out.println(Arrays.toString(arr));
    }
}
