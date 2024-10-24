/*За дадена низа од случајни броеви кои се внесуваат од стандарден влез, да се направи преместување на сите нули на почеток на низата. 
На стандарден излез да се испечати трансформираната низа.
------------------------------------------------------------------------------
For a given array of random numbers given from standard input, perform a shift of all zeros at the beginning of the sequence. 
Print the transformed array to standard output.*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                result[index++] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                result[index++] = arr[i];
            }
        }

        System.out.println("Transformiranata niza e:");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
