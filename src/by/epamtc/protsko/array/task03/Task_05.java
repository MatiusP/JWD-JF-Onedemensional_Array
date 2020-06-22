package by.epamtc.protsko.array.task03;

public class Task_05 {

    public static double getSumMinMaxElement(double[] array) {
        if (array.length > 1) {
            double minElement = array[0];
            double maxElement = array[1];

            for (int i = 0; i < array.length; i++) {
                if (i % 2 == 0) {
                    if (array[i] < minElement) {
                        minElement = array[i];
                    }
                } else {
                    if (array[i] > maxElement) {
                        maxElement = array[i];
                    }
                }
            }
            return (maxElement + minElement);
        } else {
            System.out.println("Impossible to calculate result! The array contains " + array.length + " element.");
            return Double.NaN;
        }
    }

    //----- check result -----
    public static void main(String[] args) {
        double[] array1 = {1, 2, 3, 3, 2, 1};
        double[] array2 = {-10, 5, 10, -10, -10, -10, -5};
        double[] array3 = {};

        System.out.println(getSumMinMaxElement(array1));
        System.out.println(getSumMinMaxElement(array2));
        System.out.println(getSumMinMaxElement(array3));
    }

}
