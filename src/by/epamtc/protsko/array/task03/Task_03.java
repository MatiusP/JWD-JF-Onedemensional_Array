package by.epamtc.protsko.array.task03;

import java.util.Arrays;

public class Task_03 {
    private static int indexFirstElement;
    private static int indexSecondElement;

    private static void findIndexFirstAndSecondSequenceElement(int[] startCodeSequence) {
        boolean flag = true;
        for (int i = 0; i < startCodeSequence.length; i++) {
            if (startCodeSequence[i] != 0) {
                if (flag) {
                    indexFirstElement = i;
                    flag = false;
                } else {
                    indexSecondElement = i;
                    break;
                }
            }
        }
    }

    private static boolean isInputCombinationValid(int[] startCodeSequence) {
        findIndexFirstAndSecondSequenceElement(startCodeSequence);

        if ((startCodeSequence[indexFirstElement] + startCodeSequence[indexSecondElement]) > 10
                || (startCodeSequence[indexFirstElement] + startCodeSequence[indexSecondElement]) < 4) {
            return false;
        } else if ((startCodeSequence[indexFirstElement] < 1 || startCodeSequence[indexFirstElement] > 6)
                || (startCodeSequence[indexSecondElement] < 1 || startCodeSequence[indexSecondElement] > 6)) {
            return false;
        } else if ((indexSecondElement - indexFirstElement) < 3 &&
                (startCodeSequence[indexFirstElement] + startCodeSequence[indexSecondElement]) == 10) {
            return false;
        } else if (((indexSecondElement - indexFirstElement) % 3 == 0) &&
                (startCodeSequence[indexFirstElement] != startCodeSequence[indexSecondElement])) {
            return false;
        }
        return true;
    }


    public static int[] lockCode(int[] startCodeSequence) {
        int[] lockCode = {};
        if (isInputCombinationValid(startCodeSequence)) {
            lockCode = startCodeSequence;

            if ((indexSecondElement - indexFirstElement) <= 3) {
                if (lockCode[indexFirstElement + 1] == 0 && lockCode[indexSecondElement - 1] == 0) {
                    lockCode[indexSecondElement - 1] = (10 - lockCode[indexSecondElement]) / 2;
                    indexSecondElement -= 1;
                }
            }

            while (true) {
                if ((indexFirstElement - 3) >= 0) {
                    lockCode[indexFirstElement - 3] = lockCode[indexFirstElement];
                    indexFirstElement -= 3;
                } else if ((indexSecondElement - 3) >= 0) {
                    lockCode[indexSecondElement - 3] = lockCode[indexSecondElement];
                    indexSecondElement -= 3;
                } else {
                    break;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (lockCode[i] == 0) {
                    lockCode[i] = (10 - lockCode[0] - lockCode[1] - lockCode[2]);
                    break;
                }
            }

            for (int i = 3; i < lockCode.length; i++) {
                if (lockCode[i] == 0) {
                    lockCode[i] = lockCode[i - 3];
                }
            }
            return lockCode;
        }

        System.out.println("Invalid input combination. It's impossible to get the lock code!");
        return lockCode;

    }

    //----- check result -----
    public static void main(String[] args) {
        int[] sequence1 = {0, 4, 0, 0, 4, 0, 0, 0, 3, 0};
        int[] sequence2 = {0, 4, 0, 0, 1, 0, 0, 0, 0, 0};
        int[] sequence3 = {0, 4, 0, 0, 0, 0, 0, 0, 0, 5};
        int[] sequence5 = {0, 0, 3, 1, 0, 0, 0, 0, 0, 0};
        int[] sequence6 = {0, 0, 0, 0, 0, 2, 3, 0, 0, 0};
        int[] sequence7 = {5, 0, 0, 0, 0, 0, 0, 0, 0, 4};
//        int[] sequence8 = {5, 5, 0, 0, 0, 0, 0, 0, 0, 0};
//        int[] sequence9 = {5, 0, 0, 4, 0, 0, 0, 0, 0,};
//        int[] sequence10 = {5, 0, 0, 0, 0, 0, 0, 0, 0, 6};
//        int[] sequence11 = {8, -6, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println("Lock code: " + Arrays.toString(lockCode(sequence1)));
        System.out.println("Lock code: " + Arrays.toString(lockCode(sequence2)));
        System.out.println("Lock code: " + Arrays.toString(lockCode(sequence3)));
        System.out.println("Lock code: " + Arrays.toString(lockCode(sequence5)));
        System.out.println("Lock code: " + Arrays.toString(lockCode(sequence6)));
        System.out.println("Lock code: " + Arrays.toString(lockCode(sequence7)));
//        System.out.println(Arrays.toString(getLockCode(sequence8)));
//        System.out.println(Arrays.toString(getLockCode(sequence9)));
//        System.out.println(Arrays.toString(getLockCode(sequence10)));
//        System.out.println(Arrays.toString(getLockCode(sequence11)));
    }
}
