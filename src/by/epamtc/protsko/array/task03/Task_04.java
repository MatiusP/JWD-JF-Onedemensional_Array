package by.epamtc.protsko.array.task03;

public class Task_04 {

    private static int[] frequencyOfOccurrenceElements(int[] array) {
        int[] arrayOfFrequencyOccurrenceElements = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int elementFrequency = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    elementFrequency++;
                }
            }
            arrayOfFrequencyOccurrenceElements[i] = elementFrequency;
        }
        return arrayOfFrequencyOccurrenceElements;
    }

    public static int mostFrequencyElement(int[] array) {
        int[] arrayOfFrequencyOccurrenceElements = frequencyOfOccurrenceElements(array);
        int maxFrequency = arrayOfFrequencyOccurrenceElements[0];
        int countMaxFrequencyOccurrenceElements = 0;

        for (int frequencyOccurrenceElement : arrayOfFrequencyOccurrenceElements) {
            if (frequencyOccurrenceElement > maxFrequency) {
                maxFrequency = frequencyOccurrenceElement;
                countMaxFrequencyOccurrenceElements = 1;
            } else if (frequencyOccurrenceElement == maxFrequency) {
                countMaxFrequencyOccurrenceElements++;
            }
        }

        boolean flag = true;
        int minElement = 0;
        for (int i = 0; i < arrayOfFrequencyOccurrenceElements.length; i++) {
            if (arrayOfFrequencyOccurrenceElements[i] == maxFrequency) {
                if (countMaxFrequencyOccurrenceElements == 1) {
                    return array[i];
                } else {
                    if (flag) {
                        minElement = array[i];
                        flag = false;
                    } else {
                        if (array[i] < minElement) {
                            minElement = array[i];
                        }
                    }
                }
            }
        }
        return minElement;
    }


    //----- check result -----
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 8, 9, 5, 6, 7, 5, 1, 1, 1};
        int[] array1 = {1, 1, -1, -1, -1, 3, 3, -5, -5, -5, 7};
        int[] array2 = {1, 0};

        System.out.println("Minimum element from the most common = " + mostFrequencyElement(array));
        System.out.println("Minimum element from the most common = " + mostFrequencyElement(array1));
        System.out.println("Minimum element from the most common = " + mostFrequencyElement(array2));
    }
}
