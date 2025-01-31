/*Најди ја најдолгата опаѓачка секвенца во една низа. Броевите во секвенцата не мора да се наоѓаат на последователни индекси во низата.
--------------------------------------------------------------------------------------------------------------------------------------
Find the longest decreasing sequence in an array. The numbers in the sequence don't need to be on consecutive indices in the array.*/

import java.util.Scanner;

public class Kolokviumska4{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        int[] lds = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            lds[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            if(lds[i] > max) {
                max = lds[i];
            }
        }
        System.out.println(max);
    }
}
