package by.epamtc.protsko.array.task03;

import java.util.Arrays;

public class Task_02 {
    private static int countOfMinimumElements;

    private static int minArrayElement(int[] array) {
        countOfMinimumElements = 0;
        int minElement = array[0];

        for (int element : array) {
            if (element < minElement) {
                minElement = element;
                countOfMinimumElements = 1;
            } else if (element == minElement) {
                countOfMinimumElements++;
            }
        }
        return minElement;
    }


    public static int[] arrayWithoutMinElements(int[] array) {
        int[] newArray;

        if (array.length > 1) {
            int minArrayElement = minArrayElement(array);
            newArray = new int[array.length - countOfMinimumElements];
            int indexElementNewArray = 0;

            for (int element : array) {
                if (element != minArrayElement) {
                    newArray[indexElementNewArray] = element;
                    indexElementNewArray++;
                }
            }
        } else {
            System.out.println("It's impossible to find minimum elements" +
                    " because the array contains " + array.length + " element.");
            return new int[0];
        }
        return newArray;
    }


    //----- check result -----
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 3, 2, 1};
        int[] array2 = {-10, 5, 10, -10, -10, -10, -5};
        int[] array3 = {-10};

        System.out.println(Arrays.toString(arrayWithoutMinElements(array1)));
        System.out.println(Arrays.toString(arrayWithoutMinElements(array2)));
        System.out.println(Arrays.toString(arrayWithoutMinElements(array3)));
    }
}
