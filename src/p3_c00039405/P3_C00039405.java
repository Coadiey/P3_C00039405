// Your Name: Coadiey Bryan
// Your ID: C00039405
// CMPS 261
// Programming Project: #3
// Due Date : 9/13/18 11:00 p.m.
// Program Description: Using Recursion and sorting algorithms to sort lists.
// calling them with main function.
// Certificate of Authenticity:
// I certify that the code in the method functions including method function main of this project are entirely my own work.
package p3_c00039405;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cxb02
 */
public class P3_C00039405 {

    /*printArray       
    *
    *Prints out formated strings and is convinient
    *
    * No input needed
    *
    * prints column information to help organize output
     */
    public static void printArray(/*ArrayList<Double> arrayList*/) {
        System.out.printf("Sort type              Execution Time   "
                + "           \n----------------------------------------------------------------------- \n");

    }

    /*selectionSort       
    *
    *sorts given arraylist containing type 
    *doubles using selection sort Algorithm
    *
    *Must be given an arraylist of type double sorted or unsorted
    *
    *Outputs a sorted arraylist of type double
     */
    static ArrayList<Double> selectionSort(ArrayList<Double> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = i + 1; j < arrayList.size() - 1; j++) {
                if (arrayList.get(i) > arrayList.get(j)) {
                    Double temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(i));
                    arrayList.set(i, temp);
                }
            }
        }
        long startTime = System.currentTimeMillis();
        ArrayList<Double> tempArrayList = arrayList;
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Bubble Sort            " + executionTime + " sec.");
        return tempArrayList;
    }

    /*insertionSort       
    *
    *sorts given arraylist containing type 
    *doubles using selection insertion Algorithm
    *
    *Must be given an arraylist of type double sorted or unsorted
    *
    *Outputs a sorted arraylist of type double
    *and the time it took the process to run
     */
    static ArrayList<Double> insertionSort(ArrayList<Double> arrayList) {

        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = i; 0 < j; j--) {
                if (arrayList.get(j) < arrayList.get(j - 1)) {
                    Double temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j - 1));
                    arrayList.set((j - 1), temp);
                }
            }
        }
        long startTime = System.currentTimeMillis();
        ArrayList<Double> tempArrayList = arrayList;
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Insertion Sort         " + executionTime + " sec.");
        return tempArrayList;
    }

    /*bubbleSort       
    *
    *sorts given arraylist containing type 
    *doubles using bubble sort Algorithm
    *
    *Must be given an arraylist of type double sorted or unsorted
    *
    *Outputs a sorted arraylist of type double and 
    *the time it took the process to run
     */
    static ArrayList<Double> bubbleSort(ArrayList<Double> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = arrayList.size() - 1; j > i + 1; j--) {
                if (arrayList.get(j) < arrayList.get(j - 1)) {
                    Double temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j - 1));
                    arrayList.set(j - 1, temp);
                }
            }
        }
        long startTime = System.currentTimeMillis();
        ArrayList<Double> tempArrayList = arrayList;
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Bubble Sort            " + executionTime + " sec.");
        return tempArrayList;
    }

    /*mergeSort       
    *
    *returns sorted arraylist containing type 
    *doubles using merge sort helper function
    *
    *Must be given an arraylist of type double sorted or unsorted
    *
    *passes parameters to called helper function and Outputs a sorted arraylist of type double and 
    *the time it took the process to run
     */
    public static ArrayList<Double> mergeSort(ArrayList<Double> arrayList) {
        long startTime = System.currentTimeMillis();
        ArrayList<Double> mergeSortHelper = mergeSortHelper(arrayList, 0, arrayList.size() - 1);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Merge Sort             " + executionTime + " sec.");
        return mergeSortHelper;
    }

    /*mergeSortHelper       
    *
    *uses recursion to divide given arraylist into managable smaller arraylists
    *
    *Must be given an arraylist of type double sorted or unsorted
    *
    *passes small arraylists to called merge function and recieves merged 
    *sorted arraylist that it passes back to the originally called method
    *also produces the time it took the process to run
     */
    public static ArrayList<Double> mergeSortHelper(ArrayList<Double> arrayList, int position, int lastIndex) {
        if (position < lastIndex) {
            int middle = ((position + lastIndex) / 2);
            mergeSortHelper(arrayList, position, middle);
            mergeSortHelper(arrayList, middle + 1, lastIndex);
            return merge(arrayList, position, middle, lastIndex);
        } else {
            return arrayList;
        }
    }

    /*merge       
    *
    *sorts given arraylists and passes them back to calling method
    *
    *Must be given an arraylist of type double sorted or unsorted
    *
    *recieves small arraylists and passes larger ones to calling function
    *also produces the time it took the process to run
     */
    public static ArrayList<Double> merge(ArrayList<Double> arrayList, int position, int middle, int lastIndex) {

        Double[] left = new Double[(middle - position) + 1];
        Double[] right = new Double[lastIndex - middle];
        int temp1 = (middle - position) + 1;
        int temp2 = lastIndex - middle;
        int i = 0;
        for (; temp1 > i; i++) {
            left[i] = arrayList.get(position + i);
        }
        int j = 0;
        for (; temp2 > j; j++) {
            right[j] = arrayList.get((middle + 1) + j);
        }
        i = 0;
        j = 0;
        int k = position;
        for (; k <= lastIndex; k++) {
            if ((i < left.length) && (j < right.length)) {
                if (left[i] <= right[j]) {
                    arrayList.set(k, left[i]);
                    i += 1;
                } else {
                    arrayList.set(k, right[j]);
                    j += 1;
                }
            } else if (i < left.length) {
                for (; i < left.length; i++) {
                    arrayList.set(k, left[i]);
                    k++;
                }
            } else if (j < right.length) {
                for (; j < right.length; j++) {
                    arrayList.set(k, right[j]);
                    k++;
                }
            }
        }
        return arrayList;
    }

    /*mergeWordSort       
    *
    *returns sorted arraylist containing type 
    *strings using merge sort helper function
    *
    *Must be given an arraylist of type string sorted or unsorted
    *
    *passes parameters to called helper function and Outputs a sorted arraylist of type string and 
    *the time it took the process to run
     */
    public static ArrayList<String> mergeWordSort(ArrayList<String> arrayList) {
        long startTime = System.currentTimeMillis();
        ArrayList<String> mergeWordSortHelper = mergeWordSortHelper(arrayList, 0, arrayList.size() - 1);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Merge Sort for Words             " + executionTime + " sec.");
        return mergeWordSortHelper;
    }

    /*mergeWordSortHelper       
    *
    *uses recursion to divide given arraylist into managable smaller arraylists
    *
    *Must be given an arraylist of type string sorted or unsorted
    *
    *passes small arraylists to called merge function and recieves merged 
    *sorted arraylist that it passes back to the originally called method
    *also produces the time it took the process to run
     */
    public static ArrayList<String> mergeWordSortHelper(ArrayList<String> arrayList, int position, int lastIndex) {
        if (position < lastIndex) {
            int middle = ((position + lastIndex) / 2);
            mergeWordSortHelper(arrayList, position, middle);
            mergeWordSortHelper(arrayList, middle + 1, lastIndex);
            return mergeWord(arrayList, position, middle, lastIndex);
        } else {
            return arrayList;
        }
    }

    /*mergeWord       
    *
    *sorts given arraylists and passes them back to calling method
    *uses compareTo to compare strings
    *
    *Must be given an arraylist of type string sorted or unsorted
    *
    *recieves small arraylists and passes larger ones to calling function
    *also produces the time it took the process to run
     */
    public static ArrayList<String> mergeWord(ArrayList<String> arrayList, int position, int middle, int lastIndex) {

        String[] left = new String[(middle - position) + 1];
        String[] right = new String[lastIndex - middle];
        int temp1 = (middle - position) + 1;
        int temp2 = lastIndex - middle;
        int i = 0;
        for (; temp1 > i; i++) {
            left[i] = arrayList.get(position + i);
        }
        int j = 0;
        for (; temp2 > j; j++) {
            right[j] = arrayList.get((middle + 1) + j);
        }
        i = 0;
        j = 0;
        int k = position;
        for (; k <= lastIndex; k++) {
            if ((i < left.length) && (j < right.length)) {
                if (right[j].compareTo(left[i]) < 0) {
                    arrayList.set(k, left[i]);
                    i += 1;
                } else if (right[j].compareTo(left[i]) == 0) {
                    arrayList.set(k, left[i]);
                    i += 1;
                } else {
                    arrayList.set(k, right[j]);
                    j += 1;
                }
            } else if (i < left.length) {
                for (; i < left.length; i++) {
                    arrayList.set(k, left[i]);
                    k++;
                }
            } else if (j < right.length) {
                for (; j < right.length; j++) {
                    arrayList.set(k, right[j]);
                    k++;
                }
            }
        }
        return arrayList;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        printArray();
        int size = 1000;
        System.out.println("List size: " + size);

        ArrayList<Double> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(Math.random() * 1000);
        }
        selectionSort(arrayList);
        System.gc();
        bubbleSort(arrayList);
        System.gc();
        insertionSort(arrayList);
        System.gc();
        mergeSort(arrayList);
        System.gc();

        size = 2000;
        System.out.println("List size: " + size);

        arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(Math.random() * 1000);
        }
        selectionSort(arrayList);
        System.gc();
        bubbleSort(arrayList);
        System.gc();
        insertionSort(arrayList);
        System.gc();
        mergeSort(arrayList);
        System.gc();

        size = 4000;
        System.out.println("List size: " + size);

        arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(Math.random() * 1000);
        }
        selectionSort(arrayList);
        System.gc();
        bubbleSort(arrayList);
        System.gc();
        insertionSort(arrayList);
        System.gc();
        mergeSort(arrayList);
        System.gc();

        size = 8000;
        System.out.println("List size: " + size);

        arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(Math.random() * 1000);
        }
        selectionSort(arrayList);
        System.gc();
        bubbleSort(arrayList);
        System.gc();
        insertionSort(arrayList);
        System.gc();
        mergeSort(arrayList);
        System.gc();

        ArrayList<String> wordArray = new ArrayList();
        ArrayList<String> wordCount = new ArrayList();

        String filename = "fstein.txt";
        File file = new File(filename);
        try (Scanner filereader = new Scanner(file);) {
            while (filereader.hasNextLine()) {
                String line = filereader.nextLine();
                wordCount.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Scanner filereader = new Scanner(file);) {
            while (filereader.hasNextLine()) {
                String line = filereader.nextLine();
                if (!wordArray.contains(line)) {
                    wordArray.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nWord count before sorting array:  " + wordCount.size());
        mergeWordSort(wordArray);
        System.out.println("Word count after sorting array:   " + wordArray.size());

    }
}
