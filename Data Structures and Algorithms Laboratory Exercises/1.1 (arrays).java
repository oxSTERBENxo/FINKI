/*За дадена низа од N цели броеви, да се избришат елементите со вредност помала од просекот на сите елементи во низата. На пример за низата 1, 2, 3, 4, 5 
просекот е (1 + 2 + 3 + 4 + 5) / 5 = 15 / 5 = 3, што значи треба да се избришат елементите 1 и 2, што значи низата после оваа трансформација ќе биде 3, 4, 5.
Влез: Првиот број од влезот е бројот на елементи во низата N, а потоа во следниот ред се дадени самите елементи одделени со празно место.
Излез: Низата пред и после направената трансформација.
----------------------------------------------------------------------------------------------------------------
For a given array with N integers, all the elements that are lower than the average of the whole array need to be deleted. For example for the array 1, 2, 3, 4, 5 
the average is (1 + 2 + 3 + 4 + 5) / 5 = 15 / 5 = 3 which means that the elements 1 and 2 should be deleted, so the array after the transformation will be 3, 4, 5.
Input: The first number in the input is the number of integers in the array N, then in the next line the elements are given, separated by spaces.
Output: The array before and after the transformation.*/

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        int[] niza = new int[n];
        for (int i = 0; i < n; i++) {
            niza[i] = scanner.nextInt();
        }


        double average = calculateAverage(niza, n);
        int[] filteredNiza = filterAboveAverage(niza, n, average);

        int filteredN = filteredNiza.length;

        printArray(niza, n);
        printArray(filteredNiza, filteredN);

    }

    private static double calculateAverage(int[] arr, int n) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        return (double) sum / n;
    }

    private static int[] filterAboveAverage(int[] arr, int n, double avg) {
        int filteredN = 0;
        int[] filteredNiza = new int[n];

        for (int element : arr) {
            if (element >= avg) {
                filteredNiza[filteredN++] = element;
            }
        }

        if (filteredN < n) {
            int[] trimmedFiltered = new int[filteredN];
            System.arraycopy(filteredNiza, 0, trimmedFiltered, 0, filteredN);
            return trimmedFiltered;
        }

        return filteredNiza;
    }

    private static void printArray(int[] arr, int n) {
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}
