package by.epamtc.protsko.array.task03;

public class Task_01 {

    public static double getMaxSum(double[] array) {
        double maxSum = 0;
        if (array.length > 2) {
            maxSum = array[0] + array[array.length - 1];
            for (int i = 1; i < array.length / 2; i++) {
                double sumElements = array[i] + array[array.length - (i + 1)];
                if (sumElements > maxSum) {
                    maxSum = sumElements;
                }
            }
            return maxSum;
        } else {
            System.out.println("Cannot find the result for the transmitted sequence of numbers");
            return maxSum;
        }
    }

    //----- check result -----
    public static void main(String[] args) {
        double[] array = {-5, 6, -10, -20, 0, 17, 30, 16};
        double[] array1 = {1, 5, 2, 4, 6, 3, 8, 0, 3, 4};
        double[] array2 = {1, 5, 2, 4, 20, 3, 8, 0, 3};
        double[] array3 = {10};

        System.out.println(getMaxSum(array));
        System.out.println(getMaxSum(array1));
        System.out.println(getMaxSum(array2));
        System.out.println(getMaxSum(array3));
    }
}
